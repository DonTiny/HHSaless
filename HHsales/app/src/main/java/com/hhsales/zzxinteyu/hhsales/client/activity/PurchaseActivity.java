package com.hhsales.zzxinteyu.hhsales.client.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.view.EmptyLayout;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.adapter.PurchaseAdapter;
import com.hhsales.zzxinteyu.hhsales.client.bean.Purchase;
import com.hhsales.zzxinteyu.hhsales.client.presenter.PurchasePresenter;

public class PurchaseActivity extends BaseActivity<IPurchaseView, PurchasePresenter> implements IPurchaseView, View.OnClickListener {
    private ListView lv_purchase_list;
    private PurchaseAdapter purchaseAdapter;
    private ImageView mIv_add_purchase;
    private EmptyLayout emptyLayout;
    private String client_id;
    private RelativeLayout purchaseTop;
    private ImageView ivReturn;
    @Override
    protected PurchasePresenter createPresenter() {
        return new PurchasePresenter();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_purchase);
        purchaseTop = findViewById(R.id.rl_purchase_top);
        setImmerseLayout(purchaseTop);
        lv_purchase_list = findViewById(R.id.lv_purchase_list);
        mIv_add_purchase = findViewById(R.id.iv_add_purchase);
        emptyLayout = findViewById(R.id.client_purcase_list_emptyLayout);
        ivReturn = findViewById(R.id.iv_return);
        emptyLayout.bindView(lv_purchase_list);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (getIntent() != null && getIntent().getStringExtra("client_id") != null) {
            client_id = getIntent().getStringExtra("client_id");
            initPurchaseData();
        }
    }

    @Override
    protected void initListener() {
        mIv_add_purchase.setOnClickListener(this);
        ivReturn.setOnClickListener(this);
        emptyLayout.setOnButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData(null);
            }
        });
    }

    public void initPurchaseData() {
        showLoading();
        presenter.findIntentionByClientId(client_id);

    }

    @Override
    public void setPurchaseData(Purchase purchase) {
        if (purchase.getData().size() == 0) {
            LogUtils.i("购房意向" + purchase.getData().size());
            showEmpty();

        } else {
            showSuccess();
        }

        purchaseAdapter = new PurchaseAdapter(this, purchase.getData());
        lv_purchase_list.setAdapter(purchaseAdapter);

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
        switch (v.getId()) {
            case R.id.iv_add_purchase:
                Intent intent = new Intent(PurchaseActivity.this, AddPurchaseActivity.class);
                intent.putExtra("client_id", client_id);
                startActivityForResult(intent, 4);
                break;
            case R.id.iv_return:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data!=null&&resultCode==4){
             if (data.getStringExtra("state").equals("yes")){
                 initData(null);
             }
        }
    }
}
