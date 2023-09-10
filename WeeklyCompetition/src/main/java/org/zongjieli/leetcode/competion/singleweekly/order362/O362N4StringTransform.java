package org.zongjieli.leetcode.competion.singleweekly.order362;

/**
 * 给定两个长度都为 n 的字符串 s 和 t,可以对字符串 s 执行以下操作:
 *  将 s 长度为 l(0 < l < n)的后缀字符串删除,并将它添加在 s 的开头
 * 比方说,s = 'abcd',那么一次操作中,可以删除后缀 'cd',并将它添加到 s 的开头,得到 s = 'cdab'
 * 给定一个整数 k,请返回恰好 k 次操作将 s 变为 t 的方案数
 * 由于答案可能很大,返回答案对 10^9 + 7 取余后的结果
 *
 * 2 <= s.length <= 5 * 10^5
 * 1 <= k <= 10^15
 * s.length == t.length
 * s 和 t 都只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/10
 */
public class O362N4StringTransform {

    public int numberOfWays(String s, String t, long k) {
        int[] result = findAllIndex(s, t);
        if (result[0] == -1) {
            return 0;
        }
        long[] value = result[0] == 0 ? new long[]{0, 1} : new long[]{1, 0};
        int length = s.length(), match = result[1] == -1 ? 1 : length / result[1];
        long[][] matrix = new long[][]{{length - match - 1, match}, {length - match, match - 1}}, middle = new long[][]{{1, 0}, {0, 1}};
        long a, b, c, d;
        while (k > 0) {
            if ((k & 1) == 1) {
                a = middle[0][0] * matrix[0][0] + middle[0][1] * matrix[1][0];
                b = middle[0][0] * matrix[0][1] + middle[0][1] * matrix[1][1];
                c = middle[1][0] * matrix[0][0] + middle[1][1] * matrix[1][0];
                d = middle[1][0] * matrix[0][1] + middle[1][1] * matrix[1][1];
                middle[0][0] = a % 1000000007;
                middle[0][1] = b % 1000000007;
                middle[1][0] = c % 1000000007;
                middle[1][1] = d % 1000000007;
            }
            a = matrix[0][0] * matrix[0][0] + matrix[0][1] * matrix[1][0];
            b = matrix[0][0] * matrix[0][1] + matrix[0][1] * matrix[1][1];
            c = matrix[1][0] * matrix[0][0] + matrix[1][1] * matrix[1][0];
            d = matrix[1][0] * matrix[0][1] + matrix[1][1] * matrix[1][1];
            matrix[0][0] = a % 1000000007;
            matrix[0][1] = b % 1000000007;
            matrix[1][0] = c % 1000000007;
            matrix[1][1] = d % 1000000007;
            k >>= 1;
        }
        return (int) ((value[0] * middle[0][1] + value[1] * middle[1][1]) % 1000000007);
    }

    public int[] findAllIndex(String s, String t) {
        int[] result = new int[]{-1, -1};
        char[] scs = s.toCharArray(), tcs = t.toCharArray();
        a: for (int i = 0; i < scs.length; i++) {
            for (int j = i ; j < scs.length ; j++) {
                if (scs[j] != tcs[j - i]) {
                    continue a;
                }
            }
            int afterLength = scs.length - i;
            for (int j = 0 ; j < i ; j++) {
                if (scs[j] != tcs[j + afterLength]) {
                    continue a;
                }
            }
            if (result[0] == -1) {
                result[0] = i;
            } else {
                result[1] = i - result[0];
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        O362N4StringTransform test = new O362N4StringTransform();
        // 2
        System.out.println(test.numberOfWays("abcd", "cdab", 2));
    }
}
