package org.zongjieli.leetcode.question.daily.year2021.month10.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数,分别表示分数的分子 numerator 和分母 denominator
 * 以字符串形式返回小数
 *
 * 如果小数部分为循环小数,则将循环的部分括在括号内
 * 如果存在多个答案,只需返回任意一个
 * 对于所有给定的输入,保证答案字符串的长度小于 10^4
 *
 * -2^31 <= numerator, denominator <= 2^31 - 1
 * denominator != 0
 *
 * @author   Li.zongjie
 * @date     2021/10/20
 * @version  1.0
 */
public class Z7FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorL = numerator;
        long denominatorL = denominator;

        if (numeratorL % denominatorL == 0){
            return String.valueOf(numeratorL / denominatorL);
        }

        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);

        StringBuilder result = new StringBuilder();
        if ((numerator ^ denominator) >>> 31 == 1){
            result.append('-');
        }

        result.append(numeratorL / denominatorL);
        result.append('.');

        long remain = numeratorL % denominatorL;
        char[] save = new char[10001];
        int index = 0;
        Map<Long, Integer> indexMap = new HashMap<>();
        while (!indexMap.containsKey(remain)){
            indexMap.put(remain, index);
            remain *= 10;
            save[index++] = (char) (remain / denominatorL + '0');
            remain = remain % denominatorL;
            if (remain == 0){
                result.append(save,0,index);
                return result.toString();
            }
        }
        int firstIndex = indexMap.get(remain);
        result.append(save,0,firstIndex);
        result.append('(');
        result.append(save, firstIndex, index - firstIndex);
        result.append(')');
        return result.toString();
    }

    public static void main(String[] args) {
        Z7FractionToDecimal test = new Z7FractionToDecimal();
//        System.out.println(test.fractionToDecimal(1,2));
//        System.out.println(test.fractionToDecimal(1,6));
//        System.out.println(test.fractionToDecimal(1,12));
//        System.out.println(test.fractionToDecimal(-50,8));
//        System.out.println(test.fractionToDecimal(7,-12));
//        System.out.println(test.fractionToDecimal(-1,Integer.MIN_VALUE));
//        System.out.println(test.fractionToDecimal(Integer.MIN_VALUE,-1));
        System.out.println(test.fractionToDecimal(Integer.MIN_VALUE,-10));
    }
}
