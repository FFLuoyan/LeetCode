package org.zongjieli.leetcode.algorithm.primary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: RepeatCheck
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/22
 * @Version: 1.0
 **/
public class RepeatCheck {
    public static boolean repeatCheck(int[] nums){
//        Set set = new HashSet();
//        for (int i = 0 ; i < nums.length ; i++){
//            if (set.contains(nums[i])){
//                return true;
//            }
//            set.add(i);
//        }
//        return false;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length - 1 ; i ++) {
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,8,5,4};
        System.out.println(repeatCheck(nums));
    }
}
