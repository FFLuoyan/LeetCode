package org.zongjieli.leetcode.question.daily.year2021.month8.week5;

/**
 * 给你一个整数 n
 * 按下述规则生成一个长度为 n + 1 的数组 nums
 *  nums[0] = 0
 *  nums[1] = 1
 *  当 2 <= 2 * i <= n 时,nums[2 * i] = nums[i]
 *  当 2 <= 2 * i + 1 <= n 时,nums[2 * i + 1] = nums[i] + nums[i + 1]
 *
 * 返回生成数组 nums 中的 最大值
 *
 *  0 <= n <= 100
 *
 * @author   Li.zongjie
 * @date     2021/8/23
 * @version  1.0
 */
public class Z1MaxGenerated {
    public int getMaximumGenerated(int n) {
        if (n < 2){
            return n;
        }
        int[] value = new int[n + 1];
        value[0] = 0;
        value[1] = 1;
        int result = 1;
        for (int i = 2 ; i <= n ; i++){
            int half = i / 2;
            value[i] = value[half];
            if ((i & 1) == 1){
                value[i] += value[half + 1];
                result = Math.max(value[i],result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z1MaxGenerated test = new Z1MaxGenerated();
        System.out.println(test.getMaximumGenerated(100));
    }
}
