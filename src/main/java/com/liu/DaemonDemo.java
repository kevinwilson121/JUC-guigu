package com.liu;

import java.util.concurrent.TimeUnit;

public class DaemonDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "\t -----start" + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
            while (true){

            }
            }, "t1");

        t1.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName() + "\t -----end");
    }
}
