package com.example.ktpactice01


fun main()
{
    //내용이 수정불가능한 리스트
    val _temp = listOf("one","two","three")

    for(s in _temp) {
        println(s)
    }

    println("temp[0] = ${_temp[0]}" )

    //수정 가능한 리스트
    val _muta_list = mutableListOf<Int>()

    _muta_list.add(1)
    _muta_list.add(2)
    _muta_list.add(3)

    println("size is ${_muta_list.size}")

    println("indes 1 : ${_muta_list[1]}")
    _muta_list[1] = 10
    println("indes 1 : ${_muta_list[1]}")

    _muta_list.removeAt(1)

    for(_v in _muta_list)
    {
        println(_v)
    }

    _muta_list.add(4)
    _muta_list.add(5)
    _muta_list.add(6)
    _muta_list.add(7)

    println("--------------------------------")
    for(_v in _muta_list)
    {
        print("$_v,")
    }

    println("\n--------------------------------")

    _muta_list.shuffle()
    for(_v in _muta_list)
    {
        print("$_v,")
    }

    _muta_list.add(index = 0,element = 666)
    _muta_list.add(index = 2,element = 777)
    println("\n--------------------------------")
    for(_v in _muta_list)
    {
        print("$_v,")
    }





}