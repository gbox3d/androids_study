package com.example.ktpractice02

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("hello")

        button_test.setOnClickListener {

            val btn = it as Button
            println("click ${btn.text}")

            btn.setText("clicked!!")

            Log.d("exam02","test click")
        }
    }
}