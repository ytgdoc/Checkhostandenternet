package com.ytgdoc.checkconninternetandhost.ui;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by Developer on 6/30/2016.
 */
public class ProgressDialogUI {
    public ProgressDialog progressBar;
    private Activity activity;

    public ProgressDialogUI(Activity context) {
        activity = context;
        progressBar = new ProgressDialog(activity);
        progressBar.setCancelable(false);
        progressBar.setMessage("Wating for check server...,Please!");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();
    }

}
