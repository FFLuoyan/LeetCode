package org.zongjieli.leetcode.algorthm.intermediate.arrayandstring;

import java.util.*;

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
//        int count = 0;
        for (int firstNumberIndex = 0;firstNumberIndex < nums.length - 2; firstNumberIndex++){
            if(firstNumberIndex != 0&& nums[firstNumberIndex] == nums[firstNumberIndex - 1]){
                continue;
            }
            if (nums[firstNumberIndex] > 0){
                break;
            }
            int thirdNumberIndexStart = nums.length - 1;
            int secondNumberIndexStart = firstNumberIndex + 1;
            for (int secondNumberIndex = secondNumberIndexStart;secondNumberIndex < nums.length - 1;secondNumberIndex++){
                if (secondNumberIndex != secondNumberIndexStart && nums[secondNumberIndex] == nums[secondNumberIndex - 1]){
                    continue;
                }
                int numberThird = -nums[firstNumberIndex] - nums[secondNumberIndex];
                if (numberThird < 0){
                    break;
                }
                if (numberThird > nums[nums.length - 1]){
                    continue;
                }
                for (int thirdNumberIndex = thirdNumberIndexStart;thirdNumberIndex > secondNumberIndex;thirdNumberIndex --){
//                    count++;
                    if (nums[thirdNumberIndex] < numberThird){
                        thirdNumberIndexStart = thirdNumberIndex;
                        break;
                    }
                    if (nums[thirdNumberIndex] == numberThird){
                        List<Integer> numberCombination = new ArrayList<>();
                        numberCombination.add(nums[firstNumberIndex]);
                        numberCombination.add(nums[secondNumberIndex]);
                        numberCombination.add(numberThird);
                        combinationList.add(numberCombination);
                        break;
                    }
                }
            }
        }
//        System.out.println("Count: " + count);
        return combinationList;
    }

    public static void main(String[] args) {
       NumOfThreeNumber numOfThreeNumber = new NumOfThreeNumber();
       numOfThreeNumber.threeSum(new int[]{0,1,5,-5,6,8,4,-7,8,-5,-3,-1,0,0,0,-4,2,3,9,7,1,5}).forEach(list ->{
           System.out.println(list);
       });
    }
}
