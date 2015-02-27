package com.apphealth.ifi.appheath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.apphealth.ifi.listener.CallListener;
import com.apphealth.ifi.listener.MapListener;

public class StructureDetailActivity extends Activity {

    ImageView call, map,imageStructure;
    TextView nom, adresse;
    public static String telephone;
    public  static String DepLatitude, DepLongitude, DestLatitude,DestLongitude, pharmacie;
    int btSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.structure_detail_activity);

        call = (ImageView)findViewById(R.id.call);
        map  = (ImageView)findViewById(R.id.map);
        nom  = (TextView)findViewById(R.id.nomStructure);
        adresse = (TextView)findViewById(R.id.adresse);
        imageStructure = (ImageView)findViewById(R.id.logoStructure);
        call.setOnClickListener(new CallListener(this));
        map.setOnClickListener(new MapListener(this));
    }

    @Override
    protected void onStart() {

        super.onStart();

        Intent intent = getIntent();
        pharmacie =intent.getStringExtra("nom");
        nom.setText(pharmacie);
        adresse.setText(intent.getStringExtra("adresse"));
        telephone = intent.getStringExtra("telephone");
        DepLatitude = intent.getStringExtra("DepLatitude");
        DepLongitude = intent.getStringExtra("DepLongitude");
        DestLatitude = intent.getStringExtra("DestLatitude");
        DestLongitude = intent.getStringExtra("DestLongitude");
        btSelected = Integer.parseInt(intent.getStringExtra("buttonSelected"));
        setImage();
    }

    private void setImage(){

        int resource = 0;
        if(btSelected == 1){
            imageStructure.setImageResource(R.drawable.pharma_default_img);
        }
        if(btSelected == 2){
            imageStructure.setImageResource(R.drawable.clinic_default_img);
        }
        if(btSelected == 3){
            imageStructure.setImageResource(R.drawable.hopital_default_img);
        }

    }
}
