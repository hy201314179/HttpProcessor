package com.solder.client.http;

import java.util.Map;

/**
 * 接口类
 * Created by snail on 2017/7/14.
 */

public interface IHttpProcessor {
    // 网络访问 ：post,get ,Del,Update ,put


    void  post(String url, Map<String,Object>params,ICallback callback);

    void  get(String url, Map<String,Object>params,ICallback callback);


}
