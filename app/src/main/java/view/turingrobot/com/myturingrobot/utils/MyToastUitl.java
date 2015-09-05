package view.turingrobot.com.myturingrobot.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast提示
 * Created by BoBo on 2015/9/2.
 */
public class MyToastUitl {
    public final static int SHORT_TOAST = 0;
    public final static int LONG_TOAST = 1;

    public static void showToast(Context context,String str,int sl){
        switch (sl){
            case SHORT_TOAST:
                Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
                break;
            case LONG_TOAST:
                Toast.makeText(context,str,Toast.LENGTH_LONG).show();
                break;
        }
    }
}
