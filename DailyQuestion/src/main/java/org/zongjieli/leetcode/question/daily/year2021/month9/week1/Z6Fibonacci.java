package org.zongjieli.leetcode.question.daily.year2021.month9.week1;

/**
 * 写一个函数,输入 n,求斐波那契(Fibonacci)数列的第 n 项(即 F(N))
 * 斐波那契数列的定义如下：
 *  F(0) = 0,F(1) = 1
 *  F(N) = F(N - 1) + F(N - 2),其中 N > 1
 *
 * 斐波那契数列由 0 和 1 开始,之后的斐波那契数就是由之前的两数相加而得出
 * 答案需要取模 1e9+7(1000000007),如计算初始结果为:1000000008,请返回 1
 *
 * 0 <= n <= 100
 *
 * @author   Li.zongjie
 * @date     2021/9/8
 * @version  1.0
 */
public class Z6Fibonacci {

    private final int[] result = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 134903163, 836311896, 971215059, 807526948, 778742000, 586268941, 365010934, 951279875, 316290802, 267570670, 583861472, 851432142, 435293607, 286725742, 722019349, 8745084, 730764433, 739509517, 470273943, 209783453, 680057396, 889840849, 569898238, 459739080, 29637311, 489376391, 519013702, 8390086, 527403788, 535793874, 63197655, 598991529, 662189184, 261180706, 923369890, 184550589, 107920472, 292471061, 400391533, 692862594, 93254120, 786116714, 879370834, 665487541, 544858368, 210345902, 755204270, 965550172, 720754435, 686304600, 407059028, 93363621, 500422649, 593786270, 94208912, 687995182};

    public int fib(int n) {
//        if (n <= 1){
//            return n;
//        }
//        int a = 0;
//        int b = 1;
//        while (n-- > 1){
//            int temp = a;
//            a = b;
//            b = (temp + a) % 1000000007;
//        }
//        return b;
        return result[n];
    }

    /**
     * 矩阵快速幂解法
     * @param n 序号
     * @return  结果
     */
    public int matrixFastPower(int n){
        if (n <= 1){
            return n;
        }
        n--;
        long[] matrix = new long[]{1,1,1,0};
        long[] result = new long[]{1,0,0,1};
        while (true){
            long temp = result[0];
            if ((n & 1) == 1){
                result[0] = (temp * matrix[0] + result[1] * matrix[2]) % 1000000007;
                result[1] = (temp * matrix[1] + result[1] * matrix[3]) % 1000000007;
                temp = result[2];
                result[2] = (temp * matrix[0] + result[3] * matrix[2]) % 1000000007;
                result[3] = (temp * matrix[1] + result[3] * matrix[3]) % 1000000007;
            }
            n >>= 1;
            if (n == 0){
                break;
            }
            temp = matrix[0];
            long temp1 = matrix[1];
            long temp2 = matrix[2];
            matrix[0] = (temp * temp + temp1 * temp2) % 1000000007;
            matrix[1] = (temp * temp1 + temp1 * matrix[3]) % 1000000007;
            matrix[2] = (temp2 * temp + matrix[3] * temp2) % 1000000007;
            matrix[3] = (temp2 * temp1 + matrix[3] * matrix[3]) % 1000000007;
        }
        return (int) result[0];
    }

    public static void main(String[] args) {
        Z6Fibonacci test = new Z6Fibonacci();
        test.fib(100);
    }
}
