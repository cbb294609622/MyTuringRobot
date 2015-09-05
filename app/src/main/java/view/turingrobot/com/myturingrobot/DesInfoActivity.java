package view.turingrobot.com.myturingrobot;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;


/**
 * Created by BoBo on 2015/9/2.
 */
public class DesInfoActivity extends Activity {

    private Context mContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desinfo);
        mContext = DesInfoActivity.this;

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
