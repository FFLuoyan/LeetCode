package org.zongjieli.leetcode.question.daily.year2022.month3.week4;

import java.util.Arrays;

/**
 * 图像平滑器是大小为 3 x 3 的过滤器,用于对图像的每个单元格平滑处理
 * 平滑处理后单元格的值为该单元格的平均灰度
 * 每个单元格的平均灰度定义为:
 *  该单元格自身及其周围的 8 个单元格的平均值,结果需向下取整
 *
 * 如果一个单元格周围存在单元格缺失的情况
 * 则计算平均灰度时不考虑缺失的单元格
 * 按照实际单元格数量取平均值
 *
 * m == img.length
 * n == img[i].length
 * 1 <= m, n <= 200
 * 0 <= img[i][j] <= 255
 *
 * @author   Li.zongjie
 * @date     2022/3/24
 * @version  1.0
 */
public class Z4ImageSmooth {

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        if (m == 1) {
            if (n == 1) {
                return img;
            }
            int[] row = new int[n];
            int[] ir = img[0];
            row[0] = sum0(ir) / 2;
            row[n - 1] = sumN(ir, n) / 2;
            for (int i = 1 ; i < n - 1 ; i++) {
                row[i] = sum(ir, i) / 3;
            }
            return new int[][]{row};
        }
        int[][] result = new int[m][n];
        if (n == 1) {
            result[0][0] = (img[0][0] + img[1][0]) / 2;
            result[m - 1][0] = (img[m - 2][0] + img[m - 1][0]) / 2;
            for (int i = 1 ; i < m - 1 ; i++) {
                result[i][0] = (img[i - 1][0] + img[i][0] + img[i + 1][0]) / 3;
            }
            return result;
        }

        int[] rf = result[0];
        int[] irfc = img[0];
        int[] irfa = img[1];
        rf[0] = (sum0(irfc) + sum0(irfa)) / 4;
        rf[n - 1] = (sumN(irfc, n) + sumN(irfa, n)) / 4;
        for (int i = 1 ; i < n - 1 ; i++) {
            rf[i] = (sum(irfc, i) + sum(irfa, i)) / 6;
        }

        rf = result[m - 1];
        irfc = img[m - 1];
        int[] irfb = img[m - 2];
        rf[0] = (sum0(irfc) + sum0(irfb)) / 4;
        rf[n - 1] = (sumN(irfc, n) + sumN(irfb, n)) / 4;
        for (int i = 1 ; i < n - 1 ; i++) {
            rf[i] = (sum(irfc, i) + sum(irfb, i)) / 6;
        }

        for (int i = 1 ; i < m - 1 ; i++) {
            rf = result[i];
            irfb = img[i - 1];
            irfc = img[i];
            irfa = img[i + 1];
            rf[0] = (sum0(irfb) + sum0(irfc) + sum0(irfa)) / 6;
            rf[n - 1] = (sumN(irfb, n) + sumN(irfc, n) + sumN(irfa, n)) / 6;
            for (int j = 1 ; j < n - 1 ; j++) {
                rf[j] = (sum(irfb, j) + sum(irfc, j) + sum(irfa, j)) / 9;
            }
        }
        return result;
    }

    private int sum0(int[] r) {
        return r[0] + r[1];
    }
    private int sumN(int[] r, int n) {
        return r[n - 2] + r[n - 1];
    }
    private int sum(int[] r, int i) {
        return r[i - 1] + r[i] + r[i + 1];
    }

    public static void main(String[] args) {
        Z4ImageSmooth test = new Z4ImageSmooth();
        // [[4,4,5],[5,6,6],[8,9,9],[11,12,12],[13,13,14]]
        int[][] r = test.imageSmoother(new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}});
        for (int[] rr : r) {
            System.out.println(Arrays.toString(rr));
        }
    }
}
