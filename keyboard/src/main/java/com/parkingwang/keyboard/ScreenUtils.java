package com.parkingwang.keyboard;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;


/**
 * Created by yuan on 2020/9/14.
 * Email:yuanwb@yiche.com
 */
public class ScreenUtils {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

//    /**
//     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
//     */
//    public static int px2dip(float pxValue) {
//        final float scale = GlobalInit.getApplication().getResources().getDisplayMetrics().density;
//        return (int) (pxValue / scale + 0.5f);
//    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }


//    public static int getStatusBarHeight() {
//        Resources resources = GlobalInit.getApplication().getResources();
//        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
//        int height = resources.getDimensionPixelSize(resourceId);
//        return height;
//    }

}
