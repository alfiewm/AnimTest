package meng.animtest.asdemo;

import android.app.Fragment;
import android.content.Context;
import android.widget.TextView;

/**
 * Created by meng on 2016/9/25.
 */

@SuppressWarnings("unused")
public class BasicShortcutsDemo extends Fragment {
    private int i;
    private int defaultMaxHeight = 120;

    /**
     * 打开文件
     * Cmd + O
     * Cmd + Shift + O
     * Cmd + Alt + O (path)
     * Cmd + E
     * Shift Shift (tab)
     */
    public void openFile() {
        i = 2;
    }

    /**
     * 导航&搜索
     * 前/后 Cmd + [/]
     * 全局搜索 Cmd + Shift + F
     * 文件结构 Cmd + F12
     * 查看所有引用 Alt + F7
     * 定位到声明 Cmd + B
     * 定位到实现 Cmd + Alt + B
     * 定位到父类或父类方法 Cmd + U
     * 在打开的文件中切换 Ctrl + Tab (同样适用于很多应用,例如Chrome)
     * 定位到下一个高亮错误 F2
     */
    public void navigation() {
        i = 3;
        TextView tv = new TextView(null);
    }

    /**
     * 编辑&重构
     * 格式化文件 Cmd + Alt + L
     * 显示建议操作 Alt + Enter
     * 重构弹窗 Ctrl + T
     * 重命名  Shift + F6
     * 移动 F6
     * 抽出方法 Cmd + Alt + M
     * 抽出变量
     * 内联
     * 上下移动代码块 Cmd/ALt + Shift + Arrow
     */
    public void refactorFunc(Context context) {
        // step 1
        TextView tv = new TextView(context);
        tv.setText("Hello World");
        tv.setMaxHeight(getDefaultMaxHeight());
        if (tv.getText().equals("")) {
            tv.setMaxWidth(234);
        }
        // step 2
        // step 3
    }
    
    public int getDefaultMaxHeight() {
        return defaultMaxHeight;
    }

    /**
     * Live Templates
     * Cmd + J
     * 默认提供了很多比自动补全更强大的补全功能
     * logd/logt/logm/logr/wtf
     */
    public void liveTemplates() {
    }

    /**
     * 万用命令 Cmd + Shift + A
     */
}
