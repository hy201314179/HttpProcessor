package com.solder.client.http;

/**
 * Created by snail on 2017/7/14.
 */

public interface ICallback {

     void onSuccess(String result);
     void onFailure(String e);
}
