package org.zongjieli.leetcode.origin.year2021.month4;
/**
 * 整数数组 nums 按升序排列,数组中的值互不相同 。
 *
 * 在传递给函数之前 nums 在预先未知的某个下标 k(0 <= k < nums.length) 上进行了旋转
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 *
 * 给你 旋转后 的数组 nums 和一个整数 target
 * 如果 nums 中存在这个目标值 target 则返回它的下标,否则返回 -1 
 *
 * @author   Zongjie.Li
 * @date     2021/4/7
 * @version  1.0
 */
public class SearchRotatedOrderedArray {
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        if (target < nums[leftIndex] && target > nums[rightIndex]){
            return -1;
        }

        while (leftIndex <= rightIndex){
            // 该循环必须保证每次 target 目标只能在该范围内
            if (nums[leftIndex] == target){
                return leftIndex;
            }
            if (nums[rightIndex] == target){
                return rightIndex;
            }
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (nums[middleIndex] == target){
                return middleIndex;
            }
            if (nums[leftIndex] < nums[rightIndex]){
                // 升序
                if (nums[middleIndex] < target){
                    leftIndex = middleIndex + 1;
                } else {
                    rightIndex = middleIndex - 1;
                }
                // 中间有断层
            } else if (nums[middleIndex] > nums[leftIndex]){
                // 左半部正常升序,右半部存在断层
                if (nums[middleIndex] < target || target < nums[leftIndex]){
                    leftIndex = middleIndex + 1;
                } else {
                    rightIndex = middleIndex - 1;
                }
                // 左半部存在断层,右半部正常升序
            } else if (nums[middleIndex] < target && target <= nums[rightIndex]){
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        SearchRotatedOrderedArray array = new SearchRotatedOrderedArray();
        System.out.println(array.search(new int[]{3,1},1));
    }
}
