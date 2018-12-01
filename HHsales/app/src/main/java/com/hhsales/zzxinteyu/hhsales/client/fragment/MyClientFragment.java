package com.hhsales.zzxinteyu.hhsales.client.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lib_common.base.BaseFragment;
import com.example.lib_common.inteface.IEmptyLayout;
import com.example.lib_common.utils.CustomPopup;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.view.EmptyLayout;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.ClientFragment;
import com.hhsales.zzxinteyu.hhsales.client.activity.ClientProbablyInfoActivity;
import com.hhsales.zzxinteyu.hhsales.client.adapter.ClientInfoAdapter;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.presenter.MyClientFragmentPresenter;
import com.hhsales.zzxinteyu.hhsales.client_follow.ui.FollowFragment;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientDownData;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Huairen on 2018/6/19.
 */

public class MyClientFragment extends BaseFragment<IMyClientFragment, MyClientFragmentPresenter> implements IMyClientFragment, IEmptyLayout, View.OnClickListener, AdapterView.OnItemClickListener {
    private LinearLayout mLl_client_serach;
    private TextView mTv_client_search_types;
    private ImageView mIv_client_triangle;
    private TextView mTv_client_search;
    private EditText mEt_client_search_txt;
    private ListView list_clientInfo;
    public PullToRefreshLayout clientInfotPrl;
    private EmptyLayout emptyLayout;
    private List<ClientData> currentData;
    private InputMethodManager mInputMethodManager;
    private int cpage = 1;
    private int page_size = 20;
    private int type=1;
    private boolean isNext = false;
    private boolean load = false;//是否实在上拉加载
    private boolean isSearch = false;
    private ClientInfoAdapter clientInfoAdapter;
    private String searchText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.client_info_page_item, container, false);
        initView(view);
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        mIv_client_triangle.setOnClickListener(this);
        mTv_client_search_types.setOnClickListener(this);
        mTv_client_search.setOnClickListener(this);
        emptyLayout.setOnButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重新加载数据
                cpage = 1;
                initData();
            }
        });
        list_clientInfo.setOnItemClickListener(this);
        clientInfotPrl.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        load = false;
                        isSearch = false;
                        // 结束刷新
                        currentData = null;
                        cpage = 1;
                        showInitData(cpage, page_size, type);
                    }
                }, 1000);
            }

            @Override
            public void loadMore() {
                LogUtils.i("开始上啦书安息");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cpage++;
                        if (isNext) {
                            load = true;
                            if (isSearch) {
                                search(searchText);
                            } else {
                                showInitData(cpage, page_size, type);
                            }

                        } else {
                            cpage--;
                            clientInfotPrl.finishLoadMore();

                        }

                    }
                }, 1000);
            }
        });

    }

    private void initData() {
        //初始化输入法
        mInputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        currentData = null;
        showInitData();
    }

