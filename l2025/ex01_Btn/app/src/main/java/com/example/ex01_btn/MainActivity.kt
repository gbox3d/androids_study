package com.example.ex01_btn

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex01_btn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var tvMsg: TextView
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvMsg = findViewById<TextView>(R.id.TextMsg)
        val btnTest = findViewById<Button>(R.id.btnTest1)


        btnTest.setOnClickListener {
            tvMsg.setText("Button Clicked")
        }


        binding.btnTest2.setOnClickListener {
            binding.TextMsg.text = "Binding Clicked"
        }

    }
}