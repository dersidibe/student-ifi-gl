package com.ifi.apphealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashScreenActivity extends Activity {

	 
	private final transient Handler handler = new Handler(){
		  
	    public void handleMessage(Message paramMessage){
	    	
	      if (paramMessage.what == 0){
	    	  
	        Intent localIntent = new Intent(SplashScreenActivity.this, MainActivityActivity.class);
	        SplashScreenActivity.this.startActivity(localIntent);
	        SplashScreenActivity.this.finish();
	      }
	      super.handleMessage(paramMessage);
	    }
	  };	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
	    Message localMessage = new Message();
	    localMessage.what = 0;
	    this.handler.sendMessageDelayed(localMessage, 5000L);		
	}
}
