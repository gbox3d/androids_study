
public class ex22 implements Runnable {

    public boolean m_bLoop;

    ex22() {
        m_bLoop = true;
    }

    @Override // 오버라이드 함수 체크 어노테이션
    public void run() {
        int _count = 0;
        while (_count <= 3) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " , count " + _count++);
        }
        System.out.println(Thread.currentThread().getName() + " , end");
    }

    public static void main(String[] args) {

        ex22 _ctx = new ex22();
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
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {

            System.out.println(Thread.currentThread().getName() + " , count " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " , end");
    }
}
