package view.turingrobot.com.myturingrobot.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import view.turingrobot.com.myturingrobot.R;
import view.turingrobot.com.myturingrobot.base.BaseFragment;
import view.turingrobot.com.myturingrobot.base.BaseListViewAdapter;
import view.turingrobot.com.myturingrobot.view.PullToZoomListView;

/**
 * Created by BoBo on 2015/9/8.
 */
public class HomeFragment extends BaseFragment{

    @ViewInject(R.id.home_plv)
    private PullToZoomListView home_plv;
    private List<String> listName;
    private String[] adapterData = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n"};

    @Override
    public View initView() {
        view = View.inflate(mContext, R.layout.home_fragment,null);
        ViewUtils.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        init();

        home_plv.getHeaderView().setImageResource(R.mipmap.img_home_head);
        home_plv.getHeaderView().setScaleType(ImageView.ScaleType.CENTER_CROP);

        home_plv.setAdapter(new MyAdapter(listName));

    }

    private void init() {
        listName = new ArrayList<String>();
        listName.add("aaaaaa");
        listName.add("bbbbbb");
        listName.add("cccccc");
        listName.add("dddddd");
        listName.add("eeeeee");
        listName.add("ffffff");
        listName.add("gggggg");
        listName.add("hhhhhh");
        listName.add("iiiiii");
        listName.add("jjjjjj");
        listName.add("kkkkkk");
        listName.add("llllll");
        listName.add("mmmmmm");
        listName.add("nnnnnn");
    }

    class MyAdapter extends BaseListViewAdapter<String> {

        public MyAdapter(List<String> list) {
            super(list);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null){
                convertView = View.inflate(mContext,R.layout.home_fragment_lv_item,null);

                holder = new ViewHolder();
                holder.lv_item_name = (TextView) convertView.findViewById(R.id.lv_item_name);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            holder.lv_item_name.setText(list.get(position));

            return convertView;
        }
    }

    class ViewHolder{
        private TextView lv_item_name;
    }
}
