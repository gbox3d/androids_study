//논리 연산자 2 &&,||
public class ex12 {
    
    public static void main(String[] args) {
        int a = 5;

        Boolean _r = (a> 3) && (a < 10); //AND
        System.out.println(_r);

        _r = (a == 3) || (a == 5); //OR
        System.out.println(_r);

        
        System.out.println("not : " + !_r); //부정

        //대입도 논리 연산 값으로 간주 
        System.out.println( "_r = false :" +  (_r = false) );
        System.out.println( "_r = true :" + (_r = true) );
        

        //연산 생략 , 좌측부터 우선
        System.out.println(  (a == 7) && (_r = false));
        System.out.println(_r);
        
        
    }
}
