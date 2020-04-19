package org.zongjieli.leetcode.competion.doubleweekly.order24;

import java.util.Arrays;

/**
 * @ClassName: FibonaccCount
 * @Description: 给定一个数字k,请返回和为k的斐波那契数字的最小个数
 *               斐波那契被定义为
 *                  F1=1
 *                  F2=2
 *                  Fn=F(n+1)
 * @Author: Zongjie.Li
 * @Date: 2020/4/18
 * @Version: 1.0
 **/
public class FibonaccCount {
    public int findMinFibonacciNumbers(int k) {
        int[] fibonaccArray = new int[]{1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733};
        // 题目给出了数字范围,先求出在规定数据范围内的斐波那契数字
        // 对于任意给定的 k,假设有最大的斐波那契数 Fn 与剩余的 Fa + Fb + Fc...
        // 其中每个数字下标间隔大于或等于 2
        // 则该排列则为 k 对应的斐波那契数字数目最小的组合
        // 这里的数学推论不是很懂,大致说一下自己的想法
        // 如果存在一个组合为 2*Fn-1 + Fd + Fe + ... 数字比组合 1 要少
        // 那么必然有 Fn + Fn-2 + Fd + Fe + ... 与上个组合数值一样
        // 显然,在每一个斐波那契数的下标间隔为 2 或以上时,这个数字组合无法合并
        // 针对最小的组合时,有 k = Fn + x
        // 同时 x = Fm + y
        // 依次检索得出数字 k 的一个数值组合
        int count = 0;
        for (int index = fibonaccArray.length - 1;index >= 0;index--){
            if (k >= fibonaccArray[index]){
                count ++ ;
                k-=fibonaccArray[index];
                if (k == 0){
                    break;
                }
                index--;
            }
        }
        return count;
    }
}
