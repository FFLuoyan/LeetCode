package org.zongjieli.leetcode.competion.singleweekly.order368;

/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 如果下标三元组 (i, j, k) 满足下述全部条件,则认为它是一个山形三元组:
 *  i < j < k
 *  nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请找出 nums 中元素和最小的山形三元组,并返回其元素和
 * 如果不存在满足条件的三元组,返回 -1
 *
 * 3 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^8
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/22
 */
public class O368N2MountainTuple {

    public int minimumSum(int[] nums) {
        int[] startMin = new int[nums.length];
        startMin[0] = nums[0];
        int[] endMin = new int[nums.length];
        endMin[nums.length - 1]  = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            startMin[i] = Math.min(startMin[i -  1], nums[i]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            endMin[i] = Math.min(endMin[i + 1], nums[i]);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (startMin[i]  < nums[i]  &&  endMin[i] < nums[i]) {
                result = Math.min(result, startMin[i] + nums[i]  + endMin[i]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        O368N2MountainTuple test = new O368N2MountainTuple();
        //  9
        System.out.println(test.minimumSum(new int[]{8,6, 1, 5, 3}));
    }
}
