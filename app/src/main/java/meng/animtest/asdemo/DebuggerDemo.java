package meng.animtest.asdemo;

import android.content.Context;
import android.content.Intent;

import java.util.List;

import meng.animtest.MainActivity;

@SuppressWarnings("unused")
public class DebuggerDemo {
    private static final String TAG = "DebuggerDemo";

















    /**
     * Attach Debugger(Eclipse 貌似没有这个功能)
     * 神技,默认没有快捷键,强烈建议设置一个
     */









    /**
     * 变量断点
     */
    private static int GLOBAL_INT = 3;
















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
    public static void markObject(List<Integer> integerList) {
        GLOBAL_INT = 2;
    }





















    /**
     * 只断一次(临时断点) Cmd + Alt + Shift + F8
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
     * 调试应用启动瞬间,例如做启动优化
     *
     * Debug.waitForDebugger();
     */











    /**
     * Analyze data flow to here
     */
    public static void startMainActivity(Context context) {
        Intent it = new Intent(context, MainActivity.class);
        context.startActivity(it);
    }











    /**
     * 分析外来堆栈信息
     */
    /*
    09-25 14:00:21.422 10920-10920/? E/AndroidRuntime: FATAL EXCEPTION: main
           Process: meng.animtest, PID: 10920
           Theme: themes:{default=, fontPkg:com.kapp.cm.theme.custom_1198442609}
           java.lang.RuntimeException: Unable to create application meng.animtest.DemoApplication: android.util.AndroidRuntimeException: Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?
               at android.app.ActivityThread.handleBindApplication(ActivityThread.java:4754)
               at android.app.ActivityThread.-wrap1(ActivityThread.java)
               at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1424)
               at android.os.Handler.dispatchMessage(Handler.java:102)
               at android.os.Looper.loop(Looper.java:148)
               at android.app.ActivityThread.main(ActivityThread.java:5461)
               at java.lang.reflect.Method.invoke(Native Method)
               at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
               at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
            Caused by: android.util.AndroidRuntimeException: Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?
               at android.app.ContextImpl.startActivity(ContextImpl.java:682)
               at android.app.ContextImpl.startActivity(ContextImpl.java:669)
               at android.content.ContextWrapper.startActivity(ContextWrapper.java:337)
               at meng.animtest.asdemo.DebuggerDemo.startMainActivity(DebuggerDemo.java:186)
               at meng.animtest.DemoApplication.onCreate(DemoApplication.java:27)
               at android.app.Instrumentation.callApplicationOnCreate(Instrumentation.java:1014)
               at android.app.ActivityThread.handleBindApplication(ActivityThread.java:4751)
               at android.app.ActivityThread.-wrap1(ActivityThread.java) 
               at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1424) 
               at android.os.Handler.dispatchMessage(Handler.java:102) 
               at android.os.Looper.loop(Looper.java:148) 
               at android.app.ActivityThread.main(ActivityThread.java:5461) 
               at java.lang.reflect.Method.invoke(Native Method) 
               at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726) 
               at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616) 
     */
}
