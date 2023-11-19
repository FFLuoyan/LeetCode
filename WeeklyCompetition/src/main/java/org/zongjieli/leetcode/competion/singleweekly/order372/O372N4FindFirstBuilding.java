package org.zongjieli.leetcode.competion.singleweekly.order372;

import java.util.*;

/**
 * 给定一个下标从 0 开始的正整数数组 heights,其中 heights[i] 表示第 i 栋建筑的高度
 * 如果一个人在建筑 i,且存在 i < j 的建筑 j 满足 heights[i] < heights[j],那么这个人可以移动到建筑 j
 * 给定另外一个数组 queries,其中 queries[i] = [ai, bi]
 * 第 i 个查询中,Alice 在建筑 ai,Bob 在建筑 bi
 * 请返回一个数组 ans,其中 ans[i] 是第 i 个查询中 Alice 和 Bob 可以相遇的最左边的建筑
 * 如果对于查询 i,Alice 和 Bob 不能相遇,令 ans[i] 为 -1
 *
 * 1 <= heights.length <= 5 * 10^4
 * 1 <= heights[i] <= 10^9
 * 1 <= queries.length <= 5 * 10^4
 * queries[i] = [ai, bi]
 * 0 <= ai, bi <= heights.length - 1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/19
 */
public class O372N4FindFirstBuilding {

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] findNextBigger = new int[heights.length];
        findNextBigger[heights.length - 1] = -1;
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i + 1] > heights[i]) {
                findNextBigger[i] = i + 1;
            } else {
                int find = findNextBigger[i + 1];
                while (find != -1 && heights[find] <= heights[i]) {
                    find = findNextBigger[find];
                }
                findNextBigger[i] = find;
            }
        }
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0], b = queries[i][1];
            if (a == b) {
                results[i] = a;
                continue;
            } else if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (heights[b] > heights[a]) {
                results[i] = b;
            } else {
                int next = findNextBigger[b];
                while (next != -1 && heights[next] <= heights[a]) {
                    next = findNextBigger[next];
                }
                results[i] = next;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        O372N4FindFirstBuilding test = new O372N4FindFirstBuilding();
        // [2, 5, -1, 5, 2]
        System.out.println(Arrays.toString(test.leftmostBuildingQueries(new int[]{6, 4, 8, 5, 2, 7}, new int[][]{{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}})));
        // [7, 6, -1, 4, 6]
        System.out.println(Arrays.toString(test.leftmostBuildingQueries(new int[]{5, 3, 8, 2, 6, 1, 4, 6}, new int[][]{{0, 7}, {3, 5}, {5, 2}, {3, 0}, {1, 6}})));

        int[] heights = new int[50000];
        int[][] queries = new int[50000][2];
        Random random = new Random();
        for (int i = 0; i < heights.length; i++) {
            heights[i] = random.nextInt(1000000000);
            queries[i][0] = random.nextInt(50000);
            queries[i][1] = random.nextInt(50000);
        }
        System.out.println(Arrays.toString(test.leftmostBuildingQueries(heights, queries)));
    }
}
