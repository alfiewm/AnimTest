package meng.animtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by meng on 16/6/28.
 */
public class InterpolatorFragment extends Fragment {

    public static InterpolatorFragment newInstance() {
        Bundle args = new Bundle();
        InterpolatorFragment fragment = new InterpolatorFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    public InterpolatorFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
