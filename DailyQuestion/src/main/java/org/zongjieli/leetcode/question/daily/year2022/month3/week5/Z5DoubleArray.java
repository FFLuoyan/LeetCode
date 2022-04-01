package org.zongjieli.leetcode.question.daily.year2022.month3.week5;

/**
 * 给定一个长度为偶数的整数数组 arr,只有对 arr 进行重组后可以满足
 *  对于每个 0 <= i < len(arr) / 2,都有 arr[2 * i + 1] = 2 * arr[2 * i] 
 * 时返回 true,否则返回 false
 *
 * 0 <= arr.length <= 3 * 10^4
 * arr.length 是偶数
 * -10^5 <= arr[i] <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/4/1
 * @version  1.0
 */
public class Z5DoubleArray {

    public boolean canReorderDoubled(int[] arr) {
        int max = 0, min = 0;
        for (int i : arr) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        int[] p = new int[max + 1];
        int[] n = new int[-min + 1];
        for (int i : arr) {
            if (i < 0) {
                n[-i]++;
            } else {
                p[i]++;
            }
        }
        if (p[0] % 2 == 1) {
            return false;
        }
        return valid(p) && valid(n);
    }

    public boolean valid(int[] value) {
        int count = value.length;
        if (count % 2 == 0) {
            return false;
        }
        count /= 2;
        for (int i = 1 ; i <= count ; i++) {
            int c = value[i];
            if (c != 0 && (value[2 * i] -= c) < 0) {
                return false;
            }
        }
        for (int i = count + 1 ; i < value.length ; i++) {
            if (value[i] > 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Z5DoubleArray test = new Z5DoubleArray();
        // false
        System.out.println(test.canReorderDoubled(new int[]{3, 1, 3, 6}));
        // true
        System.out.println(test.canReorderDoubled(new int[]{4, -2, 2, -4}));
    }
}
