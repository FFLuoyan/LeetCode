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
        List<List<Integer>> result = new ArrayList<>(2 << (nums.length + 1));
        int index = 0;
        while (index < nums.length){
            int value = nums[index];
            int count = 1;
            while (++index < nums.length && nums[index] == value){
                count++;
            }
            int existSize = result.size();
            for (int i = 0 ; i < count ; i++){
                List<Integer> repeatList = new ArrayList<>(2 * count);
                for (int j = 0 ; j <= i ; j++){
                    repeatList.add(value);
                }
                result.add(repeatList);
            }
            for (int i = 0 ; i < existSize ; i++){
                // existSize 内未当前已存在的数组
                // 将当前已存在的数组与当前 index 数的重复数字数组一一组合
                // 即为新组合数组
                for (int j = existSize;j < existSize + count ; j++){
                    // result[j] 为当前循环的列表
                    List<Integer> leftList = result.get(i);
                    List<Integer> repeatList = new ArrayList<>(2 * leftList.size());
                    repeatList.addAll(leftList);
                    repeatList.addAll(result.get(j));
                    result.add(repeatList);
                }
            }
        }
        result.add(new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        AllSubset allSubset = new AllSubset();
        allSubset.subsetsWithDup(new int[]{1,2,2});
    }
}
