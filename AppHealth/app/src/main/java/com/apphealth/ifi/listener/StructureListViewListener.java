package com.apphealth.ifi.listener;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.apphealth.ifi.adapter.StructureListView;
import com.apphealth.ifi.appheath.MainActivity;
import com.apphealth.ifi.appheath.StructureDetailActivity;
import com.apphealth.ifi.beans.Structure;


public class StructureListViewListener implements AdapterView.OnItemClickListener {

    ActionBarActivity activity;

    public StructureListViewListener(ActionBarActivity activity){

            this.activity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Structure structure = ((StructureListView) view).getStructure();

        Intent intent = new Intent(activity, StructureDetailActivity.class);
        intent.putExtra("id", structure.getId());
        intent.putExtra("nom", structure.getNom());
        intent.putExtra("DestLatitude", structure.getLatitude());
        intent.putExtra("DestLongitude", structure.getLongitude());
        intent.putExtra("telephone", structure.getTelephone());
        intent.putExtra("adresse", structure.getAdresse());
        intent.putExtra("distance", structure.getDistance());
        intent.putExtra("DepLatitude", MainActivity.latitude);
        intent.putExtra("DepLongitude", MainActivity.longitude);
        Log.i("Bouton","b="+MainActivity.buttonSelected);
        intent.putExtra("buttonSelected",MainActivity.buttonSelected);
        Log.i("Location","Lat="+MainActivity.latitude+" long="+MainActivity.longitude);
        activity.startActivity(intent);

    }
}
