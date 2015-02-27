package com.apphealth.ifi.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.apphealth.ifi.appheath.MapsActivity;
import com.apphealth.ifi.appheath.PharmacieDetailActivity;


public class MapListener implements View.OnClickListener{

    Activity activity;

    public MapListener(Activity activity){

        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(activity, MapsActivity.class);
        intent.putExtra("DepLatitude", PharmacieDetailActivity.DepLatitude);
        intent.putExtra("DepLongitude", PharmacieDetailActivity.DepLongitude);
        intent.putExtra("DestLatitude", PharmacieDetailActivity.DestLatitude);
        intent.putExtra("DestLongitude", PharmacieDetailActivity.DestLongitude);
        activity.startActivity(intent);
    }
}
