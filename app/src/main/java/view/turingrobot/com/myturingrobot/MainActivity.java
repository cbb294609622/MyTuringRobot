package view.turingrobot.com.myturingrobot;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;
import android.widget.FrameLayout;

import view.turingrobot.com.myturingrobot.fragment.HomeFragment;
import view.turingrobot.com.myturingrobot.utils.MyToastUitl;

public class MainActivity extends FragmentActivity {

    private Context mContext;
    private HomeFragment homeFragment;
    private FrameLayout fl_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        MyToastUitl.showToastFlag(mContext, "主界面");

        initView();
        initData();
    }

    /**
     * 初始化布局文件
     */
    private void initView() {
        homeFragment = new HomeFragment();
        fl_main = (FrameLayout) findViewById(R.id.fl_main);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, homeFragment, "HOME").commitAllowingStateLoss();
    }
}
