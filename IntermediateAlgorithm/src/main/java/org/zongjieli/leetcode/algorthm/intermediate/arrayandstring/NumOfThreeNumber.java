package org.zongjieli.leetcode.algorthm.intermediate.arrayandstring;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: NumOfThreeNumber
 * @Description: 给定一个包含 n 个整数的数组 nums,判断 nums 中是否存在三个元素,使他们的和为 0
 *               请返回所有满足条件且不重复的三元组
 * @Author: Zongjie.Li
 * @Date: 2020/4/3
 * @Version: 1.0
 **/
public class NumOfThreeNumber {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> combinationList = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return combinationList;
        }
        Arrays.sort(nums);
        for (int firstNumberIndex = 0;firstNumberIndex < nums.length - 2; firstNumberIndex++){
//            if (firstNumberIndex != nums.length - 3 && nums[firstNumberIndex] == nums[firstNumberIndex + 1]){
//                continue;
//            }
            for (int secondNumberIndex = firstNumberIndex + 1;secondNumberIndex < nums.length - 1;secondNumberIndex++){
                if (secondNumberIndex != nums.length - 2 && nums[secondNumberIndex] == nums[secondNumberIndex + 1]){
                    continue;
                }
                for (int thirdNumberIndex = secondNumberIndex + 1;thirdNumberIndex < nums.length;thirdNumberIndex ++){
                    if (thirdNumberIndex != nums.length - 1 && nums[thirdNumberIndex] == nums[thirdNumberIndex + 1]){
                        continue;
                    }
                    if (nums[firstNumberIndex] + nums[secondNumberIndex] + nums[thirdNumberIndex] == 0){
                        List<Integer> combination = new ArrayList<>();
                        combination.add(nums[firstNumberIndex]);
                        combination.add(nums[secondNumberIndex]);
                        combination.add(nums[thirdNumberIndex]);
                        combinationList.add(combination);
                    }
                }
            }
        }
        return combinationList;
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(null));
    }
}
