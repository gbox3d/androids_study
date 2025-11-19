package com.example.exam05activity03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtMsg = findViewById<EditText>(R.id.edtMsg)
        val btnSend = findViewById<Button>(R.id.btnSend)
        val btnDlg = findViewById<Button>(R.id.btnDlg)


        btnSend.setOnClickListener {
            val msg = edtMsg.text.toString()

            val _intent = Intent(this, SubActivity::class.java)

            _intent.putExtra("msg", msg)

            startActivity(_intent)
        }

        btnDlg.setOnClickListener {
            showInputDialog(edtMsg)
        }
    }

    private fun showInputDialog(targetEditText: EditText) {

        val dialogEditText = EditText(this)
        dialogEditText.hint = "Enter your message"

        val _builder = AlertDialog.Builder(this)
        _builder.setTitle("Input Dialog")
        _builder.setMessage("Please enter a message:")
        _builder.setView(dialogEditText)
        _builder.setPositiveButton("OK") { _, _ ->
            val inputText = dialogEditText.text.toString()
            targetEditText.setText(inputText)
            Toast.makeText(this, "Input: $inputText", Toast.LENGTH_SHORT).show()
        }
        _builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        _builder.show()
    }
}