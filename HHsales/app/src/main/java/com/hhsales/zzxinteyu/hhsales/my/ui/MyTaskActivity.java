package com.hhsales.zzxinteyu.hhsales.my.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.view.EmptyLayout;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.my.adapter.MyTaskAdapter;
import com.hhsales.zzxinteyu.hhsales.my.bean.MyTaskBean;
import com.hhsales.zzxinteyu.hhsales.my.bean.MyTaskData;
import com.hhsales.zzxinteyu.hhsales.my.presenter.MyTaskPresenter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTaskActivity extends BaseActivity<IMyTaskView, MyTaskPresenter> implements IMyTaskView, View.OnClickListener {
    private RelativeLayout rlMyTaskTop;
    private ImageView ivReturn;
    private int cpage = 1;
    private int page_size = 20;
    private RecyclerView recyclerView;
    private MyTaskAdapter taskAdapter;
    private MyTaskBean cacheData;
    private MyTaskBean myTaskData;//每次请求的数据
    private boolean isNext = false;
    public PullToRefreshLayout pullToRefreshLayout;
    private boolean isLoad=false;
    private EmptyLayout emptyLayout;


    @Override

    protected MyTaskPresenter createPresenter() {
        return new MyTaskPresenter();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_my_task);
        rlMyTaskTop = findViewById(R.id.rl_my_task_top);
        ivReturn = findViewById(R.id.iv_return);
        recyclerView = findViewById(R.id.rv_my_task);
        pullToRefreshLayout = findViewById(R.id.prl_my_task);
        emptyLayout = findViewById(R.id.el_my_task_empty);
        emptyLayout.bindView(recyclerView);
        setImmerseLayout(rlMyTaskTop);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (cacheData==null){
            showLoading();
        }
        presenter.findPageClinetTrack(mapPutPage(cpage, page_size));

    }

    private void initRecycler(List<MyTaskData> myTaskDataList) {
        if (isLoad){
            taskAdapter.notifyItemRangeInserted(cacheData.getData().size()-myTaskData.getData().size(),myTaskData.getData().size());
            LogUtils.i("当前数据大小+"+cacheData.getData().size());
            LogUtils.i(("显示位置"+cacheData.getData().size()+"-"+myTaskData.getData().size()+"为"+(cacheData.getData().size() - myTaskData.getData().size())));
            recyclerView.scrollToPosition(cacheData.getData().size() - myTaskData.getData().size());
        }else {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            taskAdapter = new MyTaskAdapter(this, myTaskDataList);
            recyclerView.setAdapter(taskAdapter);
        }

    }

    private Map<String, String> mapPutPage(int cpage, int page_size) {
        Map<String, String> map = new HashMap<>();
        map.put("baseModel.pageInfo.cpage", String.valueOf(cpage));
        map.put("baseModel.pageInfo.page_size", String.valueOf(page_size));
        return map;
    }

    @Override
    protected void initListener() {
        ivReturn.setOnClickListener(this);

        emptyLayout.setOnButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重新加载数据
                cpage = 1;
                initData(null);
            }
        });
        pullToRefreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                //下拉刷新
                isLoad = false;
                cpage = 1;
                cacheData.getData().clear();
                initData(null);
            }

            @Override
            public void loadMore() {
                //上拉加载
                if(isNext){
                    isLoad = true;
                    cpage++;
                    initData(null);
                }else {
                   showToast("已经到底啦");
                    pullToRefreshLayout.finishLoadMore();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_return:
                finish();
                break;
        }
    }

    @Override
    public void setMyTask(MyTaskBean myTask) {
        this.myTaskData = myTask;
        if (cacheData==null||cacheData.getData().size()==0){
            this.cacheData = myTask;
        }else {
            cacheData.getData().addAll(myTask.getData());
        }
        if (cacheData.getData().size()==0){
            showEmpty();
        }else {
            showSuccess();
        }
       isNext= myTask.getPageInfo().getIsnext();
        initRecycler(cacheData.getData());
        pullToRefreshLayout.finishLoadMore();
        pullToRefreshLayout.finishRefresh();

    }

    @Override
    public void showError() {
      emptyLayout.showError();
    }

    @Override
    public void showLoading() {
      emptyLayout.showLoading();
    }

    @Override
    public void showSuccess() {
        emptyLayout.showSuccess();
    }

    @Override
    public void showEmpty() {
        emptyLayout.showEmpty();
    }
}
