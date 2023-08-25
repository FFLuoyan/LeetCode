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
        int[][] max = new int[6][n];
        max[0][0] = slices[0];
        max[1][0] = Math.max(slices[0], slices[1]);
        max[2][0] = Math.max(max[1][0], slices[2]);
        if (n == 1) {
            return max[2][0];
        }
        max[2][1] = slices[0] + slices[2];
        max[3][0] = slices[1];
        max[4][0] = Math.max(slices[1], slices[2]);
        max[5][0] = Math.max(max[4][0], slices[3]);
        max[5][1] = slices[1] + slices[3];
        for (int i = 3; i < slices.length - 1; i++) {
            for (int add = 0 ; add <= 3 ; add += 3) {
                int[] tem = max[add];
                max[add] = max[add + 1];
                max[add + 1] = max[add + 2];
                max[add + 2] = tem;
                int slice = slices[i + add / 3];
                max[add + 2][0] = Math.max(slice, max[add + 1][0]);
                int loopSize = Math.min(i / 2 + 1, n);
                for (int j = 1 ; j < loopSize ; j++) {
                    max[add + 2][j] = Math.max(max[add + 1][j], max[add][j - 1] + slice);
                }
            }

        }
        return Math.max(max[2][n - 1], max[5][n - 1]);
    }

    public static void main(String[] args) {
        Z5Pizza3n test= new Z5Pizza3n();
        // 10
        System.out.println(test.maxSizeSlices(new int[]{1, 2, 3, 4, 5, 6}));
    }

}
