package Thread_Study;

import java.util.concurrent.locks.LockSupport;

public class Demo8 {
    //LockSupport.park() //暂停当前线程
    //LockSupport.unpark(Thread t) //回复t线程

    public static void main(String[] args) {
        Thread t1,t2;
        t1 = new Thread(()->{
            System.out.println("T1 stop");
            LockSupport.park();
            System.out.println("T1 resume");
        });
        t2 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2  resume t1");
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
    }
}
