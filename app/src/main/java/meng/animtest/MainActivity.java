package meng.animtest;

import android.animation.TimeAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import meng.animtest.asdemo.BasicShortcutsDemo;

public class MainActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.fps)
    TextView fpsView;
    private static boolean sShowFps = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BasicShortcutsDemo.navigation(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        setupFpsMonitor();
    }
    
    private BasicShortcutsDemo.TestListener testListener = new BasicShortcutsDemo.TestListener() {
        @Override
        public void onEvent() {
            // TODO(mwang): 2016/9/25 xxxx 
            // FIXME(mwang): 2016/9/25 REMOVE THIS
            // do nothing
        }
    };

    private void setupFpsMonitor() {
        TimeAnimator timeAnimator = new TimeAnimator();
        timeAnimator.setTimeListener(new TimeAnimator.TimeListener() {
            private double fps = -1.0d;

            @Override
            public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
                if (!sShowFps) {
                    return;
                }
                double currentFps;
                if (deltaTime != 0) {
                    currentFps = 1000.0 / (double) deltaTime;
                } else {
                    currentFps = 0.9 * fps;
                }
                if (fps < 0.0) {
                    fps = currentFps;
                } else {
                    fps = 0.9 * fps + 0.1 * currentFps; // 计算平均值
                }
                fpsView.setText(String.format("fps:%.2f", fps));
            }
        });
        timeAnimator.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.show_fps) {
            item.setChecked(!item.isChecked());
            sShowFps = item.isChecked();
            fpsView.setVisibility(sShowFps ? View.VISIBLE : View.GONE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public static final int CART_ANIM_IDX = 0;
        public static final int DRAWABLE_ANIM_IDX = 1;
        public static final int VIEW_ANIM_IDX = 2;
        public static final int PROPERTY_ANIM_IDX = 3;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case CART_ANIM_IDX:
                    return CartAnimFragment.newInstance();
                case DRAWABLE_ANIM_IDX:
                    return DrawableAnimFragment.newInstance();
                case VIEW_ANIM_IDX:
                    return ViewAnimFragment.newInstance();
                case PROPERTY_ANIM_IDX:
                    return PropertyAnimFragment.newInstance();
                default:
                    return PlaceholderFragment.newInstance(position + 1);
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case CART_ANIM_IDX:
                    return "Cart Anim";
                case DRAWABLE_ANIM_IDX:
                    return "Drawable Anim";
                case VIEW_ANIM_IDX:
                    return "View Anim";
                case PROPERTY_ANIM_IDX:
                    return "Property Anim";
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        AnimationDrawable animationDrawable;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            rootView.setBackgroundResource(R.drawable.traffic_lights);
            animationDrawable = (AnimationDrawable) rootView.getBackground();
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animationDrawable.start();
                }
            });
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }
}
