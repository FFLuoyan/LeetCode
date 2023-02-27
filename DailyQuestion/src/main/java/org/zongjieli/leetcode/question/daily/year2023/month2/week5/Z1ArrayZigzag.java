package org.zongjieli.leetcode.question.daily.year2023.month2.week5;

/**
 * 给定一个整数数组 nums,每次操作会从中选择一个元素并将该元素的值减少 1
 * 如果符合下列情况之一,则数组 A 就是锯齿数组:
 *  每个偶数索引对应的元素都大于相邻的元素,即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 *  或者,每个奇数索引对应的元素都大于相邻的元素,即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/27
 */
public class Z1ArrayZigzag {

    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int odd = 0, even = 0;
        for (int i = 0 ; i < nums.length ; i += 2) {
            int min = (i == 0 ? nums[1] : i == nums.length - 1 ? nums[i - 1] : Math.min(nums[i - 1], nums[i + 1]));
            if (nums[i] >= min) {
                even += (nums[i] - min + 1);
            }
        }
        for (int i = 1 ; i < nums.length ; i += 2) {
            int min = (i == nums.length - 1 ? nums[i - 1] : Math.min(nums[i - 1], nums[i + 1]));
            if (nums[i] >= min) {
                odd += (nums[i] - min + 1);
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        Z1ArrayZigzag test = new Z1ArrayZigzag();
        // 4
        System.out.println(test.movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
    }

}
