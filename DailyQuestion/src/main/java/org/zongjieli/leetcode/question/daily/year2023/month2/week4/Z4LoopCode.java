package org.zongjieli.leetcode.question.daily.year2023.month2.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 start,任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p,并且满足:
 * p[0] = start
 * p[i] 和 p[i+1] 的二进制表示形式只有一位不同
 * p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
 *
 * 1 <= n <= 16
 * 0 <= start < 2^n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/23
 */
public class Z4LoopCode {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result = new ArrayList<>(2 << n);
        changePosition(n, new int[]{start}, result);
        return result;
    }

    public void changePosition(int n, int[] current, List<Integer> result) {
        if (n == 0) {
            result.add(current[0]);
        } else {
            changePosition(--n, current, result);
            current[0] ^= (1 << n);
            changePosition(n, current, result);
        }
    }

    public static void main(String[] args) {
        Z4LoopCode test = new Z4LoopCode();
        // 3, 2, 0, 1
        System.out.println(test.circularPermutation(2, 3));
    }

}
