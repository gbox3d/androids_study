package com.gbox3d.uniexam

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class EampleCoroutinActivity : AppCompatActivity() {

    private suspend fun yesnoDlg() : Deferred<String> =
        CoroutineScope(Dispatchers.Main).async {
            println("dlg start")

            var _result = ""
            AlertDialog.Builder(this@EampleCoroutinActivity )
                .setTitle("보안절차")
                .setMessage("관리자 암호를 입력하세요.")
                .setPositiveButton("ok") { dialogInterface: android.content.DialogInterface, i: kotlin.Int ->
                    _result = "ok"
                }
                .setNegativeButton("cancel") { dialogInterface : android.content.DialogInterface, i : Int->
                    _result = "cancel"
                }
                .show()

            while (_result == "") {
                delay(100)
            }

            println("dlg close")

            return@async _result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eample_coroutin)

        val tv_out:TextView = findViewById(R.id.tv_coroutin_out)

        findViewById<Button>(R.id.btn_coroutin_1).setOnClickListener {

            tv_out.text = ""
            CoroutineScope(Dispatchers.Default).launch {

                //  비동기 실행 영역
                launch(Dispatchers.Main) {
                    delay(3000)
                    println("check 1")
                    tv_out.text = tv_out.text.toString() + " check_1 \n"
                }

                //  비동기 실행 영역
                launch(Dispatchers.Main) {
                    delay(2000)
                    println("check 2")
                    tv_out.text = tv_out.text.toString() + " check_2 \n"
                }
            }
        }

        findViewById<Button>(R.id.btn_coroutin_2).setOnClickListener {

            tv_out.setText("")
            CoroutineScope(Dispatchers.IO).launch {

                //  비동기 실행 영역
                launch(Dispatchers.Main) {
                    delay(3000)
                    println("check 1")
                    tv_out.text = tv_out.text.toString() + " check_1 \n"
                }.join() //끝날떄까지 대기한다.

                //  비동기 실행 영역
                launch(Dispatchers.Main) {
                    delay(2000)
                    println("check 2")
                    tv_out.text = tv_out.text.toString() + " check_2 \n"
                }

            }
        }

        findViewById<Button>(R.id.btn_coroutin_async).setOnClickListener {

            tv_out.text = "start ...."
            CoroutineScope(Dispatchers.IO).async {


                val _deferred1 = async {
                    delay(2000)
                    return@async 100
                }
                val _deferred2 = async {
                    delay(1000)
                    var sum = 0
                    for(i in 0..100) {
                        sum += i
                    }
                    return@async sum
                }

                async( Dispatchers.Main) {
                    val a = _deferred1.await()
                    val b = _deferred2.await()
                    tv_out.text = "${ a+b }"
                }

            }
        }

        findViewById<Button>(R.id.btn_coroutin_dlg).setOnClickListener {

            val _context = this

            CoroutineScope(Dispatchers.IO).async {

                var _r = yesnoDlg().await()
                println(_r)
                async(Dispatchers.Main) {
                    tv_out.text = _r
                }
            }

        }


    }
}