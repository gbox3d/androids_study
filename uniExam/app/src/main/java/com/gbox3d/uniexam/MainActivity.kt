package com.gbox3d.uniexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_coroutin).setOnClickListener {
            val _intent = Intent(this,EampleCoroutinActivity::class.java)
            startActivity(_intent)
        }


    }
}