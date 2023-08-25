package org.zongjieli.leetcode.question.daily.year2023.month8.week3;

/**
 * 给定一个披萨,它由 3n 块不同大小的部分组成,现在需要按照如下规则来分披萨:
 *  挑选任意 一块披萨
 *  Alice 将会挑选所选择的披萨逆时针方向的下一块披萨
 *  Bob 将会挑选所选择的披萨顺时针方向的下一块披萨
 *  重复上述过程直到没有披萨剩下
 * 每一块披萨的大小按顺时针方向由循环数组 slices 表示
 * 请返回可以获得的披萨大小总和的最大值
 *
 * 1 <= slices.length <= 500
 * slices.length % 3 == 0
 * 1 <= slices[i] <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/18
 */
public class Z5Pizza3n {

    public int maxSizeSlices(int[] slices) {
        int length = slices.length, n = length / 3, result;
        // beforeMax[a][b] 表示前 a + 1 个数中选 b + 1 个的最大值
        int[][] beforeMax = new int[length][];
        beforeMax[0] = new int[]{slices[0]};
        beforeMax[1] = new int[]{Math.max(slices[0], slices[1])};
        beforeMax[2] = new int[]{Math.max(slices[2], beforeMax[1][0]), slices[0] + slices[2]};
        if (n == 1) {
            return beforeMax[2][0];
        }
        for (int i = 3; i < slices.length - 1; i++) {
            int slice = slices[i];
            int[] max2 = beforeMax[i - 2], max1 = beforeMax[i - 1], max = (beforeMax[i] = new int[i / 2 + 1]);
            max[0] = Math.max(slice, max1[0]);
            for (int j = 1 ; j < max.length ; j++) {
                max[j] = max2[j - 1] + slice;
                if (max1.length > j) {
                    max[j] = Math.max(max[j], max1[j]);
                }
            }
        }
        result = beforeMax[slices.length - 2][n - 1];
        beforeMax[0][0] = slices[1];
        beforeMax[1][0] = Math.max(slices[1], slices[2]);
        beforeMax[2][0] = Math.max(beforeMax[1][0], slices[3]);
        beforeMax[2][1] = slices[1] + slices[3];
        for (int i = 4; i < slices.length; i++) {
            int slice = slices[i];
            int[] max2 = beforeMax[i - 3], max1 = beforeMax[i - 2], max = beforeMax[i - 1];
            max[0] = Math.max(slice, max1[0]);
            for (int j = 1 ; j < max.length ; j++) {
                max[j] = max2[j - 1] + slice;
                if (max1.length > j) {
                    max[j] = Math.max(max[j], max1[j]);
                }
            }
        }
        return Math.max(result, beforeMax[slices.length - 2][n - 1]);
    }

    public static void main(String[] args) {
        Z5Pizza3n test= new Z5Pizza3n();
        // 10
        System.out.println(test.maxSizeSlices(new int[]{1, 2, 3, 4, 5, 6}));
    }

}
