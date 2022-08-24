package Thread_Study;

public class Demo6 {
    Integer x = 1;
    class MyThread1 extends Thread{
        @Override
        public void run(){
            synchronized (x){
                try {
                    System.out.println(this.getName()+"  is waiting");
                    x.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(this.getName()+"  is runing");
        }
    }
    class MyThread2 extends Thread{
        @Override
        public void run(){
            synchronized (x){
                x.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Demo6().testwait();
    }

    private void testwait() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread tmp = new MyThread1();
            tmp.setName("MyThread  "+i);
            tmp.start();
        }
        Thread.sleep(1000);
        for (int i = 0; i < 100; i++) {
            Thread tmp = new MyThread2();
            tmp.start();
            Thread.sleep(100);
        }
    }
}
