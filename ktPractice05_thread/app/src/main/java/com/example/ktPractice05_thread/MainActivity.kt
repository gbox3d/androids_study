package com.example.ktPractice05_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//코루틴
//https://codechacha.com/ko/android-coroutine/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_1.setOnClickListener {
            Test1().start()
        }

        button_2.setOnClickListener {

            println("main thread")
            GlobalScope.launch {
                for( _i in 1..10)
                {
                    println("in coroutin count ${_i}")
                    delay(500)
                }

                println("done in coroutin")
            }

            println("done mainthread")

        }

    }

    class Test1:Thread() {
        override fun run() {
            for(_i in 1..10) {
                println("count : ${_i}")
                sleep(500)
            }
            println("stop test1")
        }
    }


}