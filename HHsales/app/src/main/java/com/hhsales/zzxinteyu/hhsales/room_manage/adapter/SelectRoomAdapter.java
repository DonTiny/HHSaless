package com.hhsales.zzxinteyu.hhsales.room_manage.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.lib_common.Adapter.Other.SimpleRecycleViewAdapter;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.Room;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBase;


import java.util.List;

/**
 * Created by Administrator on 2018/11/16.
 */

public class SelectRoomAdapter extends SimpleRecycleViewAdapter<RoomMagementBase,SelectRoomAdapterHolder> {
    private OnClickItemListener onClickItemListener;

    public SelectRoomAdapter(Context context, List<RoomMagementBase> listData) {
        super(context, listData);
    }

    @Override
    protected SelectRoomAdapterHolder onCreateItemViewHolder(ViewGroup parent) {
        return new SelectRoomAdapterHolder(inflater.inflate(R.layout.room_select_item,parent, false));
    }

    @Override
    protected void onBindItemViewHolder(SelectRoomAdapterHolder selectRoomAdapterHolder, int position) {

        selectRoomAdapterHolder.initView(context, listData.get(position), onClickItemListener, position);
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
