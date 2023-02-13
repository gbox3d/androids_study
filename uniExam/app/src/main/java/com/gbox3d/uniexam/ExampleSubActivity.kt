package com.gbox3d.uniexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ExampleSubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_sub)

        val ed_msg:EditText = findViewById(R.id.ed_subactivity_msg)

        println(intent.getStringExtra("req"))

        val reqMsg = intent.getStringExtra("req")

        findViewById<Button>(R.id.btn_subactivity_ok).setOnClickListener {
            val intent = Intent()

            intent.putExtra("res", "${reqMsg}  ${ed_msg.text.toString()}")
            setResult(RESULT_OK,intent)
            finish()
        }


    }
}