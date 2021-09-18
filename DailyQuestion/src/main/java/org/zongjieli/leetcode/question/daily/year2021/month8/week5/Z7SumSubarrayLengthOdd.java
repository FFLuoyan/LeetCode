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
        int result = arr[0];
        int add = arr[0];
        // 奇数位置和
        int oddSum = arr[0];
        int arrayCount = 1;
        for (int i = 1 ; i < arr.length ; i++){
            if ((i & 1) == 1){
                // 奇数,奇数下标为偶数位置
                add += (arrayCount * arr[i] - oddSum);
            } else {
                // 偶数,偶数下标为奇数位置
                add += (arrayCount++ * arr[i] + (oddSum += arr[i]));
            }
            result += add;
        }
        return result;
    }
}
