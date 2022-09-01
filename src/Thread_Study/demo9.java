package Thread_Study;

public class demo9 {
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (k) {
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println("ThreadA: " + i);
                        k.notify();
                        k.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                k.notify();
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (k) {
                for (int i = 0; i < 100; i++) {
                    if (k % 2 == 1) {
                        System.out.println("Thread B " + k);
                        k++;
                    }
                    synchronized (k){
                        try {
                            k.notify();
                            k.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
    static volatile Integer k = 0;
    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }
}
