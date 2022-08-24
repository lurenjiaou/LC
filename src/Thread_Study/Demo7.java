package Thread_Study;

import java.util.concurrent.locks.LockSupport;

public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                System.out.println("Thread is running");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        System.out.println("waiting");
        Thread thread2 = new Thread(()->{
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread2 is running");
        });
        thread2.start();
        System.out.println("end");
    }
}
