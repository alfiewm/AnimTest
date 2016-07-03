package meng.animtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by meng on 16/6/26.
 */
public class ViewAnimFragment extends Fragment {

    @BindView(R.id.textView)
    TextView targetView;
    private Unbinder unbinder;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ViewAnimFragment newInstance() {
        ViewAnimFragment fragment = new ViewAnimFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ViewAnimFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_anim, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick(R.id.setButton)
    public void onSetClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.set);
        targetView.startAnimation(animation);
    }

    @OnClick(R.id.alphaButton)
    public void onAlphaClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha);
        targetView.startAnimation(animation);
    }

    @OnClick(R.id.rotateButton)
    public void onRotateClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        targetView.startAnimation(animation);
    }

    @OnClick(R.id.translateButton)
    public void onTranslateClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.translate);
        targetView.startAnimation(animation);
    }

    @OnClick(R.id.scaleButton)
    public void onScaleClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.scale);
        targetView.startAnimation(animation);
    }
}
