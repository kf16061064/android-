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

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 *
 */
public class Exercises3 extends AppCompatActivity implements View.OnClickListener{
    private ListView mListView;
    private Context mContext;
    private List<User> userList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);
        findViewById(R.id.bt6).setOnClickListener(this);
        findViewById(R.id.bt7).setOnClickListener(this);
        findViewById(R.id.bt8).setOnClickListener(this);

        mContext = Exercises3.this;
        mListView = (ListView) this.findViewById(R.id.rv_list);

        /* 模拟数据 */
        userList = new ArrayList<User>();

        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setName("用户" + i);
            //user.setDescription("小巫不用说都应该知道是谁的啦！！！");
            userList.add(user);
        }

        mListView.setAdapter(new ListViewAdapter(this, userList));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: 点击列表跳转到其他页面
                Toast.makeText(getApplicationContext(),"用户"+position,Toast.LENGTH_LONG).show();
                Intent it=new Intent(getApplicationContext(), FinalChatActivity.class);
                it.putExtra("data", "这是来自用户"+ position+"消息");
                startActivity(it);
            }

        });

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



    private class ListViewAdapter extends BaseAdapter {

        private List<User> users;

        public ListViewAdapter(Context context, List<User> users) {
            this.users = users;
        }

        @Override
        public int getCount() {
            return users != null ? users.size() : 0;
        }

        @Override
        public User getItem(int position) {
            return users.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.im_list_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.itemTitle = (TextView) convertView.findViewById(R.id.tv_title);
                viewHolder.itemTime = (TextView) convertView.findViewById(R.id.tv_time);
                viewHolder.itemDesc = (TextView) convertView.findViewById(R.id.tv_description);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            User user = getItem(position);
            if (user != null) {
                // 这里只是模拟，实际开发可能需要加载网络图片，可以使用ImageLoader这样的图片加载框架来异步加载图片
                viewHolder.itemTitle.setText(user.getName());
                viewHolder.itemTime.setText(user.getTime());
                viewHolder.itemDesc.setText(user.getDescription());

            }

            return convertView;
        }

        class ViewHolder {
            TextView itemTitle;
            TextView itemTime;
            TextView itemDesc;
        }
    }
}


