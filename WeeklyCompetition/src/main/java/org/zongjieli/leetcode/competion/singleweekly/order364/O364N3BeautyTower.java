package org.zongjieli.leetcode.competion.singleweekly.order364;

import java.util.Arrays;
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
 * 1 <= n == maxHeights <= 10^5
 * 1 <= maxHeights[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/24
 */
public class O364N3BeautyTower {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size(), index = 0, max, last, before, count;
        int[] heights = new int[n], heightCount = new int[2 * n];
        for (Integer maxHeight : maxHeights) {
            heights[index++] = maxHeight;
        }
        long[] left = new long[n], right = new long[n];

        left[index = 0] = heights[0];
        heightCount[index++] = heights[0];
        heightCount[index++] = 1;

        long next;
        for (int i = 1 ; i < n ; i++) {
            max = heights[i];
            last = heightCount[index - 2];
            if (max > last) {
                heightCount[index++] = max;
                heightCount[index++] = 1;
                left[i] = left[i - 1] + max;
            } else if (max == last) {
                heightCount[index - 1]++;
                left[i] = left[i - 1] + max;
            } else {
                count = 0;
                next = left[i - 1];
                while ((index -= 2) >= 0 && (before = heightCount[index]) >= max) {
                    count += heightCount[index + 1];
                    next -= (long) (before - max) * heightCount[index + 1];
                }
                index += 2;
                heightCount[index++] = max;
                heightCount[index++] = count + 1;
                left[i] = next + max;
            }
        }

        index = 0;
        right[n - 1] = heights[n - 1];
        heightCount[index++] = heights[n - 1];
        heightCount[index++] = 1;

        for (int i = n - 2 ; i >= 0 ; i--) {
            max = heights[i];
            last = heightCount[index - 2];
            if (max > last) {
                heightCount[index++] = max;
                heightCount[index++] = 1;
                right[i] = right[i + 1] + max;
            } else if (max == last) {
                heightCount[index - 1]++;
                right[i] = right[i + 1] + max;
            } else {
                count = 0;
                next = right[i + 1];
                while ((index -= 2) >= 0 && (before = heightCount[index]) >= max) {
                    count += heightCount[index + 1];
                    next -= (long) (before - max) * heightCount[index + 1];
                }
                index += 2;
                heightCount[index++] = max;
                heightCount[index++] = count + 1;
                right[i] = next + max;
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, left[i] + right[i] - heights[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        O364N3BeautyTower test = new O364N3BeautyTower();
        // 13
        System.out.println(test.maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
    }
}
