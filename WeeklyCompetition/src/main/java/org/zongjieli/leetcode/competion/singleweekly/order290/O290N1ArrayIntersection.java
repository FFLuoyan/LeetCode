package org.zongjieli.leetcode.competion.singleweekly.order290;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维整数数组 nums
 * 其中 nums[i] 是由不同正整数组成的一个非空数组,按升序排列
 * 返回一个数组,数组中的每个元素在 nums 所有数组中都出现过
 *
 * 1 <= nums.length <= 1000
 * 1 <= sum(nums[i].length) <= 1000
 * 1 <= nums[i][j] <= 1000
 *
 * nums[i] 中的所有值 互不相同
 *
 * @author   Li.zongjie
 * @date     2022/4/24
 * @version  1.0
 */
public class O290N1ArrayIntersection {

    public List<Integer> intersection(int[][] nums) {
        int[] save = new int[1001];
        for (int[] num : nums) {
            for (int i : num) {
                save[i]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < save.length; i++) {
            if (save[i] == nums.length) {
                result.add(i);
            }
        }
        return result;
    }
}
