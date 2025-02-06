package org.zongjieli.leetcode.question.daily.year2025.month2.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums,按任意顺序返回所有不重复的全排列
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/2/6
 */
public class Z4Permutations {

    private List<List<Integer>> permutations;

    public int[] removeIndex(int[] nums, int index) {
        int[] result = new int[nums.length - 1];
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }
            result[currentIndex++] = nums[i];
        }
        return result;
    }

    public void permuteUnique(List<Integer> pre, int[] nums) {
        if (nums.length == 0) {
            permutations.add(pre);
            return;
        }
        int current = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != current) {
                current = nums[i];
                List<Integer> next = new ArrayList<>(pre);
                next.add(current);
                int[] remain = removeIndex(nums, i);
                permuteUnique(next, remain);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        permutations = new ArrayList<>();
        Arrays.sort(nums);
        permuteUnique(new ArrayList<>(), nums);
        return permutations;
    }

    public static void main(String[] args) {
        Z4Permutations test = new Z4Permutations();
        // [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
        System.out.println(test.permuteUnique(new int[]{1, 1, 2}));
    }
}
