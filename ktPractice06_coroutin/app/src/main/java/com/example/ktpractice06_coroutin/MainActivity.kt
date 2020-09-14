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

            println("main thread")
            GlobalScope.launch(Dispatchers.IO) {
                for( _i in 1..10)
                {
                    tv_test_1.setText("count : $_i")

                    println("in coroutin count ${_i}")
                    delay(500)

                }

                println("done in coroutin")
            }

            println("done mainthread")


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