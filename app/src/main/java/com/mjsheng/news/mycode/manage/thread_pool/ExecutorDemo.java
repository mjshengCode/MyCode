package com.mjsheng.news.mycode.manage.thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by mjshe on 2017/12/22.
 */

public class ExecutorDemo {
    public static void main(String[] arga) {
//        ExecutorService es = Executors.newSingleThreadExecutor();//单线程池
//        ExecutorService es = Executors.newFixedThreadPool(2); 两个两个执行
//        ExecutorService es = Executors.newCachedThreadPool();

        //2000是延时2秒后执行首个线程 1000是每隔1秒执行一个线程
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        scheduledThreadPool.scheduleAtFixedRate(new Mytask(), 2000, 1000, TimeUnit.MILLISECONDS);
//        for(int i=0;i<111;i++) {
//            Mytask task = new Mytask();
//            es.execute(task);
//        }
    }
}

class Mytask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----任务Task执行----");
    }
}
