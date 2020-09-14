package com.example.ktpractice06_coroutin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_test_1.setOnClickListener() {

            GlobalScope.launch(Dispatchers.IO) {

                var _count = 0
                while (_count < 10) {
                    delay(500)
                    println("io done")
                    _count++
                    tv_test_1.text = "$_count"
                }

            }

        }

        button_test2.setOnClickListener() {
            GlobalScope.launch(Dispatchers.Main) {
                var _count = 0

                while (_count < 10) {
                    val _async = async(Dispatchers.IO) {
                        delay(500)
                        println("done io")
                        _count++
                    }

                    _async.await()
                    tv_test_2.text = "$_count"

                    println("done ui $_count")


                }

            }
        }
    }
}