package org.zongjieli.leetcode.question.daily.year2025.month1.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target
 * 找出 candidates 中所有可以使数字和为 target 的组合
 * candidates 中的每个数字在每个组合中只能使用一次
 * 注意: 解集不能包含重复的组合
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/1/26
 */
public class Z7GroupSum {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, target, candidates.length - 1);
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target, int endIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentAddList = new ArrayList<>();
        if (target == 0) {
            result.add(currentAddList);
            return result;
        }
        if (endIndex < 0) {
            return result;
        }
        int startIndex = endIndex-1;
        while (startIndex >= 0 && candidates[startIndex] == candidates[endIndex]) {
            startIndex--;
        }
        result.addAll(combinationSum2(candidates, target, startIndex));
        for (int i = startIndex + 1; i <= endIndex && (target -= candidates[endIndex]) >= 0 ; i++) {
            currentAddList.add(candidates[endIndex]);
            List<List<Integer>> currentResults = combinationSum2(candidates, target, startIndex);
            for (List<Integer> currentResult : currentResults) {
                currentResult.addAll(currentAddList);
            }
            result.addAll(currentResults);
        }
        return result;
    }

    public static void main(String[] args) {
        Z7GroupSum test = new Z7GroupSum();
        //
//        System.out.println(test.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        // [[1, 2, 5]]
        System.out.println(test.combinationSum2(new int[]{1, 1, 2, 5}, 8));
    }
}
