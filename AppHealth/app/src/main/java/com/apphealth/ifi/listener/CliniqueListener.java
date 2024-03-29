package com.apphealth.ifi.listener;


import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.apphealth.ifi.appheath.MainActivity;
import com.apphealth.ifi.appheath.R;
import com.apphealth.ifi.asynctask.StructureLoader;
import com.apphealth.utils.Tools;
import com.google.android.gms.maps.GoogleMap;

import java.util.List;


public class CliniqueListener implements View.OnClickListener, LocationListener {

        ActionBarActivity activity;
        Button bPharmacie,bClinic, bHopital;
        TextView title;
        ListView list;
        private AsyncTask<?, ?, ?> mTask = null;
        GoogleMap map;
        LocationManager locationManager ;
        String provider;


        public CliniqueListener(ActionBarActivity activity){

            this.activity = activity;
        }

        @Override
        public void onClick(View v) {

            if(Tools.isConnected(activity)) {

                MainActivity.buttonSelected = "2";
                bPharmacie = (Button) activity.findViewById(R.id.button1);
                bHopital = (Button) activity.findViewById(R.id.button2);
                bClinic = (Button) activity.findViewById(R.id.button3);
                title = (TextView) activity.findViewById(R.id.title);
                list = (ListView) activity.findViewById(R.id.listView);

                bPharmacie.setBackgroundColor(activity.getResources().getColor(R.color.button_normal));
                bClinic.setBackgroundColor(activity.getResources().getColor(R.color.button_selected));
                bHopital.setBackgroundColor(activity.getResources().getColor(R.color.button_normal));
                title.setText(R.string.liste_clinic);
                // Getting LocationManager object
                locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

                // Creating an empty criteria object
                Criteria criteria = new Criteria();

                // Getting the name of the provider that meets the criteria
                provider = locationManager.getBestProvider(criteria, false);
                List<String> providers = locationManager.getProviders(true);
                Location bestLocation = null;
                for (String provider : providers) {

                    Location l = locationManager.getLastKnownLocation(provider);
                    locationManager.requestLocationUpdates(provider, 20000, 1, this);
                    if (l == null) {
                        continue;
                    }
                    if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                        // Found best last known location: %s", l);
                        bestLocation = l;
                    }
                }
                // Toast.makeText(activity.getBaseContext(), "Latitude ="+bestLocation.getLatitude()+" Longitude ="+bestLocation.getLongitude(), Toast.LENGTH_SHORT).show();
                Log.i("location ", "Latitude =" + bestLocation.getLatitude() + " Longitude =" + bestLocation.getLongitude());
                MainActivity.latitude = Double.toString(bestLocation.getLatitude());
                MainActivity.longitude = Double.toString(bestLocation.getLongitude());
                String lien = Tools.URL + "?latitude=" + bestLocation.getLatitude() + "&longitude=" + bestLocation.getLongitude()+"&type=2";
                mTask = new StructureLoader(activity, 2).execute(lien);
            }
            else{

                Toast.makeText(activity.getBaseContext(),"Vérifier votre connexion!",Toast.LENGTH_SHORT).show();
            }

        }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
