package meng.animtest;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by meng on 16/6/26.
 */
public class PropertyAnimFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = PropertyAnimFragment.class.getSimpleName();
    private View targetView;
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
        rootView.findViewById(R.id.resetButton).setOnClickListener(this);
        return rootView;
    }

    private long getDuration() {
        return mDurationSeekbar.getProgress();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.animateButton:
//                runValueAnimator(targetView);
//                runViewPropertyAnimator(targetView);
//                runObjectAnimators(targetView);
//                runObjectAnimator(targetView);
//                runKeyframeAnimation(targetView);
                runShakeAnimation(targetView);
                break;
            case R.id.resetButton:
                AnimHelper.resetView(targetView);
                break;
            default:
                break;
        }
    }

    private void runKeyframeAnimation(View targetView) {
        Keyframe keyframe = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframe1 = Keyframe.ofFloat(0.5f, 100.0f);
        keyframe1.setInterpolator(new DecelerateInterpolator());
        Keyframe keyframe2 = Keyframe.ofFloat(1.0f, 1000.0f);
        keyframe2.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator.ofPropertyValuesHolder(
                PropertyValuesHolder.ofKeyframe(View.Y, keyframe, keyframe1, keyframe2))
                .setDuration(getDuration());
    }

    private void runShakeAnimation(View targetView) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(targetView, View.TRANSLATION_X, 0, 25, -25, 25, -25, 15, -15, 6, -6, 0).setDuration(getDuration());
        objectAnimator.setInterpolator(new AccelerateInterpolator());
        objectAnimator.start();
    }

    private void runValueAnimator(final View targetView) {
        ValueAnimator anim = ValueAnimator.ofFloat(0.0f, 1.0f);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                ArgbEvaluator argbEvaluator = new ArgbEvaluator();
                targetView.setBackgroundColor((Integer) argbEvaluator.evaluate(fraction, 0xFF00FF00, 0xFF0000FF));
                targetView.setScaleX(1.0f + fraction * (0.5f - 1.0f));
                targetView.setRotation(0.0f + fraction * (720.0f - 0.0f));
                targetView.setZ(0.0f + fraction * (20.0f - 0.0f));
            }
        });
        anim.setDuration(getDuration());
        anim.start();
    }

    private void runViewPropertyAnimator(View targetView) {
        targetView.animate().scaleX(0.5f).rotation(720.0f).z(20.0f).setDuration(getDuration()).start();
    }

    private void runObjectAnimators(View targetView) {
        ObjectAnimator.ofFloat(targetView, View.SCALE_X, 0.5f).setDuration(getDuration()).start();
        ObjectAnimator.ofFloat(targetView, View.ROTATION, 720.0f).setDuration(getDuration()).start();
        ObjectAnimator.ofFloat(targetView, View.Z, 20.0f).setDuration(getDuration()).start();
    }

    private void runObjectAnimator(View targetView) {
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.5f);
        PropertyValuesHolder rotationX = PropertyValuesHolder.ofFloat(View.ROTATION_X, 720.0f);
        PropertyValuesHolder z = PropertyValuesHolder.ofFloat(View.Z, 20.0f);
        ObjectAnimator.ofPropertyValuesHolder(targetView, scaleX, rotationX, z).setDuration(getDuration()).start();
    }
}
