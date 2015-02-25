package com.apphealth.ifi.asynctask;


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

    public StructureListView(Context context, Structure structure) {
        super(context);

        this.context = context;
        initLayout(context);

    }

    private void initLayout(Context context){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.liste, this, true);
    }


}
