package com.example.madlabproject;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

/*public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maplayout);

        e1=(EditText)findViewById(R.id.editText);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        goToLocation(13.347402, 74.793173,15);

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }



    public void goToLocation(double latitude,double longitude,int zoom)
    {
        LatLng latLng = new LatLng(latitude,longitude);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng,15);
        mMap.moveCamera(update);
    }



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
}*/
