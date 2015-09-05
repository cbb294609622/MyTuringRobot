package view.turingrobot.com.myturingrobot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import view.turingrobot.com.myturingrobot.utils.MyToastUitl;
import view.turingrobot.com.myturingrobot.utils.SharedPreferencesUitl;

/**
 * 引导界面
 * Created by BoBo on 2015/9/2.
 */
public class GuideActivity extends Activity {
    private Context mContext;
    private ViewPager guide_vp;

    private int[] imgUrl = {R.mipmap.pager1, R.mipmap.pager2, R.mipmap.pager3, R.mipmap.pager4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mContext = GuideActivity.this;
        initView();
        initData();

    }

    private void initView() {
        guide_vp = (ViewPager) findViewById(R.id.guide_vp);
    }

    private void initData() {
        boolean isForst = SharedPreferencesUitl.getBooleanData(mContext, "isForst", false);
        isForst = false;
        if (isForst) {
            //不是第一次进入应用
            MyToastUitl.showToast(mContext, "不是第一次进入", MyToastUitl.SHORT_TOAST);
            forwardSplash();
        } else {
            //是第一次进入应用
            MyToastUitl.showToast(mContext, "是第一次进入", MyToastUitl.LONG_TOAST);
            SharedPreferencesUitl.saveBooleanData(mContext, "isForst", true);
            initFill();
        }
    }

    /**
     * 进入广告页面
     */
    private void forwardSplash() {
        startActivity(new Intent(mContext, SplashActivity.class));
    }

    /**
     * 界面展示
     */
    private void initFill() {

//    guide_vp.setAdapter();

    }

    class MyAdapter extends PagerAdapter{



        @Override
        public int getCount() {
            return imgUrl.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
