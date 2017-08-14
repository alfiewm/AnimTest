package meng.animtest.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import meng.animtest.R;

/**
 * Created by meng on 2017/8/14.
 */
public class DurationSettingView extends LinearLayout {

    public DurationSettingView(Context context) {
        this(context, null);
    }

    public DurationSettingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DurationSettingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @BindView(R.id.duration_seek)
    SeekBar durationSeekBar;
    @BindView(R.id.duration_text)
    TextView durationTextView;

    private void init() {
        inflate(getContext(), R.layout.view_duration_setting, this);
        ButterKnife.bind(this, this);
        durationSeekBar.setMax(5000);
        durationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                durationTextView.setText(getResources().getString(R.string.animation_duration, i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        durationSeekBar.setProgress(1000);
    }

    public int getDuration() {
        return durationSeekBar == null ? 0 : durationSeekBar.getProgress();
    }
}
