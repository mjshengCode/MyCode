package com.example.activityandservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MsgReceiver msgReceiver;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registered();
    }

    //动态注册广播
    private void registered() {
        msgReceiver = new MsgReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.mjsheng.mycode.RECEIVER");
        registerReceiver(msgReceiver,intentFilter);
    }

    public void start(View view) {
        mIntent = new Intent();
        mIntent.setClass(MainActivity.this, DownloadService.class);
        startService(mIntent);
    }

    //广播接受者
    public class MsgReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //拿到进度，更新UI
            String info = intent.getStringExtra(DownloadService.PRINT_DATA);
            System.out.println(info+"----------MainActivity");
            //            mProgressBar.setProgress(progress);
        }

    }

    @Override
    protected void onDestroy() {
        stopService(mIntent);
        super.onDestroy();
    }
}
