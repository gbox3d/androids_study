
public class ex23 implements Runnable {

    public boolean m_bLoop;

    ex23() {
        m_bLoop = true;
    }

    @Override // 오버라이드 함수 체크 어노테이션
    public void run() {

        try {
            int _count = 0;

            while (_count <= 3) {

                Thread.sleep(1000);

                System.out.println(Thread.currentThread().getName() + " , count " + _count++);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            System.out.println(Thread.currentThread().getName() + " , end");
        }
    }

    public static void main(String[] args) {

        ex23 _ctx = new ex23();
        ThreadEX _ctxEx = new ThreadEX();
        Thread _thred = new Thread(_ctx, "thread1");
        Thread _thredEx = new Thread(_ctxEx, "thread2");

        try {
            _thred.start();
            _thredEx.start();
            Thread.sleep(2000);
            _ctx.m_bLoop = false;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

}

public class ThreadEX implements Runnable {

    @Override
    public void run() {
        try {
            // TODO Auto-generated method stub
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " , count " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + " , end");
        }

    }
}
