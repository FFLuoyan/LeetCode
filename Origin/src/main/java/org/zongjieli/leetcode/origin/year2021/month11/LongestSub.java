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
        int max = 1;
        length[1] = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            int temp = max;
            while (temp >= 1){
                if (nums[i] > length[temp]){
                    if (temp == max){
                        length[++max] = nums[i];
                    } else {
                        length[temp + 1] = Math.min(length[temp + 1], nums[i]);
                    }
                    break;
                }
                temp--;
            }

            if (temp == 0){
                length[1] = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSub test = new LongestSub();
        System.out.println(test.lengthOfLIS(new int[]{1,2,3,0,1,2,3,4}));
    }
}
