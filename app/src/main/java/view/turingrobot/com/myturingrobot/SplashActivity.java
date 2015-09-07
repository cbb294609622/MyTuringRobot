package view.turingrobot.com.myturingrobot;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import view.turingrobot.com.myturingrobot.utils.ActivityAnimUitl;
import view.turingrobot.com.myturingrobot.utils.MyToastUitl;

/**
 * 广告界面
 * Created by BoBo on 2015/9/2.
 */
public class SplashActivity extends Activity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_splash);
        mContext = SplashActivity.this;
        MyToastUitl.showToastFlag(mContext,"广告界面",MyToastUitl.SHORT_TOAST);
    }
//    @Override
//    public void onBackPressed() {
//        finish();
//        ActivityAnimUitl.isLeftRight(SplashActivity.this);
//        super.onBackPressed();
//    }
}
