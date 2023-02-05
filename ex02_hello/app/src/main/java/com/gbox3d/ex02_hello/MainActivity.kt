package com.gbox3d.ex02_hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gbox3d.ex02_hello.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        mBinder = ActivityMainBinding.inflate(layoutInflater)
        val view = mBinder.root

        setContentView(view)

        mBinder.btnOk.setOnClickListener{
            val name = mBinder.edName.text

            Log.d("Main", "${name}")

            mBinder.tvName.text = name
        }


    }
}