package view.turingrobot.com.myturingrobot.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import view.turingrobot.com.myturingrobot.R;
import view.turingrobot.com.myturingrobot.base.BaseFragment;
import view.turingrobot.com.myturingrobot.base.BaseListViewAdapter;
import view.turingrobot.com.myturingrobot.utils.MyToastUitl;
import view.turingrobot.com.myturingrobot.view.GaussianBlurFilter;
import view.turingrobot.com.myturingrobot.view.ProcessImageTask;

/**
 * Created by BoBo on 2015/9/8.
 */
public class HomeFragment extends BaseFragment {

    private ListView home_plv;
    private ImageView home_img;
    private LinearLayout home_fment_ll;
    //在动画开始与结束的地方速率改变比较慢，在中间的时候加速
    private AccelerateDecelerateInterpolator mSmoothInterpolator;
    //存储了home_fment_rl的高度的变量
    private int mActionBarSize;
    //ListView的头布局文件
    private RelativeLayout mListViewHeader;
    private int mMinHeaderTranslation;
    private ProcessImageTask mProcessImageTask;
    private Drawable imgPic;
    private ImageView img;
    private List<String> listItem;
    private ImageView home_fment_pic;

    @Override
    public View initView() {
        view = View.inflate(mContext, R.layout.home_fragment, null);
        return view;
    }

    @Override
    public void initData() {

        init();

        home_plv = (ListView) mContext.findViewById(R.id.home_plv);
        home_img = (ImageView) mContext.findViewById(R.id.home_img);
        home_fment_ll = (LinearLayout) mContext.findViewById(R.id.home_fment_ll);
        home_fment_pic = (ImageView) mContext.findViewById(R.id.home_fment_pic);

        mSmoothInterpolator = new AccelerateDecelerateInterpolator();
        LayoutParams layoutParams = home_fment_ll.getLayoutParams();
        mActionBarSize = layoutParams.height;
        mListViewHeader = (RelativeLayout) mContext.getLayoutInflater().inflate(
                R.layout.home_fragment_lv_header, null);
        home_plv.addHeaderView(mListViewHeader);
        img = (ImageView) mContext.findViewById(R.id.img);
        home_plv.setAdapter(new MyAdapter(listItem));
        initFill();
        //ListView的点击事件
        home_plv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==0){
                    return;
                }
                MyToastUitl.showToast(mContext,listItem.get(position-1),MyToastUitl.SHORT_TOAST);
            }
        });
        home_fment_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyToastUitl.showToast(mContext,"侧拉",MyToastUitl.SHORT_TOAST);
            }
        });
    }

    private void init() {
        listItem = new ArrayList<String>();
        listItem.add("ListView控件的特效");
        for (int i = 1;i<=20;i++){
            listItem.add("ListView=="+i);
        }
    }

    private void initFill() {
        imgPic = img.getDrawable();

        home_plv.setOnScrollListener(new OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                int scrollY = getScrollY();
                home_img.setTranslationY(Math.max(-scrollY,
                        mMinHeaderTranslation));
                float alpha = clamp(home_img.getTranslationY()
                        / mMinHeaderTranslation, 0.0f, 1.0f);
                float actual = clamp(
                        1.0f - mSmoothInterpolator.getInterpolation(alpha),
                        0.0f, 1.0f);
                home_img.setAlpha(1.0f - actual);
            }
        });

        home_img.post(new Runnable() {
            @Override
            public void run() {
				/* 获取滚动的最小值 */
                mMinHeaderTranslation = -home_img.getMeasuredHeight()
                        + mActionBarSize;
            }
        });

        mProcessImageTask = new ProcessImageTask(mContext, new GaussianBlurFilter(),imgPic);
        mProcessImageTask.setCallBack(new ProcessImageTask.CallBack() {
            @Override
            public void complete(Bitmap bitmap) {
                home_img.setImageBitmap(bitmap);
            }
        });
        mProcessImageTask.execute();

    }

    public static float clamp(float value, float min, float max) {
        return Math.max(Math.min(value, max), min);
    }

    protected int getScrollY() {
        int scrollY = 0;
        int itemScrollY = 0;
        int itemNum = home_plv.getFirstVisiblePosition();
        View firstVisible = home_plv.getChildAt(0);
        if (firstVisible == null) {
            return scrollY;
        }
        if (itemNum >= 1) {
            itemScrollY = mListViewHeader.getMeasuredHeight();
        }
        scrollY = itemScrollY - firstVisible.getTop();
        return scrollY;
    }

    class MyAdapter extends BaseListViewAdapter<String>{

        public MyAdapter(List<String> list) {
            super(list);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null){
                convertView = View.inflate(mContext,R.layout.home_fragment_lv_item,null);

                holder = new ViewHolder();
                holder.item_title = (TextView) convertView.findViewById(R.id.item_title);

                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.item_title.setText(list.get(position));

            return convertView;
        }
    }
    class ViewHolder{
        private TextView item_title;
    }
}
