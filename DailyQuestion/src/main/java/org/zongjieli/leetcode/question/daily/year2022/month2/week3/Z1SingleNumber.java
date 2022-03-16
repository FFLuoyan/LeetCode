package org.zongjieli.leetcode.question.daily.year2022.month2.week3;
/**
 * 给定一个仅由整数组成的有序数组,其中每个元素都会出现两次
 * 唯有一个数只会出现一次,请找出并返回只出现一次的那个数
 *
 * 设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度
 *
 *  1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/2/14
 * @version  1.0
 */
public class Z1SingleNumber {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                return nums[left];
            }
            int middle = (left + right) / 2;
            int size = middle - left;
            if (size % 2 == 1) {
                // 单边单数
                if (nums[middle] == nums[middle + 1]) {
                    right = middle - 1;
                } else if (nums[middle] == nums[middle - 1]){
                    left = middle + 1;
                } else {
                    return nums[middle];
                }
            } else {
                // 单边双数
                if (nums[middle] == nums[middle + 1]) {
                    left = middle +  2;
                } else if (nums[middle] == nums[middle - 1]){
                    right = middle - 2;
                } else {
                    return nums[middle];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Z1SingleNumber test = new Z1SingleNumber();
        // 2
        System.out.println(test.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8}));
        // 2
        System.out.println(test.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        // 2
        System.out.println(test.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8, 9, 9}));
    }

}
