package com.example.ktpractice_udp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import gbox3d.byteutil.getAsInt
import gbox3d.byteutil.setAsInt
import gbox3d.byteutil.setAsShort
import kotlinx.android.synthetic.main.activity_main.*
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class MainActivity : AppCompatActivity() {

    companion object {
        var m_ip:String = "192.168.4.2"
        var m_Handler = Handler()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText_ip.setText(m_ip)

        button_send.setOnClickListener {
            m_ip = editText_ip.text.toString()
            Udp_SendAndReceive().start()
        }


    }

    class Udp_SendAndReceive : Thread() {
        override fun run() {
            try {
                val socket = DatagramSocket()
                var serverAddress = InetAddress.getByName(m_ip)
                val _buf = UByteArray(128)

                _buf[0] = 0x02u
                _buf[1] = 0x05u
                setAsShort(_buf,2,0)
                setAsInt(_buf,4,20200910)
                setAsInt(_buf,8,4)
                setAsInt(_buf,12,0)

                _buf[16] = 0x00u
                _buf[17] = 0x03u

                val packet = DatagramPacket(_buf.toByteArray(),18,serverAddress,50020)

                socket.send(packet)

                // receiver
                val _res_buf = ByteArray(128)
                val _res_packet = DatagramPacket(_res_buf,128)

                socket.receive(_res_packet)

                println("receive data")
                for(_b in _res_packet.data) {
                    print("$_b, ")
                }
                println("")
                println(" date : ${getAsInt(_res_packet.data.toUByteArray(),12)}")
                println(" time : ${getAsInt(_res_packet.data.toUByteArray(),16)}")


            }
            catch (e:Exception) {

            }

        }

    }
}