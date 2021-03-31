package org.zongjieli.leetcode.question.daily.year2021.month3.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组,其中可能包含重复元素
 * 请返回该数组所有可能的子集
 *
 * 解集不能包含重复的子集,返回的子集中,子集可以按照任意顺序排列
 *
 * @author   Zongjie.Li
 * @date     2021/3/31
 * @version  1.0
 */
public class AllSubset {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int startIndex = 0;
        while (startIndex < nums.length){
            int endIndex = startIndex + 1;
            int count = 1;
            while (endIndex < nums.length){
                if (nums[endIndex] == nums[startIndex]){
                    endIndex++;
                    count++;
                } else {
                    break;
                }
            }
            int existSize = result.size();
            for (int i = 0 ; i < count ; i++){
                List<Integer> repeatList = new ArrayList<>(2 * count);
                for (int j = 0 ; j <= i ; j++){
                    repeatList.add(nums[startIndex]);
                }
                result.add(repeatList);
            }
            for (int i = 0 ; i < existSize ; i++){
                for (int j = existSize;j < existSize + count ; j++){
                    // result[j] 为当前循环的列表
                    List<Integer> repeatList = new ArrayList<>(result.get(i));
                    repeatList.addAll(result.get(j));
                    result.add(repeatList);
                }
            }
            startIndex = endIndex;
        }
        result.add(new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        AllSubset allSubset = new AllSubset();
        allSubset.subsetsWithDup(new int[]{1,2,2});
    }
}
