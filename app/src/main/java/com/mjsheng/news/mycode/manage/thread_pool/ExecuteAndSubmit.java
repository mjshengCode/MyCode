package com.mjsheng.news.mycode.manage.thread_pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by mjshe on 2017/12/28.
 * 对比execute和submit的区别
 */

public class ExecuteAndSubmit {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        /*****************************execute*******************************/

        //execute(Runnable x) 没有返回值。可以执行任务，但无法判断任务是否成功完成。
        //es.execute(new RunnableTest("Take1"));


        /*****************************submit*******************************/

        //submit(Runnable x) 返回一个future。可以用这个future来判断任务是否成功完成。请看下面：
        Future future = es.submit(new RunnableTest("Task2"));

        try {
            if (future.get() == null) {
                System.out.println("任务完成");
            }
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            // 否则我们可以看看任务失败的原因是什么
            System.out.println(e.getCause().getMessage());
        }

    }
}

class RunnableTest implements Runnable {

    private String takeName;

    public RunnableTest(String takeName) {
        this.takeName = takeName;
    }

    @Override
    public void run() {
        System.out.println("inside" + takeName);
        throw new RuntimeException("RuntimeException from inside" + takeName);
    }
}
