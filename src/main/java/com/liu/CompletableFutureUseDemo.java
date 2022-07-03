package com.liu;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CompletableFutureUseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ThreadLocalRandom.current().nextInt(10);
        }).whenComplete((v,e)->{
            if (e == null) {
                System.out.println("----计算完成，更新系统" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("异常情况： " + e.getCause()+ "\t" + e.getMessage());
            return null;
        });
        System.out.println(Thread.currentThread().getName());
    }

    private static void future() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ThreadLocalRandom.current().nextInt(10);
        });
        System.out.println(Thread.currentThread().getName());
        System.out.println(future.get());
    }
}
