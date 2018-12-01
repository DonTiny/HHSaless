package com.hhsales.zzxinteyu.hhsales.client.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_common.utils.CustomAlertDialog;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.bean.PurchaseData;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientInfoDataDictionary;

import java.util.List;

/**
 * Created by Administrator on 2018/4/10.
 */
public class PurchaseAdapter extends BaseAdapter {
    private List<PurchaseData> data;
    private LayoutInflater mInflater = null;
    private Context context;
    public PurchaseAdapter(Context context, List<PurchaseData> data)
    {
        this.context=context;
        this.data = data;
        //根据context上下文加载布局，这里的是Demo17Activity本身，即this
        this.mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        //How many items are in the data set represented by this Adapter.
        //在此适配器中所代表的数据集中的条目数
        return data.size();
    }
    @Override
    public Object getItem(int position) {
        // Get the data item associated with the specified position in the data set.
        //获取数据集中与指定索引对应的数据项
        return data.get(position);
    }
    @Override
    public long getItemId(int position) {
        //Get the row id associated with the specified position in the list.
        //获取在列表中与指定索引对应的行id
        return position;
    }

    //Get a View that displays the data at the specified position in the data set.
    //获取一个在数据集中指定索引的视图来显示数据
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        //如果缓存convertView为空，则需要创建View
        if(convertView == null)
        {
            holder = new ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = mInflater.inflate(R.layout.client_purchase_item, null);
            holder.mTv_update_purchase_area_item = (TextView) convertView.findViewById(R.id.tv_update_purchase_area_item);
            holder. mTv_update_purchase_price_item = (TextView) convertView.findViewById(R.id.tv_update_purchase_price_item);
            holder. mTv_update_purchase_room_type_item = (TextView) convertView.findViewById(R.id.tv_update_purchase_room_type_item);
            holder. mTv_update_purchase_room_item = (TextView)convertView. findViewById(R.id.tv_update_purchase_room_item);
            holder. mTv_update_purchase_state_item = (TextView) convertView.findViewById(R.id.tv_update_purchase_state_item);

            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.mTv_update_purchase_area_item.setText(data.get(position).getIntention_area_min()+"----"+data.get(position).getIntention_area_max());
        holder. mTv_update_purchase_price_item.setText(data.get(position).getIntention_price_min()+"----"+data.get(position).getIntention_price_max());
        for(int i = 0; i< ClientInfoDataDictionary.room_type_id.length; i++){
            if(ClientInfoDataDictionary.room_type_id[i].equals(data.get(position).getIntention_house_type())){
                holder. mTv_update_purchase_room_type_item.setText(ClientInfoDataDictionary.room_type[i]);
            }

        }
        holder.mTv_update_purchase_room_item.setText(data.get(position).getIntention_room());
        if(data.get(position).getState()==1){
            holder. mTv_update_purchase_state_item.setText("选定");

        }else {
            holder. mTv_update_purchase_state_item.setText("意向");

        }

        return convertView;
    }





    //ViewHolder静态类
    static class ViewHolder
    {
        private TextView mTv_update_purchase_area_item;
        private TextView mTv_update_purchase_price_item;
        private TextView mTv_update_purchase_room_type_item;
        private TextView mTv_update_purchase_room_item;
        private TextView mTv_update_purchase_state_item;

}

}
