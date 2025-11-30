package com.example.ktpractice_httpreq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_req.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {

                try {
                    val url = URL("http://ubiqos001.iptime.org:10062/new")
                    val _resText = StringBuffer()

                    with(url.openConnection() as HttpURLConnection) {
                        requestMethod = "GET"
                        println("res code : $responseCode")

                        inputStream.bufferedReader().use {
                            it.forEachLine {  line->
                                _resText.append(line)
                            }
                        }
                    }
                    println(_resText)

                    val _json = JSONObject(_resText.toString())

                    println("time : ${_json["time"]}")

//                    delay(1000)
                    launch(Dispatchers.Main) {
                        tv_output.text = _resText
                    }
                }
                catch (e:Exception){
                    e.printStackTrace()
                }
            }
            println("request...")
        }
    }
}