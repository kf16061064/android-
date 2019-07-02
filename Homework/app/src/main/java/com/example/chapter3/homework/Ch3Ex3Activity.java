package com.example.chapter3.homework;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;

import java.util.List;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.app.FragmentTransaction;
import android.widget.ListView;

import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitle;
    private List<Fragment> mFragment;
    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);

        animationView = findViewById(R.id.animation_view);
        ListView Lv = findViewById(R.id.rv);

        initData();
        initView();

        animationView.animate()
                .alpha(0f)
                .setDuration(5000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animationView.setVisibility(View.GONE);
                    }
                });

    }
    private void initData(){
        mTitle=new ArrayList<>();
        mTitle.add("好友列表");
        mTitle.add("我的列表");

        mFragment=new ArrayList<>();
        mFragment.add(new Fragment1());
        mFragment.add(new Fragment2());
    }

    private void initView(){
        mTabLayout=findViewById(R.id.mTabLayout);
        mViewPager=findViewById(R.id.mViewPager);
        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());
        mViewPager.setPageTransformer(true,new DepthPageTransformer());
        //mViewPager滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                mViewPager.setPageTransformer(true,new DepthPageTransformer());
            }

            @Override
            public void onPageSelected(int i) {
                mViewPager.setPageTransformer(true,new DepthPageTransformer());
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                mViewPager.setPageTransformer(true,new DepthPageTransformer());

            }
        });

        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的item
            @Override
            public Fragment getItem(int i) {
                return mFragment.get(i);
            }
            //返回item的个数
            @Override
            public int getCount() {
                return mFragment.size();
            }
            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });
        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
    }


    // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面



    // TODO: ex3-2, 添加 TabLayout 支持 Tab
}

