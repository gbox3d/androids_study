package gbox3d.byteutil

//https://zion830.tistory.com/39

fun littleEndianConversion(bytes: UByteArray): ULong {
    var result:ULong = 0u

    bytes[0].toULong().shl(8)

    for (i in bytes.indices) {
        result = result or bytes[i].toULong().shl(8*i)
    }
    return result
}



fun getAsShort(buf:UByteArray,_offset:Int) : Short {

//    var _bytes = buf.copyOfRange(_offset,_offset+2)
//    var _r = littleEndianConversion(_bytes)
    return littleEndianConversion(buf.copyOfRange(_offset,_offset+2)).toShort()
}

fun getAsInt(buf:UByteArray,_offset: Int) : Int {
    return littleEndianConversion(buf.copyOfRange(_offset,_offset+4)).toInt()
}

fun getAsLong(buf:UByteArray,_offset: Int) : Long {

    return littleEndianConversion(buf.copyOfRange(_offset,_offset+8)).toLong()
}

fun getAsFloat(buf:UByteArray,_offset: Int) : Float {

    return Float.fromBits(littleEndianConversion(buf.copyOfRange(_offset,_offset+4)).toInt())

//    return littleEndianConversion(buf.copyOfRange(_offset,_offset+4)).toFloat()
}

fun getAsDouble(buf:UByteArray,_offset: Int) : Double = Double.fromBits(littleEndianConversion(buf.copyOfRange(_offset,_offset+8)).toLong())

//    var _v = littleEndianConversion(buf.copyOfRange(_offset,_offset+8)).toLong()

//    println(littleEndianConversion(buf.copyOfRange(_offset,_offset+8)))
//    println(_v)

//    return Double.fromBits(littleEndianConversion(buf.copyOfRange(_offset,_offset+8)).toLong())
//}

fun setAsShort(buf: UByteArray,offset:Int,_data:Int) {
    buf[offset] = _data.toUByte() and 0xffu
    buf[offset+1] = (_data shr 8).toUByte()
}

fun setAsInt(buf: UByteArray,offset:Int,_data:Int) {
    buf[offset] = _data.toUByte() and 0xffu
    buf[offset+1] = (_data shr 8).toUByte()
    buf[offset+2] = (_data shr 16).toUByte()
    buf[offset+3] = (_data shr 24).toUByte()
}

fun setAsFloat(buf: UByteArray,offset:Int,_data:Float) {
    var _bits = _data.toBits()
    buf[offset] = _bits.toUByte() and 0xffu
    buf[offset+1] = (_bits shr 8).toUByte()
    buf[offset+2] = (_bits shr 16).toUByte()
    buf[offset+3] = (_bits shr 24).toUByte()
}

fun setAsLong(buf: UByteArray,offset:Int,_data:Long) {

    var _offset = offset

    buf[_offset++] = _data.toUByte() and 0xffu
    buf[_offset++] = (_data shr 8).toUByte()
    buf[_offset++] = (_data shr 16).toUByte()
    buf[_offset++] = (_data shr 24).toUByte()
    buf[_offset++] = (_data shr 32).toUByte()
    buf[_offset++] = (_data shr 40).toUByte()
    buf[_offset++] = (_data shr 48).toUByte()
    buf[_offset++] = (_data shr 56).toUByte()
}

fun setAsDouble(buf: UByteArray,offset:Int,_data:Double) {
    var _bits = _data.toBits()
    var _offset = offset

//    println(_bits)

    buf[_offset++] = _bits.toUByte() and 0xffu
    buf[_offset++] = (_bits shr 8).toUByte()
    buf[_offset++] = (_bits shr 16).toUByte()
    buf[_offset++] = (_bits shr 24).toUByte()
    buf[_offset++] = (_bits shr 32).toUByte()
    buf[_offset++] = (_bits shr 40).toUByte()
    buf[_offset++] = (_bits shr 48).toUByte()
    buf[_offset++] = (_bits shr 56).toUByte()
}
