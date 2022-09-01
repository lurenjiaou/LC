package Thread_Study;

public class demo10 {
    static public String name1 = "ouge";
    public String name2 = "jiege";
    private static Object lock = new Object();
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println("ThreadA: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }
    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println("ThreadB: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
//        new Thread(new ThreadA()).start();
//        Thread.sleep(1000);
//        new Thread(new ThreadB()).start();

        demo10 user = new demo10();
        System.out.println(user.getClass().getField("name1").get(user));
    }

}
