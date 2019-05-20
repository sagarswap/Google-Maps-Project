package com.example.madlabproject;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EditText e1;
    public static double lat=0, longi=0;
    Intent my;
    Bundle b;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maplayout);
        my=getIntent();
        b=my.getExtras();
        name=b.getString("name");
        lat=(double)b.get("lat");
        longi=(double)b.get("longi");
        e1=(EditText)findViewById(R.id.editText);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        goToLocation(lat, longi,15);

        my=getIntent();
        b=my.getExtras();
        name=b.getString("name");
        MarkerOptions options = new MarkerOptions();
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try
        {
            List<Address> mylist = geocoder.getFromLocation(lat,longi,1);
            Address address = mylist.get(0);
            String locality = address.getLocality();
            options.title(name);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        options.position(new LatLng(lat,longi));
        mMap.addMarker(options);
    }

    /**Display location on map*/

    public void goToLocation(double latitude,double longitude,int zoom)
    {
        LatLng latLng = new LatLng(latitude,longitude);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng,15);
        mMap.moveCamera(update);
    }

    /**Physical address to map translation*/

    public void findOnMap(View v)
    {
        Geocoder geocoder = new Geocoder(this);
        try
        {
            List<Address> mylist = geocoder.getFromLocationName(e1.getText().toString(),1);
            Address address = mylist.get(0);
            String locality = address.getLocality();
            Toast.makeText(getApplicationContext(),locality,Toast.LENGTH_SHORT).show();
            double lat = address.getLatitude();
            double lon = address.getLongitude();
            goToLocation(lat,lon,15);

            /**Marker implementation*/

            MarkerOptions options = new MarkerOptions();
            options.title(locality);
            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            options.position(new LatLng(lat,lon));
            mMap.addMarker(options);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
