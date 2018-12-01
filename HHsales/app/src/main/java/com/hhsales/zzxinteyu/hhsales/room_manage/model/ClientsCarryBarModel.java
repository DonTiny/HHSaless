package com.hhsales.zzxinteyu.hhsales.room_manage.model;

import android.util.ArrayMap;
import android.util.Log;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.FileBean;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectList;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectNextLevel;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBases;
import com.hhsales.zzxinteyu.hhsales.room_manage.ui.ClientsCarryBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by acer on 2018/4/2.
 */

public class ClientsCarryBarModel implements ClientsCarryBar.Model {

    private List<FileBean> mDatas;
    private RoomMagementBases mRoomMagementBases,mAdvancedSearch;
    private Map<String, String> loadMap = new ArrayMap<>();
    //当前加载到了第几页
    private int CurrentPageNumber = 1;
    private int pageSize=10;
    private boolean internet;
    private List<ProjectList> projectLists;
    private List<ProjectNextLevel> projectNextLevels;


    /**
     * @param load:判断是第一次请求还是加载更多
     * @param getRoomData
     */
    @Override
    public void queryRoom(boolean load,Map parameter, final GetRoomData getRoomData) {
        if (load) {
            if (parameter.size()>0){
                loadMap=parameter;
                CurrentPageNumber=CurrentPageNumber+1;
                loadMap.put("baseModel.pageInfo.cpage", CurrentPageNumber + "");
            }else{
                CurrentPageNumber=CurrentPageNumber+1;
                loadMap.put("baseModel.pageInfo.cpage", CurrentPageNumber + "");
                loadMap.put("baseModel.pageInfo.page_size", pageSize+"");
            }
        } else {
            CurrentPageNumber=1;
            loadMap.put("baseModel.pageInfo.page_size", pageSize+"");
        }
        mRoomMagementBases = new RoomMagementBases();
        OkHttpClientManager.postAsyn(HttpUrl.Query_Room, loadMap, new ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                internet=false;
                getRoomData.getRoomData(internet,null);
            }

            @Override
            public void onResponse(String response) {
                internet=true;
                //把json字符串转化为对象
                mRoomMagementBases= GsonUtil.GsonToBean(response, RoomMagementBases.class);
                getRoomData.getRoomData(internet,mRoomMagementBases);
            }
        });
    }

    @Override
    public void getProjectList(final GetProjectList getProjectList) {
        OkHttpClientManager.getAsyn(HttpUrl.Project, null, new ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                internet = false;
                getProjectList.getProjectList(internet,null);
            }

            @Override
            public void onResponse(String response) throws Exception {
                internet = true;
                JSONObject object = new JSONObject(response);
                if (object.getInt("resultFlag") == 0) {
                    projectLists = new ArrayList<ProjectList>();
                    JSONArray jsonArrayData = object.getJSONArray("data");
                    for (int i = 0; i < jsonArrayData.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArrayData.get(i);
                            ProjectList projectList = new ProjectList();
                            projectList.setProject_id(jsonObject.getString("project_id"));
                            projectList.setFk_parent_item(jsonObject.getString("fk_parent_item"));
                            projectList.setItem_name(jsonObject.getString("item_name"));
                            projectLists.add(projectList);
                        } catch (Exception e) {
                            Log.i("===项目列表===", "出错了！");
                            internet = false;
                        }
                    }
                    getProjectList.getProjectList(internet,projectLists);
                }
            }
        });
    }

    @Override
    public void getProjectNextLevel(String id, final GetProjectNextLevel getProjectNextLevel) {
        OkHttpClientManager.getAsyn(HttpUrl.Choose_Building+id, null, new ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                internet = false;
                getProjectNextLevel.getProjectNextLevel(internet,null);
            }

            @Override
            public void onResponse(String response) throws Exception {
                internet = true;
                JSONObject object = new JSONObject(response);
                if (object.getInt("resultFlag") == 0) {
                    projectNextLevels = new ArrayList<ProjectNextLevel>();
                    JSONArray jsonArrayData = object.getJSONArray("data");
                    if (jsonArrayData.length()>0){
                        for (int i = 0; i < jsonArrayData.length(); i++) {
                            try {
                                JSONObject jsonObject = (JSONObject) jsonArrayData.get(i);
                                ProjectNextLevel projectList = new ProjectNextLevel();
                                projectList.setName(jsonObject.getString("name"));
                                projectList.setBuilding_id(jsonObject.getString("building_id"));
                                projectList.setFk_project_id(jsonObject.getString("fk_project_id"));
                                projectNextLevels.add(projectList);
                            } catch (Exception e) {
                                Log.i("===项目列表===", "出错了！");
                                internet = false;
                            }
                        }
                        getProjectNextLevel.getProjectNextLevel(internet,projectNextLevels);
                    }else{
                        getProjectNextLevel.getProjectNextLevel(internet,null);
                    }
                }
            }
        });
    }

    /**
     * 高级查询
     * @param parameter
     * @param getAdvancedSearch
     */
    @Override
    public void getAdvancedSearch(Map parameter, final GetAdvancedSearch getAdvancedSearch) {
        mAdvancedSearch = new RoomMagementBases();
        OkHttpClientManager.getAsyn(HttpUrl.Advanced_Search, parameter, new ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                internet = false;
                getAdvancedSearch.getAdvancedSearch(internet,null);
            }

            @Override
            public void onResponse(String response) throws Exception {
                //把json字符串转化为对象
                mAdvancedSearch= GsonUtil.GsonToBean(response, RoomMagementBases.class);
                internet = true;
                getAdvancedSearch.getAdvancedSearch(internet,mAdvancedSearch);
            }
        });
    }
}