package com.dimples.ui.index.tools;

import android.content.Context;
import android.util.TypedValue;

/**
 * dp和px属性值转换工具类
 *
 * @author zhongyj
 * @date 2019/5/11
 */
public class SystemUtil {
    /**
     * dp转px
     *
     * @param context Context
     * @param dpVal   float
     * @return int
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @param context Context
     * @param spVal   float
     * @return int
     */
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.getResources().getDisplayMetrics());
    }

}
