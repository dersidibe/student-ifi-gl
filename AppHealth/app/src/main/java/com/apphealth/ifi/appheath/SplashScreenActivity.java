package com.apphealth.ifi.appheath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashScreenActivity extends Activity {


    private final transient Handler handler = new Handler(){

        public void handleMessage(Message paramMessage){

            if (paramMessage.what == 0){

                Intent localIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                SplashScreenActivity.this.startActivity(localIntent);
                SplashScreenActivity.this.finish();
            }
            super.handleMessage(paramMessage);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        Message localMessage = new Message();
        localMessage.what = 0;
        this.handler.sendMessageDelayed(localMessage, 3000L);
    }
}