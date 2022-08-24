package Thread_Study;

import java.util.concurrent.*;
//建立线程方法3：实现Callable 接口
//Callable 方法是有返回值的，同时也支持泛型
class Demo3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 模拟计算需要⼀秒
        Thread.sleep(1000);
        return 2;
    }
//    那⼀般是怎么使⽤ Callable 的呢？ Callable ⼀般是配合线程池⼯具ExecutorService 来使⽤。
//    可以使⽤ submit ⽅法来让⼀个 Callable 接⼝执⾏。它会返回⼀个 Future ，我们后续的程序可以通过这个 Future 的 get ⽅法得到结果。
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        // 使⽤
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(new Demo3());
        System.out.println(result.get());
    }
}
