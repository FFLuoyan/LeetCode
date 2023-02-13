package org.zongjieli.leetcode.competion.singleweekly.order332;

import java.util.*;

/**
 * 给定一个二进制字符串 s 和一个整数数组 queries
 * 其中 queries[i] = [firstI, secondI]
 * 对于第 i 个查询,找到 s 的最短子字符串
 * 它对应的十进制值 val 与 firstI 按位异或得到 secondI
 * 换言之,val ^ firstI == secondI
 * 第 i 个查询的答案是子字符串 [leftI, rightI] 的两个端点(下标从 0 开始)
 * 如果不存在这样的子字符串,则答案为 [-1, -1]
 * 如果有多个答案,请选择 leftI 最小的一个
 * 请返回一个数组 ans,其中 ans[i] = [leftI, rightI] 是第 i 个查询的答案
 * 子字符串是一个字符串中一段连续非空的字符序列
 *
 * 1 <= s.length <= 10^4
 * s[i] 要么是 '0' ，要么是 '1'
 * 1 <= queries.length <= 10^5
 * 0 <= firstI, secondI <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/12
 */
public class O332N3SubstringXor {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> values = new HashMap<>();
        int firstZero = s.indexOf('0');
        if (firstZero != -1) {
            values.put(0, new int[]{firstZero, firstZero});
        }
        byte[] biValues = s.getBytes();
        for (int i = 0; i < biValues.length; i++) {
            biValues[i] -= '0';
        }
        for (int i = 0; i < biValues.length; i++) {
            if (biValues[i] == 0) {
                continue;
            }
            int current = 0;
            for (int j = i ; j < i + 32 && j < biValues.length ; j++) {
                current = (current << 1) + biValues[j];
                if (!values.containsKey(current)) {
                    values.put(current, new int[]{i, j});
                }
            }
        }
        int[][] result = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i][0] ^ queries[i][1];
            if (values.containsKey(query)) {
                result[i] = values.get(query);
            } else {
                result[i][0] = -1;
                result[i][1] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        O332N3SubstringXor test = new O332N3SubstringXor();
        // [0, 2], [2, 3]
        System.out.println(Arrays.deepToString(test.substringXorQueries("101101", new int[][]{{0, 5}, {1, 2}})));
    }
}
