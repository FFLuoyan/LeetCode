package org.zongjieli.leetcode.competion.singleweekly.order269;
/**
 * 给定一个下标从 0 开始的数组 nums
 * 数组由若干互不相同的整数组成
 * nums 中有一个值最小的元素和一个值最大的元素
 * 分别称为最小值和最大值,从数组中移除这两个元素
 * 一次删除操作定义为从数组的前面移除一个元素或从数组的后面移除一个元素
 * 返回将数组中最小值和最大值都移除需要的最小删除次数
 *
 * 1 <= nums.length <= 10^5
 * -10^5 <= nums[i] <= 10^5
 * nums 中的整数互不相同
 *
 * @author   Li.zongjie
 * @date     2021/11/28
 * @version  1.0
 */
public class RemoveMaxMin {
    public int minimumDeletions(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1 ; i < nums.length ; i++){
            if (max < nums[i]){
                max = nums[i];
                maxIndex = i;
            }
            if (min > nums[i]){
                min = nums[i];
                minIndex = i;
            }
        }
        min = Math.min(minIndex, maxIndex);
        max = Math.max(minIndex, maxIndex);
        return Math.min(Math.min(max + 1, nums.length - min), min + 1 + nums.length - max);
    }
}
