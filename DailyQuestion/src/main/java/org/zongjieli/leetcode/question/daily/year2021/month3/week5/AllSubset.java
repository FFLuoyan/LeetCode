package org.zongjieli.leetcode.question.daily.year2021.month3.week5;

import java.util.ArrayList;
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
        List<List<Integer>> result = new ArrayList<>(2 << (nums.length + 1));
        result.add(new ArrayList<>());
        for (int num : nums) {
            int existSize = result.size();
            for (int i = 0 ; i < existSize ; i++){
                new ArrayList<>().addAll(new ArrayList<>());
                List<Integer> current = result.get(i);
                if (current.contains(num)){
                    current.add(num);
                } else {
                    List<Integer> newList = new ArrayList<>(current);
                    newList.add(num);
                    result.add(newList);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AllSubset allSubset = new AllSubset();
        allSubset.subsetsWithDup(new int[]{1,2,2}).forEach(System.out::println);

    }
}
