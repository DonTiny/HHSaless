package com.hhsales.zzxinteyu.hhsales.my.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.TimeUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.my.bean.MyTaskData;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientInfoDataDictionary;

/**
 * Created by Administrator on 2018/11/16.
 */

public class MyTaskAdapterHolder extends RecyclerView.ViewHolder {
    private TextView mTv_client_name;
    private TextView mTv_client_phone;
    private TextView mTv_client_sex;
    private TextView mTv_client_project;
    private TextView mTv_client_salesman;
    private TextView mTv_client_follow_stage;
    private TextView mTv_client_last_contact;
    private TextView mTv_client_ry_group;

    public MyTaskAdapterHolder(View itemView) {
        super(itemView);
        mTv_client_name = itemView.findViewById(R.id.tv_client_name);
        mTv_client_phone = itemView.findViewById(R.id.tv_client_phone);
        mTv_client_sex = itemView.findViewById(R.id.tv_client_sex);
        mTv_client_project = itemView.findViewById(R.id.tv_client_project);
        mTv_client_salesman = itemView.findViewById(R.id.tv_client_salesman);
        mTv_client_follow_stage = itemView.findViewById(R.id.tv_client_follow_stage);
        mTv_client_last_contact = itemView.findViewById(R.id.tv_client_last_contact);
        mTv_client_ry_group = itemView.findViewById(R.id.tv_client_ry_group);
    }

    public void initView(final Context context, final MyTaskData data, final MyTaskAdapter.OnClickItemListener onClickItemListener, final int position) {
        LogUtils.i("当前RecycleView的值" + GsonUtil.GsonString(data));
        mTv_client_name.setText(data.getClientInfo().getClient_name());
        mTv_client_phone.setText(data.getClientInfo().getMobile_tele());
        mTv_client_sex.setText(ClientInfoDataDictionary.sex[data.getClientInfo().getSex()]);
        mTv_client_project.setText(data.getProItem().getItem_name());
        mTv_client_salesman.setText(data.getClientTrack().getCreator());
        mTv_client_follow_stage.setText(data.getFollow_stage());
        mTv_client_last_contact.setText(TimeUtils.getStrTime(data.getClientTrack().getNext_contact_time(), false));
        mTv_client_ry_group.setText(data.getClient_group());


    }
}
