package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.content.res.Configuration;
import android.widget.Toast;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;


/**
 * 作业1：
 * 打印出Activity屏幕切换 Activity会执行什么生命周期？
 */
public class Exercises1 extends AppCompatActivity {
    private static final String TAG = "LifeStyle";
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d(TAG,ON_CREATE);
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText("Hello World!");
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,ON_RESTART);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,ON_START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,ON_RESUME);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,ON_STOP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,ON_DESTROY);
    }


}
