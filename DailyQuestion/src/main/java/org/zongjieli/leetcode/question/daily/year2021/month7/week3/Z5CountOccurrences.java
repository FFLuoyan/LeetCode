package org.zongjieli.leetcode.question.daily.year2021.month7.week3;
/**
 * 统计一个数字在排序数组中出现的次数
 *
 * 0 <= 数组长度 <= 50000
 *
 * @author   Zongjie.Li
 * @date     2021/7/16
 * @version  1.0
 */
public class Z5CountOccurrences {

    public int search(int[] nums, int target) {
        int leftLeft = 0;
        int rightLeft = 0;
        int rightRight = nums.length - 1;
        int leftRight = nums.length - 1;

        while (leftLeft <= leftRight){
            int middle = (leftLeft + leftRight) / 2;
            if (nums[middle] < target){
                leftLeft = middle + 1;
            } else if (nums[middle] == target){
                leftRight = middle - 1;
                if (rightLeft == 0){
                    rightLeft = middle;
                }
            } else {
                leftRight = middle - 1;
                rightRight = middle;
            }
        }
        while (rightLeft <= rightRight){
            int middle = (rightLeft + rightRight) / 2;
            if (nums[middle] > target){
                rightRight = middle - 1;
            } else {
                rightLeft = middle + 1;
            }
        }
        return rightLeft - leftLeft;
    }

    public static void main(String[] args) {
        Z5CountOccurrences test = new Z5CountOccurrences();
        System.out.println(test.search(new int[]{1,3,3,3,5,6,8,8,9,10},6));
    }
}
