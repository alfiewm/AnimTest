package meng.animtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by meng on 16/6/26.
 */
public class ViewAnimFragment extends Fragment implements View.OnClickListener {

    private TextView textView;

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
        textView = (TextView) rootView.findViewById(R.id.textView);
        textView.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.chaos);
        textView.startAnimation(animation);
    }
}
