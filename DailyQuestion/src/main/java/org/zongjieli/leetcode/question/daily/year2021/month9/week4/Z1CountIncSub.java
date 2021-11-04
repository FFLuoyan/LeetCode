package org.zongjieli.leetcode.question.daily.year2021.month9.week4;

/**
 * 给定一个未排序的整数数组,找到最长递增子序列的个数
 *
 * 给定的数组长度不超过 2000 并且结果一定是 32 位有符号整数
 *
 * @author   Li.zongjie
 * @date     2021/9/24
 * @version  1.0
 */
public class Z1CountIncSub {
    public int findNumberOfLIS(int[] nums) {
        int resultLength = 1;
        int result = 0;
        int[] maxLength = new int[nums.length];
        int[] maxCount = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            int length = 1;
            int lengthCount = 1;
            for (int j = 0 ; j < i ; j++){
                if (nums[j] < nums[i]){
                    int compareLength = maxLength[j] + 1;
                    if (length < compareLength){
                        length = compareLength;
                        lengthCount = maxCount[j];
                    } else if (length == compareLength){
                        lengthCount += maxCount[j];
                    }
                }
            }
            maxLength[i] = length;
            maxCount[i] = lengthCount;
            if (length > resultLength){
                result = lengthCount;
                resultLength = length;
            } else if (length == resultLength){
                result += lengthCount;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Z1CountIncSub test = new Z1CountIncSub();
        // 2
        System.out.println(test.findNumberOfLIS(new int[]{1,3,5,4,7}));
        // 5
        System.out.println(test.findNumberOfLIS(new int[]{2,2,2,2,2}));
        // 0
        System.out.println(test.findNumberOfLIS(new int[0]));
        // 27
        System.out.println(test.findNumberOfLIS(new int[]{3,2,1,6,5,4,9,8,7}));
    }
}
