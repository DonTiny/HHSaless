package com.hhsales.zzxinteyu.hhsales.client.activity;

import com.hhsales.zzxinteyu.hhsales.client.bean.Purchase;

/**
 * Created by Administrator on 2018/7/4.
 */

public interface IPurchaseView {
   void setPurchaseData(Purchase purchase);
   void showError();
   void showLoading();
   void showSuccess();
   void showEmpty();
}
