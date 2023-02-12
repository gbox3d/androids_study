package com.gbox3d.ex04_intend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PrefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pref)

        val te_name:EditText = findViewById(R.id.te_name)
        val ok_btn : Button = findViewById(R.id.btn_ok)


        _loadPref(te_name)

        ok_btn.setOnClickListener {

            val pref = getSharedPreferences("pref", MODE_PRIVATE)

            val prefEditor = pref.edit()

            prefEditor.putString("name", te_name.text.toString() )
            prefEditor.apply()

            finish()
        }
    }

    fun _loadPref(te_name : EditText) {
//        val te_name:EditText = findViewById(R.id.te_name)
        val pref = getSharedPreferences("pref", MODE_PRIVATE)
        te_name.setText(pref.getString("name",""))

    }
}