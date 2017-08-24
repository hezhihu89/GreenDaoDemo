package com.isuno2.realmdemo;

import android.app.Application;

import com.isuno2.realmdemo.dao.DaoManager;

/**
 * Created by Hezhihu89 on 2017/8/22 0022.
 */

public class APP extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        DaoManager.getInstance().init(this);
    }

}
