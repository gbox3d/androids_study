package com.example.ktpactice01

//상속을 허용 하려면 open
open class Shape {
    lateinit var m_color :String
    constructor( color:String) {
        m_color = color
    }
    open fun Draw() {

        println("draw shape with $m_color")
    }
}

//상속받기
class Rect(color: String) : Shape(color) {

    override fun Draw() {
        println("draw rectangle with $m_color")

    }
}

//super 사용
class Circle(color: String) : Shape(color) {

    override fun Draw() {
        super.Draw()
        println("draw Circle with $m_color")
    }
}

//companion object로 정적변수 만들기
class TriAngle(color: String) : Shape(color) {

    companion object {
        val name = "triangle"
    }

    override fun Draw() {

        println("draw Triable with $m_color")
    }
}


fun main()
{
    val _list = ArrayList<Shape>()

    _list.add(Shape("red"))
    _list.add(Shape("blue"))
    _list.add(Rect("blue"))
    _list.add(Circle("yellow"))


    for( shape in _list )
    {
        println("------------------------------------")
        shape.Draw()

    }

    println(TriAngle.name)

}