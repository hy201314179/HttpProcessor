package com.solder.client.http;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;



/**
 * 返回结果的基础类
 * Created by snail on 2017/7/14.
 */

public abstract class HttpCallback<Result> implements ICallback {
    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clz = analysisClassInfo(this);
        Result objResult = (Result)gson.fromJson(result,clz);
        onSuccess(objResult);
    }

    public abstract  void  onSuccess(Result result);


    public static  Class<?> analysisClassInfo(Object object){
        Type genType = object.getClass().getGenericSuperclass();

        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        return (Class<?>) params[0];

    }

}
