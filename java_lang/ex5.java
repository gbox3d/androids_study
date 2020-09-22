public class ex5 {
    public static void main(String[] args) {
        int a;
        double b = 0.5;
        System.out.println(b);
        a = (int)b;
        
        System.out.println(a); //버림 
        System.out.println( (int)b+1 ); //올림
        System.out.println( (int)(b+0.5) ); //반올림
    }
}
