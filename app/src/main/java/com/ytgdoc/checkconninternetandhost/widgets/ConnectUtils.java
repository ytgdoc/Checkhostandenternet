package com.ytgdoc.checkconninternetandhost.widgets;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by chungnguyen on 19/01/16.
 */
public class ConnectUtils {

    private static boolean checkNetwork(Context parent) {
        ConnectivityManager conMgr = (ConnectivityManager) parent.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null) {
            NetworkInfo activeInfo = conMgr.getActiveNetworkInfo();
            if (!activeInfo.isConnected() || !activeInfo.isAvailable()) {
                return false;
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean hasActiveInternetConnection(Context context) {
        boolean connected_Internet;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        connected_Internet = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return connected_Internet;
    }
}