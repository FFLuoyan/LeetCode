package org.zongjieli.leetcode.competion.singleweekly.order361;

/**
 * 给定一个下标从 0 开始的字符串 num 表示一个非负整数
 * 在一次操作中,可以选择 num 的任意一位数字并将其删除
 * 请注意,如果删除 num 中的所有数字,则 num 变为 0
 * 返回最少需要多少次操作可以使 num 变成特殊数字
 * 如果整数 x 能被 25 整除,则该整数 x 被认为是特殊数字
 *
 * 1 <= num.length <= 100
 * num 仅由数字 '0' 到 '9' 组成
 * num 不含任何前导零
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/3
 */
public class O361N2MinOperate {

    public int minimumOperations(String num) {
        int fc = 0, sc = 0, result = num.length();
        char[] nums = num.toCharArray();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == '0') {
                break;
            }
            fc++;
        }
        if (fc != nums.length) {
            for (int i = nums.length - fc - 2; i >= 0; i--) {
                if (nums[i] == '5' || nums[i] == '0') {
                    break;
                }
                sc++;
            }
            if (sc + fc <= nums.length - 1) {
                result = sc + fc;
            }
        }
        fc = 0;
        sc = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == '5') {
                break;
            }
            fc++;
        }
        if (fc != nums.length) {
            for (int i = nums.length - fc - 2; i >= 0; i--) {
                if (nums[i] == '2' || nums[i] == '7') {
                    break;
                }
                sc++;
            }
            if (sc + fc <= nums.length - 2) {
                result = Math.min(fc + sc, result);
            }
        }
        return result;
    }

}
