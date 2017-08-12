package com.jiangdg.signalviewdemo;

import android.app.Activity;
import android.os.Bundle;

import com.jiangdg.singalviewlib.SignalView;

public class MainActivity extends Activity {
    private SignalView mSignalView;
    private SignalView mSignalView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSignalView = (SignalView)findViewById(R.id.signal);
        // 设置信号强度
        mSignalView.setSignalValue(5);
        // 设置信号类型
        mSignalView.setSignalTypeText("4G");

        mSignalView1 = (SignalView)findViewById(R.id.signal_1);
        mSignalView1.setSignalValue(2);
        mSignalView1.setSignalTypeText("wifi");
    }
}
