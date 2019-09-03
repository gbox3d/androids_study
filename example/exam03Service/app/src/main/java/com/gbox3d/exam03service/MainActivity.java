package com.gbox3d.exam03service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    public final static String TAG  = "exam03";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"start activity");

        ((Button)findViewById(R.id.button_start)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,MyService.class);
                        intent.putExtra("message", "This is my first message!");

                        startService(intent);


                    }
                }
        );

        ((Button)findViewById(R.id.button_stop)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopService(new Intent(MainActivity.this,MyService.class));

                    }
                }
        );

        ((Button)findViewById(R.id.button_send_serv)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("custom-event-name");
                        intent.putExtra("message", "This is my first message!");

                        Log.d(TAG,"broad cast");

                        LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);
                    }
                }
        );
    }
}
