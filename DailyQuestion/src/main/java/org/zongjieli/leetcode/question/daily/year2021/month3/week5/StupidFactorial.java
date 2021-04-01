package org.zongjieli.leetcode.question.daily.year2021.month3.week5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 通常,正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积
 * 我们设计了一个笨阶乘 clumsy:
 *   在整数的递减序列中
 *   我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符:
 *   *、/、+、-
 *   clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 * 这些运算仍然使用通常的算术运算顺序
 * 我们在任何加、减步骤之前执行所有的乘法和除法步骤
 * 并且按从左到右处理乘法和除法步骤
 * 另外,我们使用的除法是地板除法 (floor division)
 * 所以 10 * 9 / 8 等于 11,保证结果是一个整数
 *
 * @author   Zongjie.Li
 * @date     2021/4/1
 * @version  1.0
 */
public class StupidFactorial {
    public int clumsy(int N) {
        // 1:1
        // 2:2
        // 3:6
        // 4:7
        // ...0:n+1
        // ...1:n+2
        // ...2:n+2
        // ...3:n-1
//        if (N < 3){
//            return N;
//        }
//        if (N < 5){
//            return N+3;
//        }
//        int remain = N % 4;
//        if (remain < 2){
//            return N + 1 + remain;
//        }
//        if (remain == 2){
//            return N+2;
//        }
//        return N-1;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(N--);
        int operate = 0;
        while (N > 0){
            if (operate == 0){
                operate++;
                stack.push(stack.poll() * N--);
            } else if (operate == 1){
                operate++;
                stack.push(stack.poll() / N--);
            } else if (operate == 2){
                operate++;
                stack.push(N--);
            } else {
                operate = 0;
                stack.push((-1) * N--);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        StupidFactorial stupidFactorial = new StupidFactorial();
        for (int i = 1;i<100;i++){
            System.out.println(i + ":" + stupidFactorial.clumsy(i));
        }
    }
}
