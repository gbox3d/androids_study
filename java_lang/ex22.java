import examCls.*;

public class ex22 {

    public void _hello() {

        System.out.println("hello java");
    }
        
    public static void hello() {
        System.out.println("hello java");
    }
    public static void main(String[] args) {

        hello();

        ex22.hello();

        ex22 _clsobj =  new ex22();
        _clsobj._hello();

        System.out.println( "add : " + CTest.add(1,2));
        System.out.println( "sub : " + CTest.sub(7,2));

        helloCls _helloClsObj = new helloCls();
        _helloClsObj.print();
    }
}


public class CTest {
    public static int add(int a,int b) {
        return a+b;
    }
    public static int sub(int a,int b) {
        return a-b;
    }
}

