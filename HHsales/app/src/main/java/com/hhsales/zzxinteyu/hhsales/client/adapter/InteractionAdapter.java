package com.hhsales.zzxinteyu.hhsales.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.TimeUtils;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.bean.TransactionData;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientInfoDataDictionary;

import java.util.List;

/**
 * Created by Administrator on 2018/4/10.
 */
public class InteractionAdapter extends BaseAdapter {
    private List<TransactionData> data;
    private LayoutInflater mInflater = null;
    private Context context;
    public InteractionAdapter(Context context, List<TransactionData> data)
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
            convertView = mInflater.inflate(R.layout.client_interaction_item, null);
            holder.  mTv_client_interaction_type = convertView.findViewById(R.id.tv_client_interaction_type);
            holder.  mTv_client_follow_stage = convertView. findViewById(R.id.tv_client_follow_stage);
            holder.    mTv_client_next_interaction_time = convertView.findViewById(R.id.tv_client_next_interaction_time);
            holder.    mTv_client_interaction_text = convertView. findViewById(R.id.tv_client_interaction_text);
            holder.mTv_client_interaction_time = convertView.findViewById(R.id.tv_client_interaction_time);
            holder.mTv_client_salesman=convertView.findViewById(R.id.tv_client_salesman);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        holder. mTv_client_interaction_type .setText(ClientInfoDataDictionary.interaction_type[Integer.parseInt(data.get(position).getRecord_type())]);
        for(int i = 0; i< ClientInfoDataDictionary.follow_stage_id.length; i++){
            if(ClientInfoDataDictionary.follow_stage_id[i].equals(data.get(position).getFk_follow_stage())){
                holder. mTv_client_follow_stage.setText(ClientInfoDataDictionary.follow_stage[i]);
            }
        }
        if(data.get(position).getNext_contact_time()!=null&&!data.get(position).getNext_contact_time().equals("")){
            holder. mTv_client_next_interaction_time .setText(TimeUtils.getStrTime(data.get(position).getNext_contact_time(),true));

        }
        holder.mTv_client_interaction_time.setText(TimeUtils.getStrTime(data.get(position).getContact_time(),true));
        holder.mTv_client_interaction_text.setText(data.get(position).getRecord());
        holder.mTv_client_salesman.setText(data.get(position).getCreator());
        //holder.mIv_delet_transaction.setTag(position);
        setLientsener(holder);
        return convertView;
    }

    private void setLientsener(final ViewHolder holder) {
//        holder.mIv_delet_transaction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new CustomAlertDialog(context, 0,"删除","确定要删除?",new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if(i == -1){
//                            //确定
//                            transactionFragment.deletTransaction(data.get((Integer) holder.mIv_delet_transaction.getTag()).getClient_track_id());
//                        }
//                        if(i == -2){
//                            //取消
//                            Toast.makeText(context, "取消选定" + i, Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        });
    }

    //ViewHolder静态类
    static class ViewHolder
    {
        private TextView mTv_client_interaction_type;
        private TextView mTv_client_follow_stage;
        private TextView mTv_client_salesman;
        private TextView mTv_client_interaction_text;
        private TextView mTv_client_interaction_time;
        private TextView mTv_client_next_interaction_time;
}

}
