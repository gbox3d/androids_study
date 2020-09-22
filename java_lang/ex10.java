//증가 감소연산자
public class ex10 {
    public static void main(String[] args) {

        int count = 0;

        System.out.println("증가 연산자 ");
        count++;
        //count = count + 1;
        //count += 1;

        System.out.println(count);

        System.out.println(count++); //넘기고 증가
        System.out.println(++count); // 증가 하고 넘기기 

        System.out.println("감소 연산자 ");
        count--;
        System.out.println(count);
        
    }
    
}
