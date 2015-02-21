package com.apphealth.ifi.listener;


import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.apphealth.ifi.appheath.R;


public class CliniqueListener implements View.OnClickListener{

        ActionBarActivity activity;
        Button bPharmacie,bClinic, bHopital;
        TextView title;

        public CliniqueListener(ActionBarActivity activity){

            this.activity = activity;
        }

        @Override
        public void onClick(View v) {


            bPharmacie = (Button)activity.findViewById(R.id.button1);
            bHopital = (Button)activity.findViewById(R.id.button2);
            bClinic = (Button)activity.findViewById(R.id.button3);
            title = (TextView)activity.findViewById(R.id.title);

            bPharmacie.setBackgroundColor(activity.getResources().getColor(R.color.button_normal));
            bClinic.setBackgroundColor(activity.getResources().getColor(R.color.button_selected));
            bHopital.setBackgroundColor(activity.getResources().getColor(R.color.button_normal));
            title.setText(R.string.liste_clinic);
        }
}
