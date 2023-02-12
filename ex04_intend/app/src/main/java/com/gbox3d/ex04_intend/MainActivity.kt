package com.gbox3d.ex04_intend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private val TAG:String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_page2 : Button = findViewById(R.id.btn_page2)
        val te_msg: EditText = findViewById(R.id.te_msg)
        val btn_pref:Button = findViewById(R.id.btn_prefernce)

        btn_page2.setOnClickListener {
            Log.d(TAG,"click go page2")

            val _intent = Intent(this,MainActivity2::class.java)

            _intent.putExtra("msg", te_msg.text.toString())

            te_msg.setText("")

            startActivity(_intent)
        }

        btn_pref.setOnClickListener {
            val _intent = Intent(this,PrefActivity::class.java)
            startActivity(_intent)
        }



    }
}