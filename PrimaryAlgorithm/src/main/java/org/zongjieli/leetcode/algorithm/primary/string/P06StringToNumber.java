package org.zongjieli.leetcode.algorithm.primary.string;

/**
 * 请实现一个 myAtoi(string s) 函数
 * 使其能将字符串转换成一个 32 位有符号整数(类似 C/C++ 中的 atoi 函数)
 *
 * 函数 myAtoi(string s) 的算法如下:
 *
 *  读入字符串并丢弃无用的前导空格
 *  检查下一个字符(假设还未到字符末尾)为正还是负号
 *   读取该字符(如果有)确定最终结果是负数还是正数
 *   如果两者都不存在,则假定结果为正
 *  读入下一个字符,直到到达下一个非数字字符或到达输入的结尾
 *   字符串的其余部分将被忽略
 *  将前面步骤读入的这些数字转换为整数(即,"123" -> 123,"0032" -> 32)
 *   如果没有读入数字,则整数为 0,必要时更改符号(从步骤 2 开始)
 *  如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1]
 *   需要截断这个整数,使其保持在这个范围内
 *   具体来说,小于 −2^31 的整数应该被固定为 −2^31
 *   大于 2^31 − 1 的整数应该被固定为 2^31 − 1
 *  返回整数作为最终结果
 *
 * 注意:
 *  本题中的空白字符只包括空格字符 ' ' 。
 *  除前导空格或数字后的其余字符串外,请勿忽略任何其他字符
 *
 * 0 <= s.length <= 200
 * s 由英文字母(大写和小写)、数字(0-9)、' '、'+'、'-' 和 '.' 组成
 *
 * @author   Li.zongjie
 * @date     2021/11/9
 * @version  1.0
 */
public class P06StringToNumber {
    public int myAtoi(String s) {
        /*
            运用有限状态机思想
            将输入分为四个状态
            开始状态: 一开始属于的状态
                空格: 继续处于开始状态
                符号: 进入符号状态
                数字: 进入数字状态
                其他: 进入结束状态
            符号状态: 当输入正负号时进入该状态
                数字: 进入数字状态
                其他: 进入结束状态
            数字状态: 当输入为数字时进入该状态
                数字: 进入数字状态
                其他: 进入结束状态
            结束状态: 当输入异常或输入结束时进入该状态
         */
        boolean isPositive = true;
        long result = 0;
        int state = 0;
        int[][] states = new int[][]{
                {0,1,2,3},
                {3,3,2,3},
                {3,3,2,3},
                {3,3,3,3}
        };
        for (int i = 0 ; i < s.length() ; i++){
            char currentChar = s.charAt(i);
            state = states[state][
                    currentChar == ' ' ? 0
                    : currentChar == '+' || currentChar == '-' ? 1
                    : currentChar <= '9' && currentChar >= '0' ? 2
                    : 3];
            if (state == 3){
                break;
            }
            if (state == 1){
                isPositive = currentChar == '+';
            } else if (state == 2){
                result = result * 10 + currentChar - '0';
                if (result > Integer.MAX_VALUE){
                    break;
                }
            }
        }

        if (isPositive){
            return (int) Math.min(result, Integer.MAX_VALUE);
        } else {
            return (int) Math.max(-result, Integer.MIN_VALUE);
        }
    }

    public static void main(String[] args) {
        P06StringToNumber test = new P06StringToNumber();
        System.out.println(test.myAtoi("42"));
    }
}
