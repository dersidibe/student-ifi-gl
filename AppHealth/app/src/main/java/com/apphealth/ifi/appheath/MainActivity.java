package com.apphealth.ifi.appheath;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.apphealth.ifi.listener.CliniqueListener;
import com.apphealth.ifi.listener.HopitalListener;
import com.apphealth.ifi.listener.PharmacieListViewListener;
import com.apphealth.ifi.listener.PharmacieListener;
import com.apphealth.ifi.listener.PubListener;
import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends ActionBarActivity {


    Button bPharmacie,bClinic, bHopital;
    TextView title;
    ImageView pub;
    private GoogleMap mMap;
    ListView list;
    public static String latitude;
    public  static String longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getSupportActionBar().setIcon(R.drawable.icon);

        bPharmacie = (Button)findViewById(R.id.button1);
        bHopital = (Button)findViewById(R.id.button2);
        bClinic = (Button)findViewById(R.id.button3);
        title = (TextView)findViewById(R.id.title);
        pub = (ImageView)findViewById(R.id.pub);
        list = (ListView)findViewById(R.id.listView);

        bPharmacie.setOnClickListener(new PharmacieListener(this));
        bClinic.setOnClickListener(new CliniqueListener(this));
        bHopital.setOnClickListener(new HopitalListener(this));
        pub.setOnClickListener(new PubListener(this));
        list.setOnItemClickListener(new PharmacieListViewListener(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
