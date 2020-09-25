package com.example.ktpactice01;

public class SampleJavaClass  {

    public String m_msg;
    SampleJavaClass(String msg) {
        m_msg = msg;
    }

    public void test()
    {
        System.out.println(m_msg);
    }

    public static int rectangleArea(int x, int y){
        int result = x * y;
        return result;
    }
}
