package com.hhsales.zzxinteyu.hhsales.application;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Keep;
import android.util.Log;

import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

/**
 * Created by Administrator on 2018/11/26.
 */

public class SophixStubApplication extends Application {
    private final String TAG = "SophixStubApplication";
    private final String ID_SECRET="25306013-1";
    private final String APP_SECRET="9ffa7c0aa95b9bb466f6f1f8228a77c0";
    private final String RSA_SECRET="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCN6WMgTHPDaOJPTTREkGigIVgFg1470jFNx50LM/yo072aKSTfezCa2zcg+7tg1HGf2dqCp2NjthnkmdnwS6FShhXpp3bkCp5zpGa3htV/tNT/DA8kKJFIDSSmbnR5G4G/61/hMMQCWnJqQeCCfifMjdYQHVc53A54ruwVQED2biDz78XsgpzB2GtG30LxkJxrcRgYtucv5hEAKFgV8NRtotgMSGHtVQbaS7YvwZk7CDnOEKIQyvXSE4PWU9xEqcO/Ngjg59djvpBYsWZ2idDbjSxNcgvYpBTIjO3wqbCITxGs+3HOINeGCOtNApYYJd2ZGaTdboU/GvtMVCVCRBoJAgMBAAECggEAWdqkwRanVdtbMAsaRS+Kj5mNOjBrwkTcovr5HNbV66/mJW5XwoklxWd4CJJbmnvpVeWCzade7wumaXBg5h19D9uGlGNMjCeNHHvD7gCZvjqpgrQIAkUNeCmaQyc86FHaXcKS+ur9sN/EAjOkC/wFByfnmlx5llEXeKKJKQt+FonDP4IvZ9VzAjwT+sHdPUNo31+UrdReX98j139aXG7bpSYXS+k26g8sQyrqJHhkLgri9dq2dMUeDWGq7tbGR2xHv0VXBVn5lVjEbUK7qmBpfLlENkbr3rVFcRRMnSFsLa39GuvO/eckGmOU2AwR1y0KiuqnmS1yM4S8coExmvlB4QKBgQDBFcf8TINnL016Yn/hDMc2itOeP1F5S/hdbTbYpde1T8MfApzwAQ82vOf9YdjFdu9JD7PTS0F6O9Th5mLsLFEkaCXn7yVf7Mhpg53pdyXHhgUz23cgci14tKa2zaR6MaDSKkB7hiGvl6dYvesHv5Tm0CiOr/sxMWszPRrRn66fHwKBgQC8Jvf4WdWvVMHI0t17duucpLJHRvS6UFNZHcHCyG8+ezEhNkhfsOlVZ+tdG60OKWC+mF/Kra1L5TaJWxQYhvt/CmJ2QtelaueUzjiYzUVpvY1+DLxGnxDENnxdbULY91CnylZqc0q0btoZnm9+Vc8wYakpgC+xOmh3Bk4tm0+p1wKBgBLdUOuqghAbxAMYCoxvVitTBvfoEcq7DGn8WKZ0FY4mW9b0x2Z/hAACFtxfqfEo/Jnzycr0CFKr89GaU8HlVowrDMELUWh81tvQOyZrOKq0wl9dqtblsOGhLMShdNdnb+H4tNIcub/RHk2CSKs6IY8neT7vnKgivumDp9IhOstbAoGBAIsAexfWPoC+rD+SUSBileRu5Gq2KBzxNPJUgo5Fh7HwTzaLJOLVDz0SfhaWWL5qoVeNuM9CihHU7/p/+BO6vVh4so9OCITjutz7kWKJ3CsnZ73k6L9/ymI7IpvfGZCy/bpISJlyPZGZh7V/kD0UZfIHZHMNia50STMNzHnzEOKXAoGACZM9DR4CAeyJfgGox3buaUnkOoFgcnWIG5Jf297jHK2CRLyi5z5QXAMyHjX/LcDohG6bzZkK+Qa20ISCKm7WA64nIfXhNG/jMgrHkt6nvxb3Y+bYCP0RmikNXJPa+SuR6kYbUPmklo/rnKkCRMVa5eQV2AxdNGpn1kf6dABTvDs=";

    // 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
    @Keep
    @SophixEntry(MyApplication.class)
    static class RealApplicationStub {}
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//         如果需要使用MultiDex，需要在此处调用。
//         MultiDex.install(this);
        initSophix();
    }
    private void initSophix() {
        String appVersion = "0.0.0";
        try {
            appVersion = this.getPackageManager()
                    .getPackageInfo(this.getPackageName(), 0)
                    .versionName;
        } catch (Exception e) {
        }
        final SophixManager instance = SophixManager.getInstance();
        instance.setContext(this)
                .setAppVersion(appVersion)
                .setSecretMetaData(ID_SECRET, APP_SECRET, RSA_SECRET)
                .setEnableDebug(true)
                .setEnableFullLog()
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            Log.i(TAG, "sophix load patch success!");
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 如果需要在后台重启，建议此处用SharePreference保存状态。
                            Log.i(TAG, "sophix preload patch success. restart app to make effect.");
                        }
                    }
                }).initialize();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // queryAndLoadNewPatch不可放在attachBaseContext 中，否则无网络权限，建议放在后面任意时刻，如onCreate中
        SophixManager.getInstance().queryAndLoadNewPatch();
    }
}
