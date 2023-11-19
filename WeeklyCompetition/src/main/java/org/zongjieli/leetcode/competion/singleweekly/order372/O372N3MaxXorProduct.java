package org.zongjieli.leetcode.competion.singleweekly.order372;

/**
 * 给定三个整数 a,b,n,请返回 (a XOR x) * (b XOR x) 的最大值且 x 需要满足 0 <= x < 2^n
 * 由于答案可能会很大,返回它对 10^9 + 7 取余后的结果
 * 注意,XOR 是按位异或操作
 *
 * 0 <= a, b < 2^50
 * 0 <= n <= 50
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/19
 */
public class O372N3MaxXorProduct {

    public int maximumXorProduct(long a, long b, int n) {
        int remain = 1000000007;
        if (n == 0) {
            return (int) ((a % remain) * (b % remain) % remain);
        }
        long bit = 1L << n;
        long startA = a - (a & (bit - 1)), startB = b - (b & (bit - 1));
        bit >>= 1;
        int valueIndex = 0;
        long[] values = new long[2];
        if (startA > startB) {
            valueIndex = 1;
            values[0] = startA;
            values[1] = startB;
        } else if (startB > startA) {
            valueIndex = 1;
            values[0] = startB;
            values[1] = startA;
        } else {
            values[0] = startA;
            values[1] = startB;
        }
        while (bit > 0) {
            if (((a & bit) ^ (b & bit)) > 0) {
                values[valueIndex] += bit;
                valueIndex |= 1;
            } else {
                values[0] += bit;
                values[1] += bit;
            }
            bit >>= 1;
        }
        return (int) ((values[0] % remain) * (values[1] % remain) % remain);
    }

    public static void main(String[] args) {
        O372N3MaxXorProduct test = new O372N3MaxXorProduct();
        // 12
        System.out.println(test.maximumXorProduct(1, 6, 3));
        // 2
        System.out.println(test.maximumXorProduct(0, 3, 1));
    }
}
