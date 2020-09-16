package com.example.ktparatice06_coroutin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_test_1.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {

                var count = 0
                while(count < 10)
                {
                    delay(1000)

                    val _async = GlobalScope.async(Dispatchers.Main) {
                        tv_test_1.text = "hello $count"
                    }
                    _async.await()
                    count++
                }

                delay(1000)

                GlobalScope.launch(Dispatchers.Main) {
                    tv_test_1.text = "end coroutine $count"
                }

                println("end coroutin")
            }

            println("start coroutin")
        }
    }
}