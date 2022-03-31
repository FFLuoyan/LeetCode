package org.zongjieli.leetcode.question.daily.year2022.month3.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数是指可以被它包含的每一位数整除的数
 * 例如,128 是一个自除数,因为 128 % 1 == 0,128 % 2 == 0,128 % 8 == 0
 * 自除数不允许包含 0
 *
 * 给定两个整数 left 和 right,返回一个列表
 * 列表的元素是范围 [left, right] 内所有的自除数
 *
 * 1 <= left <= right <= 10^4
 *
 * @author   Li.zongjie
 * @date     2022/3/31
 * @version  1.0
 */
public class Z4SelfDivideNumber {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>(right - left);
        for (int i = left ; i <= right ; i++) {
            int temp = i;
            while (temp != 0) {
                int sd = temp % 10;
                if (sd == 0 || i % sd != 0) {
                    break;
                }
                temp /= 10;
            }
            if (temp == 0) {
                result.add(i);
            }
        }
        return result;
    }

}
