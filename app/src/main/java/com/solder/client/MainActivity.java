package com.solder.client;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.solder.client.bean.PhotoSetInfo;
import com.solder.client.http.HttpCallback;
import com.solder.client.http.HttpHelper;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_show;
    private Button button;
    private Map<String, Object> params = new HashMap<>();
    private final String TAG = "MainActivity";
    private String Url = "http://c.3g.163.com/photo/api/set/0001%2F2250173.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_show = (TextView) findViewById(R.id.tv_show);
        button = (Button) findViewById(R.id.bt_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_button:
                HttpHelper.obtain().post(Url, params, new HttpCallback<PhotoSetInfo>() {
                    @Override
                    public void onSuccess(PhotoSetInfo result) {
                        StringBuilder sb = new StringBuilder();

                        if (result != null) {
                            sb.append("来源： ")
                                    .append(result.getSource())
                                    .append("\r\n")
                                    .append("Tag:")
                                    .append(result.getSettag())
                                    .append("\r\n")
                                    .append("天气描述：")
                                    .append(result.getDesc());
                        }
                        tv_show.setText(sb.toString());

                    }

                    @Override
                    public void onFailure(String e) {
                        Toast.makeText(MainActivity.this, "Oh,my god @@@@@@@@@@@@@,网络失败了", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, e);
                    }
                });
                break;
        }
    }
}
