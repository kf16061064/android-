package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FinalChatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        final TextView textView=findViewById(R.id.tv_content_info);
        String data = getIntent().getStringExtra("data");
        textView.setText(data);
        //Button button1=findViewById(R.id.bt_re);
        /*
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data = getIntent().getStringExtra("data");
                textView.setText(data);
                Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG);

            }
        });*/
    }
}
