package meng.animtest;

import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

/**
 * Created by meng on 16/6/26.
 */
public class PropertyAnimFragment extends Fragment implements View.OnClickListener {

    public static final String PROPERTY_TRANSLATION_X = "translationX";
    public static final String PROPERTY_TRANSLATION_Y = "translationY";
    private ValueAnimator yAnimator;
    TextView target;
    ValueAnimator argbValueAnimator;
    ValueAnimator holderAnimator;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PropertyAnimFragment newInstance() {
        return new PropertyAnimFragment();
    }

    public PropertyAnimFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_property_anim, container, false);
        target = (TextView) rootView.findViewById(R.id.textView);
        target.setOnClickListener(this);
        initAnimators();
        return rootView;
    }

    private void initAnimators() {
        // argb animator
        argbValueAnimator = ValueAnimator.ofInt(Color.RED, Color.GREEN);
        argbValueAnimator.setEvaluator(new ArgbEvaluator());
        argbValueAnimator.setDuration(1000);
        argbValueAnimator.setInterpolator(new AccelerateInterpolator());
        argbValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                target.setBackgroundColor((Integer) animation.getAnimatedValue());
            }
        });
        // property holder construct animator
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofObject(PROPERTY_TRANSLATION_X, new FloatEvaluator(), 0.0f, -300.0f);
        PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofObject(PROPERTY_TRANSLATION_Y, new FloatEvaluator(), 0.0f, -500.0f);
        holderAnimator = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolder, propertyValuesHolder2);
        holderAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                target.setTranslationX((Float) animation.getAnimatedValue(PROPERTY_TRANSLATION_X));
                target.setTranslationY((Float) animation.getAnimatedValue(PROPERTY_TRANSLATION_Y));
            }
        });

        Keyframe keyframe = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframe1 = Keyframe.ofFloat(0.5f, 100.0f);
//        keyframe1.setInterpolator(new DecelerateInterpolator());
        Keyframe keyframe2 = Keyframe.ofFloat(1.0f, 1000.0f);
//        keyframe2.setInterpolator(new AccelerateInterpolator());
        yAnimator = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("y", keyframe, keyframe1, keyframe2));
        yAnimator.setDuration(2000);
        yAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                target.setY((Float) animation.getAnimatedValue());
            }
        });
    }

    @Override
    public void onClick(View v) {
//        argbValueAnimator.start();
//        holderAnimator.start();
        yAnimator.start();
    }
}
