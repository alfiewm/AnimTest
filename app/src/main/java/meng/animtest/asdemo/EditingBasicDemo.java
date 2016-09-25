package meng.animtest.asdemo;

import android.widget.TextView;

/**
 * Created by meng on 2016/9/25.
 */

@SuppressWarnings("unused")
public class EditingBasicDemo {
    private int i;
    /**
     * 打开文件
     * Cmd + O
     * Cmd + Shift + O
     * Cmd + Alt + O (path)
     * Cmd + E
     * Shift Shift (tab)
     */
    public void function1() {
        i = 2;
    }

    /**
     * 导航&搜索
     * 前/后 Cmd + [/]
     * 全局搜索 Cmd + Shift + F
     * 文件结构 Cmd + F12
     * 在打开的文件中切换 Ctrl + Tab (同样适用于很多应用,例如Chrome)
     * 定位到下一个高亮错误 F2
     */
    public void function2() {
        i = 3;
        TextView tv = new TextView(null);
    }
    
    
}
