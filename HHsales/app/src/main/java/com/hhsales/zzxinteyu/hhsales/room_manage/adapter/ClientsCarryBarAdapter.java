package com.hhsales.zzxinteyu.hhsales.room_manage.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lib_common.Adapter.Other.SimpleRecycleViewAdapter;
import com.example.lib_common.utils.CustomAlertDialog;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.Public;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBase;
import com.hhsales.zzxinteyu.hhsales.room_manage.presenter.ClientsCarryBarPresenter;
import com.hhsales.zzxinteyu.hhsales.room_manage.ui.ClientsCarryBarActivity;

import java.util.ArrayList;

/**
 * Created by acer on 2018/3/31.
 */

public class ClientsCarryBarAdapter extends SimpleRecycleViewAdapter<RoomMagementBase,ClientsCarryBarAdapter.RoomManagementViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private ClientsCarryBarPresenter presenter;
    private CustomAlertDialog customAlertDialog;
    //自定义弹窗
    private AlertDialog dlg;
    private ClientsCarryBarActivity clientsCarryBarActivity;
    private Context context;

    public ClientsCarryBarAdapter(ClientsCarryBarActivity clientsCarryBarActivity, ArrayList<RoomMagementBase> listData, ClientsCarryBarPresenter presenter) {
        super(clientsCarryBarActivity,listData);
        this.context = clientsCarryBarActivity;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.clientsCarryBarActivity = clientsCarryBarActivity;
        this.presenter=presenter;
    }


    /**
     * 删除
     * @param position
     */
    public void remove(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 新增
     * @param position
     */
    public void add(RoomMagementBase neWbase, int position) {
        listData.add(position, neWbase);
        notifyItemInserted(position);
    }
    @Override
    protected RoomManagementViewHolder onCreateItemViewHolder(ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.room_management_details, parent,false);
        RoomManagementViewHolder holder = new RoomManagementViewHolder(view);
        return holder;
    }

    @Override
    protected void onBindItemViewHolder(final RoomManagementViewHolder holder, final int position) {
         //绑定数据
        holder.room_room_number.setText(listData.get(position).getProject_name());
        holder.room_decoration_standard.setText(listData.get(position).getDecoration_standard());
        holder.room_room_structure.setText(listData.get(position).getRoom_structure());
        holder.room_construction_area.setText(listData.get(position).getProRoom().getBuilding_area()+"");
        holder.room_standard_total_price.setText(listData.get(position).getProRoomPricing().getStandard_total()+"");
        holder.room_positions.setText(listData.get(position).getProRoom().getStorey()+"/"
                +listData.get(position).getProRoom().getUnit_name()+"/"
                +listData.get(position).getProRoom().getRoom_number());

        holder.room_decoration_detailss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent =new Intent(context,ViewRoomActivity.class);
//                //用Bundle携带数据
//                Bundle bundle=new Bundle();
//               //主键id
//                bundle.putString("room_id", nonEmptyJudgment(listData.get(position).getProRoom().getRoom_id()));
//                intent.putExtras(bundle);
//                context.startActivity(intent);
            }
        });
        if (listData.get(position).getProRoom().getStatus()==1){
            holder.room_selec.setVisibility(View.VISIBLE);
            LogUtils.i("当前加载数据" + position);

        }else {
            holder.room_selec.setVisibility(View.GONE);

        }
        holder.room_selec.setTag(position);
        holder.room_selec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomAlertDialog(context,0,"选定","确定要选定房间吗?",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i == -1){
                            //确定
                            String room_name = listData.get((Integer) holder.room_selec.getTag()).getProject_name() + "/"
                                    +listData.get((Integer) holder.room_selec.getTag()).getBuilding_name()+"/"
                                    +listData.get((Integer) holder.room_selec.getTag()).getProRoom().getRoom_name();
                            clientsCarryBarActivity.selectedRoom(listData.get((Integer) holder.room_selec.getTag()).getProRoom().getRoom_id(),room_name);
                        }
                        if(i == -2){
                            //取消
                        }
                    }
                });

            }
        });

    }

    //非空选择判断
    public String nonEmptyJudgment(String parameter) {
        if ("".equals(parameter)) {
            return "null";
        }else if(parameter==null){
            return "null";
        }else {
            return parameter;
        }
    }

    public class RoomManagementViewHolder extends RecyclerView.ViewHolder{
        //删除按钮
        Button room_delete;
        //建筑面积
        TextView room_construction_area;
        //项目名称
        TextView room_room_number;
        //标准总价
        TextView room_standard_total_price;
        //装修标准
        TextView room_decoration_standard;
        //房间结构
        TextView room_room_structure;
        //位置
        TextView room_positions;
        //编辑
        Button room_selec;

        LinearLayout room_decoration_detailss;


        public RoomManagementViewHolder(View itemView) {
            super(itemView);
            room_construction_area = itemView.findViewById(R.id.room_construction_area);
            room_room_number = itemView.findViewById(R.id.room_room_number);
            room_standard_total_price = itemView.findViewById(R.id.room_standard_total_price);
            room_decoration_standard = itemView.findViewById(R.id.room_decoration_standard);
            room_room_structure = itemView.findViewById(R.id.room_room_structure);
            room_positions = itemView.findViewById(R.id.room_positions);
            room_selec = itemView.findViewById(R.id.room_select);
            room_decoration_detailss=itemView.findViewById(R.id.room_decoration_detailss);
        }

    }

}
