package com.bytedance.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    int i=0;
    RadioButton yes;
    RadioButton no;
    RadioGroup judge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        judge=findViewById(R.id.judge);
        Button btn1=findViewById(R.id.btn1);
        final TextView tv1=findViewById(R.id.tv1);

        judge.setOnCheckedChangeListener(new MyRadioButtonListener());


        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    switch(i) {
                        case 0:
                            tv1.setBackgroundResource(R.drawable.image2);
                            i++;
                            break;
                        case 1:
                            tv1.setBackgroundResource(R.drawable.image1);
                            i++;
                            break;
                    }
                    if(i>1) i=0;
            }
        });
    }
    class MyRadioButtonListener implements OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // 选中状态改变时被触发
            switch (checkedId) {
                case R.id.yes:
                    Log.i("name", "当前用户选择"+yes.getText().toString());
                    break;
                case R.id.no:
                    Log.i("name", "当前用户选择"+yes.getText().toString());
                    break;
            }
        }
    }
}
