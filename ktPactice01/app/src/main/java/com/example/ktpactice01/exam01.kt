package com.example.ktpactice01

fun test() {
    println("hello world")
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun mul(a:Int,b:Int) = a*b

fun main() {
    test()
    println(add(3, 5))

    var a = 10
    var b = 5

    println( "$a * $b mul is ${mul(a,b)} " )

    //외부 모듈 실행
    foo().hello()

    foo_SayHello()


}