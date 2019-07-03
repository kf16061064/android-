package com.bytedance.clockapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Message;
import android.os.Handler;

import com.bytedance.clockapplication.widget.Clock;

public class MainActivity extends AppCompatActivity {

    private View mRootView;
    private Clock mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);

        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClockView.setShowAnalog(!mClockView.isShowAnalog());
            }
        });
        final Handler updateHandler = new Handler();
        Runnable timeThread = new Runnable() {
            @Override
            public void run() {
                mClockView.postInvalidate();
                updateHandler.postDelayed(this,1000);
            }
        };
        updateHandler.post(timeThread);

    }


}
