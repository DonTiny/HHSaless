package com.hhsales.zzxinteyu.hhsales.client.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.TimeUtils;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.adapter.InteractionAdapter;
import com.hhsales.zzxinteyu.hhsales.client.bean.Transaction;
import com.hhsales.zzxinteyu.hhsales.client.bean.TransactionData;
import com.hhsales.zzxinteyu.hhsales.client.presenter.InteractionPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class InteractionActivity extends BaseActivity<IInteractionView, InteractionPresenter> implements IInteractionView, View.OnClickListener {
    private ImageView mIv_return;
    private TextView mTv_client_name;
    private TextView mTv_client_info_delet;
    private TextView mTv_esteyrday_num;
    private ListView mLv_esteyrday;
    private TextView mTv_earlier_num;
    private ListView mLv_earlier;
    private InteractionAdapter interactionAdapter;
    private String client_id;
    private TextView mTv_today_num;
    private ListView mLv_today;
    private RelativeLayout mRl_today;
    private RelativeLayout mRl_esteyrday;
    private RelativeLayout mRl_earlier;
    private RelativeLayout interactionTop;
    private ImageView mIv_add_interaction;

    @Override
    protected InteractionPresenter createPresenter() {
        return new InteractionPresenter();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_interaction);
        interactionTop= findViewById(R.id.rl_interaction_top);
        setImmerseLayout(interactionTop);
        mIv_return = (ImageView) findViewById(R.id.iv_return);
        mTv_client_name = (TextView) findViewById(R.id.tv_client_name);
        mTv_client_info_delet = (TextView) findViewById(R.id.tv_client_info_delet);
        mTv_esteyrday_num = (TextView) findViewById(R.id.tv_esteyrday_num);
        mLv_esteyrday = (ListView) findViewById(R.id.lv_esteyrday);
        mTv_earlier_num = (TextView) findViewById(R.id.tv_earlier_num);
        mLv_earlier = (ListView) findViewById(R.id.lv_earlier);
        mTv_today_num = (TextView) findViewById(R.id.tv_today_num);
        mLv_today = findViewById(R.id.lv_today);
        mRl_today = findViewById(R.id.rl_today);
        mRl_earlier = findViewById(R.id.rl_earlier);
        mRl_esteyrday = findViewById(R.id.rl_esteyrday);
        mIv_add_interaction = findViewById(R.id.iv_add_interaction);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (getIntent() != null && getIntent().getStringExtra("client_id") != null) {
            client_id = getIntent().getStringExtra("client_id");
            showLoading();
            getInteraction(client_id);
        }
    }

    @Override
    protected void initListener() {
        mIv_return.setOnClickListener(this);
        mRl_esteyrday.setOnClickListener(this);
        mRl_earlier.setOnClickListener(this);
        mRl_today.setOnClickListener(this);
        mIv_add_interaction.setOnClickListener(this);

    }


    @Override
    public void showError() {

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
    public void getInteraction(String client_id) {
        presenter.findClinetTrackByClientId(client_id);
    }

    @Override
    public void setInteraction(Transaction transaction) {
        List<TransactionData> transactionData = transaction.getData();
        List<TransactionData> esteyrdayData = new ArrayList<>();//昨天
        List<TransactionData> earlierData = new ArrayList<>();//更早
        List<TransactionData> todayData = new ArrayList<>();//今天

        if (transactionData.size() > 0) {
            for (int i = 0; i < transactionData.size(); i++) {
                try {
                    if (IsYesterday(transactionData.get(i).getContact_time())) {
                        esteyrdayData.add(transactionData.get(i));

                    } else if (IsToday(transactionData.get(i).getContact_time())) {
                        todayData.add(transactionData.get(i));


                    } else {
                        earlierData.add(transactionData.get(i));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        interactionAdapter = new InteractionAdapter(this, earlierData);
        mLv_earlier.setAdapter(interactionAdapter);
        mTv_earlier_num.setText("(" + earlierData.size() + ")");
        interactionAdapter = new InteractionAdapter(this, esteyrdayData);
        mLv_esteyrday.setAdapter(interactionAdapter);
        mTv_esteyrday_num.setText("(" + esteyrdayData.size() + ")");
        interactionAdapter = new InteractionAdapter(this, todayData);
        mLv_today.setAdapter(interactionAdapter);
        mTv_today_num.setText("(" + todayData.size() + ")");


    }

    /**
     * 判断是否为今天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true今天 false不是
     * @throws ParseException
     */
    public static boolean IsToday(String day) throws ParseException {
        day = TimeUtils.getstrTime(day, true);
        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);
        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);
        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);

            if (diffDay == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为昨天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true今天 false不是
     * @throws ParseException
     */
    public static boolean IsYesterday(String day) throws ParseException {
        day = TimeUtils.getstrTime(day, true);
        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);

        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);

            if (diffDay == -1) {
                return true;
            }
        }
        return false;
    }

    public static SimpleDateFormat getDateFormat() {
        if (null == DateLocal.get()) {
            DateLocal.set(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA));
        }
        return DateLocal.get();
    }

    private static ThreadLocal<SimpleDateFormat> DateLocal = new ThreadLocal<SimpleDateFormat>();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_return:
                finish();
                break;
            case R.id.rl_today:
                if (mLv_today.getVisibility() == View.GONE) {
                    mLv_today.setVisibility(View.VISIBLE);

                } else {
                    mLv_today.setVisibility(View.GONE);

                }
                break;
            case R.id.rl_esteyrday:
                if (mLv_esteyrday.getVisibility() == View.GONE) {
                    mLv_esteyrday.setVisibility(View.VISIBLE);

                }else {
                    mLv_esteyrday.setVisibility(View.GONE);

                }
                break;
            case R.id.rl_earlier:
                if (mLv_earlier.getVisibility() == View.GONE) {
                    mLv_earlier.setVisibility(View.VISIBLE);

                }else {
                    mLv_earlier.setVisibility(View.GONE);
                }
                break;
            case R.id.iv_add_interaction:
                Intent intent = new Intent(InteractionActivity.this, AddInteractionActivity.class);
                intent.putExtra("client_id", client_id);
                startActivityForResult(intent,0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==0&&data.getIntExtra("results",1)==0){
            initData(null);
            showToast("保存成功！");
        }
    }
}
