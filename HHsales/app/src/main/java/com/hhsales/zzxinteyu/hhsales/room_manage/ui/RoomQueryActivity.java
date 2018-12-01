package com.hhsales.zzxinteyu.hhsales.room_manage.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bin.david.form.annotation.SmartTable;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.title.ImageResTitleDrawFormat;
import com.bin.david.form.data.table.TableData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.utils.CustomPopup;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.main.MainActivity;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.Room;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomQuery;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.Unit;
import com.hhsales.zzxinteyu.hhsales.room_manage.presenter.RoomQueryPresenter;
import com.hhsales.zzxinteyu.hhsales.room_manage.view.MyOnScrollListener;
import com.hhsales.zzxinteyu.hhsales.room_manage.view.ObservableHorizontalScrollView;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomQueryActivity extends BaseActivity<IRoomQueryView, RoomQueryPresenter> implements IRoomQueryView, View.OnClickListener {
    private RelativeLayout mToolbar;
    private RecyclerView mRvLayer;
    private RecyclerView mRvRoom;
    private TextView tvUnitName;//单元名
    private TextView tvProjectName;
    private ObservableHorizontalScrollView mSvRoom;
    private List<Integer> mData;
    private List roomData = new ArrayList();
    private List<Room> unitRooms;
    private List<Room> rooms;
    private List<List<Room>> listsUnitRoom;
    private int layerCount;//楼层高度
    private String[] unitNames;
    private String projectName;
    private String buildingName;
    private ImageView ivReturn;
    private String[] statusColors = {"#d9d4ca", "#00FF06","#E4ff00","#FFA500","#D37AB8","#5F9DAF","#FA003B","#706D68"};
    private final RecyclerView.OnScrollListener mLayerOSL = new MyOnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            // 当楼层列表滑动时，单元（房间）列表也滑动
            mRvRoom.scrollBy(dx, dy);
        }
    };
    private final RecyclerView.OnScrollListener mRoomOSL = new MyOnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            // 当单元（房间）列表滑动时，楼层列表也滑动
            mRvLayer.scrollBy(dx, dy);
        }
    };

    @Override
    protected RoomQueryPresenter createPresenter() {
        return new RoomQueryPresenter();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_room_query);
        tvUnitName = findViewById(R.id.tv_unit_name);
        mToolbar = (RelativeLayout) findViewById(R.id.toolbar);
        ivReturn = findViewById(R.id.iv_return);
        setImmerseLayout(mToolbar);
        tvProjectName = findViewById(R.id.tv_project_name);
        mRvLayer = (RecyclerView) findViewById(R.id.rv_layer);
        mRvRoom = (RecyclerView) findViewById(R.id.rv_room);
        mSvRoom = (ObservableHorizontalScrollView) findViewById(R.id.sv_room);
        mRvLayer.setLayoutManager(new LinearLayoutManager(this));
        mRvLayer.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .color(Color.parseColor("#f5f5f5"))
                .size(1)
                .build()
        );
        mRvRoom.setLayoutManager(new LinearLayoutManager(this));
        mRvRoom.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .color(Color.parseColor("#f5f5f5"))
                .size(1)
                .build()
        );
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        presenter.getProItemName();

    }

    @Override
    public void setRoomQueryData(RoomQuery roomQueryData) {
        buildingName= roomQueryData.getData().getBuilding().getName();
        setProjectName(projectName, buildingName);
        mData= new ArrayList();
        layerCount= roomQueryData.getData().getBuilding().getBuilding_height();
        for (int i = 0; i < layerCount; i++) {
            roomData.add(new Object());
        }
        LogUtils.i("楼层高度" + roomQueryData.getData().getBuilding().getBuilding_height());
        for (int i = layerCount; i > 0; i--) {
            mData.add(i);
        }
        LogUtils.i("楼诚高度数据" + GsonUtil.GsonString(mData));
        unitRooms = new ArrayList<>();
        rooms = roomQueryData.getData().getListRoom();
        List<Unit> units=roomQueryData.getData().getListUnit();
        Collections.reverse(units);

        unitNames = new String[units.size()];
        for (int i=units.size()-1;i>=0;i--){
            unitNames[i] = units.get(i).getUnit_name();
        }
        unitNameQueryRoom( unitNames[0]);
//        LogUtils.i("所有单元名称"+GsonUtil.GsonString(unitNames));
        //initBuilding(roomQueryData.getData().getBuilding().getFk_project_id());
    }

    @Override
    public void initBuilding(String building_id) {
        presenter.getRoomByBuildingId(building_id);//测试数据

    }

    @Override
    public void setProjectName(String projectName, String building_id) {
        tvProjectName.setText(projectName+"-"+buildingName);
    }


    @Override
    public void firstInitBuilding(String projectName,String buildingName,String building_id) {
        presenter.getRoomByBuildingId(building_id);//测试数据
        this.projectName = projectName;


    }



    private void unitNameQueryRoom(String unitName) {
        unitRooms.clear();
        tvUnitName.setText(unitName);
        LogUtils.i("单元名称"+unitName);
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getUnit_name().equals(unitName)) {
                unitRooms.add(rooms.get(i));
            }
        }
        listsUnitRoom = new ArrayList<>();
        LogUtils.i("当前单元的房间" + GsonUtil.GsonString(unitRooms));
        List<Room> rooms1;
        for (int i=layerCount;i>0;i--){
            rooms1 = new ArrayList<>();
            for(int j=0;j<unitRooms.size();j++){
                if(unitRooms.get(j).getStorey()==i){
                    rooms1.add(unitRooms.get(j));
                }
            }
            listsUnitRoom.add(rooms1);

        }
