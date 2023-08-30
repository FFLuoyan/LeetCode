package org.zongjieli.leetcode.question.daily.year2023.month8.week5;

/**
 * 有一只跳蚤的家在数轴上的位置 x 处,请帮助它从位置 0 出发,到达它的家
 * 跳蚤跳跃的规则如下:
 *  它可以往前跳恰好 a 个位置(即往右跳)
 *  它可以往后跳恰好 b 个位置(即往左跳)
 *  它不能连续往后跳 2 次
 *  它不能跳到任何 forbidden 数组中的位置
 * 跳蚤可以往前跳超过它的家的位置,但是它不能跳到负整数的位置
 * 给定一个整数数组 forbidden,其中 forbidden[i] 是跳蚤不能跳到的位置
 * 同时给定整数 a,b,x,请返回跳蚤到家的最少跳跃次数
 * 如果没有恰好到达 x 的可行方案,请返回 -1
 *
 * 1 <= forbidden.length <= 1000
 * 1 <= a, b, forbidden[i] <= 2000
 * 0 <= x <= 2000
 * forbidden 中所有位置互不相同
 * 位置 x 不在 forbidden 中
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/30
 */
public class Z3MinJumpTime {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) {
            return 0;
        }
        int common = a >= b ? common(a, b) : common(b, a), max = 0;
        if (x % common != 0) {
            return -1;
        }
        int[] position = new int[6001];
        for (int i : forbidden) {
            position[i] = -1;
            max = Math.max(max, i);
        }
        max = Math.max(max, x) + a + b;
        jump(a, b, 0, 1, max, false, position);
        return position[x] == 0 ? -1 : position[x];
    }

    public void jump(int a, int b, int current, int time, int max, boolean isBack, int[] position) {
        int next = current - b, pn;
        if (!isBack && next > 0 && (pn  = position[next]) != -1 && (pn == 0 || pn > time)) {
            position[next] = time;
            jump(a, b, next, time + 1, max, true, position);
        }
        if ((next = (current + a)) <= max && (pn  = position[next]) != -1 && (pn == 0 || pn > time)) {
            position[next] = time;
            jump(a, b, next, time + 1, max, false, position);
        }
    }

    public int common(int a, int b) {
        a = a % b;
        if (a == 0) {
            return b;
        }
        return common(b, a);
    }

    public static void main(String[] args) {
        Z3MinJumpTime test = new Z3MinJumpTime();
        // 121
        System.out.println(test.minimumJumps(new int[]{162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98}, 29, 98, 80));
        // 3998
        System.out.println(test.minimumJumps(new int[]{1998}, 1999, 2000, 2000));
    }
}
