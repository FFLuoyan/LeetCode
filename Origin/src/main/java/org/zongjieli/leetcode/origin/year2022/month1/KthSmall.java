package org.zongjieli.leetcode.origin.year2022.month1;

import java.util.*;

/**
 * 给定一个 n x n 矩阵 matrix,其中每行和每列元素均按升序排序
 * 找到矩阵中第 k 小的元素
 * 请注意,它是排序后的第 k 小元素,而不是第 k 个 不同的元素
 *
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * 题目数据保证 matrix 中的所有行和列都按非递减顺序排列
 * 1 <= k <= n^2
 *
 * @author   Li.zongjie
 * @date     2022/1/18
 * @version  1.0
 */
public class KthSmall {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pairList = new PriorityQueue<>(2 * matrix.length, Comparator.comparingInt(a -> matrix[a[0]][a[1]]));
        for (int i = 0; i < n; i++) {
            pairList.add(new int[]{i, 0});
        }
        int[] pair;
        while (--k > 0){
            pair = pairList.poll();
            if (++pair[1] < n){
                pairList.add(pair);
            }
        }
        pair = pairList.poll();
        return matrix[pair[0]][pair[1]];
    }
}
