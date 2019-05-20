package com.example.madlabproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.telecom.ConnectionService;
import android.telecom.PhoneAccountHandle;
import android.telephony.PhoneNumberUtils;

import android.telephony.TelephonyManager;
import android.widget.Toast;


import java.util.Date;
import java.util.Objects;

public class PhoneCallChecker extends BroadcastReceiver {

    String number, state;
    private static int lastState = TelephonyManager.CALL_STATE_IDLE;
    private static Date callStartTime;
    private static boolean isIncoming;
    private static String savedNumber;
    @Override
    public void onReceive(Context context, Intent intent)
    {
        try {
            if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
                number = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");
                if (number.length() == 8) {
                    if (!(number.charAt(0) == '2' || number.charAt(0) == '3' || number.charAt(0) == '4' || number.charAt(0) == '5' || number.charAt(0) == '6' || number.charAt(0) == '7'))
                        Toast.makeText(context, "Wrong Landline Number", Toast.LENGTH_LONG).show();
                } else if (number.length() == 10) {
                    if (!(number.charAt(0) == '9' || number.charAt(0) == '8' || number.charAt(0) == '7' || number.charAt(0) == '6'))
                        Toast.makeText(context, "Wrong Mobile Number", Toast.LENGTH_LONG).show();
                }
                boolean isEmergencyNumber = PhoneNumberUtils.isEmergencyNumber(number);
                if(isEmergencyNumber)
                    Toast.makeText(context, "Emergency Number", Toast.LENGTH_LONG).show();

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void onCallStateChanged(Context context, int state, String number) {
        if(lastState == state){
            //No change, debounce extras
            return;
        }

        switch (state) {
            case TelephonyManager.CALL_STATE_OFFHOOK:
                if(lastState != TelephonyManager.CALL_STATE_RINGING){
                    isIncoming = false;
                    callStartTime = new Date();
                    Toast.makeText(context, "Outgoing Call Started" , Toast.LENGTH_SHORT).show();
                }

                break;
            case TelephonyManager.CALL_STATE_IDLE: {
                //Went to idle-  this is the end of a call.  What type depends on previous state(s)
                if (lastState == TelephonyManager.CALL_STATE_RINGING) {
                    //Ring but no pickup-  a miss
                    Toast.makeText(context, "Ringing but no pickup" + savedNumber + " Call time " + callStartTime + " Date " + new Date(), Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(context, "outgoing " + savedNumber + " Call time " + callStartTime + " Date " + new Date(), Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case TelephonyManager.SIM_STATE_ABSENT:
                Toast.makeText(context, "Phone is outside coverage area", Toast.LENGTH_SHORT).show();
                break;

            case TelephonyManager.SIM_STATE_NOT_READY:
                Toast.makeText(context, "Phone or Network is busy", Toast.LENGTH_SHORT).show();
                break;

        }
        lastState = state;
    }
}
