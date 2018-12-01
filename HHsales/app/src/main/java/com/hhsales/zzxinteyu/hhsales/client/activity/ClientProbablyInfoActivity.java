package com.hhsales.zzxinteyu.hhsales.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.inteface.IEmptyLayout;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.view.EmptyLayout;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.adapter.InteractionAdapter;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.bean.Purchase;
import com.hhsales.zzxinteyu.hhsales.client.bean.PurchaseData;
import com.hhsales.zzxinteyu.hhsales.client.bean.Transaction;
import com.hhsales.zzxinteyu.hhsales.client.presenter.ClientProbablyInfoPresenter;

public class ClientProbablyInfoActivity extends BaseActivity<IClientProbablyInfoActivityView, ClientProbablyInfoPresenter> implements IClientProbablyInfoActivityView, View.OnClickListener {
    private ImageView mIv_return;
    private TextView mTv_client_name;
    private TextView mTv_client_info_delet;
    private TextView mTv_mobile_phone;
    private TextView mTv_purchase_room;
    private ImageView mIv_purchase_room;
    private TextView mTv_purchase_room_type;
    private TextView mTv_purchase_use;
    private TextView mTv_purchase_record;
    private TextView mTv_detailed_info;
    private TextView mTv_purchase_select;
    private ListView mIv_purchase;
    private EmptyLayout emptyLayout;
    private RelativeLayout probablyInfoTop;
    private LinearLayout client_info_page_list_item;
    private String index = "4,5,6,12,14,15,8";
    private InteractionAdapter interactionAdapter;
    private String client_id;
    @Override
    protected ClientProbablyInfoPresenter createPresenter() {
        return new ClientProbablyInfoPresenter();
    }


    @Override
    protected void initView() {
        setContentView(R.layout.activity_client_probably_info);
        probablyInfoTop = findViewById(R.id.rl_probably_info_top);
        setImmerseLayout(probablyInfoTop);
        mTv_mobile_phone = (TextView) findViewById(R.id.tv_mobile_phone);
        mTv_purchase_room = (TextView) findViewById(R.id.tv_purchase_room);
        mIv_purchase_room = (ImageView) findViewById(R.id.iv_purchase_room);
        mTv_purchase_room_type = (TextView) findViewById(R.id.tv_purchase_room_type);
        mTv_purchase_use = (TextView) findViewById(R.id.tv_purchase_use);
        mTv_purchase_record = (TextView) findViewById(R.id.tv_purchase_record);
        mTv_detailed_info = (TextView) findViewById(R.id.tv_detailed_info);
        mTv_purchase_select = (TextView) findViewById(R.id.tv_purchase_select);
        mIv_purchase = (ListView) findViewById(R.id.iv_purchase);
        mIv_return = (ImageView) findViewById(R.id.iv_return);
        mTv_client_name = (TextView) findViewById(R.id.tv_client_name);
        mTv_client_info_delet = (TextView) findViewById(R.id.tv_client_info_delet);
        emptyLayout = findViewById(R.id.client_probably_emptylayout);
        client_info_page_list_item = (LinearLayout) findViewById(R.id.client_probably_linearlayout);
        emptyLayout.bindView(client_info_page_list_item);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (getIntent() != null && getIntent().getStringExtra("client_id") != null) {
            client_id = getIntent().getStringExtra("client_id");
            showLoading();
            initTabData();
            presenter.getClientInfo(client_id);
        }
    }

    @Override
    protected void initListener() {
        mIv_return.setOnClickListener(this);
        mTv_purchase_record.setOnClickListener(this);
        mTv_detailed_info.setOnClickListener(this);
        mTv_purchase_select.setOnClickListener(this);

    }

    @Override
    public void getClientInfo(String client_id) {
        presenter.getClientInfo(client_id);
    }

    @Override
    public void setClientInfo(PageClientInfo<ClientData> clientInfo) {
        mTv_client_name.setText(clientInfo.getData().getClientInfo().getClient_name());
        mTv_mobile_phone.setText(clientInfo.getData().getClientInfo().getMobile_tele());
        if(clientInfo.getData().getClientInfo().getFk_use()!=null&&!clientInfo.getData().getClientInfo().getFk_use().equals(""))
        presenter.findSysDictionaryItemByPk(clientInfo.getData().getClientInfo().getFk_use());

    }

    @Override
    public void getPurchase(String client_id) {
        presenter.findIntentionByClientId(client_id);
    }

    @Override
    public void setPurchase(Purchase purchase) {
        if(purchase.getData().size()>0) {
            PurchaseData purchaseData = purchase.getData().get(0);
            for (int i=0;i<purchase.getData().size();i++){
                if(1 == purchase.getData().get(i).getState()){
                    purchaseData = purchase.getData().get(i);
                }
            }
            mTv_purchase_room.setText(purchaseData.getIntention_room());
            if (purchaseData.getIntention_house_type()!=null&&!purchaseData.getIntention_house_type().equals(""))
            presenter.findSysDictionaryItemByPk(purchaseData.getIntention_house_type());
        }
    }

    @Override
    public void show_mTv_purchase_use(String text) {
        mTv_purchase_use.setText(text);
    }

    @Override
    public void show_mTv_purchase_room_type(String text) {
        mTv_purchase_room_type.setText(text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_return:
                finish();
                break;
            case R.id.tv_purchase_record:
                Intent intent = new Intent(ClientProbablyInfoActivity.this, InteractionActivity.class);
                intent.putExtra("client_id", client_id);
                startActivity(intent);
                break;
            case R.id.tv_detailed_info:
                Intent intent1 = new Intent(ClientProbablyInfoActivity.this, ClientInfoActivity.class);
                intent1.putExtra("client_id", client_id);
                intent1.putExtra("type", "查看");
                startActivity(intent1);
                break;

            case R.id.tv_purchase_select:
                Intent intent2 = new Intent(ClientProbablyInfoActivity.this, PurchaseActivity.class);
                intent2.putExtra("client_id", client_id);
                startActivity(intent2);
                break;

        }
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
    public void getInteraction(String client_id) {
     presenter.findClinetTrackByClientId(client_id);
    }

    @Override
    public void setInteraction(Transaction transaction) {

        interactionAdapter = new InteractionAdapter(this, transaction.getData());
        mIv_purchase.setAdapter(interactionAdapter);
    }

    //获取数据字典
    public void initTabData() {
        //presenter.findListSysDictionary(index,client_id);
    }
}
