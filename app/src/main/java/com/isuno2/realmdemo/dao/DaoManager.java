package com.isuno2.realmdemo.dao;

import android.content.Context;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by Hezhihu89 on 2017/8/24 0024.
 */

public class DaoManager {
    private static final DaoManager ourInstance = new DaoManager();
    private static final String DB_NAME = "SUNO2.db";
    private DaoMaster.DevOpenHelper openHelper;

    private Context context;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static DaoManager getInstance() {
        return ourInstance;
    }

    private DaoManager() {
    }

    public void  init(Context context){
        this.context = context;
    }

    /**
     * 判断数据库是否存在，如果不存在则创建
     * @return
     */
    public DaoMaster getDaoMaster(){
        if (null == mDaoMaster){
            openHelper =  new DaoMaster.DevOpenHelper(context,DB_NAME,null);
            mDaoMaster = new DaoMaster(openHelper.getWritableDatabase());
        }
        return mDaoMaster;
    }

    /**
     * 完成对数据库的增删查找
     * @return
     */
    public DaoSession getDaoSession(){
        if (null == mDaoSession){
            if (null == mDaoMaster){
                mDaoMaster = getDaoMaster();
            }
            mDaoSession = mDaoMaster.newSession();
        }
        return mDaoSession;
    }

    /**
     * 设置debug模式开启或关闭，默认关闭
     * @param flag
     */
    public void setDebug(boolean flag){
        QueryBuilder.LOG_SQL = flag;
        QueryBuilder.LOG_VALUES = flag;
    }

    /**
     * 关闭数据库
     */
    public void closeDataBase(){
        closeHelper();
        closeDaoSession();
    }

    public void closeDaoSession(){
        if (null != mDaoSession){
            mDaoSession.clear();
            mDaoSession = null;
        }
    }

    public  void  closeHelper(){
        if (openHelper!=null){
            openHelper.close();
            openHelper = null;
        }
    }
}
