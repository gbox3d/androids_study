package com.example.basicui01

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

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

        // EditText
        val editTextName = findViewById<EditText>(R.id.editTextName)

        // CheckBox
        val checkBoxAgree = findViewById<CheckBox>(R.id.checkBoxAgree)

        // RadioGroup
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioMale = findViewById<RadioButton>(R.id.radioMale)
        val radioFemale = findViewById<RadioButton>(R.id.radioFemale)

        // Spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinnerItems = arrayOf("서울", "부산", "대전", "광주", "제주")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        spinner.adapter = spinnerAdapter

        // Button for date/time picker
        val btnDate = findViewById<Button>(R.id.btnDate)
        val btnTime = findViewById<Button>(R.id.btnTime)

        // TextView for result
        val textResult = findViewById<TextView>(R.id.textResult)

        // 날짜 선택
        btnDate.setOnClickListener {
            val cal = Calendar.getInstance()
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, { _, y, m, d ->
                textResult.text = "선택한 날짜: $y-${m + 1}-$d"
            }, year, month, day).show()
        }

        // 시간 선택
        btnTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val minute = cal.get(Calendar.MINUTE)

            TimePickerDialog(this, { _, h, m ->
                textResult.text = "선택한 시간: ${h}시 ${m}분"
            }, hour, minute, true).show()
        }

        // 체크박스와 라디오 버튼 선택 이벤트
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            val city = spinner.selectedItem.toString()
            val gender = when (radioGroup.checkedRadioButtonId) {
                R.id.radioMale -> "남성"
                R.id.radioFemale -> "여성"
                else -> "미선택"
            }

            if (checkBoxAgree.isChecked) {
                textResult.text = "이름: $name\n성별: $gender\n도시: $city\n(약관 동의 완료)"
            } else {
                Toast.makeText(this, "약관에 동의해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}