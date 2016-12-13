package meng.animtest;

import android.app.Application;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
=======
>>>>>>> disable as demo application.

import meng.animtest.asdemo.BasicShortcutsDemo;

/**
 * Created by meng on 2016/9/25.
 */

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        Debug.waitForDebugger();
<<<<<<< HEAD
        DebuggerDemo.breakOnce(20);
        DebuggerDemo.viewAs(1474778285000L);
        List<Integer> intList = new ArrayList<>();
        intList.addAll(Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
        DebuggerDemo.markObject(intList);
        for (Integer integer : intList) {
            DebuggerDemo.conditionalBreakPoint(integer);
        }
        DebuggerDemo.logBreakPoint(324);
=======
//        DebuggerDemo.breakOnce(20);
//        DebuggerDemo.viewAs(1474778285000L);
//        List<Integer> intList = new ArrayList<>();
//        intList.addAll(Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
//        DebuggerDemo.markObject(intList);
//        for (Integer integer : intList) {
//            DebuggerDemo.conditionalBreakPoint(integer);
//        }
//        DebuggerDemo.logBreakPoint(324);
>>>>>>> disable as demo application.
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
