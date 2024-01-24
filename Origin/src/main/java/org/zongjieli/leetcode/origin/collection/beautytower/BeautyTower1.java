package org.zongjieli.leetcode.origin.collection.beautytower;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个长度为 n 下标从 0 开始的整数数组 maxHeights
 * 在坐标轴上建 n 座塔,第 i 座塔的下标为 i,高度为 heights[i]
 * 如果以下条件满足,称这些塔是美丽的:
 *  1 <= heights[i] <= maxHeights[i]
 *  heights 是一个山脉数组
 * 如果存在下标 i 满足以下条件,那么称数组 heights 是一个山脉数组:
 *  对于所有 0 < j <= i,都有 heights[j - 1] <= heights[j]
 *  对于所有 i <= k < n - 1,都有 heights[k + 1] <= heights[k]
 * 请返回满足美丽塔要求的方案中,高度和的最大值
 *
 * 1 <= n == maxHeights <= 10^3
 * 1 <= maxHeights[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/24
 */
public class BeautyTower1 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long[] leftSums = new long[maxHeights.size()];
        long[] cache = new long[leftSums.length * 2];
        long currentSum = cache[0] = leftSums[0] = maxHeights.get(0), currentCount, result;
        cache[1] = 1;
        int cacheIndex = 0, current;
        for (int i = 1; i < maxHeights.size(); i++) {
            currentSum += (current = maxHeights.get(i));
            if (current > cache[cacheIndex]) {
                cache[cacheIndex += 2] = current;
                cache[cacheIndex + 1] = 1;
            } else if (current == cache[cacheIndex]) {
                cache[cacheIndex + 1]++;
            } else {
                currentCount = 1;
                while (cacheIndex >= 0 && cache[cacheIndex] >= current) {
                    currentSum -= (cache[cacheIndex] - current) * cache[cacheIndex + 1];
                    currentCount += cache[cacheIndex + 1];
                    cacheIndex -= 2;
                }
                cache[cacheIndex += 2] = current;
                cache[cacheIndex + 1] = currentCount;
            }
            leftSums[i] = currentSum;
        }
        currentSum = cache[0] = maxHeights.get(leftSums.length - 1);
        cache[1] = 1;
        cacheIndex = 0;
        result = leftSums[leftSums.length - 1];
        for (int i = maxHeights.size() - 2; i >= 0; i--) {
            result = Math.max(result, leftSums[i] + currentSum);
            current = maxHeights.get(i);
            if (current > cache[cacheIndex]) {
                cache[cacheIndex += 2] = current;
                cache[cacheIndex + 1] = 1;
            } else if (current == cache[cacheIndex]) {
                cache[cacheIndex + 1]++;
            } else {
                currentCount = 1;
                while (cacheIndex >= 0 && cache[cacheIndex] >= current) {
                    currentSum -= (cache[cacheIndex] - current) * cache[cacheIndex + 1];
                    currentCount += cache[cacheIndex + 1];
                    cacheIndex -= 2;
                }
                cache[cacheIndex += 2] = current;
                cache[cacheIndex + 1] = currentCount;
            }
            currentSum += current;
        }
        return Math.max(result, currentSum);
    }

    public static void main(String[] args) {
        BeautyTower1 test = new BeautyTower1();
        // 100000001
        System.out.println(test.maximumSumOfHeights(Arrays.asList(1, 100000000)));
        // 33
        System.out.println(test.maximumSumOfHeights(Arrays.asList(1, 5, 2, 5, 6, 4, 6, 3, 4, 5)));
    }

}
