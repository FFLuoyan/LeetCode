package org.zongjieli.leetcode.question.daily.year2023.month12.week2;

/**
 * 假设正在爬楼梯,需要 n 阶才能到达楼顶
 * 每次可以爬 1 或 2 个台阶,有多少种不同的方法可以爬到楼顶
 *
 * 1 <= n <= 45
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/10
 */
public class Z7UpStair {

    private final int[] result = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903};

    public int climbStairs(int n) {
        return result[n];
    }

    public static void main(String[] args) {
        Z7UpStair test = new Z7UpStair();
        // 1836311903
        System.out.println(test.climbStairs(45));
    }

}
