package com.hhsales.zzxinteyu.hhsales.client.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.utils.CustomAlertDialog;
import com.example.lib_common.utils.CustomPopup;
import com.example.lib_common.utils.LogUtils;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.presenter.AddPurchasePresenter;
import com.hhsales.zzxinteyu.hhsales.room_manage.ui.ClientsCarryBarActivity;
import com.hhsales.zzxinteyu.hhsales.room_manage.ui.SelectRoomActivity;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientInfoDataDictionary;
import com.hhsales.zzxinteyu.hhsales.view.MySuperDialog;

import java.util.Map;

public class AddPurchaseActivity extends BaseActivity<IAddPurchaseView,AddPurchasePresenter> implements IAddPurchaseView, View.OnClickListener {
    private String client_id;
    private TextView mTv_update_purchase_room_type,mTv_update_purchase_room;
    private ImageView mIv_update_purchase_room_type;
    private EditText mTv_update_purchase_area_first;
    private EditText mTv_update_purchase_area_next;
    private EditText mTv_update_purchase_price_first;
    private EditText mTv_update_purchase_price_next;
    private TextView mTv_save_purchase;
    private ImageView mIv_search_purchase_room;
    private RelativeLayout addPurchaseTop;
    private String room_id;
    private String room_name;
    @Override
    protected AddPurchasePresenter createPresenter() {
        return new AddPurchasePresenter();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_add_purchase);
        addPurchaseTop=findViewById(R.id.rl_add_purchase_top);
        setImmerseLayout(addPurchaseTop);
        mTv_update_purchase_room_type = findViewById(R.id.tv_update_purchase_room_type);
        mIv_update_purchase_room_type = findViewById(R.id.iv_update_purchase_room_type);
        mTv_update_purchase_area_first = (EditText) findViewById(R.id.tv_update_purchase_area_first);
        mTv_update_purchase_area_next = (EditText)findViewById(R.id.tv_update_purchase_area_next);
        mTv_update_purchase_price_first = (EditText) findViewById(R.id.tv_update_purchase_price_first);
        mTv_update_purchase_price_next = (EditText)findViewById(R.id.tv_update_purchase_price_next);
        mTv_update_purchase_room = findViewById(R.id.tv_update_purchase_room);
        mIv_search_purchase_room = findViewById(R.id.iv_update_purchase_room);
        mTv_save_purchase = findViewById(R.id.tv_save_purchase);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (getIntent() != null && getIntent().getStringExtra("client_id") != null) {
            client_id = getIntent().getStringExtra("client_id");
        }
    }

    @Override
    protected void initListener() {
        mIv_search_purchase_room.setOnClickListener(this);
        mTv_update_purchase_room_type.setOnClickListener(this);
        mIv_update_purchase_room_type.setOnClickListener(this);
        mTv_save_purchase.setOnClickListener(this);
    }

    @Override
    public Map<String, String> getTextView() {
        Map<String, String> map = new ArrayMap<>();
        if(mTv_update_purchase_area_first.getText().toString()!=null&&!mTv_update_purchase_area_first.getText().toString().equals(""))
            map.put("intention_area_min", mTv_update_purchase_area_first.getText() + "");
        if(mTv_update_purchase_area_next.getText().toString()!=null&&!mTv_update_purchase_area_next.getText().toString().equals(""))
            map.put("intention_area_max", mTv_update_purchase_area_next.getText() + "");
        if(mTv_update_purchase_price_first.getText().toString()!=null&&!mTv_update_purchase_price_first.getText().toString().equals(""))

            map.put("intention_price_min", mTv_update_purchase_price_first.getText() + "");
        if(mTv_update_purchase_price_next.getText().toString()!=null&&!mTv_update_purchase_price_next.getText().toString().equals(""))

            map.put("intention_price_max", mTv_update_purchase_price_next.getText() + "");
            map.put("intention_room", room_name+ "");
            map.put("fk_intention_room_id", room_id+ "");
        map.put("fk_client_id", client_id);
        if(mTv_update_purchase_room_type.getTag()!=null&&!mTv_update_purchase_room_type.getTag().equals(""))
            map.put("intention_house_type", ClientInfoDataDictionary.room_type_id[(int) mTv_update_purchase_room_type.getTag()]);
        return map;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.iv_update_purchase_room_type || i == R.id.tv_update_purchase_room_type) {
            if (ClientInfoDataDictionary.room_type != null)
                new CustomPopup(this, ClientInfoDataDictionary.room_type, mTv_update_purchase_room_type, mTv_update_purchase_room_type.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        mTv_update_purchase_room_type.setText(s);
                        mTv_update_purchase_room_type.setTag(position);
                    }
                });

        }
        if (i == R.id.tv_save_purchase) {
                if(mTv_update_purchase_room_type.getText().toString().trim().equals("")){
                    showToast("请选择房间类型");
                }else {
                    MySuperDialog.showSuperDialog(this, "保存", "确定要保存么？", new MySuperDialog.ResultDialog() {
                        @Override
                        public void positivOnClick(View view) {
                            //确定
                            presenter.addIntention();
                            Intent intent = new Intent();
                            intent.putExtra("state", "yes");
                            setResult(4,intent);
                            finish();
                        }

                        @Override
                        public void negativeOnClick(View view) {

                        }
                    });
                }

        }
        if (i==R.id.iv_update_purchase_room){
            LogUtils.i("选择房间");
            Intent intent = new Intent(AddPurchaseActivity.this, SelectRoomActivity.class);
            intent.putExtra("conditions", mTv_update_purchase_room_type.getTag() != null ? mTv_update_purchase_room_type.getText().toString().trim() : "");
            startActivityForResult(intent, 2);

//            ARouter.getInstance().build("/main/ClientsCarryBarActivity")
//                    .withString("conditions",mTv_update_purchase_room_type.getTag()!=null?mTv_update_purchase_room_type.getText().toString().trim():"0" ).navigation();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==2&&data!=null){
            room_id = data.getStringExtra("room_id");
            room_name = data.getStringExtra("room_name");
            mTv_update_purchase_room.setText(room_name);
            LogUtils.i(room_id + room_name);
        }
    }
}
