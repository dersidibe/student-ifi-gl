package com.apphealth.ifi.listener;


import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.apphealth.ifi.appheath.R;
import com.google.android.gms.maps.GoogleMap;


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


            bPharmacie = (Button)activity.findViewById(R.id.button1);
            bHopital = (Button)activity.findViewById(R.id.button2);
            bClinic = (Button)activity.findViewById(R.id.button3);
            title = (TextView)activity.findViewById(R.id.title);
            list = (ListView)activity.findViewById(R.id.listView);

            bPharmacie.setBackgroundColor(activity.getResources().getColor(R.color.button_normal));
            bClinic.setBackgroundColor(activity.getResources().getColor(R.color.button_selected));
            bHopital.setBackgroundColor(activity.getResources().getColor(R.color.button_normal));
            title.setText(R.string.liste_clinic);



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
