package com.example.exam06list

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 데이터 저장용 리스트
    private val todoList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 뷰 바인딩 (findViewById 사용)
        val edtMsg = findViewById<EditText>(R.id.edtMsg)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val listView = findViewById<ListView>(R.id.listView)

        // 어댑터 설정 (기본 제공 레이아웃 simple_list_item_1 사용)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todoList)
        listView.adapter = adapter

        // 버튼 클릭 리스너
        btnAdd.setOnClickListener {
            val msg = edtMsg.text.toString()

            if (msg.isNotEmpty()) {
                todoList.add(msg)           // 데이터 추가
                adapter.notifyDataSetChanged() // 리스트뷰 갱신 알림
                edtMsg.text.clear()         // 입력창 초기화
            } else {
                Toast.makeText(this, "내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        // 리스트 아이템 클릭 리스너 (일반 클릭)
        listView.setOnItemClickListener { parent, view, position, id ->
            // position: 클릭한 아이템의 인덱스 (0부터 시작)
            val selectedItem = todoList[position]

            Toast.makeText(this, "선택된 항목: $selectedItem", Toast.LENGTH_SHORT).show()
        }

        // 리스트 아이템 롱 클릭 리스너 (길게 누르기)
        listView.setOnItemLongClickListener { parent, view, position, id ->
            todoList.removeAt(position) // 데이터 삭제
            adapter.notifyDataSetChanged() // UI 갱신

            Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show()

            // true 반환 시, 일반 클릭 이벤트(OnItemClick)가 뒤이어 발생하지 않음
            true
        }
    }
}