package Thread_Study;

public class Demo2 {
    public static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread is runing");

            this.notify();
        }

    }
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread());
        t.start();

        // Java 8 函数式编程，可以省略MyThread类
        new Thread(() -> {
            System.out.println("Java 8 匿名内部类");
        }).start();
    }
}
