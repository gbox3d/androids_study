package com.example.ktpractice_wifi;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import static android.content.ContentValues.TAG;

public class myWifi {
    private static WifiManager.LocalOnlyHotspotReservation mReservation;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void turnOnHotspot(Activity context) {
        final WifiManager manager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        //위치정보  확인
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //위치정보 혀용 여부 묻기
            if(ActivityCompat.shouldShowRequestPermissionRationale(context,Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(context,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);
            }
            else {
                ActivityCompat.requestPermissions(context,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);
            }

            return;
        }
        manager.startLocalOnlyHotspot(new WifiManager.LocalOnlyHotspotCallback() {

            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onStarted(WifiManager.LocalOnlyHotspotReservation reservation) {
                super.onStarted(reservation);
                Log.d(TAG, "Wifi Hotspot is on now");
                mReservation = reservation;

                WifiConfiguration _conf = mReservation.getWifiConfiguration();
                Log.d(TAG,"ssid : " + mReservation.getWifiConfiguration().SSID);
                Log.d(TAG,"key : " + mReservation.getWifiConfiguration().preSharedKey);

            }

            @Override
            public void onStopped() {
                super.onStopped();
                Log.d(TAG, "onStopped: ");
            }

            @Override
            public void onFailed(int reason) {
                super.onFailed(reason);
                Log.d(TAG, "onFailed: ");
            }
        }, new Handler());
    }

    public static void turnOffHotspot() {
        if (mReservation != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mReservation.close();
            }
        }
    }
}
