package org.zongjieli.leetcode.question.daily.year2023.month8.week4;

/**
 * 给定两个字符串 start 和 target,长度均为 n
 * 每个字符串仅由字符 'L'、'R' 和 '_' 组成,其中:
 * 字符 'L' 和 'R' 表示片段,其中片段 'L' 只有在其左侧直接存在一个空位时才能向左移动
 * 而片段 'R' 只有在其右侧直接存在一个空位时才能向右移动
 * 字符 '_' 表示可以被任意 'L' 或 'R' 片段占据的空位
 * 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target,返回 true,否则返回 false
 *
 * n == start.length == target.length
 * 1 <= n <= 10^5
 * start 和 target 由字符 'L'、'R' 和 '_' 组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/21
 */
public class Z1MoveEqual {

    public boolean canChange(String start, String target) {
        int length = start.length(), si = 0, ti = length, value, cv;
        if (length != target.length()) {
            return false;
        }
        int[] ci = new int[length];
        byte[] svs = start.getBytes(), tvs = target.getBytes();
        for (int i = 0; i < svs.length; i++) {
            if ((value = svs[i]) != '_') {
                ci[si++] = (value == 'L' ? i + 1 : -i - 1);
            }
        }
        while (ti > 0 && si > 0) {
            if ((value = tvs[--ti]) != '_' && (((value = (value == 'L' ? ti + 1: -ti - 1)) ^ (cv = ci[--si])) < 0 || cv < value)) {
                return false;
            }
        }
        while (--ti >= 0 && tvs[ti] == '_') {}
        return si == 0 && ti == -1;
    }

    public static void main(String[] args) {
        Z1MoveEqual test = new Z1MoveEqual();
        // true
        System.out.println(test.canChange("_L__R__R_", "L______RR"));
        // true
        System.out.println(test.canChange("R____RR", "_R___RR"));
    }
}
