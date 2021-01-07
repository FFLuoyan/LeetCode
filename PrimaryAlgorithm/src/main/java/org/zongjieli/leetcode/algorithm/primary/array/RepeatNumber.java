package org.zongjieli.leetcode.algorithm.primary.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Class Description:
 * 给定一个数组,判断数组中是否存在重复元素,如果存在某一个值在数组中至少出现两次,则返回 false
 *
 * @author   Zongjie.Li
 * @date     2021/1/7
 * @version  1.0
 */
public class RepeatNumber {

    public boolean containDuplicate(int[] nums){
//        return repeatBySort(nums);
//        return repeatBySortOptimize(nums);
//        return repeatByHash(nums);
        return repeatByMax(nums);
    }


    public boolean repeatBySort(int[] nums){
        Arrays.sort(nums);
        for (int i = 1 ; i < nums.length ; i++){
            if (nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

    public boolean repeatBySortOptimize(int[] nums){
        for (int i = 1 ; i < nums.length ; i++){
            int temp = nums[i];
            if (temp < nums[i-1]){
                nums[i] = nums[i - 1];
                int j = i - 1;
                for (; j > 0 ; j--){
                    if (temp < nums[j - 1]){
                        nums[j] = nums[j - 1];
                    } else if (temp == nums[j - 1]){
                        return true;
                    } else {
                        nums[j] = temp;
                        break;
                    }
                }
                if (j == 0){
                    nums[0] = temp;
                }
            } else if (temp == nums[i - 1]){
                return true;
            }
        }
        return false;
    }

    public boolean repeatByHash(int[] nums){
        HashMap<Integer,Boolean> repeat = new HashMap<>(nums.length);
        for (int num : nums){
            if (repeat.containsKey(num)){
                return true;
            } else {
                repeat.put(num,true);
            }
        }
        return false;
    }

    public boolean repeatByMax(int[] nums){
        if (nums == null || nums.length == 0){
            return false;
        }
        int temp = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            if (nums[i] == temp){
                return true;
            } else if (nums[i] > temp){
                temp = nums[i];
            } else {
                for (int j = i - 1 ; j >= 0 ; j--){
                    if (nums[i] == nums[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5,8,7,4,0,6};
        RepeatNumber repeatNumber = new RepeatNumber();
        System.out.println(repeatNumber.containDuplicate(nums));
    }
}
