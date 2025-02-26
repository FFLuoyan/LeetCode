package org.zongjieli.leetcode.question.daily.year2025.month2.week5;

/**
 * 有一个只支持单个标签页的浏览器,最开始浏览的网页是 homepage
 * 可以访问其他的网站 url,也可以在浏览历史中后退 steps 步或前进 steps 步
 * 请实现 Z3BrowserHistory 类:
 *  BrowserHistory(string homepage):
 *      用 homepage 初始化浏览器类
 *  void visit(string url):
 *      从当前页跳转访问 url 对应的页面,执行此操作会把浏览历史前进的记录全部删除
 *  string back(int steps):
 *      在浏览历史中后退 steps 步,如果只能在浏览历史中后退至多 x 步且 steps > x
 *      那么只后退 x 步,请返回后退至多 steps 步以后的 url
 *  string forward(int steps):
 *      在浏览历史中前进 steps 步,如果只能在浏览历史中前进至多 x 步且 steps > x
 *      那么只前进 x 步,请返回前进至多 steps 步以后的 url
 *
 * 1 <= homepage.length <= 20
 * 1 <= url.length <= 20
 * 1 <= steps <= 100
 * homepage 和 url 都只包含 '.' 或者小写英文字母
 * 最多调用 5000 次 visit, back 和 forward 函数
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/2/26
 */
public class Z3BrowserHistory {

    private String[] history;

    private int index;

    private int size;

    public Z3BrowserHistory(String homepage) {
        history = new String[20];
        history[0] = homepage;
        index = 0;
        size = 1;
    }

    public void visit(String url) {
        if (index == history.length - 1) {
            // 扩容
            String[] newHistory = new String[history.length * 2];
            System.arraycopy(history, 0, newHistory, 0, history.length);
            history = newHistory;
        }
        history[++index] = url;
        size = index + 1;
    }

    public String back(int steps) {
        index = Math.max(0, index - steps);
        return history[index];
    }

    public String forward(int steps) {
        index = Math.min(index + steps, size - 1);
        return history[index];
    }

}
