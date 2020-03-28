package org.zongjieli.leetcode.primaryalgorithm.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RomanToInt
 * @Description:   将罗马字符转化为 Int
 *                 罗马字符串包含 7 中字符
 *                 I: 1
 *                 V: 5
 *                 X: 10
 *                 L: 50
 *                 C: 100
 *                 D: 500
 *                 M: 1000
 *                 通常情况下数据用字符的个数表示,大数在前,小数在后
 *                 但对于每个整 5,整 10 ,用小数在大数之前,表示该数减去小数的结果
 *                 例如用 100 或 50 表示 90 或 40 的表示方式为 XC 和 XL
 * @Author: Zongjie.Li
 * @Date: 2020/3/28
 * @Version: 1.0
 **/
public class RomanToInt {

    public int romanToInt(String s){
        if (s.length() < 1){
            return 0;
        }
        int[] valueArray = new int[100];
        valueArray['I'] = 1;
        valueArray['V'] = 5;
        valueArray['X'] = 10;
        valueArray['L'] = 50;
        valueArray['C'] = 100;
        valueArray['D'] = 500;
        valueArray['M'] = 1000;
        int count = valueArray[s.charAt(0)];
        for (int index = 1; index < s.length() ;index++){
            int valueNow = valueArray[s.charAt(index)];
            int valueBefore = valueArray[s.charAt(index - 1)];
            if (valueNow > valueBefore){
                count += (valueNow - valueBefore - valueBefore);
            } else {
                count += valueNow;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("CIV"));
    }
}
