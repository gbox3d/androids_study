package com.example.ktpractics_fileio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mFileName = filesDir.toString() + "/test.txt"
        println(mFileName)

        button_write.setOnClickListener {

//            println("file dir : ${filesDir}")

            mFileName = "${filesDir.toString()}/${te_filename.text.toString()}"

            try {
                if(File(mFileName).exists()) {
                    println("file already exist skip writing")
                }
                else {
                    val bw = BufferedWriter(FileWriter(mFileName, false))
                    val _text = te_out.text
                    bw.write(_text.toString())
                    bw.close()

                    println("success write ${filesDir.toString() + "test.txt"}")
                }

            }
            catch (e: Exception) {
                e.printStackTrace()
            }


        }

        button_read.setOnClickListener {
            mFileName = "${filesDir.toString()}/${te_filename.text.toString()}"
            try {
                if(File(mFileName).exists()) {
                    val br = BufferedReader(FileReader(mFileName))
                    var readStr = ""
                    var str: String? = null
                    while (br.readLine().also { str = it } != null) {
                        readStr += str
                    }
                    br.close()
                    println(readStr)
                    te_out.setText(readStr)
                }
                else {
                    println("file not exist skip reading")
                }

            }
            catch (e: IOException) {
                e.printStackTrace()
            }

        }

        button_del.setOnClickListener {
            mFileName = "${filesDir.toString()}/${te_filename.text.toString()}"
            try {
                val _file = File(mFileName )

                if(_file.exists()) {
                    _file.delete()
                    println("delete ${mFileName}")
                }
                else {
                    println("not exist ${mFileName}")
                }

            }
            catch (e:Exception) {

            }
        }

        button_list.setOnClickListener {
//            mFileName = "${filesDir.toString()}"
            try {
                val _files = File(filesDir.toString() ).list()
//                for( _f in _files) {
//                    println(_f)
//                }
                _files.forEach { println(it) }
            }
            catch (e:Exception) {
                e.printStackTrace()
            }

        }




    }
}