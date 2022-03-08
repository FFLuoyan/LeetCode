package org.zongjieli.leetcode.question.daily.year2022.month3.week2;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 给定一个长桌子,桌子上盘子和蜡烛排成一列
 * 给定一个下标从 0 开始的字符串 s,它只包含字符 '*' 和 '|'
 * 其中 '*' 表示一个盘子,'|' 表示一支蜡烛
 *
 * 同时给定一个下标从 0 开始的二维整数数组 queries
 * 其中 queries[i] = [leftI, rightI] 表示子字符串 s[leftI ... rightI](包含左右端点的字符)
 * 对于每个查询,需要找到子字符串中在两支蜡烛之间的盘子的数目
 * 如果一个盘子在子字符串中左边和右边都至少有一支蜡烛,那么这个盘子满足在两支蜡烛之间
 *
 * 比方说,s = "||**||**|*",查询 [3, 8],表示的是子字符串 "*||**|"
 * 子字符串中在两支蜡烛之间的盘子数目为 2,子字符串中右边两个盘子在它们左边和右边都至少有一支蜡烛
 * 请你返回一个整数数组 answer,其中 answer[i] 是第 i 个查询的答案
 *
 * 3 <= s.length <= 10^5
 * s 只包含字符 '*' 和 '|'
 * 1 <= queries.length <= 10^5
 * queries[i].length == 2
 * 0 <= leftI <= rightI < s.length
 *
 * @author   Li.zongjie
 * @date     2022/3/8
 * @version  1.0
 */
public class Z2PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] left = new int[s.length()];
        int[] leftContain = new int[left.length];
        int all = 0;
        int current = 0;
        int lastIndex = -1;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '|') {
                all += current;
                current = 0;
                for (int j = lastIndex + 1 ; j <= i ; j++) {
                    leftContain[j] = all;
                }
                lastIndex = i;
            } else {
                current++;
            }
            left[i] = all;
        }
        all += current;
        for (int i = lastIndex + 1 ; i < leftContain.length ; i++) {
            leftContain[i] = all;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = Math.max(0, left[queries[i][1]] - leftContain[queries[i][0]]);
        }
        return result;
    }

    public static void main(String[] args) {
        Z2PlatesBetweenCandles test = new Z2PlatesBetweenCandles();
        // [2]
        System.out.println(Arrays.toString(test.platesBetweenCandles("||**||**|*", new int[][]{{3, 8}})));
        // [9,0,0,0,0]
        System.out.println(Arrays.toString(test.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}})));
        // [0]
        System.out.println(Arrays.toString(test.platesBetweenCandles("*|*", new int[][]{{2, 2}})));
    }
}
