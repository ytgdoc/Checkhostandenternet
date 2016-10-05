package com.ytgdoc.checkconninternetandhost.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
/**
 * Created by Developer on 6/30/2016.
 */
public class CheckConnServer extends AsyncTask<String, Void, String> {
    Activity activity;
    ProgressDialogUI dialogUI;

    public CheckConnServer(Activity activity) {
        this.activity = activity;
        dialogUI = new ProgressDialogUI(activity);
    }

    @Override
    protected String doInBackground(String... params) {
        String res = "";
        Runtime runtime = Runtime.getRuntime();
        try {
            Process mIpAddrProcess = runtime.exec("/system/bin/ping -c 1 " + params[0]);
            int mExitValue = mIpAddrProcess.waitFor();// cho cho time phan hoi lai
            //System.out.println(" mExitValue "+mExitValue);
            if (mExitValue == 0) {
                res = "success";
            } else {
                res = "fail";
            }
        } catch (InterruptedException ignore) {
            ignore.printStackTrace();
            System.out.println(" Exception:" + ignore);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" Exception:" + e);
        }
        return res;
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("success")) {
            dialogUI.progressBar.dismiss();
            Log.wtf("Connection", "Success !");
            Toast.makeText(activity, "Connect server successfull", Toast.LENGTH_SHORT).show();
        } else {
            dialogUI.progressBar.dismiss();
            AlertDialog.Builder builder1 = new AlertDialog.Builder(activity);
            builder1.setMessage("Your device  connect host has error, please contact admin and try again");
            builder1.setCancelable(false);
            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            activity.finish();
                        }
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }

    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}
