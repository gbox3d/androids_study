package com.example.ktpractice03_tcp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_connect.setOnClickListener {
            println("connecting.. ")



        }
    }
}

class Connect:Thread() {
    
}