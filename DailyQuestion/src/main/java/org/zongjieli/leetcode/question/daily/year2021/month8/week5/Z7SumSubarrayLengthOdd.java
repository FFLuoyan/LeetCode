package org.zongjieli.leetcode.question.daily.year2021.month8.week5;
/**
 * 返回所有奇数长度子数组的和
 *
 * 给一个正整数数组 arr,请计算所有可能的奇数长度子数组的和
 * 子数组定义为原数组中的一个连续子序列
 * 请返回 arr 中所有奇数长度子数组的和
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 * @author   Li.zongjie
 * @date     2021/9/18
 * @version  1.0
 */
public class Z7SumSubarrayLengthOdd {
    public int sumOddLengthSubarray(int[] arr) {
        int result = 0;
        for (int i = 0 ; i < arr.length ; i++){
            // 计算前后各有几种组成子数组的方式
            // 前置(包含自己)如果为奇数,则后置(不包含自己),应该为偶数
            // 前置(包含自己)如果为偶数,则后置(不包含自己),应该为奇数
            int leftOdd = i / 2 + 1;
            int leftEven = (i + 1) / 2;
            int rightEven = (arr.length - i + 1) / 2;
            int rightOdd = (arr.length - i) / 2;
            result += (leftOdd * rightEven + leftEven * rightOdd) * arr[i];
        }
        return result;
    }
}
