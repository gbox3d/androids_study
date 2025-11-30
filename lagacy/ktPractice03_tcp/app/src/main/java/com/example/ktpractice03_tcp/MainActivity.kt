package com.example.ktpractice03_tcp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket
import java.net.Socket
import java.net.SocketException

import gbox3d.byteutil.*


class MainActivity : AppCompatActivity() {

    companion object{
        var socket = Socket()
        var server = ServerSocket()
        lateinit var writeSocket: DataOutputStream
        lateinit var readSocket: DataInputStream
        var ip = "192.168.4.2"
        var port = 5050
        var mHandler = Handler()
        var closed = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText_ip.setText(ip)

        button_connect.setOnClickListener {
            ip = editText_ip.text.toString()
            println("connecting.. ")
            Connect().start()
        }

        button_disconnect.setOnClickListener {
            println("closing.. ")
            DisConnect().start()
        }

        mHandler = object : Handler(Looper.getMainLooper()){  //Thread들로부터 Handler를 통해 메시지를 수신
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                when(msg.what){
                    1->Toast.makeText(this@MainActivity, "IP 주소가 잘못되었거나 서버의 포트가 개방되지 않았습니다.", Toast.LENGTH_SHORT).show()
                    2->Toast.makeText(this@MainActivity, "서버 포트 "+port +"가 준비되었습니다.", Toast.LENGTH_SHORT).show()
                    3->Toast.makeText(this@MainActivity, msg.obj.toString(), Toast.LENGTH_SHORT).show()
                    4->Toast.makeText(this@MainActivity, "연결이 종료되었습니다.", Toast.LENGTH_SHORT).show()
                    5->Toast.makeText(this@MainActivity, "이미 사용중인 포트입니다.", Toast.LENGTH_SHORT).show()
                    6->Toast.makeText(this@MainActivity, "서버 준비에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                    7->Toast.makeText(this@MainActivity, "서버가 종료되었습니다.", Toast.LENGTH_SHORT).show()
                    8->Toast.makeText(this@MainActivity, "서버가 정상적으로 닫히는데 실패하였습니다.", Toast.LENGTH_SHORT).show()
                    9-> println(msg.obj as String)//text_status.text = msg.obj as String
                    11->Toast.makeText(this@MainActivity, "서버에 접속하였습니다.", Toast.LENGTH_SHORT).show()
                    12->Toast.makeText(this@MainActivity, "메시지 전송에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                    13->Toast.makeText(this@MainActivity, "클라이언트와 연결되었습니다.",Toast.LENGTH_SHORT).show()
                    14->Toast.makeText(this@MainActivity,"서버에서 응답이 없습니다.", Toast.LENGTH_SHORT).show()
                    15->Toast.makeText(this@MainActivity, "서버와의 연결을 종료합니다.", Toast.LENGTH_SHORT).show()
                    16->Toast.makeText(this@MainActivity, "클라이언트와의 연결을 종료합니다.", Toast.LENGTH_SHORT).show()
                    17->Toast.makeText(this@MainActivity, "포트가 이미 닫혀있습니다.", Toast.LENGTH_SHORT).show()
                    18->Toast.makeText(this@MainActivity, "서버와의 연결이 끊어졌습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    class Connect:Thread(){

        override fun run(){
            try{
                socket = Socket(ip, port)
                writeSocket = DataOutputStream(socket.getOutputStream())
                readSocket = DataInputStream(socket.getInputStream())
                var _count = 0
                var _fsm = 0
                var _buf = ByteArray(128)
                while (true) {
                    val b = readSocket.read(_buf)

                    if( _buf[0].toInt() == 0x02) {
                        val _opcode = _buf[1]
                        val _id = getAsInt(_buf.toUByteArray(),4)
                        println("opcode : $_opcode")
                        println("id : $_id")
                    }

//                    when(_fsm) {
//                        0-> {
//                            if(b == 0x02) {
//                                _fsm = 10 //header
//                            }
//
//                        }
//                        10-> {
//                            _buf[_count++] = b.toUByte()
//
//                        }
//                    }
//
                    for (_t in _buf) {
                        print("$_t, ")
                    }
                    println("\n $b")

//                    println("recv (${_count}) : $b")

                }

            }catch(e:Exception){    //연결 실패
                println("msg : ${e.message} , ${e.cause}  , closed : $closed")
                if( !closed) {
                    val state = 1
                    mHandler.obtainMessage(state).apply {
                        sendToTarget()
                    }
                    socket.close()
                }

            }

        }
    }

    class DisConnect:Thread() {
        override fun run() {
            try {
                closed = true
                writeSocket.write(0x10)
                socket.close()

                println("connection closed")
            }
            catch (e:Exception) {
                println(e.message)
            }

        }
    }

}



