package com.apphealth.ifi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.apphealth.ifi.appheath.R;
import com.apphealth.ifi.beans.Structure;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Structure> mData  = new ArrayList<Structure>();
    int entity;

    public MyAdapter(Context context, int entity){
        this.context = context;
        this.entity = entity;
    }

    @Override
    public int getCount() {

        return this.mData.size();
    }

    @Override
    public Object getItem(int pos) {

        return mData.get(pos);
    }

    @Override
    public long getItemId(int pos) {

        return pos;
    }

    @Override
    public View getView(int pos, View vue, ViewGroup parent) {

        Structure structure = mData.get(pos);
        if(vue == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vue = inflater.inflate(R.layout.liste_structure, null);
        }

        StructureListView structureView = new StructureListView(context, structure,entity);

        return structureView;
    }

    public ArrayList<Structure> getListeStructure(){

        return mData;
    }

    public void setListeStructure(ArrayList<Structure> art){

        this.mData = art;
    }

}
