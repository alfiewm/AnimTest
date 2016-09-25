package meng.animtest;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import meng.animtest.asdemo.DebuggerDemo;

/**
 * Created by meng on 2016/9/25.
 */

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DebuggerDemo.breakOnce(20);
        for (int i = 0; i < 1000; i++) {
            DebuggerDemo.conditionalBreakPoint(i);
        }
        DebuggerDemo.viewAs(1474778285000L);
        List<Integer> intList = new ArrayList<>();
        intList.addAll(Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
        DebuggerDemo.markObject(intList);
//        DebuggerDemo.startMainActivity(this);
    }
}
