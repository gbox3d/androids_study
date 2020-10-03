package com.example.ktproactice_json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //파싱
        button_parse.setOnClickListener {
            val _JsonStr = "{\"r\":\"ok\",\"d\":[[\"12882072\",{\"type\":\"egcs\",\"ip\":\"128.0.0.0\",\"port\":62390,\"version\":110,\"at\":1601393794043}]]}"

            val _root = JSONObject(_JsonStr)
            println("r : ${_root["r"]}")

            val _data = _root["d"] as JSONArray
            val _item = _data[0] as JSONArray

            println("id : ${_item[0]}")
            println("data : ${_item[1]}")

            println("type : ${(_item[1] as JSONObject)["type"]}")

        }

        //생성
        button_stringify.setOnClickListener {
            val _root = JSONObject()
            _root.put("name","kotlin")
            _root.put("age",3)

            //배열 추가하기
            val _subroot = JSONArray()
            _subroot.put("pi")
            _subroot.put(3.14)
            _subroot.put(360)

            _root.put("data",_subroot)

            val _outStr = _root.toString()



            println(_outStr)
        }
    }
}