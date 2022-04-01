package org.zongjieli.leetcode.question.daily.year2022.month3.week5;

import java.util.Map;
import java.util.TreeMap;

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
        int[][] save = new int[2][100001];
        for (int i : arr) {
            save[i < 0 ? 1 : 0][Math.abs(i)]++;
        }
        if (save[0][0] % 2 == 1) {
            return false;
        }
        for (int i = 1 ; i < 50001 ; i++) {
            if (save[0][i] != 0 && (save[0][2 * i] -= save[0][i]) < 0) {
                return false;
            }
            if (save[1][i] != 0 && (save[1][2 * i] -= save[1][i]) < 0) {
                return false;
            }
        }
        for (int i = 50000 ; i < 100001 ; i++) {
            if (save[0][i] > 0 || save[1][i] > 0) {
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
