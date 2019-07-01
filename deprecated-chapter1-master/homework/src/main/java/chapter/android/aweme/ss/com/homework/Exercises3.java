package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ListView;
import org.w3c.dom.Text;
import android.widget.ArrayAdapter;

import java.util.zip.Inflater;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        /*
        Button bt1 =(Button) findViewById(R.id.bt1);
        Button bt2 =(Button) findViewById(R.id.bt2);
        Button bt3 =(Button) findViewById(R.id.bt3);
        Button bt4 =(Button) findViewById(R.id.bt4);
        Button bt5 =(Button) findViewById(R.id.bt5);
        Button bt6 =(Button) findViewById(R.id.bt6);
        Button bt7 =(Button) findViewById(R.id.bt7);
        Button bt8 =(Button) findViewById(R.id.bt8);
        */
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);
        findViewById(R.id.bt6).setOnClickListener(this);
        findViewById(R.id.bt7).setOnClickListener(this);
        findViewById(R.id.bt8).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                System.out.println("get");
                Intent intent=new Intent(this, ChatActivity.class);
                System.out.println("--------------------------------------------");
                intent.putExtra("data", "这是 粉丝 按钮");
                System.out.println("********************************************");
                startActivity(intent);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                break;
            case R.id.bt2:
                Intent intent1=new Intent(this, ChatActivity.class);
                intent1.putExtra("data", "这是 赞 按钮");
                startActivity(intent1);
            case R.id.bt3:
                Intent intent2=new Intent(this, ChatActivity.class);
                intent2.putExtra("data", "这是 @我的 按钮");
                startActivity(intent2);
                break;
            case R.id.bt4:
                Intent intent3=new Intent(this, ChatActivity.class);
                intent3.putExtra("data", "这是 评论 按钮");
                startActivity(intent3);
                break;
            case R.id.bt5:
                Intent intent4=new Intent(this, ChatActivity.class);
                intent4.putExtra("data", "这是 首页 按钮");
                startActivity(intent4);
                break;
            case R.id.bt6:
                Intent intent5=new Intent(this, ChatActivity.class);
                intent5.putExtra("data", "这是 关注 按钮");
                startActivity(intent5);
                break;
            case R.id.bt7:
                Intent intent6=new Intent(this, ChatActivity.class);
                intent6.putExtra("data", "这是 消息 按钮");
                startActivity(intent6);
                break;
            case R.id.bt8:
                Intent intent7=new Intent(this, ChatActivity.class);
                intent7.putExtra("data", "这是 我 按钮");
                startActivity(intent7);
                break;
        }

    }

}

