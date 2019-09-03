package com.gbox3d.exam04bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import static com.gbox3d.exam04bindservice.MainActivity.TAG;

public class MyService extends Service {
    private final IBinder mBinder = new LocalBinder();
    private int number;

    class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        Log.d(TAG,"bind service");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Toast.makeText(getApplicationContext(), "Service Created", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"service created");

        number = 0;
    }

    int getNumber() {
        Log.d(TAG,"bibd call success");
        return number++;
    }



}
