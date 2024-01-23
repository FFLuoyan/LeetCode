package org.zongjieli.leetcode.question.daily.year2024.month1.week4;

/**
 * 给定一个非负整数,至多可以交换一次数字中的任意两位,返回能得到的最大值
 * 给定数字的范围是 [0, 10^8]
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/23
 */
public class Z1ChangeMax {

    public int maximumSwap(int num) {
        int[] values = new int[9], count = new int[10];
        int ci = -1, remain, max = 9, mi = 0, result = 0, before = num;
        while (num > 0) {
            remain = num % 10;
            values[++ci] = remain;
            count[remain]++;
            num = num / 10;
        }
        while (ci > 0 && values[ci] == (max = findMax(count, max))) {
            count[max]--;
            ci--;
        }
        if (ci == 0) {
            return before;
        }
        while (mi < ci && values[mi] != max) {
            mi++;
        }
        values[mi] = values[ci];
        values[ci] = max;
        for (int i = values.length - 1; i >= 0; i--) {
            result = result * 10 + values[i];
        }
        return result;
    }

    public int findMax(int[] count, int max) {
        while (count[max] == 0) {
            max--;
        }
        return max;
    }

    public static void main(String[] args) {
        Z1ChangeMax test = new Z1ChangeMax();
        // 9973
        System.out.println(test.maximumSwap(9973));
    }
}
