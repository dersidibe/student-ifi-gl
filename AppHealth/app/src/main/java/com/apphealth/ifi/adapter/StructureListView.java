package com.apphealth.ifi.adapter;


import android.widget.LinearLayout;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.apphealth.ifi.appheath.R;
import com.apphealth.ifi.beans.Structure;


public class StructureListView extends LinearLayout{

    private TextView nomStructure;
    private TextView distanceStructure;
    private ImageView logoStructure;
    Context context;
    private Structure structure;
    int entity;
    public StructureListView(Context context, Structure structure, int entity) {
        super(context);

        this.context = context;
        this.entity = entity;
        initLayout(context);
        initComposants();
        setArticle(structure);
    }

    private void initLayout(Context context){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.liste_structure, this, true);
    }

    private void initComposants(){

        this.nomStructure = (TextView) this.findViewById(R.id.name);
        this.distanceStructure = (TextView) this.findViewById(R.id.distance);
        this.logoStructure = (ImageView) this.findViewById(R.id.list_image);

    }
    private void initContenuComposants(Structure structure){

        this.nomStructure.setText(structure.getNom());
        this.distanceStructure.setText(structure.getDistance()+" mètres");
        setImage();
    }

    public Structure getStructure(){
        return structure;
    }

    public void setArticle(Structure structure){

        this.structure = structure;

        initContenuComposants(structure);

    }
    private void setImage(){

        int resource = 0;
        if(entity == 1){
            logoStructure.setImageResource(R.drawable.pharma_list_img);
        }
        if(entity == 2){
            logoStructure.setImageResource(R.drawable.clinic_list_img);
        }
        if(entity == 3){
            logoStructure.setImageResource(R.drawable.hopital_list_img);
        }

    }
}
