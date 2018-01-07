package com.example.activityandservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by mjsheng on 2018/1/2.
 */

public class DownloadService extends IntentService {

    public static final String PRINT_DATA = "print";


    private Intent mIntent = new Intent("com.mjsheng.mycode.RECEIVER");

    private String info = "";

    //这里需无参构造方法，不然在注册时会报错
    public DownloadService() {
        super("DownloadService");
    }

    public DownloadService(String name) {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        startDownload();
    }

    private void startDownload() {
        for(int i=0;i<10;i++) {
            info+=i+"::";

            //发送广播
            mIntent.putExtra(PRINT_DATA, info);
            sendBroadcast(mIntent);

            System.out.println("DownloadService:"+info);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
