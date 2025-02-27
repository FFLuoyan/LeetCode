package org.zongjieli.leetcode.question.daily.year2025.month2.week5;

/**
 * 请设计一个带光标的文本编辑器,它可以实现以下功能:
 *  添加:
 *      在光标所在处添加文本
 *  删除:
 *      在光标所在处删除文本(模拟键盘的删除键)
 *  移动:
 *      将光标往左或者往右移动
 *
 * 当删除文本时,只有光标左边的字符会被删除,光标会留在文本内
 * 也就是说任意时候 0 <= cursor.position <= currentText.length 都成立
 *
 * 请实现 TextEditor 类:
 *  TextEditor():
 *      用空文本初始化对象
 *  void addText(string text):
 *      将 text 添加到光标所在位置,添加完后光标在 text 的右边
 *  int deleteText(int k):
 *      删除光标左边 k 个字符,返回实际删除的字符数目
 *  string cursorLeft(int k):
 *      将光标向左移动 k 次,返回移动后光标左边 min(10, len) 个字符
 *      其中 len 是光标左边的字符数目
 *  string cursorRight(int k):
 *      将光标向右移动 k 次,返回移动后光标左边 min(10, len) 个字符
 *      其中 len 是光标左边的字符数目
 *
 * 1 <= text.length, k <= 40
 * text 只含有小写英文字母
 * 调用 addText, deleteText, cursorLeft 和 cursorRight 的总次数不超过 2 * 10^4 次
 *
 * 进阶: 设计并实现一个每次调用时间复杂度为 O(k) 的解决方案
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/2/27
 */
public class Z4TextEditor {

    static class EditorChar {
        EditorChar before, after;
        char c;

        public EditorChar(char c, EditorChar before, EditorChar after) {
            this.c = c;
            this.before = before;
            this.after = after;
        }
    }

    EditorChar start, end, current;

    public Z4TextEditor() {
        start = new EditorChar(' ', null, null);
        end = new EditorChar(' ', start, null);
        start.after = end;
        current = end;
    }

    public void addText(String text) {
        EditorChar addNextNode = current.before;
        for (char currentChar : text.toCharArray()) {
            addNextNode.after = new EditorChar(currentChar, addNextNode, null);
            addNextNode = addNextNode.after;
        }
        addNextNode.after = current;
        current.before = addNextNode;
    }

    public int deleteText(int k) {
        EditorChar deleteNode = current.before;
        int realDelete = 0;
        while (k > 0 && deleteNode != start) {
            deleteNode = deleteNode.before;
            k--;
            realDelete++;
        }
        deleteNode.after = current;
        current.before = deleteNode;
        return realDelete;
    }

    public String cursorLeft(int k) {
        EditorChar targetCursor = current.before;
        while (k-- > 0 && targetCursor != start) {
            targetCursor = targetCursor.before;
        }
        current = targetCursor.after;
        return cursorLeftString();
    }

    public String cursorRight(int k) {
        while (k-- > 0 && end != current) {
            current = current.after;
        }
        return cursorLeftString();
    }

    public String cursorLeftString() {
        // 左边 min(10, len) 个字符
        char[] values = new char[10];
        int index = 10;
        EditorChar value = current.before;
        while (index > 0 && value != start) {
            values[--index] = value.c;
            value = value.before;
        }
        return new String(values, index, 10 - index);
    }

    public static void main(String[] args) {
        Z4TextEditor editor = new Z4TextEditor();
        editor.addText("leetcode");
        // 4
        System.out.println(editor.deleteText(4));
        editor.addText("practice");
        // etpractice
        System.out.println(editor.cursorRight(3));
        // leet
        System.out.println(editor.cursorLeft(8));
        // 4
        System.out.println(editor.deleteText(10));
        // ''
        System.out.println(editor.cursorLeft(2));
        // practi
        System.out.println(editor.cursorRight(6));
    }
}
