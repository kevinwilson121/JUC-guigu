package com.liu;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> stringFutureTask = new FutureTask<>(new MyThread());
        new Thread(stringFutureTask,"t1").start();

        System.out.println(stringFutureTask.get());
    }
}

class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("---------call");
        return "Hello";
    }
}


