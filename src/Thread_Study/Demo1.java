package Thread_Study;
//线程的实现1 继承Thread类

public class Demo1 extends Thread{

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread is runing");
            try {

                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("MyThread is end");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new MyThread();

        //调用start方法才启动
        myThread.start();

        synchronized (myThread){
            myThread.wait();
        }
        System.out.println("Main ----------------");
    }
}