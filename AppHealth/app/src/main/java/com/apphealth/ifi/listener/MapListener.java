package com.apphealth.ifi.listener;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.apphealth.ifi.appheath.PathGoogleMapActivity;
import com.apphealth.ifi.appheath.StructureDetailActivity;
import com.apphealth.utils.Tools;


public class MapListener implements View.OnClickListener{

    Activity activity;

    public MapListener(Activity activity){

        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        if(Tools.isConnected(activity)) {

            Intent intent = new Intent(activity, PathGoogleMapActivity.class);
            intent.putExtra("DepLatitude", StructureDetailActivity.DepLatitude);
            intent.putExtra("DepLongitude", StructureDetailActivity.DepLongitude);
            intent.putExtra("DestLatitude", StructureDetailActivity.DestLatitude);
            intent.putExtra("DestLongitude", StructureDetailActivity.DestLongitude);
            Log.i("nom= ", StructureDetailActivity.pharmacie);
            intent.putExtra("nom", StructureDetailActivity.pharmacie);
            activity.startActivity(intent);
        }
        else{

            Toast.makeText(activity.getBaseContext(), "Vérifier votre connexion!", Toast.LENGTH_SHORT).show();
        }
    }
}
