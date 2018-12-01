package com.hhsales.zzxinteyu.hhsales.my.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.lib_common.base.BaseActivity;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.bean.userinfo.UserInfo;
import com.hhsales.zzxinteyu.hhsales.my.presenter.MyUserInfoPresenter;
import com.hhsales.zzxinteyu.hhsales.utlis.UserDictionary;

public class MyUserInfoActivity extends BaseActivity<IMyUserInfoView,MyUserInfoPresenter> implements IMyUserInfoView, View.OnClickListener {

    private RelativeLayout rlUserInfTop;
    private ImageView ivReturn;
    private TextView tv_user_info_username;
    private TextView tv_user_info_department;
    private TextView tv_user_info_role;
    private EditText et_user_info_name;
    private EditText et_user_info_tel;
    private EditText et_user_info_email;
    private TextView tv_user_info_entry_time;
    private TextView tv_user_info_birthday;
    private TextView tv_user_info_schooling;
    private TextView tv_user_info_sex;
    private EditText et_user_info_Id_card;
    private EditText et_user_info_office_tel;
    private EditText et_user_info_position;
    private EditText et_user_info_address;
    @Override
    protected MyUserInfoPresenter createPresenter() {
        return new MyUserInfoPresenter();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_my_user_info);
        rlUserInfTop=findViewById(R.id.rl_user_info_top);
        ivReturn = findViewById(R.id.iv_return);
        setImmerseLayout(rlUserInfTop);
        tv_user_info_username = (TextView) findViewById(R.id.tv_user_info_username);
        tv_user_info_department = (TextView) findViewById(R.id.tv_user_info_department);
        tv_user_info_role = (TextView) findViewById(R.id.tv_user_info_role);
        et_user_info_name = (EditText) findViewById(R.id.et_user_info_name);
        et_user_info_tel = (EditText) findViewById(R.id.et_user_info_tel);
        et_user_info_email = (EditText) findViewById(R.id.et_user_info_email);
        tv_user_info_entry_time = (TextView) findViewById(R.id.tv_user_info_entry_time);
        tv_user_info_birthday = (TextView) findViewById(R.id.tv_user_info_birthday);
        tv_user_info_schooling = (TextView) findViewById(R.id.tv_user_info_schooling);
        tv_user_info_sex = (TextView) findViewById(R.id.tv_user_info_sex);
        et_user_info_Id_card = (EditText) findViewById(R.id.et_user_info_Id_card);
        et_user_info_office_tel = (EditText) findViewById(R.id.et_user_info_office_tel);
        et_user_info_position = (EditText) findViewById(R.id.et_user_info_position);
        et_user_info_address = (EditText) findViewById(R.id.et_user_info_address);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
      presenter.findMyUserInfo();

    }

    @Override
    protected void initListener() {
        ivReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_return:
                finish();
                break;
        }
    }

    @Override
    public void setViewData(UserInfo userInfo) {
        tv_user_info_username.setText(userInfo.getData().get(0).getUser_name());

        if(userInfo.getData().get(0).getListDept()!=null&&userInfo.getData().get(0).getListDept().size()>0){
            tv_user_info_department.setText(userInfo.getData().get(0).getListDept().get(0).getName());
        }
        if(userInfo.getData().get(0).getListStaff()!=null&&userInfo.getData().get(0).getListStaff().size()>0){
            et_user_info_tel .setText(userInfo.getData().get(0).getListStaff().get(0).getPhone());
            et_user_info_email .setText(userInfo.getData().get(0).getListStaff().get(0).getEmail());
            tv_user_info_entry_time .setText(userInfo.getData().get(0).getListStaff().get(0).getHiredate());
            tv_user_info_birthday .setText(userInfo.getData().get(0).getListStaff().get(0).getBirthday());
            tv_user_info_schooling .setText(userInfo.getData().get(0).getListStaff().get(0).getFk_degree());
            tv_user_info_sex .setText(UserDictionary.sex[userInfo.getData().get(0).getListStaff().get(0).getSex()]);
            et_user_info_Id_card .setText(userInfo.getData().get(0).getListStaff().get(0).getIdcard());
            et_user_info_office_tel.setText(userInfo.getData().get(0).getListStaff().get(0).getOfficetb());
            et_user_info_position .setText(userInfo.getData().get(0).getListStaff().get(0).getDutie());
            et_user_info_address .setText(userInfo.getData().get(0).getListStaff().get(0).getAddress());
        }
        if(userInfo.getData().get(0).getListRole()!=null&&userInfo.getData().get(0).getListRole().size()>0){
            tv_user_info_role.setText(userInfo.getData().get(0).getListRole().get(0).getName());
        }


        et_user_info_name .setText(userInfo.getData().get(0).getSysUser().getUser_name());

    }

    @Override
    public void showError() {
        showToast("请检查网络连接");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showEmpty() {

    }
}
