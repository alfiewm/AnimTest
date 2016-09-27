package meng.animtest;

import android.app.Application;
import android.os.Debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import meng.animtest.asdemo.BasicShortcutsDemo;
import meng.animtest.asdemo.DebuggerDemo;

/**
 * Created by meng on 2016/9/25.
 */

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Debug.waitForDebugger();
        DebuggerDemo.breakOnce(20);
        DebuggerDemo.viewAs(1474778285000L);
        List<Integer> intList = new ArrayList<>();
        intList.addAll(Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
        DebuggerDemo.markObject(intList);
        for (Integer integer : intList) {
            DebuggerDemo.conditionalBreakPoint(integer);
        }
        DebuggerDemo.logBreakPoint(324);
//        DebuggerDemo.startMainActivity(this);
    }
    
    public BasicShortcutsDemo.TestListener testListener = new BasicShortcutsDemo.TestListener() {
        @Override
        public void onEvent() {
            // do nothing.
            // FIXME(mwang): 16/9/25 remove this
        }
    };
}
