package com.hhsales.zzxinteyu.hhsales.main;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lib_common.view.CustomViewPager;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.ClientFragment;
import com.hhsales.zzxinteyu.hhsales.home.HomeFragment;
import com.hhsales.zzxinteyu.hhsales.my.fragment.MyFragment;
import com.hhsales.zzxinteyu.hhsales.client_follow.ui.FollowFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String textSelectColor="#1296db";
    //声明ViewPager
    private CustomViewPager mViewPager;
    //适配器
    private FragmentPagerAdapter mAdapter;
    //装载Fragment的集合
    private List<Fragment> mFragments;
    //声明四个Tab
    private LinearLayout mLl_tab_home;
    private LinearLayout mLl_tab_client;
    private LinearLayout mLl_tab_referral;
    private LinearLayout mLl_tab_my;
    private LinearLayout ll_mian;

    //声明四个ImageView
    private ImageView mIv_tab_home;
    private ImageView mIv_tab_client;
    private ImageView mIv_tab_referral;
    private ImageView mIv_tab_my;

    //声明四个TextView
    private TextView mTv_tab_home;
    private TextView mTv_tab_client;
    private TextView mTv_tab_referral;
    private TextView mTv_tab_my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化控件
        initData();//初始化数据
        initListener();//初始化事件

    }

    private void initListener() {
        //设置四个Tab的点击事件
        mLl_tab_home.setOnClickListener(this);
        mLl_tab_client.setOnClickListener(this);
        mLl_tab_referral.setOnClickListener(this);
        mLl_tab_my.setOnClickListener(this);
    }

    private void initData() {
        mFragments = new ArrayList<>();
        //将四个Fragment加入集合中
        mFragments.add(new HomeFragment());
        mFragments.add(new ClientFragment());
        mFragments.add(new FollowFragment());
        mFragments.add(new MyFragment());

        //初始化适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {//从集合中获取对应位置的Fragment
                return mFragments.get(position);
            }

            @Override
            public int getCount() {//获取集合中Fragment的总数
                return mFragments.size();
            }

        };
        //不要忘记设置ViewPager的适配器
        mViewPager.setAdapter(mAdapter);
        //设置ViewPager的切换监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //页面滚动事件
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //页面选中事件
            @Override
            public void onPageSelected(int position) {
                //设置position对应的集合中的Fragment
                mViewPager.setCurrentItem(position);
                resetImgs();
                selectTab(position);
            }

            @Override
            //页面滚动状态改变事件
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @SuppressLint("ResourceAsColor")
    private void selectTab(int i) {
        //根据点击的Tab设置对应的ImageButton为绿色
        switch (i) {
            case 0:
                mIv_tab_home.setImageResource(R.drawable.home_2);
                mTv_tab_home.setTextColor(Color.parseColor(textSelectColor));

                break;
            case 1:
                mIv_tab_client.setImageResource(R.drawable.client_2);
                mTv_tab_client.setTextColor(Color.parseColor(textSelectColor));

                break;
            case 2:
                mIv_tab_referral.setImageResource(R.drawable.referral_2);
                mTv_tab_referral.setTextColor(Color.parseColor(textSelectColor));

                break;
            case 3:
                mIv_tab_my.setImageResource(R.drawable.my_2);
                mTv_tab_my.setTextColor(Color.parseColor(textSelectColor));
                break;
        }
        //设置当前点击的Tab所对应的页面
        mViewPager.setCurrentItem(i);
    }
    private void initView() {
        mViewPager =  findViewById(R.id.id_viewpager);
        mViewPager.setScanScroll(false);
        mLl_tab_home = (LinearLayout) findViewById(R.id.ll_tab_home);
        mLl_tab_client = (LinearLayout) findViewById(R.id.ll_tab_client);
        mLl_tab_referral = (LinearLayout) findViewById(R.id.ll_tab_referral);
        mLl_tab_my = (LinearLayout) findViewById(R.id.ll_tab_my);

        mIv_tab_home = (ImageView) findViewById(R.id.iv_tab_home);
        mIv_tab_client = (ImageView) findViewById(R.id.iv_tab_client);
        mIv_tab_referral = (ImageView) findViewById(R.id.iv_tab_referral);
        mIv_tab_my = (ImageView) findViewById(R.id.iv_tab_my);

        mTv_tab_home = (TextView) findViewById(R.id.tv_tab_home);
        mTv_tab_client = (TextView) findViewById(R.id.tv_tab_client);
        mTv_tab_referral = (TextView) findViewById(R.id.tv_tab_referral);
        mTv_tab_my = (TextView) findViewById(R.id.tv_tab_my);

        ll_mian = findViewById(R.id.ll_mian);

    }
    //将四个ImageButton设置成灰色
    private void resetImgs () {
        mIv_tab_home.setImageResource(R.drawable.home_1);
        mIv_tab_client.setImageResource(R.drawable.client_1);
        mIv_tab_referral.setImageResource(R.drawable.referral_1);
        mIv_tab_my.setImageResource(R.drawable.my_1);

        mTv_tab_home.setTextColor(Color.parseColor("#8a8a8a"));
        mTv_tab_client.setTextColor(Color.parseColor("#8a8a8a"));
        mTv_tab_referral.setTextColor(Color.parseColor("#8a8a8a"));
        mTv_tab_my.setTextColor(Color.parseColor("#8a8a8a"));

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        //先将四个ImageButton都设置成灰色
        resetImgs();
        switch (v.getId()) {
            case R.id.ll_tab_home:
                //设置viewPager的当前Tab
                mViewPager.setCurrentItem(0);
                //将当前Tab对应的ImageButton设置成绿色
                mIv_tab_home.setImageResource(R.drawable.home_2);
                mTv_tab_home.setTextColor(Color.parseColor(textSelectColor));

                break;
            case R.id.ll_tab_client:
                mViewPager.setCurrentItem(1);
                mIv_tab_client.setImageResource(R.drawable.client_2);
                mTv_tab_client.setTextColor(Color.parseColor(textSelectColor));

                break;
            case R.id.ll_tab_referral:
                mViewPager.setCurrentItem(2);
                mIv_tab_referral.setImageResource(R.drawable.referral_2);
                mTv_tab_referral.setTextColor(Color.parseColor(textSelectColor));

                break;
            case R.id.ll_tab_my:
                mViewPager.setCurrentItem(3);
                mIv_tab_my.setImageResource(R.drawable.my_2);
                mTv_tab_my.setTextColor(Color.parseColor(textSelectColor));

                break;
        }
    }


}
