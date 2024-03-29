package org.zongjieli.leetcode.question.daily.year2022.month11.week4;

/**
 * 有 A 和 B 两种类型的汤,一开始每种类型的汤有 n 毫升,有四种分配操作:
 *  提供 100ml 的汤 A 和 0ml 的汤 B
 *  提供 75ml 的汤 A 和 25ml 的汤 B
 *  提供 50ml 的汤 A 和 50ml 的汤 B
 *  提供 25ml 的汤 A 和 75ml 的汤 B
 * 当我们把汤分配给某人之后,汤就没有了
 * 每个回合,我们将从四种概率同为 0.25 的操作中进行分配选择
 * 如果汤的剩余量不足以完成某次操作,我们将尽可能分配
 * 当两种类型的汤都分配完时,停止操作
 * 注意: 不存在先分配 100 ml 汤 B 的操作
 * 需要返回的值: 汤 A 先分配完的概率 + 汤 A 和汤 B 同时分配完的概率 / 2
 * 返回值在正确答案 10^-5 的范围内将被认为是正确的
 *
 * 0 <= n <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/2
 */
public class Z1ShareSoup {

    public double soupServings(int n) {
        n = (n + 24) / 25;
        if (n >= 179) {
            return 1;
        }
        double[][] save = new double[n + 1][n + 1];
        return countResult(n, n, save);
    }

    public double countResult(int a, int b, double[][] save) {
        if (a <= 0) {
            if (b > 0) {
                return 1d;
            }
            return 0.5;
        }
        if (b <= 0) {
            return 0;
        }
        if (save[a][b] != 0) {
            return save[a][b];
        }

        double result = 0d;
        result += 0.25 * countResult(a - 4, b, save);
        result += 0.25 * countResult(a - 3, b - 1, save);
        result += 0.25 * countResult(a - 2, b - 2, save);
        result += 0.25 * countResult(a - 1, b - 3, save);
        return save[a][b] = result;
    }

    public static void main(String[] args) {
        Z1ShareSoup test = new Z1ShareSoup();
        // 0.625
        System.out.println(test.soupServings(50));
        // 0.5
        System.out.println(test.soupServings(0));
        // 0.625
        System.out.println(test.soupServings(1));
    }

}
