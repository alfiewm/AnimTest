package meng.animtest.asdemo;

@SuppressWarnings("unused")
public class DebuggerDemo {
    private static final String TAG = "DebuggerDemo";
    private static int GLOBAL_INT = 3;

    /**
     * Attach Debugger(Eclipse 貌似没有这个功能)
     */

    /**
     * 条件断点
     */
    public static int conditionalBreakPoint(int value) {
        return value;
    }

    /**
     * log断点
     */
    public static int logBreakPoint(int value) {
        return value;
    }

    /**
     * 标记对象
     */
    public static int markObject(int value) {
        return value;
    }

    /**
     * 只断一次(临时断点)
     */
    public static int breakOnce(int value) {
        return value;
    }

    /**
     * view as
     */
    public static long viewAs(long timeValue) {
        return timeValue;
    }

    /**
     * Debug.waitForDebugger();
     */
}
