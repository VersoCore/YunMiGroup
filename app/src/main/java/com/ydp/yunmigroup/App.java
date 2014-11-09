package com.ydp.yunmigroup;

import android.app.Application;
import android.content.Context;

/**
 * Created by YDP on 2014/11/7.
 */
public class App extends Application {

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }
}
