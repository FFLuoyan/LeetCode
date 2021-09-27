package org.zongjieli.leetcode.origin.year2021.month9;
/**
 *
 * 给定两个字符串 text1 和 text2,返回这两个字符串的最长公共子序列的长度
 * 如果不存在公共子序列,返回 0
 *
 * 一个字符串的子序列是指这样一个新的字符串:
 *  由原字符串在不改变字符的相对顺序的情况下删除某些字符(也可以不删除任何字符)后组成的新字符串
 *
 * 例如,"ace" 是 "abcde" 的子序列,但 "aec" 不是 "abcde" 的子序列
 * 两个字符串的公共子序列是这两个字符串所共同拥有的子序列
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 *
 * @author   Li.zongjie
 * @date     2021/9/26
 * @version  1.0
 */
public class LongestCommonSequence {
    /**
     *
     * @param text1 第一个字符串
     * @param text2 第二个字符串
     * @return  最长公共子序列长度
     *
     * 动态规划的逻辑容易理解,但是个人认为该题的难点在于常规方法的转换
     * 常规的解答方案是在理解了动态规划方法之后才想到的,这里记录一下
     *
     * 要想尽可能大的匹配两个字符串,则必不可少的需要抛弃某些字符
     * 当使用 text2 对 text1 进行匹配时
     * 假设 text1 前 5 个字符可以顺序在 text2 中找到,之后再无相关匹配的字符
     * 则在这种情况下,匹配长度为 5,但这不一定是最优解
     * 对于 text1 中的第一个字符,我们有两种选择,匹配或者放弃
     * 当选择放弃时,我们用第二个字符在 text2 中进行匹配
     * 当选择匹配时,我们第二个字符的匹配,则无法从第一个字符匹配的位置之前进行查找
     * 例如 text1 = eabcd, text2 = abcde
     * 当放弃第一个字符时,可以得到最大匹配长度 4
     * 不停地进行匹配循环,获取到所有结果,选取其中最大的
     *
     * 动态规划,也可以有另一种解法
     * 将匹配标识(true/false)按照位置放入二维数组中
     * 从左上往右下走,每次左右至少要走一步,求经过的 true 的数量最大值
     *
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] value = new int[length1 + 1][length2 + 1];
        for (int i = 0 ; i < length1 ; i++){
            char c1 = text1.charAt(i);
            for (int j = 0 ; j < length2 ; j++){
                char c2 = text2.charAt(j);
                value[i + 1][j + 1] = c1 == c2 ? value[i][j] + 1 : Math.max(value[i + 1][j],value[i][j + 1]);
            }
        }
        return value[length1][length2];
    }


}
