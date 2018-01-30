package com.capstone.icoffie.pharmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TrackAccount extends AppCompatActivity {

    private LinearLayout viewAllDevices, viewLoginActivity, addDevice, addGeofence;
    private TextView accountTaglineTv, accountNameTv;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_account);

        // set toolbar
        toolbar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get bundle or extras from fragment activity
        Bundle bundle = getIntent().getExtras();
        String accountNameExtra = bundle.getString("ACCOUNT_NAME");
        String accountTaglineExtra = bundle.getString("ACCOUNT_TAGLINE");
        String accountIdExtra = bundle.getString("ACCOUNT_ID");
        String userAccountIdExtra = bundle.getString("USER_ACCOUNT_ID");

        // get view components by ids
        accountTaglineTv = (TextView) findViewById(R.id.accountTagline);
        accountNameTv = (TextView) findViewById(R.id.accountName);
        viewAllDevices = (LinearLayout) findViewById(R.id.viewalldevices);
        viewLoginActivity = (LinearLayout) findViewById(R.id.viewloginactivity);
        addDevice = (LinearLayout) findViewById(R.id.adddevice);
        addGeofence = (LinearLayout) findViewById(R.id.addgeofence);

        //set Account Header Info
        accountNameTv.setText(accountNameExtra.toUpperCase());
        accountTaglineTv.setText(accountTaglineExtra);



        viewAllDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrackAccount.this, MapsActivity.class));
            }
        });

        viewLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrackAccount.this, MapsActivity.class));
            }
        });

        addGeofence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("Adding Geofence...");
            }
        });

        addDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("Adding New Device...");
            }
        });
    }

    public void makeToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

