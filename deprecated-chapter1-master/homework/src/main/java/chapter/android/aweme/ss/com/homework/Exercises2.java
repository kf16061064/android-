package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout);
        LinearLayout layout= (LinearLayout) findViewById(R.id.lv1);
        int count=getViewCount(layout);
        TextView textView=(TextView) findViewById(R.id.tv2);
        textView.setText(String.valueOf(count));
        Log.i("Number", "共有"+count+"子view");
    }

    public static int getViewCount(View view) {
        //todo 补全你的代码
        int viewCount = 0;

        if (null == view) {
            return 0;
        }

        if (view instanceof LinearLayout) {
            viewCount++;
            for (int i = 0; i < ((LinearLayout) view).getChildCount(); i++) {
                View view1 = ((LinearLayout) view).getChildAt(i);
                if (view1 instanceof LinearLayout) {
                    viewCount += getViewCount(view1);
                } else {
                    viewCount++;
                }
            }
        }

        //Log.i("Number", "MainActivity共有"+viewCount+"子view");

        return viewCount;
    }
}
