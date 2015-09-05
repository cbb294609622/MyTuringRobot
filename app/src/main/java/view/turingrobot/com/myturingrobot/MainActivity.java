package view.turingrobot.com.myturingrobot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;

        initView();
        initData();

    }

    /**
     * 初始化布局文件
     */
    private void initView() {

    }

    /**
     * 初始化数据
     */
    private void initData() {

    }
}
