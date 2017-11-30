package meng.animtest.utils;

import android.content.Context;

/**
 * Created by meng on 2017/11/30.
 */
public class DimenUtils {

    private static Context mContext;

    protected DimenUtils() {
    }

    public static void init(Context context) {
        mContext = context;
    }

    public static int dip2px(float dip) {
        return (int) (dip * mContext.getResources().getDisplayMetrics().density);
    }

    public static int getScreenWidth() {
        return mContext.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return mContext.getResources().getDisplayMetrics().heightPixels;
    }
}
