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

                println("end coroutin ?")
            }

            println("start coroutin")
        }

        btn_launch_test.setOnClickListener {

            tv_out.text = ""

            GlobalScope.launch(Dispatchers.IO) {

                delay(500)
                launch(Dispatchers.Main) {
                    tv_out.text = tv_out.text.toString().plus("step 0\n")
                }

                launch(Dispatchers.Main) {
                    delay(300)
                    tv_out.text = tv_out.text.toString().plus("step 1\n")
                }
                launch(Dispatchers.Main) {
                    delay(250)
                    tv_out.text = tv_out.text.toString().plus("step 2\n")
                }
            }

            tv_out.text = tv_out.text.toString().plus("step 3\n")
        }

        button_withContext.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {

                //블럭안의 내용이 끝날때까지 기다렸다가 진행 
                withContext(Dispatchers.Main) {
                    delay(3000)
                    println("step 1")
                    tv_out.text = tv_out.text.toString().plus("\nstep 1")
                }

                withContext(Dispatchers.Default) {
                    delay(1000)
                    println("step 2")
                }

            }
            tv_out.text = "with context test start"
        }
    }


}