package com.hhsales.zzxinteyu.hhsales.client.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.utils.CustomAlertDialog;
import com.example.lib_common.utils.CustomPopup;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.TimeUtils;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.presenter.AddInteractionPresenter;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientInfoDataDictionary;
import com.hhsales.zzxinteyu.hhsales.utlis.DateChooseWheelViewDialog;

import java.util.Date;
import java.util.Map;

public class AddInteractionActivity extends BaseActivity<IAddInteractionView,AddInteractionPresenter> implements IAddInteractionView, View.OnClickListener {
    private TextView mTv_update_transaction_client_interaction_type;
    private ImageView mV_update_transaction_client_interaction_type;
    private TextView mTv_update_transaction_client_follow_stage;
    private ImageView mV_update_transaction_client_follow_stage;
    private TextView mTv_update_transaction_client_next;
    private ImageView mIv_update_transaction_client_next;
    private EditText mEt_update_client_contact;
    private TextView mTv_save_transaction;
    private TextView mTv_empty;
    private RelativeLayout addInteractionTop;


    private String client_id;
    @Override
    protected AddInteractionPresenter createPresenter() {
        return new AddInteractionPresenter();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_add_interaction);
        addInteractionTop=findViewById(R.id.rl_add_interaction_top);
        setImmerseLayout(addInteractionTop);
        mTv_update_transaction_client_interaction_type = (TextView) findViewById(R.id.tv_update_transaction_client_interaction_type);
        mV_update_transaction_client_interaction_type = (ImageView) findViewById(R.id.v_update_transaction_client_interaction_type);
        mTv_update_transaction_client_follow_stage = (TextView) findViewById(R.id.tv_update_transaction_client_follow_stage);
        mV_update_transaction_client_follow_stage = (ImageView) findViewById(R.id.v_update_transaction_client_follow_stage);
        mTv_update_transaction_client_next = (TextView) findViewById(R.id.tv_update_transaction_client_next);
        mIv_update_transaction_client_next = (  ImageView) findViewById(R.id.iv_update_transaction_client_next);
        mEt_update_client_contact = (EditText) findViewById(R.id.et_update_client_contact);
        mTv_save_transaction = (TextView) findViewById(R.id.tv_save_transaction);
        mTv_empty = findViewById(R.id.tv_empty);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (getIntent() != null && getIntent().getStringExtra("client_id") != null) {
            client_id = getIntent().getStringExtra("client_id");
        }
    }

    @Override
    protected void initListener() {
        mTv_update_transaction_client_interaction_type.setOnClickListener(this);
        mV_update_transaction_client_interaction_type.setOnClickListener(this);
        mTv_update_transaction_client_follow_stage.setOnClickListener(this);
        mV_update_transaction_client_follow_stage.setOnClickListener(this);
        mTv_update_transaction_client_next.setOnClickListener(this);
        mIv_update_transaction_client_next.setOnClickListener(this);
        mTv_save_transaction.setOnClickListener(this);
        mTv_empty.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.tv_update_transaction_client_interaction_type || i == R.id.v_update_transaction_client_interaction_type) {
            if (ClientInfoDataDictionary.interaction_type != null) {
                new CustomPopup(this, ClientInfoDataDictionary.interaction_type, mTv_update_transaction_client_interaction_type, mTv_update_transaction_client_interaction_type.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        mTv_update_transaction_client_interaction_type.setText(s);
                        mTv_update_transaction_client_interaction_type.setTag(position);
                    }
                });
            }

        } else if (i == R.id.tv_update_transaction_client_follow_stage || i == R.id.v_update_transaction_client_follow_stage) {
            if (ClientInfoDataDictionary.follow_stage != null) {
                new CustomPopup(this, ClientInfoDataDictionary.follow_stage, mTv_update_transaction_client_follow_stage, mTv_update_transaction_client_follow_stage.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        mTv_update_transaction_client_follow_stage.setText(s);
                        mTv_update_transaction_client_follow_stage.setTag(position);
                    }
                });
            }

        } else if (i == R.id.tv_update_transaction_client_next || i == R.id.iv_update_transaction_client_next) {
             // 日期格式为yyyy-MM-dd HH:mm

            DateChooseWheelViewDialog endDateChooseDialog = new DateChooseWheelViewDialog(AddInteractionActivity.this,
                    new DateChooseWheelViewDialog.DateChooseInterface() {
                        @Override
                        public void getDateTime(String time, boolean longTimeChecked) {
                            mTv_update_transaction_client_next.setText(time);
                        }
                    });
            endDateChooseDialog.setTimePickerGone(true);
            endDateChooseDialog.setDateDialogTitle("下次交互");
            endDateChooseDialog.showDateChooseDialog();

        } else if (i == R.id.tv_save_transaction) {
                if (mTv_update_transaction_client_interaction_type.getText().toString().trim().equals("")) {
                    showToast("请选择交互类型");

                } else if (mTv_update_transaction_client_follow_stage.getText().toString().trim().equals("")) {
                    showToast("请选择跟进阶段");
                } else if (mEt_update_client_contact.getText().toString().trim().equals("")) {
                    showToast("请输入交互内容");

                }else if(!mTv_update_transaction_client_next.getText().equals("")){
                    LogUtils.log(TimeUtils.getTimeBar(mTv_update_transaction_client_next.getText().toString(), false)+"???");
                    if(Long.parseLong(TimeUtils.getTimeBar(mTv_update_transaction_client_next.getText().toString(), false))>new Date().getTime()){

                            new CustomAlertDialog(this, 0, "保存", "确定要保存么", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (i == -1) {
                                        //确定
                                        presenter.addClinetTrack();
                                    }
                                    if (i == -2) {
                                        //取消
                                    }
                                }
                            });


                    }else {
                        showToast("请选择正确的时间");
                    }

                }





        } else if (i == R.id.tv_empty) {
            mTv_update_transaction_client_interaction_type.setText("");
            mTv_update_transaction_client_follow_stage.setText("");
            mEt_update_client_contact.setText("");
        }
    }

    @Override
    public Map<String, String> getViewText() {
        Map<String, String> map = new ArrayMap<>();
        if (!(mTv_update_transaction_client_follow_stage.getText() + "").trim().equals("") || !(mTv_update_transaction_client_interaction_type.getText() + "").trim().equals("") || !(mEt_update_client_contact.getText() + "").trim().equals("")) {
            map.put("record_type", String.valueOf(mTv_update_transaction_client_interaction_type.getTag()));
            if (ClientInfoDataDictionary.follow_stage_id != null)
                map.put("fk_follow_stage", ClientInfoDataDictionary.follow_stage_id[(int) mTv_update_transaction_client_follow_stage.getTag()]);


            String time = mTv_update_transaction_client_next.getText().toString().trim();
            //time = time.replaceAll("年", "-").replaceAll("月", "-").replaceAll("日", "");
            map.put("next_contact_time", time);

            map.put("record", mEt_update_client_contact.getText().toString());
            map.put("fk_client_id",client_id);
        } else {
            return null;
        }
        return map;
    }

    @Override
    public void onBackPressed() {
        setResult(1,new Intent() );
      finish();
    }

    @Override
    public void addClinetTrackResults(int results) {
        if(results==0){
         showToast("保存失败，请检查网络！");
        }else if(results==1){
            Intent intent = new Intent();
            intent.putExtra("results", 0);
            setResult(0, intent);
            finish();
        }


    }

}
