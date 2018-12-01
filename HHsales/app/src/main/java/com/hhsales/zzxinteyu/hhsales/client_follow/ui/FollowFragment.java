package com.hhsales.zzxinteyu.hhsales.client_follow.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.example.lib_common.Adapter.Other.MyPagerAdapter;
import com.example.lib_common.base.BaseFragment;
import com.example.lib_common.utils.CustomPopup;
import com.example.lib_common.utils.LogUtils;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.bean.UserPermissions;
import com.hhsales.zzxinteyu.hhsales.client.fragment.MyClientFragment;
import com.hhsales.zzxinteyu.hhsales.client_follow.fragment.MyAllClientFollowFragment;
import com.hhsales.zzxinteyu.hhsales.client_follow.fragment.MyClientFollowFragment;
import com.hhsales.zzxinteyu.hhsales.client_follow.fragment.MyShareClientFollowFragment;
import com.hhsales.zzxinteyu.hhsales.client_follow.fragment.MyTeamClientFollowFragment;
import com.hhsales.zzxinteyu.hhsales.client_follow.fragment.PubClientFragment;
import com.hhsales.zzxinteyu.hhsales.client_follow.presenter.FollowPresenter;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientDownData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Huairen on 2018/6/19.
 */

public class FollowFragment extends BaseFragment<IFollowView,FollowPresenter> implements IFollowView, View.OnClickListener {
    public static String project_id;
    private TextView tvProjectName;
    private LinearLayout followTop;
    private String[] projectNames;
    private String project_name;
    private ProItemName pageDatas;
    private String permissionsCode;//权限码
    private boolean isFirstLoad = true;//是否是第一次加载界面,默认true
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_client_follow, container, false);
        initView(view);
        initData();
        initListenter();
        return view;
    }

    private void initListenter() {
        tvProjectName.setOnClickListener(this);
    }

    private MyClientFollowFragment myClientFollowFragment;
    private MyTeamClientFollowFragment myTeamClientFollowFragment;
    private MyShareClientFollowFragment myShareClientFollowFragment;
    private MyAllClientFollowFragment myAllClientFollowFragment;
    private PubClientFragment pubClientFragment;

    PagerSlidingTabStrip pst;
    ViewPager viewPager;
    ArrayList<Fragment> fragments;
    //声明pst的标题
    List<String> titles;
    //String[] titles = {"我的客户", "我的团队客户", "我的分享客户","全部客户","公共客户"};
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    protected FollowPresenter createPresenter() {
        return new FollowPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initData() {
        if (isFirstLoad){
            checkPermissions();
        }else {
            getcCache();
        }

    }

    //检查权限
    private void checkPermissions(){
        LogUtils.i("开始检查权限");
        presenter.checkPermissions(mapPut(new HashMap<String, String>()));

    }
    private void initPager() {
        if (project_id!=null){
            fragments = new ArrayList<>();
            //添加fragment到集合中时注意顺序
            titles = new ArrayList<>();
//        LogUtils.i("权限码"+permissionsCode);
            if (Character.toString(permissionsCode.charAt(6)).equals("1")){
                myClientFollowFragment = new MyClientFollowFragment();
                fragments.add(myClientFollowFragment);
                titles.add("我的客户");
            }
            if (Character.toString(permissionsCode.charAt(7)).equals("1")){
                myTeamClientFollowFragment = new MyTeamClientFollowFragment();
                fragments.add(myTeamClientFollowFragment);
                titles.add("团队客户");
            }
            if (Character.toString(permissionsCode.charAt(8)).equals("1")) {
                myShareClientFollowFragment = new MyShareClientFollowFragment();
                fragments.add(myShareClientFollowFragment);
                titles.add("我的分享客户");
            }
            if (Character.toString(permissionsCode.charAt(8)).equals("1")) {
                myAllClientFollowFragment = new MyAllClientFollowFragment();
                fragments.add(myAllClientFollowFragment);
                titles.add("全部客户");
            }
            if (Character.toString(permissionsCode.charAt(8)).equals("1")) {
                pubClientFragment = new PubClientFragment();
                fragments.add(pubClientFragment);
                titles.add("公共客户");
            }
            FragmentManager fragmentManager =getChildFragmentManager();
            viewPager.setAdapter(new MyPagerAdapter(fragmentManager, titles, fragments));
            viewPager.setCurrentItem(0);
            //当ViewPager的onPagerChangeListener回调时，PagerSlidingTabStrip也一起随之变动
            //具体做法都已封装到了PagerSlidingTabStrip.setViewPager()方法里，使用时调用实例如下
            pst.setViewPager(viewPager);
            //pst.setTextSize(22);
            pst.setTextColor(Color.WHITE);
        }else {
            showToast(getActivity(),"暂无所属项目");
        }

    }

    private void initView(View view) {
        pst = (PagerSlidingTabStrip)view.findViewById(R.id.client_page_pst);
        viewPager = (ViewPager)view. findViewById(R.id.client_page_pager);
        tvProjectName = view.findViewById(R.id.tv_project_name);
        followTop = view.findViewById(R.id.ll_follow_top);
        setImmerseLayout(followTop);
    }
    protected void setImmerseLayout(View view) {// view为标题栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int statusBarHeight = getStatusBarHeight(getActivity().getBaseContext());
            view.setPadding(0, statusBarHeight, 0, 0);

        }
    }

    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public void setPageData(ProItemName pageData) {
        this.pageDatas = pageData;
        projectNames = new String[pageDatas.getData().size()];
        for (int i=0;i<pageDatas.getData().size();i++){
            projectNames[i] = pageDatas.getData().get(i).getItem_name();
        }
        project_id = pageDatas.getData().get(0).getProject_id();
        tvProjectName.setText(pageData.getData().get(0).getItem_name());
        project_name = pageData.getData().get(0).getItem_name();
        initPager();

    }

    @Override
    public void setPermissions(UserPermissions permissions) {
        this.permissionsCode = permissions.getRoleValue();
        presenter.findProItemName();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_project_name:
              if(pageDatas!=null){
                  new CustomPopup(getActivity(),projectNames, tvProjectName, 400, new CustomPopup.GetDataOnListener() {
                      @Override
                      public void onClick(String s, int position) {
                          tvProjectName.setText(pageDatas.getData().get(position).getItem_name());
                          project_id = pageDatas.getData().get(position).getProject_id();
                          initPager();
                      }
                  });

              }

                break;
        }
    }

    private Map<String, String> mapPut(Map<String, String> map) {
        map.put("baseModel.pageInfo.cpage", "1");
        map.put("baseModel.pageInfo.page_size","1");
        map.put("baseModel.condition", "1");
        return map;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFirstLoad = false;
    }
    private void getcCache() {
        initPager();
        cacheView();
    }

    private void cacheView() {
        tvProjectName.setText(project_name);
    }
}

