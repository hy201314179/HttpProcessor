package com.solder.client.http;

import android.util.Log;

import com.solder.client.MyApp;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * Created by snail on 2017/7/14.
 */

public class XutilsProcessor implements IHttpProcessor {
    private final  String  TAG = "XutilsProcessor";

    public  XutilsProcessor (MyApp app){
        x.Ext.init(app);

    }
    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams  = new RequestParams(url);

        x.http().post(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e(TAG,"onSuccess"+result);
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG,"onError"+ex.toString());

                callback.onFailure(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams  = new RequestParams(url);

        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG,"onSuccess"+result);
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG,"onError"+ex.toString());

                callback.onFailure(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
