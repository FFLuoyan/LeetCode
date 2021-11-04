package org.zongjieli.leetcode.origin.year2021.month11;
/**
 * 给定一个整数数组 nums,找到其中最长严格递增子序列的长度
 *
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 *  
 * @author   Li.zongjie
 * @date     2021/11/4
 * @version  1.0
 */
public class LongestSub {
    public int lengthOfLIS(int[] nums) {
        int[] length = new int[2501];
        int max = 0;
        length[0] = Integer.MIN_VALUE;
        for (int num : nums) {
            for (int temp = max ; temp >= 0 ; temp--){
                if (num > length[temp]) {
                    length[temp == max ? ++max : temp + 1] = num;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSub test = new LongestSub();
        System.out.println(test.lengthOfLIS(new int[]{1,2,3,0,1,2,3,4}));
        System.out.println(test.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(test.lengthOfLIS(new int[]{-10,9,2,5,3,7,101,18}));
    }
}
