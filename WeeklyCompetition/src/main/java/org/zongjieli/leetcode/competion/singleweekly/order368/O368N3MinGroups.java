package org.zongjieli.leetcode.competion.singleweekly.order368;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个长度为 n 下标从 0 开始的整数数组 nums
 * 将下标进行分组,使得 [0, n - 1] 内所有下标 i 都恰好被分到其中一组
 * 如果以下条件成立,这个分组方案是合法的:
 *  对于每个组 g,同一组内所有下标在 nums 中对应的数值都相等
 *  对于任意两个组 g1 和 g2,两个组中下标数量的差值不超过 1
 * 请返回一个整数,表示得到一个合法分组方案的最少组数
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/22
 */
public class O368N3MinGroups {

    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1,  Integer::sum);
        }
        List<Integer> values = new ArrayList<>(count.values());
        int min = values.stream().mapToInt(Integer::intValue).min().getAsInt();
        a: for (int i = min  + 1 ;  i>=1 ; i--) {
            int groupCount =  0;
            for (Integer value : values) {
                int first = value / i, second = value  % i;
                if (second == 0) {
                    groupCount += first;
                } else if (first + second >= i - 1) {
                    groupCount += first + 1;
                } else {
                    continue a;
                }
            }
            return groupCount;
        }
        return -1;
    }

    public static void main(String[] args) {
        O368N3MinGroups test= new O368N3MinGroups();
        // 2
        System.out.println(test.minGroupsForValidAssignment(new int[]{3,2, 3, 2, 3}));
        // 4
        System.out.println(test.minGroupsForValidAssignment(new int[]{10,10,10,3,1,1}));
    }

}
