package view.turingrobot.com.myturingrobot;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

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
        setContentView(R.layout.activity_splash);
        mContext = SplashActivity.this;

        MyToastUitl.showToast(mContext,"广告界面",MyToastUitl.SHORT_TOAST);
    }
}
