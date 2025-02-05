package org.zongjieli.leetcode.question.daily.year2025.month2.week2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个整数数组 nums,其中可能包含重复元素,请返回该数组所有可能的子集(幂集)
 * 解集不能包含重复的子集,返回的解集中,子集可以按任意顺序排列
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/2/5
 */
public class Z3SubSets {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int[] count = new int[21];
        for (int num : nums) {
            count[num + 10]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            List<List<Integer>> nextResult = new ArrayList<>(result);
            List<Integer> current = new ArrayList<>();
            for (int j = 0 ; j < count[i] ; j++) {
                // 当前数字为 i - 10,数量为 count[i]
                current.add(i - 10);
                for (List<Integer> item : result) {
                    List<Integer> next = new ArrayList<>(item);
                    next.addAll(current);
                    nextResult.add(next);
                }
            }
            result = nextResult;
        }
        return result;
    }

    public static void main(String[] args) {
        Z3SubSets test = new Z3SubSets();
        // [[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]
        System.out.println(test.subsetsWithDup(new int[]{1, 2, 2}));
    }

}
