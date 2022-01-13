package org.zongjieli.leetcode.question.daily.year2022.month1.week3;
/**
 * 给定一个整数数组 nums,其中总是存在唯一的一个最大整数
 * 请找出数组中的最大元素并检查它是否至少是数组中每个其他数字的两倍
 * 如果是,则返回最大元素的下标,否则返回 -1
 *
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 *
 * @author   Li.zongjie
 * @date     2022/1/13
 * @version  1.0
 */
public class Z4MaxAllDouble {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1){
            return 0;
        }
        int maxIndex = nums[0] > nums[1] ? 0 : 1;
        int secondIndex = maxIndex ^ 1;

        for (int i = 2 ; i < nums.length ; i++){
            if (nums[i] > nums[maxIndex]){
                secondIndex = maxIndex;
                maxIndex = i;
            } else if (nums[i] > nums[secondIndex]){
                secondIndex = i;
            }
        }

        return nums[maxIndex] >= 2 * nums[secondIndex] ? maxIndex : -1;
    }

    public static void main(String[] args) {
        Z4MaxAllDouble test = new Z4MaxAllDouble();
        System.out.println(test.dominantIndex(new int[]{3,6,1,0}));
    }
}
