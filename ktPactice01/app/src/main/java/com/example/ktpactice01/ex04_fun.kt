package com.example.ktpactice01

fun doubler(x : Int) : Int
{
    return x*2
}

//리턴문만 있을때 간편표기
fun plustwo(x:Int) = x+2

//기본인자
fun hello(name : String ="anymouse")
{
    println("hello $name")
}

fun make_party(footman:String,mage:String,captine:String)
{
    println("footman is $footman , mage : $mage , captine is : $captine")
}

fun <T>variableArgument(vararg ts:T)
{
    for( t in ts)
    {
        println(t)
    }
}

fun main()
{
    println(doubler(3))
    println(plustwo(3))

    hello("rambo")
    hello()

    make_party(captine = "siver",footman = "valman",mage = "yushine")

    variableArgument(1,2,3,4,"hello","gonichiwa","nihao",3.14,true)


}