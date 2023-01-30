package org.zongjieli.leetcode.question.daily.year2023.month1.week5;

/**
 * 给定一个下标从 0 开始的二维整数数组 brackets
 * 其中 brackets[i] = [upperI, percentI]
 * 表示第 i 个税级的上限是 upperI,征收的税率为 percentI
 * 税级按上限从低到高排序(在满足 0 < i < brackets.length 的前提下,upper(I-1) < upperI)
 * 税款计算方式如下:
 *  不超过 upper0 的收入按税率 percent0 缴纳
 *  接着 upper1 - upper0 的部分按税率 percent1 缴纳
 *  然后 upper2 - upper1 的部分按税率 percent2 缴纳
 *  以此类推
 * 给定一个整数 income 表示总收入
 * 返回需要缴纳的税款总额,与标准答案误差不超 10^-5 的结果将被视作正确答案
 *
 * 1 <= brackets.length <= 100
 * 1 <= upperI <= 1000
 * 0 <= percentI <= 100
 * 0 <= income <= 1000
 * upperI 按递增顺序排列
 * upperI 中的所有值互不相同
 * 最后一个税级的上限大于等于 income
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/30
 */
public class Z1CalculateTax {

    public double calculateTax(int[][] brackets, int income) {
        if (income <= brackets[0][0]) {
            return 0.01d * income * brackets[0][1];
        }
        int tax = brackets[0][0] * brackets[0][1], i = 0;
        while (++i < brackets.length && brackets[i][0] < income) {
            tax += ((brackets[i][0] - brackets[i - 1][0]) * brackets[i][1]);
        }
        tax += (income - brackets[i - 1][0]) * brackets[i][1];
        return 0.01d * tax;
    }

    public static void main(String[] args) {
        Z1CalculateTax test = new Z1CalculateTax();
        System.out.println(test.calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10));
    }

}
