package com.hhsales.zzxinteyu.hhsales.client.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.utils.CustomAlertDialog;
import com.example.lib_common.utils.CustomPopup;
import com.example.lib_common.utils.DatePickerFragment;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.TimeUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.view.EmptyLayout;
import com.hhsales.zzxinteyu.hhsales.R;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.bean.ProTeamByFKProject;
import com.hhsales.zzxinteyu.hhsales.client.presenter.ClientInfoPresenter;
import com.hhsales.zzxinteyu.hhsales.room_manage.presenter.RoomQueryPresenter;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientInfoDataDictionary;
import com.hhsales.zzxinteyu.hhsales.view.MySuperDialog;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Map;

public class ClientInfoActivity extends BaseActivity<IClientInfoView,ClientInfoPresenter> implements IClientInfoView, View.OnClickListener {
    private PageClientInfo<ClientData> pageClientInfo;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};
    private EditText mEt_update_client_name;
    private TextView mTv_update_client_type;
    private EditText mEt_update_client_nationality;
    private EditText mEt_update_client_native_place;
    private TextView mTv_update_client_care_type;
    private EditText mEt_update_client_card_number;
    private TextView mTv_update_client_birth_date;
    private TextView mTv_update_client_sex;
    private TextView mTv_update_client_marriage;
    private EditText mEt_update_client_work_units;
    private EditText mEt_update_client_professional;
    private EditText mEt_update_client_living_area;
    private EditText mEt_update_client_working_area;
    private TextView mTv_update_client_age_paragraph;
    private TextView mTv_update_client_comprehensive_salary;
    private TextView mTv_update_client_purchase_use;
    private TextView mTv_update_client_subordinate_project;
    private TextView mTv_update_client_salesman;
    private TextView mTv_update_client_group;
    private TextView mTv_update_client_follow_stage;
    private EditText mEt_update_client_mobile_phone;
    private EditText mEt_update_client_home_phone;
    private EditText mEt_update_client_office_phone;
    private EditText mEt_update_client_fax;
    private EditText mEt_update_client_communication_address;
    private EditText mEt_update_client_zip_code;
    private EditText mEt_update_client_business_license;
    private EditText mEt_update_client_legal_representative;
    private EditText mEt_update_client_contact;

    private EditText mEt_update_client_family_structure;
    private EditText mEt_update_client_guest_type;
    private EditText mEt_update_client_transportation;
    private EditText mEt_update_client_career_feature;
    private EditText mEt_update_client_dwell_info;
    private EditText mEt_update_client_congnitive_approach;
    private EditText mEt_update_client_buy_focus;
    private TextView mTv_update_client_isRelation;
    private LinearLayout mLl_update_client_isRelation;

    private ImageView mIv_update_client_type;
    private ImageView mIv_update_client_care_type;
    private ImageView mIv_update_client_sex;
    private ImageView mIv_update_client_marriage;
    private ImageView mIv_update_client_age_paragraph;
    private ImageView mIv_update_client_comprehensive_salary;
    private ImageView mIv_update_client_purchase_use;
    private ImageView mIv_update_client_group;
    private ImageView mIv_update_client_follow_stage;
    private ImageView mIv_update_client_subordinate_project;
    private ImageView mIv_update_client_salesman;
    private ImageView mIv_update_client_birth_date;
    private EmptyLayout elEmpty;
    private ScrollView scrollView;
    private Button btn_save_info;
    private ImageView ivReturn;
    private RelativeLayout rlClientInfoTop;
    private String client_id;
    private String type;
    @Override
    protected ClientInfoPresenter createPresenter() {
        return new ClientInfoPresenter();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_client_info);
        rlClientInfoTop = findViewById(R.id.rl_client_info_top);
        setImmerseLayout(rlClientInfoTop);
        mEt_update_client_name = findViewById(R.id.et_update_client_name);
        mTv_update_client_type =  findViewById(R.id.tv_update_client_type);
        mEt_update_client_nationality = (EditText) findViewById(R.id.et_update_client_nationality);
        mEt_update_client_native_place = (EditText) findViewById(R.id.et_update_client_native_place);
        mTv_update_client_care_type = (TextView) findViewById(R.id.tv_update_client_care_type);
        mEt_update_client_card_number = (EditText) findViewById(R.id.et_update_client_card_number);
        mTv_update_client_birth_date = (TextView) findViewById(R.id.tv_update_client_birth_date);
        mTv_update_client_sex = (TextView) findViewById(R.id.tv_update_client_sex);
        mTv_update_client_marriage = (TextView) findViewById(R.id.tv_update_client_marriage);
        mEt_update_client_work_units = (EditText) findViewById(R.id.et_update_client_work_units);
        mEt_update_client_professional = (EditText) findViewById(R.id.et_update_client_professional);
        mEt_update_client_living_area = (EditText) findViewById(R.id.et_update_client_living_area);
        mEt_update_client_working_area = (EditText) findViewById(R.id.et_update_client_working_area);
        mTv_update_client_age_paragraph = (TextView) findViewById(R.id.tv_update_client_age_paragraph);
        mTv_update_client_comprehensive_salary = (TextView) findViewById(R.id.tv_update_client_comprehensive_salary);
        mTv_update_client_purchase_use = (TextView) findViewById(R.id.tv_update_client_purchase_use);
        mTv_update_client_subordinate_project = (TextView) findViewById(R.id.tv_update_client_subordinate_project);
        mTv_update_client_salesman = (TextView) findViewById(R.id.tv_update_client_salesman);
        mTv_update_client_group = (TextView) findViewById(R.id.tv_update_client_group);
        mTv_update_client_follow_stage = (TextView) findViewById(R.id.tv_update_client_follow_stage);
        mEt_update_client_mobile_phone = (EditText) findViewById(R.id.et_update_client_mobile_phone);
        mEt_update_client_home_phone = (EditText) findViewById(R.id.et_update_client_home_phone);
        mEt_update_client_office_phone = (EditText) findViewById(R.id.et_update_client_office_phone);
        mEt_update_client_fax = (EditText) findViewById(R.id.et_update_client_fax);
        mEt_update_client_communication_address = (EditText) findViewById(R.id.et_update_client_communication_address);
        mEt_update_client_zip_code = (EditText) findViewById(R.id.et_update_client_zip_code);
        mEt_update_client_business_license = (EditText) findViewById(R.id.et_update_client_business_license);
        mEt_update_client_legal_representative = (EditText)findViewById(R.id.et_update_client_legal_representative);
        mEt_update_client_contact = (EditText) findViewById(R.id.et_update_client_contact);
        mIv_update_client_type = findViewById(R.id.iv_update_client_type);
        mIv_update_client_care_type = findViewById(R.id.iv_update_client_care_type);
        mIv_update_client_sex = findViewById(R.id.iv_update_client_sex);
        mIv_update_client_marriage = findViewById(R.id.iv_update_client_marriage);
        mIv_update_client_age_paragraph = findViewById(R.id.iv_update_client_age_paragraph);
        mIv_update_client_comprehensive_salary = findViewById(R.id.iv_update_client_comprehensive_salary);
        mIv_update_client_purchase_use = findViewById(R.id.iv_update_client_purchase_use);
        mIv_update_client_group = findViewById(R.id.iv_update_client_group);
        mIv_update_client_follow_stage = findViewById(R.id.iv_update_client_follow_stage);
        mIv_update_client_subordinate_project = findViewById(R.id.iv_update_client_subordinate_project);
        mIv_update_client_salesman = findViewById(R.id.iv_update_client_salesman);
        mIv_update_client_birth_date = findViewById(R.id.iv_update_client_birth_date);
        btn_save_info = findViewById(R.id.btn_save_info);
        ivReturn = findViewById(R.id.iv_return);
        elEmpty = findViewById(R.id.el_empty);
        scrollView = findViewById(R.id.scro_client);
        elEmpty.bindView(scrollView);
        mEt_update_client_family_structure = findViewById(R.id.et_update_client_family_structure);
        mEt_update_client_guest_type = findViewById(R.id.et_update_client_guest_type);
        mEt_update_client_transportation = findViewById(R.id.et_update_client_transportation);
        mEt_update_client_career_feature = findViewById(R.id.et_update_client_career_feature);
        mEt_update_client_dwell_info = findViewById(R.id.et_update_client_dwell_info);
        mEt_update_client_congnitive_approach = findViewById(R.id.et_update_client_congnitive_approach);
        mEt_update_client_buy_focus = findViewById(R.id.et_update_client_buy_focus);
        mTv_update_client_isRelation = findViewById(R.id.tv_update_client_isRelation);
        mLl_update_client_isRelation = findViewById(R.id.ll_update_client_isRelation);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        Intent initIntent= getIntent();
        if(initIntent!=null&&initIntent.getStringExtra("type")!=null){
             type = initIntent.getStringExtra("type");
            if(type.equals("查看")){
                client_id = initIntent.getStringExtra("client_id");
                presenter.setClientInfo(client_id);
            }
            if(type.equals("add")){

            }
        }

    }
    @Override
    protected void initListener() {
        ivReturn.setOnClickListener(this);
        mTv_update_client_type.setOnClickListener(this);
        mIv_update_client_type.setOnClickListener(this);
        mTv_update_client_care_type.setOnClickListener(this);
        mIv_update_client_care_type.setOnClickListener(this);
        mTv_update_client_sex.setOnClickListener(this);
        mIv_update_client_sex.setOnClickListener(this);
        mIv_update_client_marriage.setOnClickListener(this);
        mTv_update_client_marriage.setOnClickListener(this);
        mIv_update_client_age_paragraph.setOnClickListener(this);
        mTv_update_client_age_paragraph.setOnClickListener(this);
        mIv_update_client_comprehensive_salary.setOnClickListener(this);
        mTv_update_client_comprehensive_salary.setOnClickListener(this);
        mIv_update_client_purchase_use.setOnClickListener(this);
        mTv_update_client_purchase_use.setOnClickListener(this);
        mIv_update_client_group.setOnClickListener(this);
        mTv_update_client_group.setOnClickListener(this);
        mIv_update_client_follow_stage.setOnClickListener(this);
        mTv_update_client_follow_stage.setOnClickListener(this);
        mIv_update_client_subordinate_project.setOnClickListener(this);
        mTv_update_client_subordinate_project.setOnClickListener(this);
        mIv_update_client_salesman.setOnClickListener(this);
        mTv_update_client_salesman.setOnClickListener(this);
        mIv_update_client_birth_date.setOnClickListener(this);
        mTv_update_client_birth_date.setOnClickListener(this);
        btn_save_info.setOnClickListener(this);
        mLl_update_client_isRelation.setOnClickListener(this);
        elEmpty.setOnButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData(null);
            }
        });
    }


    @Override
    public void onClick(View v) {

        int i = v.getId();
        if (i == R.id.iv_update_client_type || i == R.id.tv_update_client_type) {
            if (ClientInfoDataDictionary.client_type != null&&ClientInfoDataDictionary.client_type.length>0)
                new CustomPopup(this, ClientInfoDataDictionary.client_type, mTv_update_client_type, mTv_update_client_type.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        mTv_update_client_type.setText(s);
                        mTv_update_client_type.setTag(position);
                    }
                });

            //证件类型选择
        } else if (i == R.id.iv_update_client_care_type || i == R.id.tv_update_client_care_type) {
            if (ClientInfoDataDictionary.care_type != null&&ClientInfoDataDictionary.care_type.length>0)
                new CustomPopup(this, ClientInfoDataDictionary.care_type, mTv_update_client_care_type, mTv_update_client_care_type.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        mTv_update_client_care_type.setText(s);
                        mTv_update_client_care_type.setTag(position);
                    }
                });

        } else if (i == R.id.tv_update_client_sex || i == R.id.iv_update_client_sex) {
            if (ClientInfoDataDictionary.sex != null&&ClientInfoDataDictionary.sex.length>0)
                new CustomPopup(this, ClientInfoDataDictionary.sex, mTv_update_client_sex, mTv_update_client_sex.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        mTv_update_client_sex.setText(s);
                        mTv_update_client_sex.setTag(position);
                    }
                });

        } else if (i == R.id.tv_update_client_marriage || i == R.id.iv_update_client_marriage) {
            if (ClientInfoDataDictionary.marriage != null&&ClientInfoDataDictionary.marriage.length>0)
                new CustomPopup(this, ClientInfoDataDictionary.marriage, mTv_update_client_marriage, mTv_update_client_marriage.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        mTv_update_client_marriage.setText(s);
                        mTv_update_client_marriage.setTag(position);
                    }
                });


        } else if (i == R.id.iv_update_client_age_paragraph || i == R.id.tv_update_client_age_paragraph) {
            if (ClientInfoDataDictionary.age_paragraph != null&&ClientInfoDataDictionary.age_paragraph.length>0)
                new CustomPopup(this, ClientInfoDataDictionary.age_paragraph, mTv_update_client_age_paragraph, mTv_update_client_age_paragraph.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        mTv_update_client_age_paragraph.setText(s);
                        mTv_update_client_age_paragraph.setTag(position);
                    }
                });

        } else if (i == R.id.iv_update_client_comprehensive_salary || i == R.id.tv_update_client_comprehensive_salary) {
            if (ClientInfoDataDictionary.comprehensive_salary != null&&ClientInfoDataDictionary.comprehensive_salary.length>0)
                new CustomPopup(this, ClientInfoDataDictionary.comprehensive_salary, mTv_update_client_comprehensive_salary, mTv_update_client_comprehensive_salary.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        mTv_update_client_comprehensive_salary.setText(s);
                        mTv_update_client_comprehensive_salary.setTag(position);
                    }
                });

        } else if (i == R.id.iv_update_client_purchase_use || i == R.id.tv_update_client_purchase_use) {
            if (ClientInfoDataDictionary.purchase_use != null&&ClientInfoDataDictionary.purchase_use.length>0)
                new CustomPopup(this, ClientInfoDataDictionary.purchase_use, mTv_update_client_purchase_use, mTv_update_client_purchase_use.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        LogUtils.i("当前选择购房意图"+s+position+GsonUtil.GsonString(ClientInfoDataDictionary.purchase_use)+GsonUtil.GsonString(ClientInfoDataDictionary.purchase_use_id));
                        mTv_update_client_purchase_use.setText(s);
                        mTv_update_client_purchase_use.setTag(position);
                    }
                });

        } else if (i == R.id.iv_update_client_group || i == R.id.tv_update_client_group) {
            if (ClientInfoDataDictionary.client_group != null&&ClientInfoDataDictionary.client_group.length>0)
                new CustomPopup(this, ClientInfoDataDictionary.client_group, mTv_update_client_group, mTv_update_client_group.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {

                        mTv_update_client_group.setText(s);
                        mTv_update_client_group.setTag(position);
                    }
                });

        } else if (i == R.id.iv_update_client_follow_stage || i == R.id.tv_update_client_follow_stage) {
            if (ClientInfoDataDictionary.follow_stage != null&&ClientInfoDataDictionary.follow_stage .length>0)
                new CustomPopup(this, ClientInfoDataDictionary.follow_stage, mTv_update_client_follow_stage, mTv_update_client_follow_stage.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        mTv_update_client_follow_stage.setText(s);
                        mTv_update_client_follow_stage.setTag(position);
                    }
                });

        } else if (i == R.id.iv_update_client_subordinate_project || i == R.id.tv_update_client_subordinate_project) {
            if (ClientInfoDataDictionary.page_project != null&&ClientInfoDataDictionary.page_project.length>0)
                new CustomPopup(this, ClientInfoDataDictionary.page_project, mTv_update_client_subordinate_project, mTv_update_client_subordinate_project.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {

                        mTv_update_client_subordinate_project.setText(s);
                        mTv_update_client_subordinate_project.setTag(position);
                        List<ProTeamByFKProject> projects = ClientInfoDataDictionary.proTeamByFKProject;
                        for (int i = 0; i < projects.size(); i++) {
                            //LogUtils.i("项目团队" + GsonUtil.GsonString(projects));
                            if (ClientInfoDataDictionary.page_project_id[position].equals(projects.get(i).getProject_id())) {
                                LogUtils.i(projects.get(i).getProject_id());
                                if (projects.get(i).getData() != null && projects.get(i).getData().size() > 0) {
                                    ClientInfoDataDictionary.salesman = new String[projects.get(i).getData().size()];
                                    ClientInfoDataDictionary.salesman_id = new String[projects.get(i).getData().size()];
                                    for (int j = 0; j < projects.get(i).getData().size(); j++) {
                                        ClientInfoDataDictionary.salesman[j] = projects.get(i).getData().get(j).getSysStaff().getName();
                                        ClientInfoDataDictionary.salesman_id[j] = projects.get(i).getData().get(j).getSysStaff().getStaff_id();
                                    }
                                    LogUtils.i("给业务员加标签");
                                    mTv_update_client_salesman.setTag(0);
                                    mTv_update_client_salesman.setText(ClientInfoDataDictionary.salesman[0]);

                                } else {
                                    ClientInfoDataDictionary.salesman = null;
                                    showSalesman();
                                }
                            }
//                                if(projects.get(i).getData()!=null&&projects.get(i).getData().size()>0){
//                                    LogUtils.i("团队"+GsonUtil.GsonString(projects.get(i)));
//                                    ClientInfoDataDictionary.salesman=new String[projects.get(i).getData().size()];
//                                     for (int j=0;j<projects.get(i).getData().size();j++){
//                                         ClientInfoDataDictionary.salesman[j]=projects.get(i).getData().get(j).getSysStaff().getName();
//                                         LogUtils.i("业务员"+projects.get(i).getData().get(j).getSysStaff().getName());
//                                     }
//                                    // if()
//                               }else {
//                                   ClientInfoDataDictionary.salesman = null;
//                             }
                        }

                    }
                });

        } else if (i == R.id.iv_update_client_salesman || i == R.id.tv_update_client_salesman) {
            //LogUtils.i("业务员");
            showSalesman();

        } else if (i == R.id.iv_update_client_birth_date || i == R.id.tv_update_client_birth_date) {
            DatePickerFragment datePicker = new DatePickerFragment(new DatePickerFragment.ResultTime() {
                @Override
                public void resultText(String time) {
                    mTv_update_client_birth_date.setText(time);
                }
            });
            datePicker.show(this.getFragmentManager(), "DatePicker");

        } else if (i == R.id.btn_save_info) {
            if(type.equals("查看"))
                new CustomAlertDialog(this, 0, "修改", "确定要修改么", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == -1) {
                            //确定
                            updateClientInfo();

                        }
                        if (i == -2) {

                            //取消
                        }
                    }
                });
               if (type.equals("add"))
                new CustomAlertDialog(this, 0, "新增", "确定要新增么", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == -1) {
                            //确定
                            //showProgressBar(this);
                            LogUtils.i("开始新增");
                            presenter.addClientInfo();

                        }
                        if (i == -2) {
                            //取消
                        }
                    }
                });

        }
        else if (i == R.id.ll_update_client_isRelation) {
            if (ClientInfoDataDictionary.is_relation != null&&ClientInfoDataDictionary.is_relation.length>0)
                new CustomPopup(this, ClientInfoDataDictionary.is_relation, mTv_update_client_isRelation, mTv_update_client_isRelation.getWidth(), new CustomPopup.GetDataOnListener() {
                    @Override
                    public void onClick(String s, int position) {
                        LogUtils.i("当前选择"+s+position);
                        mTv_update_client_isRelation.setText(s);
                        mTv_update_client_isRelation.setTag(position);
                    }
                });

        } else if (i == R.id.iv_return) {
            finish();
        }
    }
    private void showSalesman() {
        if (ClientInfoDataDictionary.salesman != null) {
            LogUtils.i("给业务员加标签");
            new CustomPopup(this, ClientInfoDataDictionary.salesman, mTv_update_client_salesman, mTv_update_client_salesman.getWidth(), new CustomPopup.GetDataOnListener() {
                @Override
                public void onClick(String s, int position) {
                    mTv_update_client_salesman.setText(s);
                    mTv_update_client_salesman.setTag(position);
                }
            });
        } else {
            mTv_update_client_salesman.setText("");
            mTv_update_client_salesman.setTag(null);
        }
    }

    @Override
    public void setClient() {

    }

    @Override
    public void showClientInfo(PageClientInfo<ClientData> pageClientInfo) {
        this.pageClientInfo = pageClientInfo;
        LogUtils.i(GsonUtil.GsonString(pageClientInfo));
        //显示用户信息
        mEt_update_client_name.setText(pageClientInfo.getData().getClientInfo().getClient_name());//客户名
        mTv_update_client_type.setText(ClientInfoDataDictionary.client_type[pageClientInfo.getData().getClientInfo().getCard_type()]);//客户类型
        mTv_update_client_type.setTextColor(Color.BLACK);
        mEt_update_client_nationality.setText(pageClientInfo.getData().getClientInfo().getNationality());//国籍
        mEt_update_client_native_place.setText(pageClientInfo.getData().getClientInfo().getNative_place());//籍贯
        mTv_update_client_care_type.setText(ClientInfoDataDictionary.care_type[pageClientInfo.getData().getClientInfo().getCard_type()]);//证件类型
        mEt_update_client_card_number.setText(pageClientInfo.getData().getClientInfo().getCard_number());//证件号
        if (pageClientInfo.getData().getClientInfo().getBirthday() != null && !pageClientInfo.getData().getClientInfo().getBirthday().equals("")) {
            mTv_update_client_birth_date.setText(TimeUtils.getstrTime(pageClientInfo.getData().getClientInfo().getBirthday(), false));//出生日期
        }
        mTv_update_client_sex.setText(ClientInfoDataDictionary.sex[pageClientInfo.getData().getClientInfo().getSex()]);//性别
        if(pageClientInfo.getData().getClientInfo().getFk_marriage()!=null&&!pageClientInfo.getData().getClientInfo().getFk_marriage().equals(""))
            presenter.findSysDictionaryItemByPk(pageClientInfo.getData().getClientInfo().getFk_marriage());//婚姻
        mEt_update_client_work_units.setText(pageClientInfo.getData().getClientInfo().getWorkplace());//工作单位
        mEt_update_client_professional.setText(pageClientInfo.getData().getClientInfo().getProfession());//职业
        mEt_update_client_living_area.setText(pageClientInfo.getData().getClientInfo().getResidential_zone());//居住区域
        mEt_update_client_working_area.setText(pageClientInfo.getData().getClientInfo().getCorp_area());//工作区域
        if (pageClientInfo.getData().getClientInfo().getFk_age() != null && !pageClientInfo.getData().getClientInfo().getFk_age().equals(""))
            presenter.findSysDictionaryItemByPk(pageClientInfo.getData().getClientInfo().getFk_age());//年龄段
        if (pageClientInfo.getData().getClientInfo().getFk_annual_salary() != null && !pageClientInfo.getData().getClientInfo().getFk_annual_salary().equals(""))

            presenter.findSysDictionaryItemByPk(pageClientInfo.getData().getClientInfo().getFk_annual_salary());//综合年薪
        if (pageClientInfo.getData().getClientInfo().getFk_use() != null && !pageClientInfo.getData().getClientInfo().getFk_use().equals(""))

            presenter.findSysDictionaryItemByPk(pageClientInfo.getData().getClientInfo().getFk_use());//购房用途
        mTv_update_client_subordinate_project.setText(pageClientInfo.getData().getRy_project_name());//所属项目
        mTv_update_client_salesman.setText(pageClientInfo.getData().getRy_salesman());//业务员
        if(pageClientInfo.getData().getClientProject()!=null) {
            if (ClientInfoDataDictionary.proTeamByFKProject != null && pageClientInfo.getData().getClientProject().getFk_project_id() != null && !pageClientInfo.getData().getClientProject().getFk_project_id().equals(""))
                for (int i = 0; i < ClientInfoDataDictionary.proTeamByFKProject.size(); i++) {
                    if (pageClientInfo.getData().getClientProject().getFk_project_id().equals(ClientInfoDataDictionary.proTeamByFKProject.get(i).getProject_id())) {
                        ClientInfoDataDictionary.salesman = new String[ClientInfoDataDictionary.proTeamByFKProject.get(i).getData().size()];
                        ClientInfoDataDictionary.salesman_id = new String[ClientInfoDataDictionary.proTeamByFKProject.get(i).getData().size()];
                        for (int j = 0; j < ClientInfoDataDictionary.proTeamByFKProject.get(i).getData().size(); j++) {
                            ClientInfoDataDictionary.salesman[j] = ClientInfoDataDictionary.proTeamByFKProject.get(i).getData().get(j).getSysStaff().getName();
                            ClientInfoDataDictionary.salesman_id[j] = ClientInfoDataDictionary.proTeamByFKProject.get(i).getData().get(j).getSysStaff().getStaff_id();
                        }
                    }
                }
        }
        mTv_update_client_group.setText(pageClientInfo.getData().getRy_group());//客户分组
        if (pageClientInfo.getData().getClientInfo().getFk_follow_stage() != null && !pageClientInfo.getData().getClientInfo().getFk_follow_stage().equals(""))
            presenter.findSysDictionaryItemByPk(pageClientInfo.getData().getClientInfo().getFk_follow_stage());//跟进阶段
        mEt_update_client_mobile_phone.setText(pageClientInfo.getData().getClientInfo().getMobile_tele());//移动电话
        mEt_update_client_home_phone.setText(pageClientInfo.getData().getClientInfo().getHomephone());//住宅电话
        mEt_update_client_office_phone.setText(pageClientInfo.getData().getClientInfo().getWork_phone());//办公电话
        mEt_update_client_fax.setText(pageClientInfo.getData().getClientInfo().getFax());//传真
        mEt_update_client_communication_address.setText(pageClientInfo.getData().getClientInfo().getAddress());//通讯地址
        mEt_update_client_zip_code.setText(pageClientInfo.getData().getClientInfo().getPostcard());//邮编
        mEt_update_client_business_license.setText(pageClientInfo.getData().getClientInfo().getBusiness_license());//营业执照
        mEt_update_client_legal_representative.setText(pageClientInfo.getData().getClientInfo().getLegal_repre());//法人代表
        mEt_update_client_contact.setText(pageClientInfo.getData().getClientInfo().getContact());//联络人

    }

    @Override
    public void showMarriage(String name) {
        mTv_update_client_marriage.setText(name);
    }

    @Override
    public void showComprehensive_salary(String string) {
        mTv_update_client_comprehensive_salary.setText(string);//综合年薪

    }

    @Override
    public void showFk_age(String string) {
        mTv_update_client_age_paragraph.setText(string);
    }

    @Override
    public void showFk_use(String string) {
        mTv_update_client_purchase_use.setText(string);
    }

    @Override
    public void showFk_follow_stage(String string) {
        mTv_update_client_follow_stage.setText(string);
    }

    @Override
    public Map<String, String> getViewText() {
        Map<String, String> map = new ArrayMap<>();
        if(type.equals("查看")){
            map.put("clientInfo.client_id", client_id);
        }
        map.put("clientInfo.client_name", mEt_update_client_name.getText().toString().trim());//客户名
        if((mEt_update_client_name.getText()+"".trim()).equals("")){
            showToast("客户名称不能为空");
            return null;
        }
        String client_type;
        if (mTv_update_client_type.getTag() != null) {
            client_type=mTv_update_client_type.getTag().toString();
        }else if(!mTv_update_client_type.getText().toString().equals("")) {
            client_type=findDataIndex(ClientInfoDataDictionary.client_type,mTv_update_client_type.getText().toString().trim());
        }else {
            client_type = "";
        }
        map.put("clientInfo.client_type", client_type);//客户类型
        map.put("clientInfo.nationality", mEt_update_client_nationality.getText().toString().trim());//国籍
        map.put("clientInfo.native_place", mEt_update_client_native_place.getText().toString().trim());//籍贯
        String care_type;
        if (mTv_update_client_care_type.getTag() != null) {
            care_type = mTv_update_client_care_type.getTag().toString();
        }else if(!mTv_update_client_care_type.getText().toString().equals("")) {
            care_type = findDataIndex(ClientInfoDataDictionary.care_type, mTv_update_client_care_type.getText().toString().trim());
        }else {
            care_type = "0";
        }
        map.put("clientInfo.card_type", care_type);//证件类型
        map.put("clientInfo.card_number", mEt_update_client_card_number.getText().toString().trim());//证件号
        if (mTv_update_client_birth_date.getText() != null && !mTv_update_client_birth_date.getText().equals("")) {
            map.put("clientInfo.birthday",mTv_update_client_birth_date.getText().toString().trim());//出生日期
        } else {
            map.put("clientInfo.birthday", "");//出生日期
        }
        String sex;
        if (mTv_update_client_sex.getTag() != null) {
            sex=mTv_update_client_sex.getTag().toString();
        }else {
            sex = String.valueOf(pageClientInfo.getData().getClientInfo().getSex());
        }
        map.put("clientInfo.sex", sex);//性别
        if (mTv_update_client_marriage.getTag() != null && ClientInfoDataDictionary.marriage_id != null) {
            map.put("clientInfo.fk_marriage", ClientInfoDataDictionary.marriage_id[(int) mTv_update_client_marriage.getTag()]);//婚姻状况
        }
        map.put("clientInfo.workplace", mEt_update_client_work_units.getText().toString().trim());//工作单位
        map.put("clientInfo.profession", mEt_update_client_professional.getText().toString().trim());//职业
        map.put("clientInfo.residential_zone", mEt_update_client_living_area.getText().toString().trim());//居住区域
        map.put("clientInfo.corp_area", mEt_update_client_working_area.getText().toString().trim());//工作区域
        String age_paragraph;
         if(mTv_update_client_age_paragraph.getTag()==null){
             age_paragraph= pageClientInfo.getData().getClientInfo().getFk_age();
         }else {
             age_paragraph = ClientInfoDataDictionary.age_paragraph_id[(int) mTv_update_client_age_paragraph.getTag()];
         }
        map.put("clientInfo.fk_age", age_paragraph);//年龄段
        if (ClientInfoDataDictionary.comprehensive_salary_id != null & mTv_update_client_comprehensive_salary.getTag() != null) {
            map.put("clientInfo.fk_annual_salary", ClientInfoDataDictionary.comprehensive_salary_id[(int) mTv_update_client_comprehensive_salary.getTag()]);//综合年薪
        }
        if (ClientInfoDataDictionary.purchase_use_id != null && mTv_update_client_purchase_use.getTag() != null) {
            map.put("clientInfo.fk_use", ClientInfoDataDictionary.purchase_use_id[(int) mTv_update_client_purchase_use.getTag()]);//购房用途
        }
        String page_project;
        if (ClientInfoDataDictionary.page_project_id != null && mTv_update_client_subordinate_project.getTag() != null) {
            page_project = ClientInfoDataDictionary.page_project_id[(int) mTv_update_client_subordinate_project.getTag()];
        } else if(pageClientInfo.getData().getClientProject().getFk_project_id()!=null){
            page_project = pageClientInfo.getData().getClientProject().getFk_project_id();
        }else {
            page_project = "";
        }
        map.put("clientProject.fk_project_id", page_project);//所属项目
        String salesman;
        if (mTv_update_client_salesman.getTag() != null) {
            salesman = ClientInfoDataDictionary.salesman_id[(int) mTv_update_client_salesman.getTag()];
        } else{
            salesman = pageClientInfo.getData().getClientProject().getFk_salesman_id();
        }
        map.put("clientProject.fk_salesman_id", salesman);//业务员
        if (ClientInfoDataDictionary.client_group_id != null && mTv_update_client_group.getTag() != null) {
            map.put("clientInfo.fk_group_id", ClientInfoDataDictionary.client_group_id[(int) mTv_update_client_group.getTag()]);//客户分组
        }
        if (ClientInfoDataDictionary.follow_stage_id != null && mTv_update_client_follow_stage.getTag() != null) {
            LogUtils.i("跟进阶段数据字典大小"+ClientInfoDataDictionary.follow_stage_id .length);
            map.put("clientInfo.fk_follow_stage", ClientInfoDataDictionary.follow_stage_id[(int) mTv_update_client_follow_stage.getTag()]);//跟进阶段
        }else {
            if(mTv_update_client_follow_stage.getText().toString()!=null)
                map.put("clientInfo.fk_follow_stage",findDataId(ClientInfoDataDictionary.follow_stage,ClientInfoDataDictionary.follow_stage_id,mTv_update_client_follow_stage.getText().toString()));//跟进阶段
        }
        map.put("clientInfo.mobile_tele", mEt_update_client_mobile_phone.getText().toString().trim());//移动电话
        map.put("clientInfo.homephone", mEt_update_client_home_phone.getText().toString().trim());//住宅电话
        map.put("clientInfo.work_phone", mEt_update_client_office_phone.getText().toString().trim());//办公电话
        map.put("clientInfo.fax", mEt_update_client_fax.getText().toString().trim());//传真
        map.put("clientInfo.address", mEt_update_client_communication_address.getText().toString().trim());//通讯地址
        map.put("clientInfo.postcard", mEt_update_client_zip_code.getText().toString().trim());//邮编
        map.put("clientInfo.business_license", mEt_update_client_business_license.getText().toString().trim());//营业执照
        map.put("clientInfo.legal_repre", mEt_update_client_legal_representative.getText().toString().trim());//法人代表
        map.put("clientInfo.contact", mEt_update_client_contact.getText().toString().trim());//联络
        map.put("clientInfo.family_structure",  mEt_update_client_family_structure.getText().toString().trim());//家庭结构
        map.put("clientInfo.guest_type",  mEt_update_client_guest_type.getText().toString().trim());//来宾类型
        map.put("clientInfo.transportation", mEt_update_client_transportation.getText().toString().trim());//交通工具
        map.put("clientInfo.career_feature", mEt_update_client_career_feature.getText().toString().trim());//职业特征
        map.put("clientInfo.dwell_info", mEt_update_client_dwell_info.getText().toString().trim());//居住信息
        map.put("clientInfo.congnitive_approach", mEt_update_client_congnitive_approach.getText().toString().trim());//认知途径
        map.put("clientInfo.buy_focus", mEt_update_client_buy_focus.getText().toString().trim());//买房关注要素
        if (mTv_update_client_isRelation.getTag() != null) {
            map.put("clientInfo.isRelation", mTv_update_client_isRelation.getTag().toString().trim());////是否为关系户
        }
        LogUtils.i("打印一下参数" + GsonUtil.GsonString(map));
        return map;
    }

    @Override
    public Map<String, String> getViewTextAdd() {
        Map<String, String> map = new ArrayMap<>();

        if(type.equals("查看")){
            map.put("clientInfo.client_id", client_id);
        }
        map.put("clientInfo.client_name", mEt_update_client_name.getText().toString().trim());//客户名
        if((mEt_update_client_name.getText()+"".trim()).equals("")){
            Toast.makeText(this, "客户名称不能为空", Toast.LENGTH_SHORT).show();
            return null;
        }
        if (mTv_update_client_type.getTag() != null) {
            map.put("clientInfo.client_type", String.valueOf(mTv_update_client_type.getTag()) );//客户类型
        }
        map.put("clientInfo.nationality", mEt_update_client_nationality.getText().toString().trim());//国籍
        map.put("clientInfo.native_place", mEt_update_client_native_place.getText().toString().trim());//籍贯
        if (mTv_update_client_care_type.getTag() != null) {
            map.put("clientInfo.card_type", mTv_update_client_care_type.getTag() + "");//证件类型
        }
        map.put("clientInfo.card_number", mEt_update_client_card_number.getText().toString().trim());//证件号
        LogUtils.i("时间是" + mTv_update_client_birth_date.getText());
        if (mTv_update_client_birth_date.getText() != null && !mTv_update_client_birth_date.getText().equals("")) {
            map.put("clientInfo.birthday", mTv_update_client_birth_date.getText().toString().trim());//出生日期
        } else {
            map.put("clientInfo.birthday", "");//出生日期
        }
        if (mTv_update_client_sex.getTag() != null) {
            map.put("clientInfo.sex",  mTv_update_client_sex.getTag()+"");//性别
        }
        if (mTv_update_client_marriage.getTag() != null && ClientInfoDataDictionary.marriage_id != null) {
            map.put("clientInfo.fk_marriage", ClientInfoDataDictionary.marriage_id[(int) mTv_update_client_marriage.getTag()]);//婚姻状况
        }
        map.put("clientInfo.workplace", mEt_update_client_work_units.getText().toString().trim());//工作单位
        map.put("clientInfo.profession", mEt_update_client_professional.getText().toString().trim());//职业
        map.put("clientInfo.residential_zone", mEt_update_client_living_area.getText().toString().trim());//居住区域
        map.put("clientInfo.corp_area", mEt_update_client_working_area.getText().toString().trim());//工作区域
        if (ClientInfoDataDictionary.age_paragraph_id != null && mTv_update_client_age_paragraph.getTag() != null) {
            map.put("clientInfo.fk_age", ClientInfoDataDictionary.age_paragraph_id[(int) mTv_update_client_age_paragraph.getTag()]);//年龄段
        }
        if (ClientInfoDataDictionary.comprehensive_salary_id != null & mTv_update_client_comprehensive_salary.getTag() != null) {
            map.put("clientInfo.fk_annual_salary", ClientInfoDataDictionary.comprehensive_salary_id[(int) mTv_update_client_comprehensive_salary.getTag()]);//综合年薪
        }
        if (ClientInfoDataDictionary.purchase_use_id != null && mTv_update_client_purchase_use.getTag() != null) {
            map.put("clientInfo.fk_use", ClientInfoDataDictionary.purchase_use_id[(int) mTv_update_client_purchase_use.getTag()]);//购房用途
        }
        if (ClientInfoDataDictionary.page_project_id != null && mTv_update_client_subordinate_project.getTag() != null) {
            map.put("clientProject.fk_project_id", ClientInfoDataDictionary.page_project_id[(int) mTv_update_client_subordinate_project.getTag()]);//所属项目
        } else {
            map.put("clientProject.fk_project_id", "");//所属项目
        }
        if (ClientInfoDataDictionary.salesman_id != null && mTv_update_client_salesman.getTag() != null) {
            map.put("clientProject.fk_salesman_id", ClientInfoDataDictionary.salesman_id[(int) mTv_update_client_salesman.getTag()]);//业务员
        } else{
            map.put("clientProject.fk_salesman_id", "");//业务员
        }
        if (ClientInfoDataDictionary.client_group_id != null && mTv_update_client_group.getTag() != null) {
            map.put("clientInfo.fk_group_id", ClientInfoDataDictionary.client_group_id[(int) mTv_update_client_group.getTag()]);//客户分组
        }
        if (ClientInfoDataDictionary.follow_stage_id != null && mTv_update_client_follow_stage.getTag() != null) {
            map.put("clientInfo.fk_follow_stage", ClientInfoDataDictionary.follow_stage_id[(int) mTv_update_client_follow_stage.getTag()]);//跟进阶段
        }else {
            showToast("跟进阶段不能为空");
            return null;
        }
        map.put("clientInfo.mobile_tele", mEt_update_client_mobile_phone.getText().toString().trim());//移动电话
        map.put("clientInfo.homephone", mEt_update_client_home_phone.getText().toString().trim());//住宅电话
        map.put("clientInfo.work_phone", mEt_update_client_office_phone.getText().toString().trim());//办公电话
        map.put("clientInfo.fax", mEt_update_client_fax.getText().toString().trim());//传真
        map.put("clientInfo.address", mEt_update_client_communication_address.getText().toString().trim());//通讯地址
        map.put("clientInfo.postcard", mEt_update_client_zip_code.getText().toString().trim());//邮编
        map.put("clientInfo.business_license", mEt_update_client_business_license.getText().toString().trim());//营业执照
        map.put("clientInfo.legal_repre", mEt_update_client_legal_representative.getText().toString().trim());//法人代表
        map.put("clientInfo.contact", mEt_update_client_contact.getText().toString().trim());//联络
        map.put("clientInfo.family_structure",  mEt_update_client_family_structure.getText().toString().trim());//家庭结构
        map.put("clientInfo.guest_type",  mEt_update_client_guest_type.getText().toString().trim());//来宾类型
        map.put("clientInfo.transportation", mEt_update_client_transportation.getText().toString().trim());//交通工具
        map.put("clientInfo.career_feature", mEt_update_client_career_feature.getText().toString().trim());//职业特征
        map.put("clientInfo.dwell_info", mEt_update_client_dwell_info.getText().toString().trim());//居住信息
        map.put("clientInfo.congnitive_approach", mEt_update_client_congnitive_approach.getText().toString().trim());//认知途径
        map.put("clientInfo.buy_focus", mEt_update_client_buy_focus.getText().toString().trim());//买房关注要素
        if (mTv_update_client_isRelation.getTag() != null) {

            map.put("clientInfo.isRelation", mTv_update_client_isRelation.getTag().toString().trim());////是否为关系户
        }else {
            LogUtils.i("关系户是空的");
        }
        LogUtils.i("参数"+GsonUtil.GsonString(map));
        return map;
    }

    @Override
    public void updateClientInfo() {
        presenter.updateClientInfo();

    }

    @Override
    public void addYes() {
        showToast("新增客户成功");
        finish();
    }

    @Override
    public void addNo() {
        showToast("新增失败，请检查网络");
    }

    @Override
    public void initDataNo(String type) {

    }

    @Override
    public void showError() {
        elEmpty.showError();
    }

    @Override
    public void showLoading() {
        elEmpty.showLoading();
    }

    @Override
    public void showSuccess() {
        elEmpty.showSuccess();
    }

    @Override
    public void showEmpty() {
        elEmpty.showEmpty();
    }

    private  String findDataId(String [] data,String [] data_id,String text){
        String text_id=null;
        for (int i=0;i<data.length;i++){
            if(text.equals(data[i])){
                text_id=data_id[i];
            }else {

            }
        }
        return text_id;
    }

    private String findDataIndex(String[] data, String text) {
        String index = null;
        for (int i=0;i<data.length;i++){
             if(text.equals(data[i])){
                 index = String.valueOf(i);
             }
        }
        return index;
    }
}
