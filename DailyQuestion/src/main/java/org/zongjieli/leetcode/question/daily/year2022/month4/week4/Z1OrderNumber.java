package org.zongjieli.leetcode.question.daily.year2022.month4.week4;

import java.util.*;

/**
 * 给定一个整数 n,按字典序返回范围 [1, n] 内所有整数
 * 时间复杂度为 O(n) 且使用 O(1) 额外空间的算法
 *
 * 1 <= n <= 5 * 10^4
 *
 * @author   Li.zongjie
 * @date     2022/4/18
 * @version  1.0
 */
public class Z1OrderNumber {

    public List<Integer> lexicalOrder(int n) {
        TreeSet<Integer> result = new TreeSet<>(Comparator.comparing(String::valueOf));
        for (int i = n ; i >= 1 ; i--) {
            result.add(i);
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Z1OrderNumber test = new Z1OrderNumber();
        // [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(test.lexicalOrder(13));
    }
}
