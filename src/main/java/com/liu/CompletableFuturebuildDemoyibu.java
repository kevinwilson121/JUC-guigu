package com.liu;

import java.util.concurrent.*;

public class CompletableFuturebuildDemoyibu {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        });

        System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务了");

        System.out.println(future.get());

    }


}
