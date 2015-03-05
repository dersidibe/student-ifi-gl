package com.apphealth.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;


public class Tools {

    //public static String URL = "http://192.168.0.105/project/bdpgl/view/infoStructure.php";
    public static String URL = "http://zouma.wc.lt/bdpgl/view/infoStructure.php";
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
