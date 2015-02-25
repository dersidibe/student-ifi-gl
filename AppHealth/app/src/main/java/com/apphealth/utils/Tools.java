package com.apphealth.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;


public class Tools {

    public static boolean isConnected(Context ctx){

        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if(activeNetworkInfo != null){

            State networkState = activeNetworkInfo.getState();

            if(networkState.compareTo(State.CONNECTED) == 0){

                return true;
            }
        }
        return false;
    }
}
