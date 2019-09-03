package com.gbox3d.exam03service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import static com.gbox3d.exam03service.MainActivity.TAG;

public class MyService extends Service {

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            // Get extra data included in the Intent
            String message = intent.getStringExtra("message");
            Log.d(TAG, "service side Got message: " + message);
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"start service");

        LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver,
                new IntentFilter("custom-event-name")
        );


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"destroy service");
        LocalBroadcastManager.getInstance(this).unregisterReceiver( mMessageReceiver);


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);

        Log.d(TAG,"onStartCommand");

        String message = intent.getStringExtra("message");

        Log.d(TAG,"message : " + message);


        return START_NOT_STICKY;

    }





}
