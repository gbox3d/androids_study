package com.boltec.gbox3d.exam02j2kotlin

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


fun helloMessage(name:String) : String
{
    return "hello ${name}"
}

//helloMessage 의 다른 표현
fun helloMsg(name:String) : String = "hello ${name}"

fun helloMessageByKotlin(_activity : AppCompatActivity,name:String)
{
    _activity.test_textView2.text = "yo! ${name}"
}