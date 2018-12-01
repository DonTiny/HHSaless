package com.hhsales.zzxinteyu.hhsales.login.presenter;

import com.example.lib_common.bean.user.UserBean;
import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.RSAUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.google.gson.Gson;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.client.bean.ProTeamByFKProject;
import com.hhsales.zzxinteyu.hhsales.login.model.ILoginModel;
import com.hhsales.zzxinteyu.hhsales.login.model.LoginModelImpl;
import com.hhsales.zzxinteyu.hhsales.login.ui.ILoginView;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientInfoDataDictionary;
import com.hhsales.zzxinteyu.hhsales.utlis.RoomDataDictionary;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/3/30.
 */

public class LoginPresenter<T extends ILoginView> extends BasePresenter<T> {
    private String index = "4,5,6,12,14,15,8,10";
    private int search_progress=0;
    ILoginModel loginModel = new LoginModelImpl();
    private Map<String, String> map;
    //UI操作
    public void fetch() {
        if (mViewRef.get() != null) {
            mViewRef.get().showLoading();
            map = mViewRef.get().getUserNameOrPsw();
            if (loginModel != null) {
                loginModel.getPublicKey(null, new ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {
                        mViewRef.get().LoginNo();
                    }

                    @Override
                    public void onResponse(String response) {
                        encodePassword(response);
                        loginModel.loginRequestBase64(map, new ResultCallback<String>() {
                            @Override
                            public void onError(Request request, Exception e) {

                            }

                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    if(jsonObject.getString("message").equals("登录成功")){
                                        mViewRef.get().startMeun(new Gson().fromJson(response,UserBean.class));
                                        findListSysDictionary(index);
                                    }else {
                                        mViewRef.get().LoginNo();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
            }
        }


    }
    /**
     * 使用公钥对字符串进行加密
     *
     * @param publickKey
     */
    private void encodePassword(String publickKey) {
        RSAUtils.loadPublicKey(publickKey);
        try {
            map.put("password_err", RSAUtils.encryptWithRSA(map.get("password_err")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //一次性获取数据字典
    public void findListSysDictionary(String string) {
        loginModel.getFindListSysDictionary(string, new ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("一次性获取数据字典失败"+e);
            }

            @Override
            public void onResponse(String response) throws Exception {
                //LogUtils.i("一次性获取数据字典成功"+response);
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray;
                if(jsonObject.getString("message").equals("根据外键id查询数据字典明细信息成功")){
                    JSONObject objectData=jsonObject.getJSONObject("data");
                    String[] strings;
                    String[] strings_id;

                    jsonArray=objectData.getJSONArray("4");//跟进阶段
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.follow_stage=strings;
                        ClientInfoDataDictionary.follow_stage_id = strings_id;
                    }

                    jsonArray=objectData.getJSONArray("5");//婚姻状况
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.marriage=strings;
                        ClientInfoDataDictionary.marriage_id = strings_id;
                    }

                    jsonArray=objectData.getJSONArray("6");//综合年薪
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.comprehensive_salary=strings;
                        ClientInfoDataDictionary.comprehensive_salary_id = strings_id;
                    }


                    jsonArray=objectData.getJSONArray("8");//房间类型
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.room_type=strings;
                        ClientInfoDataDictionary.room_type_id = strings_id;
                    }


                    jsonArray=objectData.getJSONArray("12");//客户分组
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.client_group=strings;
                        ClientInfoDataDictionary.client_group_id = strings_id;
                    }

                    jsonArray=objectData.getJSONArray("14");//年龄阶段
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.age_paragraph = strings;
                        ClientInfoDataDictionary.age_paragraph_id = strings_id;
                    }

                    jsonArray=objectData.getJSONArray("15");//购房用途
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.purchase_use = strings;
                        ClientInfoDataDictionary.purchase_use_id = strings_id;
                    }

                    jsonArray=objectData.getJSONArray("10");//购房用途
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                       RoomDataDictionary.decoration_standard = strings;
                        RoomDataDictionary.decoration_standard_id = strings_id;
                    }

                }
                findProItemName();
            }
        });

    }


    //查询项目名称
    public void findProItemName(){
        loginModel.getfindProItemName( new ResultCallback<ProItemName>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("查询所有项目名称失败"+e);
                //mViewRef.get().initTabDataNO();
            }

            @Override
            public void onResponse(ProItemName response) {
           //     LogUtils.i("查询所有项目名称成功"+response);
                String[] strings = new String[response.getData().size()];
                String[] id=new String[response.getData().size()];
                for (int i=0;i<response.getData().size();i++){
                    strings[i]=response.getData().get(i).getItem_name();
                    id[i] = response.getData().get(i).getProject_id();
                }
                ClientInfoDataDictionary.page_project=strings;
                ClientInfoDataDictionary.page_project_id=id;
                findProTeamByFKProjectId(id);
            }
        });

    }

    //根据项目id查询项目团队
    public void findProTeamByFKProjectId(final String[] id){
        // LogUtils.i("项目团队id"+);
        if(ClientInfoDataDictionary.page_project_id!=null&&id.length>0)
            loginModel.getfindProTeamByFKProjectId(id[search_progress], new ResultCallback<ProTeamByFKProject>() {
                @Override
                public void onError(Request request, Exception e) {
                    LogUtils.i("项目id查询项目团队失败"+e);

                }

                @Override
                public void onResponse(ProTeamByFKProject response){
                    if(response.getData()!=null||response.getData().equals(""))
                  //      LogUtils.i("项目id查询项目团队成功"+ GsonUtil.GsonString(response));
                    ClientInfoDataDictionary.proTeamByFKProject.add(response);
                    ClientInfoDataDictionary.proTeamByFKProject.get(search_progress).setProject_id(id[search_progress]);
                    search_progress++;
                    if(search_progress<id.length){
                        findProTeamByFKProjectId(id);
                    }
                    //mViewRef.get().initTabDataYes();

                }
            });
    }
}
