package org.zongjieli.leetcode.competion.singleweekly.order183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: MinSubArray
 * @Description: 给定一个数组,从中抽取一个子序列
 *               要求该子序列的元素之和严格大于未包含在该子序列中的个元素之和
 *               如果存在多个解决方案,请返回长度最小的子序列,如果仍有多个,返回元素和最大的子序列
 *               子序列中的元素可以不连续
 * @Author: Zongjie.Li
 * @Date: 2020/4/5
 * @Version: 1.0
 **/
public class MinSubArray {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i : nums){
            sum+=i;
        }
        int count = 0;
        int size = 0;
        List<Integer> list = new ArrayList<>(size);
        for (int i = nums.length - 1;i >= 0 ; i--){
            count += nums[i];
            if (count > (sum- count)){
                for (int add = nums.length - 1;add >= i; add--){
                    list.add(nums[add]);
                }
                break;
            }
            size++;
        }
        return list;
    }

    public static void main(String[] args) {
        MinSubArray minSubArray = new MinSubArray();
        System.out.println(minSubArray.minSubsequence(new int[]{1,5,7,4,1,3,6,8,9,5,2}));
    }
}
