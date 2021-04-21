package org.zongjieli.leetcode.question.daily.year2021.month4.week4;

import java.util.Arrays;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了编码
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 要解码已编码的消息,所有数字必须基于上述映射的方法
 * 反向映射回字母(可能有多种方法)
 *
 * 例如,"11106" 可以映射为：
 *
 * "AAJF"   将消息分组为 (1 1 10 6)
 * "KJF"    将消息分组为 (11 10 6)
 *
 * 注意,消息不能分组为 (1 11 06)
 * 因为 "06" 不能映射为 "F",这是由于 "6" 和 "06" 在映射中并不等价
 *
 * 给你一个只含数字的非空字符串 s,请计算并返回解码方法的总数
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 1 <= s.length <= 100
 * s 只包含数字,并且可能包含前导零
 * @author   Zongjie.Li
 * @date     2021/4/21
 * @version  1.0
 */
public class NumberDecode {

    private int[] fibonacci = new int[]{0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903};

    public int numDecoding(String s) {
        int num = 1;
        int fibonacciCount = 0;
        int index = 0;
        while (index < s.length()){
            char loopChar = s.charAt(index);
            if (loopChar == '1' || loopChar == '2'){
                fibonacciCount++;
            } else if (loopChar == '0'){
                if (fibonacciCount == 0){
                    return 0;
                }
                if (fibonacciCount > 1){
                    num *= fibonacci[fibonacciCount - 1];
                }
                fibonacciCount = 0;
            } else if (fibonacciCount != 0){
                if (s.charAt(index - 1) != '2' || loopChar <= '6' ){
                    fibonacciCount++;
                }
                num *= fibonacci[fibonacciCount];
                fibonacciCount = 0;
            }
            index++;
        }

        return fibonacciCount == 0 ? num : num * fibonacci[fibonacciCount];
    }

    public static void main(String[] args) {
        NumberDecode decode = new NumberDecode();
        System.out.println(decode.numDecoding("1234"));
        System.out.println(decode.numDecoding("1204"));
        System.out.println(decode.numDecoding("1304"));
    }
}
