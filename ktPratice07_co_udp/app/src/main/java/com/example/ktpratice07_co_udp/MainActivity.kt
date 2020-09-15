package com.example.ktpratice07_co_udp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_test_1.setOnClickListener {
            GlobalScope.launch {
                delay(3000)

                GlobalScope.launch(Dispatchers.Main) {
                    tv_test_1.text = "hello"
                }


            }

            println("click")
        }
    }
}