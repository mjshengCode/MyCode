package com.mjsheng.news.callback;

/**
 * Created by mjshe on 2017/12/30.
 */

public class Boss implements CallBack {
    @Override
    public void doEvent() {
        System.out.println("打电话给老板");
    }
}
