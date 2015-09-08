package view.turingrobot.com.myturingrobot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

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

        MyToastUitl.showToastFlag(mContext,"广告界面");

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(mContext,MainActivity.class));
                ActivityAnimUitl.isRightLeft(SplashActivity.this);
                finish();
            }
        };
        timer.schedule(timerTask,1000*4);
    }
//    @Override
//    public void onBackPressed() {
//        finish();
//        ActivityAnimUitl.isLeftRight(SplashActivity.this);
//        super.onBackPressed();
//    }
}
