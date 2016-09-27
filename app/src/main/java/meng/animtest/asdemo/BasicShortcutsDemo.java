package meng.animtest.asdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by meng on 2016/9/25.
 */

@SuppressWarnings("unused")
public class BasicShortcutsDemo extends Fragment {
    private int i;
    private int defaultMaxHeight = 120;



    /**
     * 万能命令 Cmd + Shift + A
     */











    /**
     * Shift Shift (tab)
     */
    public void openFile() {
        i = 2;
    }











    /**
     * Alt + F1
     */













    /**
     * 定位到下一个高亮错误 F2
     * 建议操作 Alt + Enter
     */
    public static void navigation(Context context) {
        TextView tv = new TextView(context);
        if (testListener != null) {
            testListener.onEvent();
        }
    }

    public static TestListener testListener;
    public interface TestListener {
        void onEvent();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }












    /**
     * 重构弹窗 Ctrl + T
     * 上下移动代码块 Cmd/ALt + Shift + Arrow
     */
    public void refactorFunc(Context context) {
        // step 1
        TextView tv = new TextView(context);
        tv.setText("Hello World");
        if (tv.getText().equals("")) {
            tv.setMaxWidth(234);
        }
        tv.setMaxHeight(getDefaultMaxHeight());
        // step 2
        // ...
        // step 3
        // ...
    }

    public int getDefaultMaxHeight() {
        return defaultMaxHeight;
    }











    /**
     * Live Templates
     * 
     * Cmd + J
     * logd/logt/logm/logr/wtf
     * ifn/inn
     * visible/gone
     * todo/fixme
     */
    public void liveTemplates(TextView tv) {
    }


    /**
     *
     */
}
