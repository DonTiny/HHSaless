package com.hhsales.zzxinteyu.hhsales.my.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lib_common.base.BaseFragment;
import com.example.lib_common.utils.GlideUtils;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.ViewManager;
import com.example.lib_common.utils.okhttpUtils.DownloadListener;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.login.ui.LoginActivity;
import com.hhsales.zzxinteyu.hhsales.main.MainActivity;
import com.hhsales.zzxinteyu.hhsales.my.presenter.MyFragmentPresenter;
import com.hhsales.zzxinteyu.hhsales.my.ui.MyTaskActivity;
import com.hhsales.zzxinteyu.hhsales.my.ui.MyUserInfoActivity;
import com.hhsales.zzxinteyu.hhsales.utlis.PermissionUtils;
import com.hhsales.zzxinteyu.hhsales.view.MyItemView;
import com.hhsales.zzxinteyu.hhsales.view.MySuperDialog;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Created by Huairen on 2018/6/19.
 */

public class MyFragment extends BaseFragment<IMyFragmentView,MyFragmentPresenter> implements IMyFragmentView, View.OnClickListener {
    private ProgressDialog progressDialog;
    private RelativeLayout rl_my;
    private ImageView h_back,h_head;
    private TextView tv_user_role,tv_user_name;
    private MyItemView mtvMyTask,mtvUserInfo,mtvLogOut,detectionUpdate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_my, container, false);
        initView(view);
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        mtvMyTask.setOnClickListener(this);
        mtvUserInfo.setOnClickListener(this);
        mtvLogOut.setOnClickListener(this);
        detectionUpdate.setOnClickListener(this);

    }

    private void initData() {
        presenter.findMyUserInfo();
    }

    private void initView(View view) {
        rl_my = view.findViewById(R.id.rl_my);
        h_back = view.findViewById(R.id.h_back);
        h_head = view.findViewById(R.id.h_head);
        tv_user_name = view.findViewById(R.id.user_name);
        tv_user_role = view.findViewById(R.id.user_role);
        mtvMyTask = view.findViewById(R.id.mtv_my_task);
        mtvUserInfo = view.findViewById(R.id.mtv_user_info);
        mtvLogOut = view.findViewById(R.id.mtv_log_out);
        detectionUpdate = view.findViewById(R.id.detection_update);
        setImmerseLayout(rl_my,getActivity());
        GlideUtils.loadImageBlurTransformation(getActivity(),R.drawable.morentouxiang,h_back);
        GlideUtils.loadImageCropCircleTransformation(getActivity(),R.drawable.morentouxiang,h_head);
    }


    @Override
    protected MyFragmentPresenter createPresenter() {
        return new MyFragmentPresenter();
    }

    @Override
    public void setUserName(String name) {
        tv_user_name.setText(name);
    }

    @Override
    public void setUserRole(String role) {
        tv_user_role.setText(role);
    }

    @Override
    public void showError() {
        showToast(getActivity(),"请检查网络连接");
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mtv_my_task:
                Intent myTaskIntent = new Intent(getActivity(), MyTaskActivity.class);
                startActivity(myTaskIntent);
                break;
            case R.id.mtv_user_info:
                Intent myInfoIntent = new Intent(getActivity(), MyUserInfoActivity.class);
                startActivity(myInfoIntent);
                break;

            case R.id.mtv_log_out:

                MySuperDialog.showSuperDialog(getActivity(), "退出登录", "确定要退出登录么？", new MySuperDialog.ResultDialog() {
                    @Override
                    public void positivOnClick(View view) {
                        ViewManager.getInstance().exitApp(getActivity());
                    }

                    @Override
                    public void negativeOnClick(View view) {

                    }

                });
                break;

            case R.id.detection_update:
                if (PermissionUtils.isGrantExternalRW(getActivity(), 1)) {
                    presenter.getVersion();
                    break;
                }}
    }

    private void startUpload(String url) {
        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("正在下载新版本");
        progressDialog.setCancelable(false);//不能手动取消下载进度对话框
        //登陆
        LogUtils.i("更新地址"+url);
        url = "http://192.168.26.200:8080/hhsales/files/temp/app-debug.apk";
        final DownloadListener downloadListener=new DownloadListener() {
            @Override
            public void start(long max) {
                LogUtils.i("开始下载"+max);
                progressDialog.setMax((int)max/1024);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.show();
                    }
                });

            }

            @Override
            public void loading(final int progress) {
                LogUtils.i("正在下载"+progress);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.setProgress((int)progress);
                    }
                });
            }

            @Override
            public void complete(final String path) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                        LogUtils.i("下载完成，文件路径"+path);
