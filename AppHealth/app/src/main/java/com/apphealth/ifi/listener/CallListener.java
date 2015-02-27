package com.apphealth.ifi.listener;

import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.view.View;

import com.apphealth.ifi.appheath.PharmacieDetailActivity;


public class CallListener implements View.OnClickListener{

    Activity activity;

    public CallListener(Activity activity){

        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" +PharmacieDetailActivity.telephone));
        activity.startActivity(callIntent);
    }
}
