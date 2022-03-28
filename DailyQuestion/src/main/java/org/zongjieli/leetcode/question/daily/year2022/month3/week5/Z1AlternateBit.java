package org.zongjieli.leetcode.question.daily.year2022.month3.week5;
/**
 * 给定一个正整数,检查它的二进制表示是否总是 0、1 交替出现
 * 换句话说,就是二进制表示中相邻两位的数字永不相同
 *
 * 1 <= n <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2022/3/28
 * @version  1.0
 */
public class Z1AlternateBit {

    public boolean hasAlternatingBits(int n) {
        boolean isNextZero = (n & 1) == 0;
        while (n > 0) {
            boolean isCurrentZero = (n & 1) == 0;
            if (isCurrentZero ^ isNextZero) {
                return false;
            }
            n >>= 1;
            isNextZero = !isNextZero;
        }
        return true;
    }
}
