package com.jiangdg.signalviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jiangdg.singalviewlib.SignalView;

public class MainActivity extends AppCompatActivity {
    private SignalView mSignalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSignalView = (SignalView)findViewById(R.id.signal);
        mSignalView.setSignalValue(5);
        mSignalView.setSignalTypeText("4G");
    }
}
