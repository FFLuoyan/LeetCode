package org.zongjieli.leetcode.question.daily.year2023.month3.week2;

/**
 * 给定一个字符串 s,它仅包含字符 'a' 和 'b'
 * 可以删除 s 中任意数目的字符,使得 s 平衡
 * 当不存在下标对 (i,j) 满足 i < j
 * 且 s[i] = 'b' 的同时 s[j]= 'a'
 * 此时认为 s 是平衡的
 * 请返回使 s 平衡的最少删除次数
 *
 * 1 <= s.length <= 10^5
 * s[i] 要么是 'a' 要么是 'b'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/6
 */
public class Z1BalanceString {

    public int minimumDeletions(String s) {
        byte[] values = s.getBytes();
        int start = 0, end = values.length - 1;
        while (start < values.length && values[start] == 'a') {
            start++;
        }
        if (start == values.length) {
            return 0;
        }
        while (end >= 0 && values[end] == 'b') {
            end--;
        }
        if (end < start) {
            return 0;
        }
        int[] count = new int[end - start + 1];
        int index = 0;
        count[0] = 1;
        while (++start <= end) {
            if (values[start] != values[start - 1]) {
                index++;
            }
            count[index]++;
        }
        int aCount = 0, bCount = 0;
        for (int i = 0 ; i < index ; i += 2) {
            bCount += count[i];
        }
        int result = bCount;
        for (int i = index ; i >= 0 ; i -= 2) {
            aCount += count[i];
            bCount -= count[i - 1];
            result = Math.min(result, aCount + bCount);
        }
        return result;
    }

}
