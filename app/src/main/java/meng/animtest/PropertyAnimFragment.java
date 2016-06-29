package meng.animtest;

import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by meng on 16/6/26.
 */
public class PropertyAnimFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = PropertyAnimFragment.class.getSimpleName();
    private ValueAnimator yAnimator;
    View targetView;
    ValueAnimator argbValueAnimator;
    ValueAnimator holderAnimator;
    private ObjectAnimator objAnimator;
    private SeekBar mDurationSeekbar;
    private TextView mDurationLabel;
    private static final int INITIAL_DURATION_MS = 750;

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
        targetView = rootView.findViewById(R.id.square);
        mDurationSeekbar = (SeekBar) rootView.findViewById(R.id.durationSeek);
        mDurationLabel = (TextView) rootView.findViewById(R.id.durationLabel);

        // Register listener to update the text label when the SeekBar value is updated
        mDurationSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mDurationLabel.setText(getResources().getString(R.string.animation_duration, i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Set initial progress to trigger SeekBarChangeListener and update UI
        mDurationSeekbar.setProgress(INITIAL_DURATION_MS);
        rootView.findViewById(R.id.animateButton).setOnClickListener(this);
        initAnimators();
        return rootView;
    }

    private long getDuration() {
        return mDurationSeekbar.getProgress();
    }

    private void initAnimators() {
        // argb animator
        argbValueAnimator = ValueAnimator.ofInt(Color.RED, Color.GREEN);
        argbValueAnimator.setEvaluator(new ArgbEvaluator());
        argbValueAnimator.setDuration(getDuration());
        argbValueAnimator.setInterpolator(new AccelerateInterpolator());
        argbValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                targetView.setBackgroundColor((Integer) animation.getAnimatedValue());
            }
        });
        // property holder construct animator
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofObject("scaleX", new FloatEvaluator(), 1.0f, 0.0f, 1.0f);
        PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofObject("scaleY", new FloatEvaluator(), 1.0f, 0.0f, 1.0f);
        holderAnimator = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolder, propertyValuesHolder2);
        holderAnimator.setInterpolator(new AccelerateInterpolator());
        holderAnimator.setDuration(getDuration());
        holderAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                targetView.setScaleX((Float) animation.getAnimatedValue("scaleX"));
                targetView.setScaleY((Float) animation.getAnimatedValue("scaleY"));
            }
        });

        Keyframe keyframe = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframe1 = Keyframe.ofFloat(0.5f, 100.0f);
        keyframe1.setInterpolator(new DecelerateInterpolator());
        Keyframe keyframe2 = Keyframe.ofFloat(1.0f, 1000.0f);
        keyframe2.setInterpolator(new AccelerateInterpolator());
        yAnimator = ValueAnimator.ofPropertyValuesHolder(
                PropertyValuesHolder.ofKeyframe("y", keyframe, keyframe1, keyframe2));
        yAnimator.setDuration(getDuration());
        yAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                targetView.setY((Float) animation.getAnimatedValue());
            }
        });

        objAnimator = ObjectAnimator.ofArgb(targetView, "backgroundColor", 0x80ff0000, 0x8000ff00, 0x800000ff, 0x80ff0000).setDuration(getDuration());
    }

    ObjectAnimator getShakeAnimator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(targetView, "translationX", 0, 25, -25, 25, -25, 15, -15, 6, -6, 0).setDuration(getDuration());
        objectAnimator.setInterpolator(new AccelerateInterpolator());
        return objectAnimator;
    }

    @Override
    public void onClick(View v) {
//        targetView.animate().setDuration(getDuration()).scaleX(0.5f).rotation(720.0f).z(20.0f).start();
//        ObjectAnimator.ofFloat(targetView, "translationX", 0, 25, -25, 25, -25, 15, -15, 6, -6, 0)
//                .setDuration(getDuration()).start();
//        argbValueAnimator.start();
//        holderAnimator.start();
//        yAnimator.start();
//        AnimatorSet set = new AnimatorSet();
//        set.playTogether(objAnimator, holderAnimator, getShakeAnimator());
//        set.start();
//        getShakeAnimator().start();
        
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new IntEvaluator());
        valueAnimator.setIntValues(0, 100, 0, 100, 0);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d(TAG, "onAnimationUpdate: value = " + animation.getAnimatedValue());
            }
        });
        valueAnimator.start();
    }
}
