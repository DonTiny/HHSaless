package com.hhsales.zzxinteyu.hhsales.client.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lib_common.utils.CustomAlertDialog;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.TimeUtils;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;

import java.util.List;

/**
 * Created by Administrator on 2018/4/10.
 */
public class ClientInfoAdapter extends BaseAdapter {
    private List<ClientData> data;
    private LayoutInflater mInflater = null;
    private Context context;
    public ClientInfoAdapter(Context context, List<ClientData> data)
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
            convertView = mInflater.inflate(R.layout.client_info_page_list_item, null);
            holder.  mTv_client_name = convertView.findViewById(R.id.tv_client_name);
            holder.  mTv_client_phone = convertView. findViewById(R.id.tv_client_phone);
            holder.    mTv_client_sex = convertView.findViewById(R.id.tv_client_sex);
            holder.    mTv_client_project = convertView. findViewById(R.id.tv_client_project);
            holder.   mTv_client_salesman =convertView. findViewById(R.id.tv_client_salesman);
            holder.   mTv_client_follow_stage = convertView. findViewById(R.id.tv_client_follow_stage);
            holder.    mTv_client_last_contact = convertView.findViewById(R.id.tv_client_last_contact);
            holder.    mTv_client_ry_group = convertView.findViewById(R.id.tv_client_ry_group);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        holder. mTv_client_name .setText(data.get(position).getClientInfo().getClient_name());
        holder. mTv_client_phone .setText(data.get(position).getClientInfo().getMobile_tele());

        String sex="未填";
        if(data.get(position).getClientInfo().getSex()==0) sex = "未填";
        else if (data.get(position).getClientInfo().getSex()==1) sex = "男";
        else sex = "女";
        holder. mTv_client_sex .setText(sex);

