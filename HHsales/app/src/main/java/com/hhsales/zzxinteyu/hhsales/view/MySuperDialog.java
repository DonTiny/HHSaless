package com.hhsales.zzxinteyu.hhsales.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.mylhyl.superdialog.SuperDialog;

/**
 * Created by Administrator on 2018/11/6.
 */

public class MySuperDialog {

  public static void  showSuperDialog(Activity context, String title, String text, final ResultDialog resultDialog){
      new SuperDialog.Builder((FragmentActivity) context).setRadius(10)
              .setAlpha(1.0f)
              .setWidth(0.8f)
              .setTitle(title).setMessage(text)
              .setNegativeButton("取消", new SuperDialog.OnClickNegativeListener() {
                  @Override
                  public void onClick(View v) {
                      resultDialog.negativeOnClick(v);
                  }
              })
              .setPositiveButton("确定", new SuperDialog.OnClickPositiveListener() {
                  @Override
                  public void onClick(View v) {
                      resultDialog.positivOnClick(v);
                  }
              }).build();

  }
  public interface ResultDialog{
     void positivOnClick(View view);
      void negativeOnClick(View view);

  }
}
