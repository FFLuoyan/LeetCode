package org.zongjieli.leetcode.competion.singleweekly.order372;

/**
 * 给定三个字符串 s1、s2 和 s3
 * 可以根据需要对这三个字符串执行以下操作任意次数
 *  在每次操作中,可以选择其中一个长度至少为 2 的字符串并删除其最右位置上的字符
 * 如果存在某种方法能够使这三个字符串相等
 * 请返回使它们相等所需的最小操作次数,否则返回 -1
 *
 * 1 <= s1.length, s2.length, s3.length <= 100
 * s1、s2 和 s3 仅由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/19
 */
public class O372N1StringEqual {

    public int findMinimumOperations(String s1, String s2, String s3) {
        int min = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int max = 0;
        while (max < min && s1.charAt(max) == s2.charAt(max) && s1.charAt(max) == s3.charAt(max)) {
            max++;
        }
        if (max == 0) {
            return -1;
        }
        return s1.length() - max + s2.length() - max + s3.length() - max;
    }

}
