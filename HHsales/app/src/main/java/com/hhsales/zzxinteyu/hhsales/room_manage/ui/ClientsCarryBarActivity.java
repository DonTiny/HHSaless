package com.hhsales.zzxinteyu.hhsales.room_manage.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.utils.CustomPopupWindow;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.SelectProjectControls.IDataPassInteface;
import com.example.lib_common.utils.SelectProjectControls.SeleteProjectPopup;

import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.room_manage.adapter.ClientsCarryBarAdapter;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.FileBean;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectList;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectNextLevel;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBase;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBases;
import com.hhsales.zzxinteyu.hhsales.room_manage.presenter.ClientsCarryBarPresenter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by acer on 2018/3/29.
 */
@Route(path = "/main/ClientsCarryBarActivity")
public class ClientsCarryBarActivity extends BaseActivity<ClientsCarryBar.View,
        ClientsCarryBarPresenter<ClientsCarryBar.View>> implements ClientsCarryBar.View<FileBean> {

    private LinearLayout mClients_navigation_recede;
    private TextView mClients_navigation_title;
    private TextView mClients_navigation_plus;
    private TextView mClients_project;
    private ImageView mImg_triangle;
    private EditText mClients_et;
    private TextView mClients_searchfor;
    private LinearLayout mClients_load;
    private PullToRefreshLayout mClients_prl;
    private RecyclerView mClients_lv;

    private ClientsCarryBarAdapter adapter;
    private ArrayList<RoomMagementBase> queryRoomss;
    private LinearLayout room_load;
    private String name = "admin";
    private String password = "111111";
    private Map<String, String> map;
    //高级查询要传递的参数
    private Map<String, String> parameter = new ArrayMap<String, String>();
    //是否有下一页
    private boolean isnext;
    private ArrayList<String> projectList;
    private ArrayList<String> projectNextData = new ArrayList<>();
    //保存最低层的栋集合
    private List<ProjectNextLevel> projectNextLevels;
    //选择楼栋的时候判断当前是第几层
    private int Layers = 0;
    //选择的楼栋id
    private String fk_building_id_string = null;
    //查询条件
    private String Query_conditions = "null";
    //选择项目的id
    private String id = null;
    //判断有没有点击过户型
    private List<ProjectList> otherData, AllData;
    private SeleteProjectPopup seleteProjectPopup;
    private boolean first = true;
    private CustomPopupWindow customPopupWindow;
    private TextView search_room_name, search_room_no, search_building_name, room_management_searchfor,
            search_room_structure, search_product_type, search_floor, search_heading, search_sales_status;
    private View searchContentView;


    @Override
    protected ClientsCarryBarPresenter<ClientsCarryBar.View> createPresenter() {
        return new ClientsCarryBarPresenter<ClientsCarryBar.View>(this);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.clients_carry_bar);
        mClients_navigation_recede = (LinearLayout) findViewById(R.id.clients_navigation_recede);
        mClients_navigation_title = (TextView) findViewById(R.id.clients_navigation_title);
        mClients_navigation_plus = (TextView) findViewById(R.id.clients_navigation_plus);
        mClients_project = (TextView) findViewById(R.id.clients_project);
        mImg_triangle = (ImageView) findViewById(R.id.img_triangle);
        mClients_et = (EditText) findViewById(R.id.clients_et);
        mClients_searchfor = (TextView) findViewById(R.id.clients_searchfor);
        mClients_load = (LinearLayout) findViewById(R.id.clients_load);
        mClients_prl = (PullToRefreshLayout) findViewById(R.id.clients_prl);
        mClients_lv = (RecyclerView) findViewById(R.id.clients_lv);

        searchContentView = LayoutInflater.from(ClientsCarryBarActivity.this).inflate(R.layout.room_search_popuplayout, null);
        search_room_name = searchContentView.findViewById(R.id.search_room_name);
        search_room_no = searchContentView.findViewById(R.id.search_room_no);
        search_building_name = searchContentView.findViewById(R.id.search_building_name);
        search_room_structure = searchContentView.findViewById(R.id.search_room_structure);
        search_product_type = searchContentView.findViewById(R.id.search_product_type);
        search_floor = searchContentView.findViewById(R.id.search_floor);
        search_heading = searchContentView.findViewById(R.id.search_heading);
        search_sales_status = searchContentView.findViewById(R.id.search_sales_status);
        //为RecyclerView添加默认动画效果
        mClients_lv.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (getIntent().getStringExtra("conditions") != null && !getIntent().getStringExtra("conditions").equals("0")) {
            parameter.put("baseModel.advancedQueryList[0].fieldName", "di8.name");
            parameter.put("baseModel.advancedQueryList[0].fieldValue", getIntent().getStringExtra("conditions"));
            parameter.put("baseModel.advancedQueryList[0].tempOperator", "LIKE");
            parameter.put("baseModel.pageInfo.page_size", "10");
            LogUtils.i("按条件查询房间参数" + GsonUtil.GsonString(parameter));
            presenter.getAdvancedSearch(parameter);
        } else {
            presenter.queryRoom(false, null);
        }
    }

    @Override
    protected void initListener() {

        mClients_prl.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 结束刷新
                        first = false;
                        presenter.queryRoom(false, null);
                        adapter.notifyDataSetChanged();
                        mClients_prl.finishRefresh();
                        mClients_project.setText("查询目标");
                        Query_conditions = "null";
                        parameter.clear();
                    }
                }, 2000);
            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (parameter.size() > 0) {
                            if (isnext) {
                                presenter.queryRoom(true, parameter);
                            } else {
                                showToast("亲，已经没有数据了。");
                            }
                        } else {
                            presenter.queryRoom(true, parameter);
                        }
                        mClients_prl.finishLoadMore();
                    }
                }, 2000);
            }
        });

        mClients_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //搜索条件弹出框
                customPopupWindow = new CustomPopupWindow(ClientsCarryBarActivity.this, searchContentView, 250, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                customPopupWindow.setParameter(mClients_project, 0, -20);
            }
        });
        //高级搜索
        mClients_searchfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("null".equals(Query_conditions)) {
                    showToast("请选择好你要查询的条件");
                } else if ("".equals(mClients_et.getText().toString()) || mClients_et.getText().toString() == null) {
                    showToast("请填好你要查询条件的值");
                } else {
                    if (parameter.size() > 0) {
                        parameter.put("baseModel.advancedQueryList[1].fieldName", Query_conditions);
                        parameter.put("baseModel.advancedQueryList[1].fieldValue", mClients_et.getText() + "");
                        parameter.put("baseModel.advancedQueryList[1].tempOperator", "LIKE");
                    } else {
                        parameter.put("baseModel.advancedQueryList[0].fieldName", Query_conditions);
                        parameter.put("baseModel.advancedQueryList[0].fieldValue", mClients_et.getText() + "");
                        parameter.put("baseModel.advancedQueryList[0].tempOperator", "LIKE");
                        parameter.put("baseModel.pageInfo.page_size", "10");
                    }
                    presenter.getAdvancedSearch(parameter);
                    Visibility(false);
                }
            }
        });
        GetOnClick(search_room_name);
        GetOnClick(search_room_no);
        GetOnClick(search_building_name);
        GetOnClick(search_room_structure);
        GetOnClick(search_product_type);
        GetOnClick(search_floor);
        GetOnClick(search_heading);
        GetOnClick(search_sales_status);

        mClients_navigation_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseBuilding();
            }
        });
    }


    /**
     * 楼栋详情
     */
    private void chooseBuilding() {
        if (projectList.size() > 0) {
            seleteProjectPopup = new SeleteProjectPopup(ClientsCarryBarActivity.this, projectList, new IDataPassInteface() {
                @Override
                public void getData(String data) {
                    for (int i = 0; i < AllData.size(); i++) {
                        if (data.equals(AllData.get(i).getItem_name())) {
                            Layers = 0;
                            id = AllData.get(i).getProject_id();
                        }
                    }
                    if (Layers == 1) {
                        showToast(data);
                        for (int i = 0; i < projectNextLevels.size(); i++) {
                            if (data.equals(projectNextLevels.get(i).getName())) {
                                String lowId = projectNextLevels.get(i).getBuilding_id();
                                fk_building_id_string = projectNextLevels.get(i).getBuilding_id();
                                List<String> a = new ArrayList<String>();
                                seleteProjectPopup.showData(a, false);
                                parameter.put("baseModel.advancedQueryList[0].fieldName", "fk_building_id");
                                parameter.put("baseModel.advancedQueryList[0].fieldValue", fk_building_id_string);
                                parameter.put("baseModel.advancedQueryList[0].tempOperator", "LIKE");
                                parameter.put("baseModel.pageInfo.page_size", "10");
                                presenter.getAdvancedSearch(parameter);
                                Visibility(false);
                            }
                        }
                    } else if (Layers == 0) {
                        presenter.getProjectNextLevel(id);
                        Layers = 1;
                    }

                }
            });
        }
    }

    @Override
    public void queryRoom(boolean load, RoomMagementBases queryRooms) {
        if (mClients_load.getVisibility() != View.GONE) {
            mClients_load.setVisibility(View.GONE);
            mClients_lv.setVisibility(View.VISIBLE);
        }
        if (queryRooms.getResultFlag() == 0) {
            isnext = queryRooms.getPageInfo().getIsnext();
            if (load) {
                for (int i = 0; i < queryRooms.getData().size(); i++) {
                    queryRoomss.add(queryRoomss.size(), queryRooms.getData().get(i));
                }
                //RecyclerView列表进行批量UI数据更新
                adapter.notifyItemRangeInserted(queryRoomss.size() - 10, queryRooms.getData().size());
                // scrollToPosition（0）作用是把列表移动到顶端
                mClients_lv.scrollToPosition(queryRoomss.size() - 10);
                showToast("加载成功！");
            } else {
                queryRoomss = queryRooms.getData();
                adapter = new ClientsCarryBarAdapter(this, queryRoomss, presenter);
                //设置item间距，10dp
                mClients_lv.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示
                mClients_lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                if (first) {
                    mClients_load.setVisibility(View.GONE);
                    mClients_lv.setVisibility(View.VISIBLE);

                } else {
                    showToast("刷新成功！");
                }
            }
        } else {
            showToast("亲，数据异常。");
        }
        presenter.getProjectList();
    }

    @Override
    public void networkRequestFailed(String name) {
        showToast(name);
        Visibility(true);
    }

    @Override
    public void getProjectList(List<ProjectList> projectLists) {
        AllData = projectLists;
        projectList = new ArrayList<String>();
        otherData = new ArrayList<ProjectList>();
        for (int i = 0; i < projectLists.size(); i++) {
            if ("null".equals(projectLists.get(i).getFk_parent_item())) {
                projectList.add(projectLists.get(i).getItem_name());
            } else if ("".equals(projectLists.get(i).getFk_parent_item())) {
                projectList.add(projectLists.get(i).getItem_name());
            } else {
                otherData.add(projectLists.get(i));
            }
        }
    }

    @Override
    public void getProjectNextLevel(List<ProjectNextLevel> projectLists, boolean loudongRequest) {
        this.projectNextLevels = projectLists;
        if (projectNextData != null) {
            projectNextData.clear();
        }
        if (projectLists != null) {
            for (int i = 0; i < projectLists.size(); i++) {
                projectNextData.add(projectLists.get(i).getName());
            }
            for (int j = 0; j < otherData.size(); j++) {
                if (id.equals(otherData.get(j).getFk_parent_item())) {
                    projectNextData.add(otherData.get(j).getItem_name());
                }
            }
            seleteProjectPopup.showData(projectNextData, true);
        } else {
            if (loudongRequest) {
                showToast("请求失败！");
            } else {
                showToast("没有数据！");
            }
            List<String> a = new ArrayList<String>();
            seleteProjectPopup.showData(a, true);
        }


    }

    /**
     * 高级查询查询成功返回的接口
     *
     * @param mRoomBase
     */
    @Override
    public void getAdvancedSearch(RoomMagementBases mRoomBase) {
        if (mRoomBase.getResultFlag() == 0) {
            isnext = mRoomBase.getPageInfo().getIsnext();
            queryRoomss = mRoomBase.getData();
            adapter = new ClientsCarryBarAdapter(this, queryRoomss, presenter);
            //设置item间距，10dp
            mClients_lv.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示
            mClients_lv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else {
            showToast("亲，没有数据了。");
        }
        Query_conditions = "null";
        mClients_et.setText("");
        mClients_project.setText("查询目标");
        Visibility(true);
    }

    @Override
    public void selectedRoom(String room_id, String room_name) {
        Intent intent = new Intent();
        intent.putExtra("room_id", room_id);
        intent.putExtra("room_name", room_name);
        setResult(2, intent);
        finish();
    }


    public void GetOnClick(final TextView view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClients_project.setText(view.getText());
                customPopupWindow.dismiss();
                if ("房间名称".equals(view.getText())) {
                    Query_conditions = "pr.room_name";
                } else if ("房号".equals(view.getText())) {
                    Query_conditions = "pr.room_number";
                } else if ("楼栋名称".equals(view.getText())) {
                    Query_conditions = "pb.name";
                } else if ("房间结构".equals(view.getText())) {
                    Query_conditions = "di8.name";
                } else if ("产品类型".equals(view.getText())) {
                    Query_conditions = "di7.namer";
                } else if ("楼层".equals(view.getText())) {
                    Query_conditions = "pr.storey";
                } else if ("朝向".equals(view.getText())) {
                    Query_conditions = "di13.namer";
                } else if ("销售状态".equals(view.getText())) {
                    Query_conditions = "pr.status";
                } else {
                    Query_conditions = "null";
                }
            }
        });
    }

    //ProgressBar的隐藏与显示true隐藏
    public void Visibility(boolean gone) {
        if (gone) {
            mClients_load.setVisibility(View.GONE);
        } else {
            mClients_load.setVisibility(View.VISIBLE);
        }
    }
}
