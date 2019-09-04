package com.gbox3d.exam01push;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.io.IOException;

import static com.gbox3d.exam01push.MainActivity.TAG;

public class MyPlayerService extends Service {

    MediaPlayer m_PlayerNinja;

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            // Get extra data included in the Intent
            String message = intent.getStringExtra("message");
            Log.d(TAG, "service side Got message: " + message);

            try {
                if(message == "start") {
                    m_PlayerNinja.start();
                }
                else if(message == "stop"){
                    m_PlayerNinja.stop();
                    m_PlayerNinja.prepare();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };



    public MyPlayerService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG,"MyPlayerService create ");

        m_PlayerNinja =  MediaPlayer.create(this,R.raw.ninja);

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
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
