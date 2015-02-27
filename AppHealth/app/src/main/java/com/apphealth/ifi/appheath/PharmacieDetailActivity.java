package com.apphealth.ifi.appheath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.apphealth.ifi.listener.CallListener;
import com.apphealth.ifi.listener.MapListener;

public class PharmacieDetailActivity extends Activity {

    ImageView call, map;
    TextView nom, adresse;
    public static String telephone;
    public  static String DepLatitude, DepLongitude, DestLatitude,DestLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pharmacie_detail_activity);

        call = (ImageView)findViewById(R.id.call);
        map  = (ImageView)findViewById(R.id.map);
        nom  = (TextView)findViewById(R.id.nomPharma);
        adresse = (TextView)findViewById(R.id.adresse);
        call.setOnClickListener(new CallListener(this));
        map.setOnClickListener(new MapListener(this));
    }

    @Override
    protected void onStart() {

        super.onStart();

        Intent intent = getIntent();
        nom.setText(intent.getStringExtra("nom"));
        adresse.setText(intent.getStringExtra("adresse"));
        telephone = intent.getStringExtra("telephone");
        DepLatitude = intent.getStringExtra("DepLatitude");
        DepLongitude = intent.getStringExtra("DepLongitude");
        DestLatitude = intent.getStringExtra("DestLatitude");
        DestLongitude = intent.getStringExtra("DestLongitude");
    }
}