//        LogUtils.i("处理完之后的数据" + GsonUtil.GsonString(listsUnitRoom));
        initAdapter();

    }

    private void initAdapter() {
        mRvLayer.setAdapter(
                new BaseQuickAdapter<Integer, BaseViewHolder>(R.layout.item_building_height, mData) {
                    @Override
                    protected void convert(BaseViewHolder helper, Integer item) {
                        helper.setText(R.id.tv_building_height, item + "");
                    }
                });
        mRvRoom.setAdapter(
                new BaseQuickAdapter<List<Room>, BaseViewHolder>(R.layout.item_layer, listsUnitRoom) {
                    @Override
                    protected void convert(BaseViewHolder helper, List<Room> item) {
                        LinearLayout llLayer = helper.getView(R.id.ll_layer);
                        llLayer.removeAllViews();
                        for (int i = 0; i < item.size(); i++) {
                            View room = View.inflate(RoomQueryActivity.this, R.layout.item_room, null);
                            View line = new View(RoomQueryActivity.this);
                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(1, LinearLayout.LayoutParams.MATCH_PARENT);
                            room.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,(1.0f/item.size())));
                            line.setLayoutParams(params);
                            line.setBackgroundColor(Color.parseColor("#f5f5f5"));
                            llLayer.addView(room);
                            llLayer.addView(line);
                            TextView view= room.findViewById(R.id.tv_room_text);
                            View tvStColor = room.findViewById(R.id.tv_status_colors);
                            tvStColor.setBackgroundColor(Color.parseColor(statusColors[item.get(i).getStatus()]));
                            view.setText(item.get(i).getRoom_name());

                        }
                        if (item.size()==0){
                           // LogUtils.i("当前层数房间数为空");
                            View room = View.inflate(RoomQueryActivity.this, R.layout.item_room, null);
                            room.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,(1.0f)));
                            llLayer.addView(room);
                        }
                    }
                });
    }

    @Override
    protected void initListener() {
        setSyncScrollListener();
        tvUnitName.setOnClickListener(this);
        tvProjectName.setOnClickListener(this);
        ivReturn.setOnClickListener(this);

    }


    /**
     * 设置两个列表的同步滚动
     */
    private void setSyncScrollListener() {

        mRvLayer.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            private int mLastY;

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                // 当列表是空闲状态时
                if (rv.getScrollState() == RecyclerView.SCROLL_STATE_IDLE) {
                    onTouchEvent(rv, e);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                // 若是手指按下的动作，且另一个列表处于空闲状态
                if (e.getAction() == MotionEvent.ACTION_DOWN && mRvRoom.getScrollState() == RecyclerView.SCROLL_STATE_IDLE) {
                    // 记录当前另一个列表的y坐标并对当前列表设置滚动监听
                    mLastY = rv.getScrollY();
                    rv.addOnScrollListener(mLayerOSL);
                } else {
                    // 若当前列表原地抬起手指时，移除当前列表的滚动监听
                    if (e.getAction() == MotionEvent.ACTION_UP && rv.getScrollY() == mLastY) {
                        rv.removeOnScrollListener(mLayerOSL);
                    }
                }
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        mRvRoom.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            private int mLastY;

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                if (rv.getScrollState() == RecyclerView.SCROLL_STATE_IDLE) {
                    onTouchEvent(rv, e);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                if (e.getAction() == MotionEvent.ACTION_DOWN && mRvLayer.getScrollState() == RecyclerView.SCROLL_STATE_IDLE) {
                    mLastY = rv.getScrollY();
                    rv.addOnScrollListener(mRoomOSL);
                } else {
                    if (e.getAction() == MotionEvent.ACTION_UP && rv.getScrollY() == mLastY) {
                        rv.removeOnScrollListener(mRoomOSL);
                    }
                }
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        mSvRoom.setScrollViewListener(new ObservableHorizontalScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableHorizontalScrollView scrollView, int x, int y, int oldx, int oldy) {
                mRvLayer.removeOnScrollListener(mLayerOSL);
                mRvRoom.removeOnScrollListener(mRoomOSL);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_unit_name:
                new CustomPopup(this, unitNames, tvUnitName, 500, new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        unitNameQueryRoom(s);
                    }
                });
                break;
            case R.id.tv_project_name:
                Intent prjectName = new Intent(RoomQueryActivity.this, TowerSelectActivity.class);
                startActivityForResult(prjectName,1 );
                break;

            case R.id.iv_return:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(data!=null){
              initBuilding(data.getStringExtra("building_id"));
                projectName = data.getStringExtra("project_name");
            }
        }
    }


    //请求失败
    @Override
    public void requestFailed() {
        showToast("请检查网络连接");
    }

    /**
     * 权限检查
     */

    //检查权限
    private void checkPermissions(){
        LogUtils.i("开始检查权限");
        presenter.checkBuildingPermissions(null);

    }

    //权限通过
    @Override
    public void permissionsYes() {

    }
    //权限不通过
    @Override
    public void permissionsNo() {

    }

}
