package org.zongjieli.leetcode.question.daily.year2023.month8.week4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums
 * 返回恰好覆盖数组中所有数字的最小有序区间范围列表
 * 也就是说,nums 的每个元素都恰好被某个区间范围所覆盖
 * 并且不存在属于某个范围但不属于 nums 的数字 x
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出:
 *  "a->b",如果 a != b
 *  "a",如果 a == b
 *
 *  0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中的所有值都互不相同
 * nums 按升序排列
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/26
 */
public class Z6RangeList {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>(nums.length);
        int start = 0, end = start;
        while (start < nums.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[start]);
            while (++end < nums.length && nums[end] - nums[end - 1] == 1) {}
            if (--end != start) {
                sb.append("->");
                sb.append(nums[end]);
            }
            result.add(sb.toString());
            start = ++end;
        }
        return result;
    }
}
