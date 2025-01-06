package org.zongjieli.leetcode.question.daily.year2025.month1.week2;

import java.util.Arrays;

/**
 * 租用大楼的部分楼层作为办公空间,并将一些楼层作为特殊楼层
 * 给定两个整数 bottom 和 top,表示租用了从 bottom 到 top(含 bottom 和 top 在内)的所有楼层
 * 另给定一个整数数组 special,其中 special[i] 表示指定的特殊楼层
 * 返回不含特殊楼层的最大连续楼层数
 *
 * 1 <= special.length <= 10^5
 * 1 <= bottom <= special[i] <= top <= 10^9
 * special 中的所有值互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/1/6
 */
public class Z1LongestContinuation {

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = Math.max(special[0] - bottom, top - special[special.length - 1]);
        for (int i = 1; i < special.length; i++) {
            max = Math.max(max, special[i] - special[i - 1] - 1);
        }
        return max;
    }

}
