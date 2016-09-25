package meng.animtest.asdemo;

import android.content.Context;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by meng on 16/9/17.
 */
@SuppressWarnings("unused")
public class AdvancedShortcutsDemo {
    private static final String TAG = "AdvanceShortcutsDemo";
    private static final String CONSTANT = "I'm a CONSTANT field";
    private Context mContext;

    /**
     * 1. Smart Join: Ctrl + Shift + J
     * Copy concatenated intent.
     */
    public String getDescription() {
        int i;
        i = 2;
        // comments 1
        // comments 2
        
        final String desc = "Quiz"
                + " activity"
                + " description: ";
        return desc + "TAG: " + TAG + "Constant: " + CONSTANT; 
    }

    /**
     * 2.- Completion: Enter vs Tab
     */
    public boolean completion(String first, String second) {
        return first.contains(second);
    }

    /**
     * 3.- instanceof context
     * "." 提示类型相关方法
     * Alt+Enter: 插入转换声明
     */
    public void setContext(Object o) {
        if (o instanceof Context) {
        }
    }

    /**
     * 4.- Multi Cursor
     * Select Next: Ctrl+G
     * Skip: Cmd+G
     * Live Templates 对所有的光标都适用
     * 多个粘贴板
     */
    public void logPlayers() {
    }
    
    // 5.- Navigation
    // Cmd+F12 Navigate (感觉像是Cmd + O,显示当前文件的目录结构)
    // 给当前行添加书签 F3?
    // Ctrl + Shift + 0 添加0号书签
    // Ctrl + 0   回到0号书签

    /**
     * 6.- Extract method
     * Selection with:
     * Alt + up/down
     * Method:
     * Cmd+ALt+M OR Cmd + Shit + A -> Extract Method
     */
    public void values() {
        List<Integer> even = new LinkedList<>();
        List<Integer> odd = new LinkedList<>();
        
        int mod = 0;
        for (int i = 0; i < 10; i++) {
            if (i %2 == mod) {
                even.add(i);
            }
        }
        mod = 1;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == mod) {
                odd.add(i);
            }
        }
    }

    /**
     * 7.- Postfix code templates.
     * 还有很多
     */
    public void postfix() {
        int[] ints = {1, 2, 3, 4};
        // ints.for/fori/forr
        
        Object o = new Object();
        // o.nn
        
    }

    /**
     * 8.- Manipulate if conditions with intents.
     */
    public void conditions(boolean a , boolean b, boolean c, boolean d) {
        if (!(!(c || d) || !(a || b))) {
            Log.d(TAG, "conditions: (!(c || d) || !(a || b)) is true!");
        }
    }

    /**
     * 9.- Ctrl + Space vs Ctrl-Shift-Space (smart!)
     */
    public Context getContext() {
        return null;
    }
    
    private Context createContext() {
        return null;
    }

    /**
     * 10.- local history
     * Ctrl + Shift + A, local history
     */

    /**
     * 回到上个编辑位置Cmd + Shift + Backspace
     */
    private void editingPlace() {
        
    }
}
