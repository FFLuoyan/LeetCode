package org.zongjieli.leetcode.question.daily.year2021.month10.week5;

import java.util.HashSet;

/**
 * 给定一个整数数组 nums,其中恰好有两个元素只出现一次
 * 其余所有元素均出现两次,找出只出现一次的那两个元素
 * 可以按任意顺序返回答案
 *
 * 2 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 除两个只出现一次的整数外,nums 中的其他数字都出现两次
 *
 * @author   Li.zongjie
 * @date     2021/11/1
 * @version  1.0
 */
public class Z6DisappearOnce {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> save = new HashSet<>();
        for (int num : nums) {
            if (save.contains(num)){
                save.remove(num);
            } else {
                save.add(num);
            }
        }
        Object[] temp = save.toArray();
        return new int[]{(int) temp[0], (int) temp[1]};
    }
}
