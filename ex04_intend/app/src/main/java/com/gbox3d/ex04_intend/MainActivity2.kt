package com.gbox3d.ex04_intend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private val TAG : String = "MainActivity2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tv_page2_msg:TextView = findViewById(R.id.tv_page2_msg)

        if(intent.hasExtra("msg")) {
            val _msg = intent.getStringExtra("msg")
            if (_msg != null) {
                Log.d(TAG,_msg)
                tv_page2_msg.text = _msg
            }

        }
    }
}