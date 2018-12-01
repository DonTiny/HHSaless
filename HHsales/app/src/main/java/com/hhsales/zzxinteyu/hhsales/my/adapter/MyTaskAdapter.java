package com.hhsales.zzxinteyu.hhsales.my.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.lib_common.Adapter.Other.SimpleRecycleViewAdapter;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.my.bean.MyTaskData;

import java.util.List;

/**
 * Created by Administrator on 2018/11/16.
 */

public class MyTaskAdapter extends SimpleRecycleViewAdapter<MyTaskData,MyTaskAdapterHolder> {
    private OnClickItemListener onClickItemListener;

    public MyTaskAdapter(Context context, List<MyTaskData> listData) {
        super(context, listData);
    }

    @Override
    protected MyTaskAdapterHolder onCreateItemViewHolder(ViewGroup parent) {
        return new MyTaskAdapterHolder(inflater.inflate(R.layout.my_task_item,parent, false));
    }

    @Override
    protected void onBindItemViewHolder(MyTaskAdapterHolder myTaskAdapterHolder, int position) {

        myTaskAdapterHolder.initView(context, listData.get(position), onClickItemListener, position);
    }
    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }
    public interface OnClickItemListener {
        void onClick(int label, int position);
        void compileClient(String client_id);
        void allotClue(int position);
    }
}
