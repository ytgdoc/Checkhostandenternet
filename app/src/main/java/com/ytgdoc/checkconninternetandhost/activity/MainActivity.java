package com.ytgdoc.checkconninternetandhost.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ytgdoc.checkconninternetandhost.R;
import com.ytgdoc.checkconninternetandhost.ui.CheckConnServer;
import com.ytgdoc.checkconninternetandhost.widgets.ConnectUtils;

public class MainActivity extends AppCompatActivity {
    private ConnectUtils connectUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectUtils = new ConnectUtils();
        if(!connectUtils.hasActiveInternetConnection(this)){
            AlertDialog.Builder builder =  new AlertDialog.Builder(this);
            builder.setMessage("You running offline state, Please turn on internet");
            builder.setCancelable(false);
            builder.setPositiveButton("Okie", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            AlertDialog dialog =builder.create();
            dialog.show();
        }else {
            String host = "google.com.vn";
            CheckConnServer connServer = new CheckConnServer(this);
            connServer.execute(host);
        }

    }
}
