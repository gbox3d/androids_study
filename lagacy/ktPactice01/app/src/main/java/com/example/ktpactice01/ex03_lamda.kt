package com.example.ktpactice01

//참고자료
//https://codechacha.com/ko/kotlin-lambda-expressions/

val lambada = {
    println("lanbada")
}

val outMsg : (String)->Unit = { msg ->

    println(msg)
    println("hi")
}

val sum: (Int, Int) -> Int = { x, y -> x+y }

//인자가 하나일때는 생략 가능 인자이름은 it으로 사용
val _greeting : (String)->String  = {
//    println("hi")
//    println("hello $it ")
    var _temp:String = ""
    if (it == "rambo") {
        _temp = "u're wellocom $it"
    }
    else {
        _temp = "kick as hole"
    }
    _temp
}



fun main() {
    //람다호출하기
    lambada.invoke()
    lambada()

    //변수처럼 사용하기
    var _ramboda = lambada
    _ramboda()

    outMsg("hello")

//    sum(1,2)

    println(sum(1, 2))

    println(_greeting("rambo"))
    println(_greeting("lambo"))

}