//                        Intent intent = new Intent();
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        intent.setAction(Intent.ACTION_VIEW);
//                        intent.setDataAndType(Uri.parse("file://"+path),"application/vnd.android.package-archive");
//                        startActivity(intent);
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        //版本在7.0以上是不能直接通过uri访问的
                        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                            LogUtils.i("版本超过7.0");
                            File file = (new File(path));
                            if (file.exists()){
                                LogUtils.i("文件存在");
                            }
                            // 由于没有在Activity环境下启动Activity,设置下面的标签
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
                            Uri apkUri = FileProvider.getUriForFile(getContext(), "com.example.chenfengyao.installapkdemo", file);
                            //添加这一句表示对目标应用临时授权该Uri所代表的文件
                            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
                        } else {
                            intent.setDataAndType(Uri.fromFile(new File(path)),
                                    "application/vnd.android.package-archive");
                        }
                       getActivity(). startActivity(intent);
                    }
                });
            }

            @Override
            public void fail(int code, String message) {

            }

            @Override
            public void loadfail(String message) {

            }
        };

        Callback callback=new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                long length = response.body().contentLength();
                LogUtils.i("报文长度");
                if (length == 0){
                    // 说明文件已经下载完，直接跳转安装就好
                    downloadListener.complete(String.valueOf(getFile().getAbsoluteFile()));
                    return;
                }
                downloadListener.start(length+0);
                // 保存文件到本地
                InputStream is = null;
                RandomAccessFile randomAccessFile = null;
                BufferedInputStream bis = null;

                byte[] buff = new byte[2048];
                int len = 0;
                try {
                    is = response.body().byteStream();
                    bis  =new BufferedInputStream(is);

                    File file = getFile();
                    // 随机访问文件，可以指定断点续传的起始位置
                    randomAccessFile =  new RandomAccessFile(file, "rwd");
                    randomAccessFile.seek (0);
                    while ((len = bis.read(buff)) != -1) {
                        randomAccessFile.write(buff, 0, len);
                    }

                    // 下载完成
                    downloadListener.complete(String.valueOf(file.getAbsoluteFile()));
                } catch (Exception e) {
                    e.printStackTrace();
                    downloadListener.loadfail(e.getMessage());
                } finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                        if (bis != null){
                            bis.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        OkHttpClientManager._downloadMultiFile(url, downloadListener, 0,callback);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //检验是否获取权限，如果获取权限，外部存储会处于开放状态，会弹出一个toast提示获得授权
                    String sdCard = Environment.getExternalStorageState();
                    if (sdCard.equals(Environment.MEDIA_MOUNTED)){
                        Toast.makeText(getActivity(),"获得授权",Toast.LENGTH_LONG).show();
                    }
                } else {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "buxing", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    private File getFile() {
        String root = Environment.getExternalStorageDirectory().getPath();
        File file = new File(root,"updateDemo.apk");
        return file;
    }

    private long getFileStart(){
        String root = Environment.getExternalStorageDirectory().getPath();
        File file = new File(root,"updateDemo.apk");
        return file.length();
    }

    //获取当前版本号
    @Override
    public int getVersionCode() {
        // 获取packagemanager的实例
        int version = 0;
        try {
            PackageManager packageManager = this.getContext().getPackageManager();
            //getPackageName()是你当前程序的包名
            PackageInfo packInfo = packageManager.getPackageInfo(this.getContext().getPackageName(), 0);
            version = packInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;
    }

    @Override
    public void startpdateU(final String url) {
     getActivity().runOnUiThread(new Runnable() {
         @Override
         public void run() {
             // 这里的属性可以一直设置，因为每次设置后返回的是一个builder对象
             AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
             // 设置提示框的标题
             builder.setTitle("版本升级").
                     setIcon(R.mipmap.ic_launcher). // 设置提示框的图标
                     setMessage("发现新版本！请及时更新").// 设置要显示的信息
                     setPositiveButton("确定", new DialogInterface.OnClickListener() {// 设置确定按钮
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     startUpload(url);//下载最新的版本程序
                 }
             }).setNegativeButton("取消", null);//设置取消按钮,null是什么都不做，并关闭对话框
             AlertDialog alertDialog = builder.create();
             // 显示对话框
             alertDialog.show();
         }
     });

    }

    @Override
    public void noUpdate() {
         getActivity().runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 showToast(getActivity(),"已经是最新的版本了");
             }
         });
    }

    @Override
    public void getVersionError() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToast(getActivity(),"请检查网络连接");
            }
        });
    }
}

