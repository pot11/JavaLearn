package p9;


import java.util.concurrent.*;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws Exception {
//        method1();
//        method2();
        method3();
    }

    private static void method1() throws InterruptedException {
        long start = System.currentTimeMillis();
        //任务一
        Thread.sleep(300);
        //任务二
        Thread.sleep(500);
        //主线程
        Thread.sleep(300);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void method2() throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        Mask1 mask1 = new Mask1();
        Mask2 mask2 = new Mask2();
        FutureTask<String> futureTask1 = new FutureTask<>(mask1);
        FutureTask<String> futureTask2= new FutureTask<>(mask2);
        executorService.submit(futureTask1);
        Thread.sleep(300);
        executorService.submit(futureTask2);
        String s = futureTask1.get();
        String s1 = futureTask2.get();
        System.out.println(s);
        System.out.println(s1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void method3() throws Exception {
        long start = System.currentTimeMillis();
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程一开始");
                    Thread.sleep(300);
                    System.out.println("线程一结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //中间线程（主线程）
        System.out.println("中间线程线程开始");
        Thread.sleep(400);
        System.out.println("中间线程线程结束");

        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程二开始");
                    Thread.sleep(500);
                    System.out.println("线程二结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                return null;
            }
        });
        CompletableFuture.supplyAsync(() -> {return "1";});
        CompletableFuture.supplyAsync(() -> "1");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
