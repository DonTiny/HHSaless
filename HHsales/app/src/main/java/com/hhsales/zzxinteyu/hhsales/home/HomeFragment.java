package com.hhsales.zzxinteyu.hhsales.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lib_common.base.BaseFragment;
import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.view.GlideImageLoader;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.activity.ClientInfoActivity;
import com.hhsales.zzxinteyu.hhsales.my.ui.MyTaskActivity;
import com.hhsales.zzxinteyu.hhsales.room_manage.ui.RoomQueryActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huairen on 2018/6/19.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private String image1 = "http://www.xmhaohan.cn/public/images/2.jpg";
    private String image2 = "http://www.xmhaohan.cn/public/images/4.jpg";
    private String image3 = "http://www.xmhaohan.cn//UserFiles/fUpfiles/2015072811_0000.jpg";
    private RelativeLayout rl_hhsales;
    private Banner banner;
    private RelativeLayout rlMyTask;
    private LinearLayout llAddClientInfo;
    private ImageView ivRoomQuery;
    private TextView tvRoomQuery;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_home, container, false);
        initView(view);
        initListener();
        return view;
    }

    private void initListener() {
        rlMyTask.setOnClickListener(this);
        llAddClientInfo.setOnClickListener(this);
        ivRoomQuery.setOnClickListener(this);
        tvRoomQuery.setOnClickListener(this);

    }

    private void initView(View view) {
        rl_hhsales = view.findViewById(R.id.rl_hhsales);
        banner = view.findViewById(R.id.banner_home);
        rlMyTask = view.findViewById(R.id.rl_my_task);
        llAddClientInfo = view.findViewById(R.id.ll_add_client_info);
        ivRoomQuery = view.findViewById(R.id.iv_room_query);
        tvRoomQuery = view.findViewById(R.id.tv_room_query);
        setImmerseLayout(rl_hhsales, getActivity());
        initBanner();
    }

    private void initBanner() {
        List<String> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.rl_my_task:
                Intent myTaskIntent = new Intent(getActivity(), MyTaskActivity.class);
                startActivity(myTaskIntent);

                break;
            case R.id.ll_add_client_info:
                Intent addClientIntent = new Intent(getActivity(), ClientInfoActivity.class);
                addClientIntent.putExtra("type", "add");
                startActivity(addClientIntent);
                break;

            case R.id.iv_room_query:
                Intent roomQueryIntent = new Intent(getActivity(), RoomQueryActivity.class);
                startActivity(roomQueryIntent);
                break;

        }
    }
}

