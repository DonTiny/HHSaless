package com.hhsales.zzxinteyu.hhsales.room_manage.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.view.EmptyLayout;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.room_manage.adapter.SelectRoomAdapter;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBase;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBases;
import com.hhsales.zzxinteyu.hhsales.room_manage.interfaces.ISelectRoom;
import com.hhsales.zzxinteyu.hhsales.room_manage.presenter.SelectRoomPresenter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectRoomActivity extends BaseActivity<ISelectRoom.View, SelectRoomPresenter> implements ISelectRoom.View, View.OnClickListener {
    private RelativeLayout mRl_select_room_top;
    private ImageView mIv_return;
    private TextView mTv_project_name;
    private EmptyLayout mEl_select_room_empty;
    private PullToRefreshLayout mPrl_select_room;
    private RecyclerView mRv_select_room;
    private SelectRoomAdapter selectRoomAdapter;
    private List<RoomMagementBase> cacheData;
    private String building_id;
    private String project_id;
    private int cpage = 1;
    private int page_size = 30;
    private boolean isLoad = false;
    private boolean isNext = false;
    private RoomMagementBases bases;//每次请求的数据
    private String room_type;
    @Override
    protected SelectRoomPresenter createPresenter() {
        return new SelectRoomPresenter();
    }


    @Override
    protected void initView() {
        setContentView(R.layout.activity_select_room);
        mRl_select_room_top = (RelativeLayout) findViewById(R.id.rl_select_room_top);
        setImmerseLayout(mRl_select_room_top);
        mIv_return = (ImageView) findViewById(R.id.iv_return);
        mTv_project_name = (TextView) findViewById(R.id.tv_project_name);
        mEl_select_room_empty = (com.example.lib_common.view.EmptyLayout) findViewById(R.id.el_select_room_empty);
        mPrl_select_room = (com.jwenfeng.library.pulltorefresh.PullToRefreshLayout) findViewById(R.id.prl_select_room);
        mRv_select_room = (android.support.v7.widget.RecyclerView) findViewById(R.id.rv_select_room);
        mEl_select_room_empty.bindView(mRv_select_room);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (getIntent()!=null){
            room_type = getIntent().getStringExtra("conditions");
            LogUtils.i("选择查找的房间结构"+room_type);
        }
        showLoading();
        presenter.getProItemName();

    }


    @Override
    protected void initListener() {
        mIv_return.setOnClickListener(this);
        mTv_project_name.setOnClickListener(this);
        mPrl_select_room.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                //下拉刷新
                isLoad = false;
                cpage = 1;
                cacheData.clear();
                findPageProRoomByBuildingId();
            }

            @Override
            public void loadMore() {
                //上拉加载
                if (isNext) {
                    LogUtils.i("存在下一页"+"当前页数"+cpage);
                    isLoad = true;
                    cpage++;
                    findPageProRoomByBuildingId();
                } else {
                    showToast("已经到底啦");
                    mPrl_select_room.finishLoadMore();
                }
            }
        });

        mEl_select_room_empty.setOnButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData(null);
            }
        });
    }

    @Override
    public void showError() {
        downLoad();
        mEl_select_room_empty.showError();
    }

    @Override
    public void showLoading() {
        mEl_select_room_empty.showLoading();
    }

    @Override
    public void showSuccess() {
        mEl_select_room_empty.showSuccess();
    }

    @Override
    public void showEmpty() {
        mEl_select_room_empty.showEmpty();
    }

    @Override
    public void firstInitBuilding(String projectName, String buildingName, String building_id) {
        this.building_id = building_id;
        setProjecTName(projectName, buildingName);
        showLoading();

        findPageProRoomByBuildingId();

    }

    private void findPageProRoomByBuildingId() {
        LogUtils.i("本次请求参数" + GsonUtil.GsonString(mapPageParameter()));
        presenter.findPageProRoomByBuildingId(mapPageParameter());

    }

    @Override
    public void setPageRoomData(RoomMagementBases roomData) {
        this.bases = roomData;
        if (cacheData == null || cacheData.size() == 0) {
            this.cacheData = roomData.getData();
        } else {
            cacheData.addAll(roomData.getData());
        }
        LogUtils.i("当前数据大小" + cacheData.size());
        isNext = roomData.getPageInfo().getIsnext();
        initAdapter(roomData.getData());
        downLoad();
    }

    @Override
    public void setProjecTName(String projectName, String buildingName) {
        mTv_project_name.setText(projectName + "-" + buildingName);
    }

    @Override
    public void initializei() {
        cpage = 1;
         page_size = 30;
         isLoad = false;
         isNext = false;
    }

    private void initAdapter(List<RoomMagementBase> data) {
        if (isLoad) {
            selectRoomAdapter.notifyItemRangeInserted(cacheData.size() - bases.getData().size(), bases.getData().size());
            mRv_select_room.scrollToPosition(cacheData.size() - bases.getData().size());
        } else {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            mRv_select_room.setLayoutManager(layoutManager);
            selectRoomAdapter = new SelectRoomAdapter(this, data);
            mRv_select_room.setAdapter(selectRoomAdapter);
        }

    }

    public Map<String, String> mapPageParameter() {
        Map<String, String> map = new HashMap<>();
        map.put("baseModel.pageInfo.cpage", cpage + "");
        map.put("baseModel.pageInfo.page_size", page_size + "");
        map.put("baseModel.advancedQueryList[0].fieldName", "fk_building_id");
        map.put("baseModel.advancedQueryList[0].tempOperator", "LIKE");
        map.put("baseModel.advancedQueryList[0].fieldValue", building_id);
        if (room_type != null && !room_type.equals("")) {
            map.put("baseModel.advancedQueryList[1].fieldName", "di8.name");
            map.put("baseModel.advancedQueryList[1].tempOperator", "LIKE");
            map.put("baseModel.advancedQueryList[1].fieldValue", room_type);

        }
        return map;

    }

    public void downLoad() {
        mPrl_select_room.finishLoadMore();
        mPrl_select_room.finishRefresh();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_project_name:
                Intent intent = new Intent(SelectRoomActivity.this, TowerSelectActivity.class);
                startActivityForResult(intent, 3);
                break;

            case R.id.iv_return:
                finish();
                break;

        }
    }
    @Override
    public void selectedRoom(String room_id, String room_name) {
        Intent intent = new Intent();
        intent.putExtra("room_id", room_id);
        intent.putExtra("room_name", room_name);
        setResult(2, intent);
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 3) {
            if (data != null) {
                initializei();
                cacheData.clear();
                mRv_select_room.removeAllViews();
                building_id = data.getStringExtra("building_id");
                firstInitBuilding(data.getStringExtra("project_name"), data.getStringExtra("building_name"), data.getStringExtra("building_id"));
            }
        }
    }
}
