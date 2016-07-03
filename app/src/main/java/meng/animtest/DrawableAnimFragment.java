package meng.animtest;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by meng on 16/6/26.
 */
public class DrawableAnimFragment extends Fragment {

    private TextView textView;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DrawableAnimFragment newInstance() {
        DrawableAnimFragment fragment = new DrawableAnimFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public DrawableAnimFragment() {
    }

    private AnimationDrawable animationDrawable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drawable_anim, container, false);
        textView = (TextView) rootView.findViewById(R.id.textView);
        setupDrawableAnimation();
        return rootView;
    }

    private void setupDrawableAnimation() {
        //noinspection deprecation
        animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.traffic_lights);
        textView.setBackground(animationDrawable);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animationDrawable.isRunning()) {
                    animationDrawable.stop();
                } else {
                    animationDrawable.start();
                }
            }
        });
    }
}
