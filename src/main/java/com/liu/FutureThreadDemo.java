package com.liu;

import java.sql.Time;
import java.util.concurrent.*;

public class FutureThreadDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //三个任务多个异步线程处理 耗时多少

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        long start = System.currentTimeMillis();
        FutureTask<String> futureTask1 = new FutureTask<String>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return "task1 over";
        });

        threadPool.submit(futureTask1);

        FutureTask<String> futureTask2 = new FutureTask<String>(()->{
            TimeUnit.MILLISECONDS.sleep(300);
            return "task1 over";
        });

        threadPool.submit(futureTask2);

        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        TimeUnit.MILLISECONDS.sleep(300);

        long end = System.currentTimeMillis();
        System.out.println("--------------costTime" + (end-start) + "毫秒");
        System.out.println(Thread.currentThread().getName() + "\t ---------end");
        threadPool.shutdown();
    }

    private static void m1() throws InterruptedException {
        //三个任务只有一个线程处理 耗时多少
        long start = System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(5);
        TimeUnit.MILLISECONDS.sleep(3);
        TimeUnit.MILLISECONDS.sleep(2);
        long end = System.currentTimeMillis();

        System.out.println("--------------costTime" + (end-start) + "毫秒");
        System.out.println(Thread.currentThread().getName() + "\t ---------end");
    }
}
