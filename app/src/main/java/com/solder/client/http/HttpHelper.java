package com.solder.client.http;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 代理类
 * Created by snail on 2017/7/14.
 */

public class HttpHelper implements IHttpProcessor{
    private static  IHttpProcessor mHttpProcessor =null;


    public static void init(IHttpProcessor httpProcessor){
        mHttpProcessor =httpProcessor;
    }

    private static  HttpHelper instance;
    private HttpHelper () {

    }
    public static  HttpHelper obtain(){
        synchronized (HttpHelper.class) {
            if(instance==null){
                instance = new HttpHelper();
            }
        }
        return instance;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
        final  String finalUrl = appendParams(url,params);
        mHttpProcessor.post(finalUrl,params,callback);
    }


    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        final  String finalUrl = appendParams(url,params);

        mHttpProcessor.get(finalUrl,params,callback);

    }

    private String appendParams(String url, Map<String, Object> params) {
        if(params ==null ||params.isEmpty()){
            return  url;
        }

        StringBuilder urlBuilder = new StringBuilder();

        if(urlBuilder.indexOf("?")<=0){
            urlBuilder.append("?");
        }else{
            if(!urlBuilder.toString().endsWith("?")){
                urlBuilder.append("&");
            }
        }

        for (Map.Entry<String,Object> entry : params.entrySet()){
            urlBuilder.append(entry.getKey()).append("=").append(encode(entry.getValue().toString()));

        }
        return  urlBuilder.toString();
    }


    // URI不允许有空格等字符，如果参数值空格，需要此方法转换
    private static String  encode(String str ){
        try {
            return URLEncoder.encode(str,"utf-8");
        }catch (UnsupportedEncodingException e){
            // 针对不支持的编码时报错 ，utf-8 是支持的

            Log.e("参数转码异常",e.toString());
            throw  new RuntimeException(e);

        }
    }

}
