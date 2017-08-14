package meng.animtest.utils;

import android.support.annotation.FloatRange;

/**
 * Created by meng on 2016/12/15.
 */
public class AnimUtils {

    private AnimUtils() {
    }

    /**
     * 二阶贝塞尔曲线计算公式
     *
     * @param fraction 时间比率
     * @param start    起始值
     * @param end      终止值
     * @param control  控制点值
     * @return 当前值
     */
    public static float quadBezier(@FloatRange(from = 0.0f, to = 1.0f) float fraction, float start,
            float end, float control) {
        float leftFraction = 1 - fraction;
        return leftFraction * leftFraction * start + 2 * fraction * leftFraction * control
                + fraction * fraction * end;
    }

    public static float cubicBezier(@FloatRange(from = 0.0f, to = 1.0f) float fraction,
            float start, float end, float control1, float control2) {
        float leftFraction = 1 - fraction;
        return (float) (Math.pow(leftFraction, 3) * start + Math.pow(leftFraction, 2) * fraction * control1 * 3
                + leftFraction * Math.pow(fraction, 2) * control2 * 3 + Math.pow(fraction, 3) * end);
    }
}