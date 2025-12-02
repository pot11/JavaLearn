package p22;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<CompletableFuture<Void>> futures = Arrays.asList(
                CompletableFuture.runAsync(() -> {
                    System.out.println("任务1开始");
                    sleep(1000);
                    System.out.println("任务1完成");
                }, executor),

                CompletableFuture.runAsync(() -> {
                    System.out.println("任务2开始");
                    sleep(500);
                    throw new RuntimeException("任务2失败！"); // 这个会失败
                }, executor),

                CompletableFuture.runAsync(() -> {
                    System.out.println("任务3开始");
                    sleep(2000);
//                    System.out.println("任务3完成"); // 这个会继续执行
                    throw new RuntimeException("任务2失败！"); // 这个会失败
                }, executor)
        );

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        try {
            allOf.get(); // 这里会抛出 ExecutionException
            System.out.println("所有任务成功完成");
        } catch (Exception e) {
            System.out.println("整体执行失败: " + e.getMessage());
            // 但任务3的完成消息仍然会输出
        }
        executor.shutdown();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
