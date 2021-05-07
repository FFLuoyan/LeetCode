package org.zongjieli.leetcode.question.daily.year2021.month5.week2;
/**
 * 给定两个整数,n 和 start
 *
 * 数组 nums 定义为：nums[i] = start + 2*i(下标从 0 开始)
 * 且 n == nums.length
 *
 * 请返回 nums 中所有元素按位异或(XOR)后得到的结果
 *
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 *
 * @author   Zongjie.Li
 * @date     2021/5/7
 * @version  1.0
 */
public class XorOperation {
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0 ; i < n ; i++){
            result = result ^ (start + 2 * i);
        }
        return result;
    }
}
