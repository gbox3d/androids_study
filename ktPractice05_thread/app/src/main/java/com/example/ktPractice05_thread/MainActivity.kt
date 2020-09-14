package com.example.ktPractice05_thread

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//코루틴
//https://codechacha.com/ko/android-coroutine/

class MainActivity : AppCompatActivity() {


    companion object {
        lateinit var mHandler:Handler
    }

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
//                    tv_counter2.setText("count : $_i")

                    println("in coroutin count ${_i}")
                    delay(500)

                    mHandler.obtainMessage(0x20).apply {
                        this.arg1 = _i
                        sendToTarget()
                    }

                }

                println("done in coroutin")
            }

            println("done mainthread")

        }

        mHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                println("what : ${msg.what} , arg1 : ${msg.arg1}")

                when(msg.what) {
                    0x10->
                        textView_counter1.setText(" count  : ${msg.arg1}")
                    0x20->
                        tv_counter2.text = " count  : ${msg.arg1}"
                }
            }
        }

    }

    class Test1:Thread() {
        override fun run() {
            for(_i in 1..10) {
                println("count : ${_i}")
                sleep(500)
//                val _msg = mHandler.obtainMessage()
//                _msg.what = 0x10 //count data
//                _msg.arg1 = _i
//                mHandler.sendMessage(_msg)

                mHandler.obtainMessage(0x10).apply {
                    this.arg1 = _i
                    sendToTarget()
                }
            }
            println("stop test1")
        }
    }


}