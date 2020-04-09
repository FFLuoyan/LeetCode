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
        Map<Integer,Map<Integer,Integer>> numberMap = new HashMap<>();
        for (int firstNumberIndex = 0;firstNumberIndex < nums.length - 2; firstNumberIndex++){
            Map<Integer,Integer> firstNumberMap = numberMap.get(nums[firstNumberIndex]);
            if (firstNumberMap != null){
                continue;
            }
            if (nums[firstNumberIndex] > 0){
                break;
            }
            firstNumberMap = new HashMap<>();
            numberMap.put(nums[firstNumberIndex],firstNumberMap);
            int thirdNumberIndexStart = nums.length - 1;
            for (int secondNumberIndex = firstNumberIndex + 1;secondNumberIndex < nums.length - 1;secondNumberIndex++){
                if (firstNumberMap.get(nums[secondNumberIndex]) != null){
                    continue;
                }
                int numberThird = -nums[firstNumberIndex] - nums[secondNumberIndex];
                if (numberThird < 0){
                    break;
                }
                for (int thirdNumberIndex = thirdNumberIndexStart;thirdNumberIndex > secondNumberIndex;thirdNumberIndex --){
                    if (nums[thirdNumberIndex] < numberThird){
                        thirdNumberIndexStart = thirdNumberIndex;
                        break;
                    }
                    if (nums[thirdNumberIndex] == numberThird){
                        firstNumberMap.put(nums[secondNumberIndex],numberThird);
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
        return combinationList;
    }

    public static void main(String[] args) {
       NumOfThreeNumber numOfThreeNumber = new NumOfThreeNumber();
       numOfThreeNumber.threeSum(new int[]{0,1,5,-5,6,8,4,-7,8,-5,-3,-1,0,0,0,-4,2,3,9,7,1,5}).forEach(list ->{
           System.out.println(list);
       });
    }
}
