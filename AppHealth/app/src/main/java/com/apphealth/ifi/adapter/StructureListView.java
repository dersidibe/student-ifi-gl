package com.apphealth.ifi.adapter;


import android.widget.LinearLayout;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.apphealth.ifi.appheath.R;
import com.apphealth.ifi.beans.Structure;


public class StructureListView extends LinearLayout{

    private TextView nomStructure;
    private TextView distanceStructure;
    private ImageView logoStructure;
    Context context;
    private Structure structure;

    public StructureListView(Context context, Structure structure) {
        super(context);

        this.context = context;
        initLayout(context);
        initComposants();
        setArticle(structure);
    }

    private void initLayout(Context context){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.liste, this, true);
    }

    private void initComposants(){

        this.nomStructure = (TextView) this.findViewById(R.id.name);
        this.distanceStructure = (TextView) this.findViewById(R.id.distance);
        this.logoStructure = (ImageView) this.findViewById(R.id.list_image);

    }
    private void initContenuComposants(Structure structure){

        this.nomStructure.setText(structure.getNom());
        this.distanceStructure.setText(structure.getDistance()+" mètres");
    }

    public Structure getStructure(){
        return structure;
    }

    public void setArticle(Structure structure){

        this.structure = structure;

        initContenuComposants(structure);

    }
}
