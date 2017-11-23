package com.baway.liuheng.ddxxgd.app;

import android.app.Application;

import com.bw.LH.greendao.gen.DaoMaster;
import com.bw.LH.greendao.gen.DaoSession;
import com.bw.LH.greendao.gen.UserDao;

/**
 * Created by lenovo on 2017/11/23.
 */

public class App extends Application {
    public static UserDao userDao;
    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "lenvess.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
    }
}
