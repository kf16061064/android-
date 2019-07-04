package com.bytedance.android.lesson.restapi.solution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_s1).setOnClickListener(this);
        findViewById(R.id.btn_s2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_s1:
                Solution2C1(v);
                break;
            case R.id.btn_s2:
                Solution2C2(v);
                break;
        }
    }

    public void Solution2C1(View view) {
        startActivity(new Intent(this, Solution2C1Activity.class));
    }

    public void Solution2C2(View view) {
        startActivity(new Intent(this, Solution2C2Activity.class));

    }
}
