package com.bytedance.android.lesson.restapi.solution;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bytedance.android.lesson.restapi.solution.bean.Comment;
import com.bytedance.android.lesson.restapi.solution.bean.CommentResponse;
import com.bytedance.android.lesson.restapi.solution.bean.Feed;
import com.bytedance.android.lesson.restapi.solution.bean.FeedResponse;
import com.bytedance.android.lesson.restapi.solution.bean.Note;
import com.bytedance.android.lesson.restapi.solution.db.TodoContract;
import com.bytedance.android.lesson.restapi.solution.db.TodoDbHelper;
import com.bytedance.android.lesson.restapi.solution.debug.DebugActivity;
import com.bytedance.android.lesson.restapi.solution.newtork.CommentService;
import com.bytedance.android.lesson.restapi.solution.newtork.IMiniDouyinService;
import com.bytedance.android.lesson.restapi.solution.newtork.RetrofitManager;
import com.bytedance.android.lesson.restapi.solution.ui.CommentListAdapter;
import com.bytedance.android.lesson.restapi.solution.ui.NoteListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CommentNet extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD = 1002;

    private RecyclerView recyclerView;
    private CommentListAdapter commentAdapter;
    private List<Comment> mComment = new LinkedList<>();
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //final String vname=getIntent().getStringExtra("vname");
        url=getIntent().getStringExtra("url");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CommentNet.this, NewNoteActivity.class);
                //intent.putExtra("vname",vname);
                intent.putExtra("url",url);
                startActivityForResult(intent, REQUEST_CODE_ADD);
            }
        });

        recyclerView = findViewById(R.id.list_todo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        commentAdapter = new CommentListAdapter(new CommentOperator() {
            @Override
            public void deleteNote(Comment comment) {
                loadNotesFromDatabase();
                //Log.i("Load3",mComment.get(0).toString());
                //commentAdapter.refresh(mComment);
            }

            @Override
            public void updateNote(Comment comment) {
                //CommentActivity.this.updateNode(note);
                loadNotesFromDatabase();
                //Log.i("Load4",mComment.get(0).toString());
                //commentAdapter.refresh(mComment);
            }
        });
        recyclerView.setAdapter(commentAdapter);
        Log.i("msg","运行adapter");

        //System.out.println("111**************");
        loadNotesFromDatabase();
        //System.out.println("222**************");
        //Log.i("Load1",mComment.get(0).toString());
        //commentAdapter.refresh(mComment);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_debug:
                startActivity(new Intent(this, DebugActivity.class));
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD
                && resultCode == Activity.RESULT_OK) {
            //Log.i("onA","wfewgewgwrhw");
            loadNotesFromDatabase();
            //Log.i("Load2",mComment.get(0).toString());
            //commentAdapter.refresh(mComment);
        }
    }

    private void loadNotesFromDatabase() {
        Retrofit retrofit= RetrofitManager.get("http://114.115.172.245:8008/");
        CommentService getService =  retrofit.create(CommentService.class);
        final Call<CommentResponse> commentCall = getService.getComment(url);
        final Comment[] comment = new Comment[1000];
        commentCall.enqueue(new Callback<CommentResponse>() {
            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                Log.i("info",String.valueOf(response.body()));
                CommentResponse commentList = response.body();
                if(commentList.getstatus()==1) {
                    //for (int i=0;i<)
                    //Log.i("list",String.valueOf(commentList.getcommentlist().get(0)));
                    commentAdapter.refresh(commentList.getcommentlist());

                    //Log.i("list1",String.valueOf(mComment.get(0)));
                }
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                t.printStackTrace();
                Log.i("onFailure","Failed");
            }
        });

    }


}

