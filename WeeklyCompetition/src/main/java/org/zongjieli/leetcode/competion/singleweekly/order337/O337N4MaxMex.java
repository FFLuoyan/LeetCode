package org.zongjieli.leetcode.competion.singleweekly.order337;

/**
 * 给定一个下标从 0 开始的整数数组 nums 和一个整数 value
 * 在一步操作中,可以对 nums 中的任一元素加上或减去 value
 * 例如,如果 nums = [1,2,3] 且 value = 2
 * 可以选择 nums[0] 减去 value,得到 nums = [-1,2,3]
 * 数组的 MEX (minimum excluded) 是指其中数组中缺失的最小非负整数
 * 例如,[-1,2,3] 的 MEX 是 0,而 [1,0,3] 的 MEX 是 2
 * 返回在执行上述操作任意次后,nums 的最大 MEX
 *
 * 1 <= nums.length, value <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/19
 */
public class O337N4MaxMex {
    public int findSmallestInteger(int[] nums, int value) {
        int[] remains = new int[value];
        for (int num : nums) {
            if (num < 0) {
                int a = (-num) % value;
                if (a == 0) {
                    remains[0]++;
                } else {
                    remains[value - a]++;
                }
            } else {
                remains[num % value]++;
            }
        }
        int min = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < remains.length; i++) {
            if (remains[i] < min) {
                min = remains[i];
                index = i;
            }
        }
        return value * min + index;
    }

    public static void main(String[] args) {
        O337N4MaxMex test = new O337N4MaxMex();
        // 10
        System.out.println(test.findSmallestInteger(new int[]{3,0,3,2,4,2,1,1,0,4},5));
    }
}
