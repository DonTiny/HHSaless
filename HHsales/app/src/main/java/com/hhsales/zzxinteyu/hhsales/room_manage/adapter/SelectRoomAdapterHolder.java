package com.hhsales.zzxinteyu.hhsales.room_manage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.hhsales.zzxinteyu.hhsales.R;

import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBase;
import com.hhsales.zzxinteyu.hhsales.room_manage.ui.SelectRoomActivity;
import com.hhsales.zzxinteyu.hhsales.utlis.RoomDataDictionary;
import com.hhsales.zzxinteyu.hhsales.view.MySuperDialog;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/11/16.
 */

public class SelectRoomAdapterHolder extends RecyclerView.ViewHolder {
    private TextView mRoom_room_number;
    private TextView mRoom_construction_area;
    private TextView mRoom_standard_total_price;
    private TextView mRoom_decoration_standard;
    private TextView mRoom_room_structure;
    private TextView mRoom_positions;
    private Button mRoom_select;
    SelectRoomActivity activity;
    public SelectRoomAdapterHolder(View itemView) {
        super(itemView);
        mRoom_room_number = (TextView) itemView.findViewById(R.id.room_room_number);
        mRoom_construction_area = (TextView)itemView. findViewById(R.id.room_construction_area);
        mRoom_standard_total_price = (TextView) itemView.findViewById(R.id.room_standard_total_price);
        mRoom_decoration_standard = (TextView)itemView. findViewById(R.id.room_decoration_standard);
        mRoom_room_structure = (TextView) itemView.findViewById(R.id.room_room_structure);
        mRoom_positions = (TextView)itemView. findViewById(R.id.room_positions);
        mRoom_select = (Button)itemView. findViewById(R.id.room_select);
    }

    public void initView(final Context context, final RoomMagementBase data, final SelectRoomAdapter.OnClickItemListener onClickItemListener, final int position) {
        mRoom_room_number.setText(data.getProject_name());
        mRoom_construction_area.setText(data.getProRoom().getBuilding_area() + "");
        mRoom_standard_total_price.setText(data.getProRoom().getDecorate_total() + "");
        mRoom_decoration_standard.setText(data.getDecoration_standard());
        mRoom_room_structure.setText(data.getRoom_structure());
        mRoom_positions.setText(data.getBuilding_name() + "/" + data.getProRoom().getUnit_name() + "/" + data.getProRoom().getRoom_name());
        if(data.getProRoom().getStatus()==1){
            mRoom_select.setVisibility(View.VISIBLE);

        }else {
            mRoom_select.setVisibility(View.GONE);

        }
        activity = (SelectRoomActivity) context;

        mRoom_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MySuperDialog.showSuperDialog(activity, "选定", "确定要选定房间么?", new MySuperDialog.ResultDialog() {
                    @Override
                    public void positivOnClick(View view) {
                        //确定
                        String room_name = data.getProject_name() + "/"
                                +data.getBuilding_name()+"/"
                                +data.getProRoom().getRoom_name();
                        activity.selectedRoom(data.getProRoom().getRoom_id(),room_name);
                    }

                    @Override
                    public void negativeOnClick(View view) {

                    }

                });

            }
        });
    }
}
