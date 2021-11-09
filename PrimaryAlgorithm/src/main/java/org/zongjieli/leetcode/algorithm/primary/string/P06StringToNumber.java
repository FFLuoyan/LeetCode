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
        int signal = 1;
        int index = 0;
        while (index < s.length()){
            if ((signal = s.charAt(index)) == ' '){
                ++index;
                continue;
            }
            break;
        }

        long result = 0;
        if (signal >= '0' && signal <= '9'){
            result = signal - '0';
            signal = 1;
        } else if (signal == '-'){
            signal = -1;
        } else if (signal == '+'){
            signal = 1;
        } else {
            return 0;
        }

        while (++index < s.length()){
            char currentChar = s.charAt(index);
            if (currentChar < '0' || currentChar > '9'){
                break;
            }
            result = 10 * result + (currentChar - '0');
            if (-result < Integer.MIN_VALUE){
                break;
            }
        }
        result = signal * result;
        if (result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) result;

    }

    public static void main(String[] args) {
        P06StringToNumber test = new P06StringToNumber();
        System.out.println(test.myAtoi("42"));
    }
}
