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
        int[][] result = new int[m][n];
        for (int i = 0 ; i < m ; i++) {
            int[] rr = result[i];
            int[] irb = null;
            if (i > 0) {
                irb = img[i - 1];
            }
            int[] irc = img[i];
            int[] ira = null;
            if (i < m - 1) {
                ira = img[i + 1];
            }

            for (int j = 0 ; j < n ; j++) {
                int count = 1;
                if (i > 0) {
                    count++;
                    if (j > 0) {
                        rr[j] += irb[j - 1];
                        count++;
                    }
                    rr[j] += irb[j];
                    if (j < n - 1) {
                        rr[j] += irb[j + 1];
                        count++;
                    }
                }
                if (j > 0) {
                    rr[j] += irc[j - 1];
                    count++;
                }
                rr[j] += irc[j];
                if (j < n - 1) {
                    rr[j] += irc[j + 1];
                    count++;
                }
                if (i < m - 1) {
                    count++;
                    if (j > 0) {
                        rr[j] += ira[j - 1];
                        count++;
                    }
                    rr[j] += ira[j];
                    if (j < n - 1) {
                        rr[j] += ira[j + 1];
                        count++;
                    }
                }
                rr[j] /= count;
            }
        }
        return result;
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
