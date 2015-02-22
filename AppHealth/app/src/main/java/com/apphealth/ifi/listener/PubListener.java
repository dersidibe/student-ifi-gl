package com.apphealth.ifi.listener;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.content.Intent;

public class PubListener implements View.OnClickListener {

    ActionBarActivity activity;
    String URL_IFI = "http://ifi.vnu.edu.vn/index.php";
    public PubListener(ActionBarActivity activity){

        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_IFI));
        activity.startActivity(intent);
    }
}
