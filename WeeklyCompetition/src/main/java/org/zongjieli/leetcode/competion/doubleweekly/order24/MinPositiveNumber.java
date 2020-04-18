package org.zongjieli.leetcode.competion.doubleweekly.order24;

/**
 * @ClassName: MinPositiveNumber
 * @Description: 选定任意正数作为初始值,从左至右遍历数组进行累加
 *               需要确保累加和始终大于 0(等于1),选一个最小的正数
 * @Author: Zongjie.Li
 * @Date: 2020/4/18
 * @Version: 1.0
 **/
public class MinPositiveNumber {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums){
            sum += num;
            min = min < sum ? min : sum;
        }
        if (min >0){
            return 1;
        }
        return 0 - min + 1;
    }
}
