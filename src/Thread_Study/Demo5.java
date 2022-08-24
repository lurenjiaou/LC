package Thread_Study;

public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        new Demo5().testwait();
    }



    //注意点： k.wait()，与k.notify()的使用时要得到k的锁
    //一个线程使用 k.wait()就是使该线程处于等到状态
    //一个线程调用 k.notify()对于在此对象的监视器上等待的所有线程（通过使用任何一个重载 wait() 方法 ），notify() 通知将会随机唤醒任何一个线程。
    private void testwait() throws InterruptedException {
        //WAITING,等待状态。处于等待状态的线程变成RUNNABLE状态需要其他线程唤醒。
        Integer k = 1;
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (k){
                k.notify();
            }
        });
        thread3.start();
        System.out.println(thread3.getState());

        Thread thread4 = new Thread(() -> {
            try {
                //线程4等待线程3的唤醒
                synchronized (k){
                k.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread4.start();
        Thread.sleep(10);
        System.out.println(thread4.getState());
        Thread.sleep(2000);
        System.out.println(thread4.getState());
    }
}
