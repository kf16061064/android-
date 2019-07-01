package chapter.android.aweme.ss.com.homework;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;

public class ChatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final TextView textView=findViewById(R.id.tv_re);
        Button button1=findViewById(R.id.bt_re);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data = getIntent().getStringExtra("data");
                textView.setText(data);
                Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG);

            }
        });
    }
}