//    @Override
//    public void showToast(String text) {
//        Toast.makeText(getParentFragment().getActivity(), text, Toast.LENGTH_SHORT);
//    }

    @Override
    public void showInitData() {
        showLoading();
//        LogUtils.i("客户台账参数" + GsonUtil.GsonString(mapPage(cpage, page_size, type)));
        presenter.setClientPageInfo(mapPage(cpage, page_size, type));

    }

    @Override
    public void showPageClientInfo(PageClientInfo<List<ClientData>> pageClientInfo) {
        showSuccess();
        stopTopBottomLoad();
        if (pageClientInfo.getData() == null || pageClientInfo.getData().toString().equals("[]")) {
//            mTv_client_data_no.setVisibility(View.VISIBLE);
//            mTv_client_data_no.setText("无更多数据，点击空白处刷新");
            showEmpty();
        }
        if (currentData == null) {
            currentData = new ArrayList<>();
        }
        currentData.addAll(pageClientInfo.getData());
        isNext = pageClientInfo.getPageInfo().getIsnext();
        LogUtils.i("当前数据大小" + currentData.size());
        clientInfoAdapter = new ClientInfoAdapter(getActivity(), currentData);
        list_clientInfo.setAdapter(clientInfoAdapter);
        if (load) {
            showListIndex();
        }
    }

    public void showListIndex() {
        //showLoading();
        list_clientInfo.setSelection((cpage - 1) * page_size);

    }

    @Override
    public void showInitData(int cpage, int page_size, int type) {
        presenter.setClientPageInfo(mapPage(cpage, page_size, type));

    }

    @Override
    public void showPageClientInfoError() {
        showError();
    }

    @Override
    public void stopTopBottomLoad() {
        clientInfotPrl.finishRefresh();
        clientInfotPrl.finishLoadMore();
    }

    private void initView(View view) {
        mLl_client_serach = view.findViewById(R.id.ll_client_serach);
        mTv_client_search_types = view.findViewById(R.id.tv_client_search_types);
        mIv_client_triangle = view.findViewById(R.id.img_client_triangle);
        mTv_client_search = view.findViewById(R.id.tv_client_search);
        mEt_client_search_txt = view.findViewById(R.id.et_client_search_txt);
        list_clientInfo = view.findViewById(R.id.lv_clientInfo);
        clientInfotPrl = view.findViewById(R.id.client_info_manage);
        emptyLayout = view.findViewById(R.id.client_info_page_list_emptyLayout);
        emptyLayout.bindView(list_clientInfo);
    }

    @Override
    protected MyClientFragmentPresenter createPresenter() {
        return new MyClientFragmentPresenter();
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

    @Override
    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.img_client_triangle || i == R.id.tv_client_search_types) {
            new CustomPopup(getActivity(), ClientDownData.client_search_types, mLl_client_serach, mTv_client_search_types.getWidth() + mIv_client_triangle.getWidth(), new CustomPopup.GetDataOnListener() {
                @Override
                public void onClick(String s, int position) {
                    mTv_client_search_types.setText(s);
                }
            });

        } else if (i == R.id.tv_client_search) {
            //mEt_client_search_txt.setFocusable(false);
            if (mInputMethodManager.isActive()) {
                mInputMethodManager.hideSoftInputFromWindow(mEt_client_search_txt.getWindowToken(), 0);// 隐藏输入法
            }
            currentData = null;
            searchText = mTv_client_search_types.getText().toString();
            isSearch = true;
            if (searchText.equals("")) {
                isSearch = false;
                cpage = 1;
                showInitData();
            } else {
                search(mTv_client_search_types.getText());

            }

        }
    }

    private void search(CharSequence text) {
        Map<String, String> map;
        if (text.equals("客户名称")) {
            map = new ArrayMap<>();
            mapPut(map, "ci.client_name", mEt_client_search_txt.getText() + "");

        } else if (text.equals("移动电话")) {
            map = new ArrayMap<>();
            mapPut(map, "ci.mobile_tele", mEt_client_search_txt.getText() + "");

        } else if (text.equals("证件号码")) {
            map = new ArrayMap<>();
            mapPut(map, "ci.card_number", mEt_client_search_txt.getText() + "");

        } else if (text.equals("法人代表")) {
            map = new ArrayMap<>();
            mapPut(map, "ci.legal_repre", mEt_client_search_txt.getText() + "");

        } else if (text.equals("营业执照")) {
            map = new ArrayMap<>();
            mapPut(map, "ci.business_license", mEt_client_search_txt.getText() + "");
        }
    }

    private void mapPut(Map<String, String> map, String s, String s1) {
        map.put("baseModel.pageInfo.cpage", "1");
        map.put("baseModel.pageInfo.page_size", page_size + "");
        map.put("advancedQueryList[1].fieldName", "pi.project_id");
        map.put("advancedQueryList[1].fieldValue", ClientFragment.project_id);
        map.put("advancedQueryList[1].tempOperator", "QUERY");
        map.put("advancedQueryList[2].fieldName", "sdi4.name");
        map.put("advancedQueryList[2].fieldValue", ClientFragment.stateType);
        map.put("advancedQueryList[2].tempOperator", "QUERY");
        map.put("advancedQueryList[0].fieldName", s);
        map.put("advancedQueryList[0].tempOperator", "LIKE");
        map.put("advancedQueryList[0].fieldValue", s1);
        map.put("baseModel.condition", String.valueOf(type));
        showLoading();
        presenter.findClientInfoState2(map);
    }

    private Map<String, String> mapPage(int cpage, int page_size, int type) {
        Map<String, String> map = new ArrayMap<>();
        map.put("baseModel.pageInfo.cpage", cpage + "");
        map.put("baseModel.pageInfo.page_size", page_size + "");
        map.put("baseModel.condition", type + "");
        map.put("advancedQueryList[1].fieldName", "pi.project_id");
//        LogUtils.i("项目id" + ClientFragment.project_id);
        map.put("advancedQueryList[1].fieldValue", ClientFragment.project_id);
        map.put("advancedQueryList[1].tempOperator", "QUERY");

        map.put("advancedQueryList[2].fieldName", "sdi4.name");
        map.put("advancedQueryList[2].fieldValue", ClientFragment.stateType);
        map.put("advancedQueryList[2].tempOperator", "QUERY");

        return map;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getParentFragment().getActivity(), ClientProbablyInfoActivity.class);
        intent.putExtra("client_id", currentData.get(position).getClient_id());
        startActivity(intent);
    }
    public void emptyData(){

    }
}
