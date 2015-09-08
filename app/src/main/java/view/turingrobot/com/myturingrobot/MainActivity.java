package view.turingrobot.com.myturingrobot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import view.turingrobot.com.myturingrobot.utils.MyToastUitl;

public class MainActivity extends Activity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        MyToastUitl.showToastFlag(mContext,"主界面");
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
