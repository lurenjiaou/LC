package Thread_Study;
//6种线程状态
// NEW,
// RUNNABLE,
// BLOCKED,
// WAITING,
// TIMED_WAITING,
// TERMINATED;
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        //new 线程被创建，并调用没有start()
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState());
        //TERMINATED线程运行接受
        thread.start();
        Thread.sleep(200);
        System.out.println(thread.getState());
        //RUNNABLE 线程正在运行
        Thread thread2 = new Thread(() -> {});
        System.out.println(thread.getState());


    }

}
