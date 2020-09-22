//스캐너 IO
import java.util.Scanner;

public class ex16_1 {
    public static void main(String[] args) {

        Scanner _sc = new Scanner(System.in);

        System.out.println("input integer : ");
        int _a = _sc.nextInt();
        System.out.println("result : " + _a );

        _sc.nextLine();

        System.out.println("input String : ");
        String _b = _sc.nextLine();
        System.out.println("result : " + _b );

        // _sc.nextLine();

        System.out.println("input double : ");
        Double _c = _sc.nextDouble();
        System.out.println("result : " + _c );



        
    }
}
