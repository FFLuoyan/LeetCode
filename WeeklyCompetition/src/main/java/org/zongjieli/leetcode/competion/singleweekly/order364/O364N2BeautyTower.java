package org.zongjieli.leetcode.competion.singleweekly.order364;

import java.util.List;

/**
 * 给定一个长度为 n,下标从 0 开始的整数数组 maxHeights
 * 在坐标轴上建 n 座塔,第 i 座塔的下标为 i,高度为 heights[i]
 * 如果以下条件满足,那么称这些塔是美丽的:
 *  1 <= heights[i] <= maxHeights[i]
 *  heights 是一个山状数组
 * 如果存在下标 i 满足以下条件,那么称数组 heights 是一个山状数组:
 *  对于所有 0 < j <= i,都有 heights[j - 1] <= heights[j]
 *  对于所有 i <= k < n - 1,都有 heights[k + 1] <= heights[k]
 * 请返回满足美丽塔要求的方案中,高度和的最大值
 *
 * 1 <= n == maxHeights <= 10^3
 * 1 <= maxHeights[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/24
 */
public class O364N2BeautyTower {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long result = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            result = Math.max(result, maximumSumOfHeights(maxHeights, i));
        }
        return result;
    }

    public long maximumSumOfHeights(List<Integer> maxHeights, int maxIndex) {
        long result = maxHeights.get(maxIndex), leftMax = result, rightMax = result;
        for (int i = maxIndex - 1 ; i >= 0 ; i--) {
            leftMax = Math.min(maxHeights.get(i), leftMax);
            result += leftMax;
        }
        for (int i = maxIndex + 1 ; i < maxHeights.size() ; i++) {
            rightMax = Math.min(rightMax, maxHeights.get(i));
            result += rightMax;
        }
        return result;
    }
}
