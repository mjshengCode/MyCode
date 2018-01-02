package com.mjsheng.news.callback;

/**
 * Created by mjshe on 2017/12/30.
 */

public class Employee {
    CallBack mCallBack;

    public Employee(CallBack callBack) {
        mCallBack = callBack;
    }

    public void doWork() {
        System.out.println("工作工作");
        mCallBack.doEvent();
    }
}
