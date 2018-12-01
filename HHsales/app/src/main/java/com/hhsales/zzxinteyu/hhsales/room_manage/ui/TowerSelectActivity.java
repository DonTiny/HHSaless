package com.hhsales.zzxinteyu.hhsales.room_manage.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.room_manage.adapter.SimpleTreeListViewAdapter;
import com.hhsales.zzxinteyu.hhsales.room_manage.adapter.TreeListViewAdapter;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.Building;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.FileBean;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.OrgBean;
import com.hhsales.zzxinteyu.hhsales.room_manage.presenter.TowerSelectPresenter;
import com.hhsales.zzxinteyu.hhsales.room_manage.utlis.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TowerSelectActivity extends BaseActivity<ITowerSelectView,TowerSelectPresenter> implements ITowerSelectView, View.OnClickListener {
    private RelativeLayout mToolbar;
    private ImageView ivReturn;

    private ListView mTree;
    private SimpleTreeListViewAdapter<OrgBean> mAdapter;
    private List<FileBean> mDatas;
    private List<OrgBean> mDatas2;
    private ProItemName proItemName;

    @Override
    protected TowerSelectPresenter createPresenter() {
        return new TowerSelectPresenter();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_tower_select);
        mTree = (ListView) findViewById(R.id.id_listview);
        mToolbar = (RelativeLayout) findViewById(R.id.toolbar);
        ivReturn = findViewById(R.id.iv_return);
        setImmerseLayout(mToolbar);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        presenter.getProItemName();
       // initDatas();

    }

    @Override
    protected void initListener() {
        ivReturn.setOnClickListener(this);
    }


    private void initEvent()
    {
        mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener()
        {
            @Override
            public void onClick(Node node, int position)
            {
                if (node.isLeaf())
                {
                    if(node.getType()==1){
                        Intent intent=new Intent();
                        intent.putExtra("building_id", node.getBuilding_id());
                        intent.putExtra("building_name", node.getName());

                        for (int i=0;i<proItemName.getData().size();i++){
                            if(proItemName.getData().get(i).getId()==node.getpId()){
                                intent.putExtra("project_name", proItemName.getData().get(i).getItem_name());
                                LogUtils.i("当前楼栋所属项目"+proItemName.getData().get(i).getItem_name());
                            }
                        }
                        setResult(1, intent);
                        setResult(3, intent);
                        finish();

                    }else {
                        Toast.makeText(TowerSelectActivity.this, "该项目暂无楼栋",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

//        mTree.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
//        {
//
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view,
//                                           final int position, long id)
//            {
//                // DialogFragment
//                final EditText et = new EditText(TowerSelectActivity.this);
//                new AlertDialog.Builder(TowerSelectActivity.this).setTitle("Add Node")
//                        .setView(et)
//                        .setPositiveButton("Sure", new DialogInterface.OnClickListener()
//                        {
//                            @Override
//                            public void onClick(DialogInterface dialog,
//                                                int which)
//                            {
//
//                                if (TextUtils.isEmpty(et.getText().toString()))
//                                    return;
//                                mAdapter.addExtraNode(position, et.getText()
//                                        .toString());
//                            }
//                        }).setNegativeButton("Cancel", null).show();
//
//                return true;
//            }
//        });
    }

    private void initDatas()
    {
        mDatas = new ArrayList<FileBean>();
        FileBean bean = new FileBean(1, 0, "根目录1");
        mDatas.add(bean);
        bean = new FileBean(2, 0, "根目录2");
        mDatas.add(bean);
        bean = new FileBean(3, 0, "根目录3");
        mDatas.add(bean);
        bean = new FileBean(4, 1, "根目录1-1");
        mDatas.add(bean);
        bean = new FileBean(5, 1, "根目录1-2");
        mDatas.add(bean);
        bean = new FileBean(6, 5, "根目录1-2-1");
        mDatas.add(bean);
        bean = new FileBean(7, 3, "根目录3-1");
        mDatas.add(bean);
        bean = new FileBean(8, 3, "根目录3-2");
        mDatas.add(bean);


    }

    @Override
    public void initNode(ProItemName proItemName) {

        this.proItemName = proItemName;


    }

    @Override
    public void initBuiding(Map<String, List<Building>> listMap) {
        LogUtils.i("当前项目名称"+GsonUtil.GsonString(proItemName));
        // initDatas
        mDatas2 = new ArrayList<OrgBean>();
        OrgBean bean2;
        for (int i=0;i<proItemName.getData().size();i++){

            proItemName.getData().get(i).setId(i+1);
            if(proItemName.getData().get(i).getFk_parent_item()==null||proItemName.getData().get(i).getFk_parent_item().equals("")){
                proItemName.getData().get(i).setParent_id(0);
            }

        }
        LogUtils.i("当前项目名称"+GsonUtil.GsonString(proItemName));

        for (int i=0;i<proItemName.getData().size();i++){
            if(null==proItemName.getData().get(i).getFk_parent_item()||proItemName.getData().get(i).getFk_parent_item().equals("")){
                bean2 = new OrgBean(proItemName.getData().get(i).getId(), 0, proItemName.getData().get(i).getItem_name(),proItemName.getData().get(i).getProject_id());
                mDatas2.add(bean2);

            }else {
                for (int j=0;j<proItemName.getData().size();j++){
                    if(proItemName.getData().get(i).getFk_parent_item().equals(proItemName.getData().get(j).getProject_id())){
                        bean2 = new OrgBean(proItemName.getData().get(i).getId(), proItemName.getData().get(j).getId(), proItemName.getData().get(i).getItem_name(),proItemName.getData().get(i).getProject_id());
                        mDatas2.add(bean2);

                    }

                }
            }


        }



        for (String key : listMap.keySet()) {
           for ( int i=0 ;i<proItemName.getData().size();i++){
               if(key.equals(proItemName.getData().get(i).getProject_id())){
                   for (int j=0;j<listMap.get(key).size();j++){
                       bean2 = new OrgBean(Integer.parseInt(listMap.get(key).get(j).getCode()), proItemName.getData().get(i).getId(), listMap.get(key).get(j).getName(),listMap.get(key).get(j).getBuilding_id(),1);
                       mDatas2.add(bean2);
                   }
//                   bean2 = new OrgBean(listMap.get(key).get(), proItemName.getData().get(i).getId(), proItemName.getData().get(i).getItem_name());

               }
           }
        }


        LogUtils.i("当前节点数据"+GsonUtil.GsonString(mDatas2));
        try
        {
            mAdapter = new SimpleTreeListViewAdapter<OrgBean>(mTree, this,
                    mDatas2, 0);
            mTree.setAdapter(mAdapter);
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        initEvent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_return:
                finish();
                break;
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();    }
}
