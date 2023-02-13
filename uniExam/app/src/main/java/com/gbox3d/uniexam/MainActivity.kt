package com.gbox3d.uniexam

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    //https://winterpoet-kim.tistory.com/25



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_coroutin).setOnClickListener {
            val _intent = Intent(this,EampleCoroutinActivity::class.java)
            startActivity(_intent)
        }

        val activityLauncher= openActivityResultLauncher()

        findViewById<Button>(R.id.btn_subactivity).setOnClickListener {
            val _intent = Intent(this,ExampleSubActivity::class.java)
            _intent.putExtra("req","gbox3d") //보내기
            activityLauncher.launch(_intent)
        }
    }

    private fun openActivityResultLauncher(): ActivityResultLauncher<Intent> {

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "수신 성공", Toast.LENGTH_SHORT).show()

                val msg =  result.data?.getStringExtra("res")
                val tv_output:TextView = findViewById(R.id.tv_output)

                println(msg)
                tv_output.text = msg
//                binding.tvComeback.text = result.data?.getStringExtra("comeback")
            }
            else {
                Toast.makeText(this, "수신 실패", Toast.LENGTH_SHORT).show()
            }
        }
        return resultLauncher
    }


}