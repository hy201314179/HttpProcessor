package com.solder.client;

import android.app.Application;

import com.solder.client.http.HttpHelper;
import com.solder.client.http.XutilsProcessor;

/**
 * Created by snail on 2017/7/14.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       // HttpHelper.init(new VolleyProcessor(this));
       // HttpHelper.init(new OkHttpProcessor());
        HttpHelper.init(new XutilsProcessor(this));
    }
}
