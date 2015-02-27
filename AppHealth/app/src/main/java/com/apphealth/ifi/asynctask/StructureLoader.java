package com.apphealth.ifi.asynctask;


import java.util.ArrayList;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.apphealth.ifi.beans.Structure;
import  com.apphealth.ifi.adapter.MyAdapter;
import com.apphealth.ifi.appheath.R;
import com.apphealth.utils.Tools;
import static com.apphealth.ifi.parser.StructureSAXParser.getData;

public class StructureLoader extends AsyncTask<String, Void, Boolean> {


    private ArrayList<Structure> listes = null;
    ArrayList<Structure> feeds = null;
    ActionBarActivity activity;
    MyAdapter monAdapater;
    ProgressBar maprogress;
    ListView maListView;
    Context ctx;
    String idRoom;
    private volatile boolean running = true;

    public StructureLoader( ActionBarActivity activity,int entity){

        this.activity = activity;
        this.ctx = activity.getApplication();
        this.monAdapater = new MyAdapter(ctx,entity);
        maprogress = (ProgressBar)activity.findViewById(R.id.progressBar);
        maListView = (ListView)activity.findViewById(R.id.listView);
    }

    @Override
    protected void onPreExecute() {

        maprogress.setVisibility(View.VISIBLE);
        super.onPreExecute();
    }

    @Override
    protected void onCancelled() {
        running = false;
    }

    @Override
    protected Boolean doInBackground(String... url) {

        String URL =  url[0];
        Boolean test_while = false;
        while(running){

            if(Tools.isConnected(ctx)){

                ArrayList<Structure> structure = new ArrayList<Structure>();
                feeds = getData(URL);

                if(feeds != null){

                    listes = feeds;
                    for(Structure feed : feeds){


                        Structure struct = new Structure();
                        struct.setId(feed.getId());
                        struct.setNom(feed.getNom());
                        struct.setLatitude(feed.getLatitude());
                        struct.setLongitude(feed.getLongitude());
                        struct.setAdresse(feed.getAdresse());
                        struct.setTelephone(feed.getTelephone());
                        struct.setDistance(feed.getDistance());
                        structure.add(struct);
                        if(isCancelled()){
                            break;
                        }

                    }

                    test_while = true;
                }

            }
            running = false;
        }

        //.......................................................................//
        return test_while;
    }


    protected void onPostExecute(Boolean result) {

        if(result){

            maListView.setAdapter(null);
            monAdapater.setListeStructure(listes);
            monAdapater.notifyDataSetChanged();
            maListView.setAdapter(monAdapater);
        }
        maprogress.setVisibility(View.GONE);
        super.onPostExecute(result);
    }
}
