package com.example.ktpactice01

import gbox3d.byteutil.*

//https://zion830.tistory.com/39
//https://stackoverflow.com/questions/56872782/convert-byte-array-to-int-odd-result-java-and-kotlin

fun main()
{
    var _buf = UByteArray(18)

    setAsShort(_buf,0,258)
    setAsInt(_buf,2,314)
    setAsFloat(_buf,6,3.14f)
    setAsDouble(_buf,10,3.1415926)

//    var pi = 3.1415926
//    var _pi = pi.toBits()
//
//    println(_pi)
//    println(Double.fromBits(_pi))

//    setAsFloat(_buf,6,3.14f)


    println( getAsShort(_buf,0) )
    println( getAsInt(_buf,2) )
    println( getAsFloat(_buf,6) )
    println( getAsDouble(_buf,10) )


}
