package com.hhsales.zzxinteyu.hhsales.login.ui;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.bean.user.UserBean;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.LoginUtils;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.login.presenter.LoginPresenter;
import com.hhsales.zzxinteyu.hhsales.main.MainActivity;
import com.hhsales.zzxinteyu.hhsales.room_manage.presenter.RoomQueryPresenter;
import com.joker.annotation.PermissionsCustomRationale;
import com.joker.annotation.PermissionsDenied;
import com.joker.annotation.PermissionsGranted;
import com.joker.api.Permissions4M;
import com.taobao.sophix.SophixManager;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity<ILoginView,LoginPresenter<ILoginView>> implements ILoginView, View.OnClickListener {
    private String name;
    private String password;
    private Button btnLogin;
    private EditText etName;
    private EditText etPassword;
    private LinearLayout ll_login;
    private SharedPreferences sp;
    private CheckBox mCb_save_password;
    private CheckBox mCb_automatic_landing;
    private void setListenter() {
        btnLogin.setOnClickListener(this);
    }


    @Override
    protected LoginPresenter<ILoginView> createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);
        ll_login = findViewById(R.id.ll_login);
        btnLogin = findViewById(R.id.btn_login);
        etName = findViewById(R.id.et_login_username);
        etPassword = findViewById(R.id.et_login_password);
        mCb_save_password = findViewById(R.id.cb_save_password);
        mCb_automatic_landing = findViewById(R.id.cb_automatic_landing);
        setListenter();

        Window window = getWindow();
        //隐藏状态栏
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
       // setImmerseLayout(ll_login);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        Permissions4M.onRequestPermissionsResult(LoginActivity.this, requestCode, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    @Override
    protected void initData(Bundle savedInstanceState) {


        SophixManager.getInstance().queryAndLoadNewPatch();

        sp = getSharedPreferences("user", Context.MODE_PRIVATE);
        if(getIntent()!=null){
            if(getIntent().getStringExtra("loginOut")!=null&&getIntent().getStringExtra("loginOut").equals("注销")){
                mCb_automatic_landing.setChecked(false);
                //获取到edit对象
                SharedPreferences.Editor edit = sp.edit();
                //通过editor对象写入数据
                edit.putString("isSavePassword","false");
                edit.putString("userName","");
                edit.putString("password","");
                edit.putString("isAutomaticLanding","false");
                edit.commit();

            }
        }
        if(sp!=null){
            if(sp.getString("isAutomaticLanding","null").equals("true")){
                showProgressBar(this);

                LogUtils.i("自动登录");
                mCb_save_password.setChecked(true);
                mCb_automatic_landing.setChecked(true);
                etName.setText(sp.getString("userName",""));
                etPassword.setText(sp.getString("password",""));
                showToast("准备自动登陆");
                presenter.fetch();

            }else if(sp.getString("isSavePassword","null").equals("true")){
                mCb_save_password.setChecked(true);
                etName.setText(sp.getString("userName",""));
                etPassword.setText(sp.getString("password",""));
            }
        }


    }

    @Override
    protected void initListener() {
        mCb_save_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCb_automatic_landing.isChecked()){
                    mCb_save_password.setChecked(true);
                }
            }
        });
        mCb_automatic_landing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCb_automatic_landing.isChecked()){
                    mCb_save_password.setChecked(true);
                }else {
                    mCb_save_password.setChecked(false);

                }
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public Map<String, String> getUserNameOrPsw() {
        name = etName.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        Map<String, String> map = new HashMap<String, String>();
        map.get("sad");
        map.put("user_name", name);
        map.put("password_err", password);
        return map;
    }

    @Override
    public void startMeun(UserBean userBean) {
        LoginUtils.name=name;
        LoginUtils.password = password;
        dismissProgressBar();
        if(mCb_automatic_landing.isChecked()){
            SharedPreferences.Editor edit = sp.edit();
            //通过editor对象写入数据
            edit.putString("isAutomaticLanding","true");
            //提交数据存入到xml文件中
            edit.commit();
        }
        if( mCb_save_password.isChecked()){
            //获取到edit对象
            SharedPreferences.Editor edit = sp.edit();
            //通过editor对象写入数据
            edit.putString("isSavePassword","true");
            edit.putString("userName",etName.getText().toString().trim());
            edit.putString("password",etPassword.getText().toString().trim());

            //提交数据存入到xml文件中
            edit.commit();
        }else {
            //获取到edit对象
            SharedPreferences.Editor edit = sp.edit();
            //通过editor对象写入数据
            edit.putString("isSavePassword","false");
            edit.putString("userName",null);
            edit.putString("password",null);
            //提交数据存入到xml文件中
            edit.commit();
        }
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("user", userBean);
        startActivity(intent);
        finish();
    }

    @Override
    public void LoginNo() {
        dismissProgressBar();
        showToast("登陆失败");
    }


    @Override
    public void onClick(View view) {

        if(!etName.getText().toString().trim().equals("")&&!etPassword.getText().toString().trim().equals("")) {
            showProgressBar(this);

            presenter.fetch();
        }else {

            showToast("请输入用户名和密码");
        }

    }
}