        holder.mTv_client_project.setText(data.get(position).getRy_project_name());
        holder.mTv_client_salesman.setText(data.get(position).getRy_salesman());
        holder.mTv_client_follow_stage.setText(data.get(position).getRy_follow_stage());
        if (data.get(position).getListTrack().size()>=1||data.get(position).getListTrack()==null) {
            if(data.get(position).getListTrack().get(0).getContact_time()!=null&&!data.get(position).getListTrack().get(0).getContact_time().equals("")){
                holder.mTv_client_last_contact.setText(TimeUtils.getStrTime(data.get(position).getListTrack().get(0).getContact_time(),true));//最后联系时间
                    LogUtils.i("最后联系时间"+TimeUtils.getStrTime(data.get(position).getListTrack().get(0).getContact_time(),true));
            }
        }else{
            holder.mTv_client_last_contact.setText("");//最后联系时间

        }
        holder.mTv_client_ry_group.setText(data.get(position).getRy_group());
        setLisenter(holder);
        return convertView;
    }

    private void setLisenter(final ViewHolder holder) {
    }

    public interface DeleteClientInfoListenter{
        void deletClient(String client_id);
   }

    public interface AssignClientInfoListenter{
        void assignClient(String client_id);
    }
    //ViewHolder静态类
    static class ViewHolder
    {
        private TextView mTv_client_name;
        private TextView mTv_client_phone;
        private TextView mTv_client_sex;
        private TextView mTv_client_project;
        private TextView mTv_client_salesman;
        private TextView mTv_client_follow_stage;
        private TextView mTv_client_last_contact;
        private TextView mTv_client_ry_group;

}
//    private Context context = null;
//    private List<ClientData> data;
//    private LayoutInflater inflater;
//    private ListView clueList;
//
//    private int[] positionArr;
//
//    public ClientInfoAdapter() {
//    }
//
//    public ClientInfoAdapter(Context context, List<ClientData> data, ListView clientDataList) {
//        this.context = context;
//        this.data = data;
//        this.clueList = clueList;
//        this.inflater = LayoutInflater.from(context);
//        positionArr = new int[data.size()];
//    }
//
//    @Override
//    public int getCount() {
//        return data.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return data.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder holder = null;
//        if (view == null) {
//            view = View.inflate(context, R.layout.item_client_info_list, null);
////            holderList = new ArrayList<>();
//            holder = new ViewHolder(view);
////            holderList.add(holder);
//            view.setTag(holder);
//        } else {
//            holder = (ViewHolder) view.getTag();
//        }
//        // 从传入的数据中提取数据并绑定到指定的view中
//        holder. mTv_client_name .setText(data.get(i).getClientInfo().getClient_name());
//        holder. mTv_client_phone .setText(data.get(i).getClientInfo().getMobile_tele());
//
//        String sex="未填";
//        if(data.get(i).getClientInfo().getSex()==0) sex = "未填";
//        else if (data.get(i).getClientInfo().getSex()==1) sex = "男";
//        else sex = "女";
//        holder. mTv_client_sex .setText(sex);
//
//        holder.mTv_client_project.setText(data.get(i).getRy_project_name());
//        holder.mTv_client_salesman.setText(data.get(i).getRy_salesman());
//        holder.mTv_client_follow_stage.setText(data.get(i).getRy_follow_stage());
//        if (data.get(i).getListTrack().size()>=1||data.get(i).getListTrack()==null) {
//
//            LogUtils.i("第一列当前是"+data.get(i).getClientInfo().getClient_name()+"第"+i+"项时间"+data.get(i).getListTrack().get(0).getContact_time());//最后联系时间
//            LogUtils.i("当前是"+data.get(i).getClientInfo().getClient_name()+"第"+i+"项时间"+data.get(i).getListTrack().get(0).getContact_time());
//
//        }
//        LogUtils.i("当前是"+data.get(i).getClientInfo().getClient_name()+"第"+i+"项");
//        holder.mTv_client_ry_group.setText(data.get(i).getRy_group());
//
//        //删除按钮
//        holder.mBtn_clirnt_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
//                LogUtils.v("= = =");
//                CustomAlertDialog customAlertDialog = new CustomAlertDialog(context, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if(i == -1){
//                            //确定
//                            Toast.makeText(context, "确认删除" + i, Toast.LENGTH_SHORT).show();
//                        }
//                        if(i == -2){
//                            //取消
//                            Toast.makeText(context, "取消删除" + i, Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        });
//
//        //编辑按钮
//        holder.mBtn_client_assign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        return view;
//    }
//
//    static class ViewHolder {
//        private TextView mTv_client_name;
//        private TextView mTv_client_phone;
//        private TextView mTv_client_sex;
//        private TextView mTv_client_project;
//        private TextView mTv_client_salesman;
//        private TextView mTv_client_follow_stage;
//        private TextView mTv_client_last_contact;
//        private TextView mTv_client_ry_group;
//        private Button mBtn_client_assign;
//        private Button mBtn_clirnt_delete;
//
//        // End Of Content View Elements
//
//        private void bindViews() {
//
//
//        }
//
//        ViewHolder(View view) {
//            mTv_client_name = view.findViewById(R.id.tv_client_name);
//            mTv_client_phone = view. findViewById(R.id.tv_client_phone);
//            mTv_client_sex = view.findViewById(R.id.tv_client_sex);
//            mTv_client_project = view. findViewById(R.id.tv_client_project);
//            mTv_client_salesman =view. findViewById(R.id.tv_client_salesman);
//            mTv_client_follow_stage = view. findViewById(R.id.tv_client_follow_stage);
//            mTv_client_last_contact = view.findViewById(R.id.tv_client_last_contact);
//            mTv_client_ry_group = view.findViewById(R.id.tv_client_ry_group);
//            mBtn_client_assign =view. findViewById(R.id.btn_client_assign);
//            mBtn_clirnt_delete =view. findViewById(R.id.btn_clirnt_delete);
//        }
//    }

}
