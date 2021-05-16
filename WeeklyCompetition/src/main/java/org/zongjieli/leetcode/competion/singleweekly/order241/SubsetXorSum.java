package org.zongjieli.leetcode.competion.singleweekly.order241;
/**
 * 一个数组的异或总和定义为数组中所有元素按位 XOR 的结果
 * 如果数组为空,则异或总和为 0
 *
 * 例如数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1
 * 给一个数组 nums,请你求出 nums 中每个子集的异或总和
 * 计算并返回这些值相加之和
 *
 * 注意:在本题中,元素相同的不同子集应多次计数
 *
 * 数组 a 是数组 b 的一个子集的前提条件是:从 b 删除几个(也可能不删除)元素能够得到 a
 *
 * 1 <= nums.length <= 12
 * 1 <= nums[i] <= 20
 *
 * @author   Zongjie.Li
 * @date     2021/5/16
 * @version  1.0
 */
public class SubsetXorSum {
    public int subsetXORSum(int[] nums) {
        int[] result = new int[]{0};
        subIndex(nums,0,result,0);
        return result[0];
    }

    public void subIndex(int[] nums,int index,int[] result,int currentValue){
        if (index == nums.length - 1){
            result[0] += currentValue;
            result[0] += currentValue ^ nums[nums.length - 1];
        } else {
            subIndex(nums,index + 1,result,currentValue ^ nums[index]);
            subIndex(nums,index + 1,result,currentValue);
        }
    }
}
