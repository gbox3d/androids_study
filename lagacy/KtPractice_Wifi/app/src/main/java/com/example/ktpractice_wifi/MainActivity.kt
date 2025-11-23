package com.example.ktpractice_wifi

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Method

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_hotspot_status.setOnClickListener {
            myWifi.turnOnHotspot(this)

        }
        btn_hotspo_off.setOnClickListener {
            myWifi.turnOffHotspot()
        }
    }
}