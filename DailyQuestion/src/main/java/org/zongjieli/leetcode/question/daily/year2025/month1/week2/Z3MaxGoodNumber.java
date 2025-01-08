package org.zongjieli.leetcode.question.daily.year2025.month1.week2;

/**
 * 给定一个字符串 num 表示一个大整数
 * 如果一个整数满足下述所有条件,则认为该整数是一个优质整数:
 *  该整数是 num 的一个长度为 3 的子字符串
 *  该整数由唯一一个数字重复 3 次组成
 *  以字符串形式返回最大的优质整数,如果不存在满足要求的整数,则返回一个空字符串 ""
 * 注意:
 *  子字符串是字符串中的一个连续字符序列
 *  num 或优质整数中可能存在前导零
 *
 * 3 <= num.length <= 1000
 * num 仅由数字(0 - 9)组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/1/8
 */
public class Z3MaxGoodNumber {

    public String largestGoodInteger(String num) {
        byte result = -1;
        byte[] values = num.getBytes();
        for (int i = 0; i < values.length - 2; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] > result) {
                result = values[i];
            }
        }
        if (result == -1) {
            return "";
        }
        return new String(new byte[]{result, result, result});
    }

}
