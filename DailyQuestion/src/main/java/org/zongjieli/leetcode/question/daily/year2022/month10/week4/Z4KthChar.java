package org.zongjieli.leetcode.question.daily.year2022.month10.week4;

/**
 * 构建了一个包含 n 行(索引从 1 开始 )的表
 * 首先在第一行写上一个 0,接下来的每一行,将前一行中的 0 替换为 01,1 替换为 10
 * 例如,对于 n = 3,第 1 行是 0,第 2 行是 01,第 3 行是 0110
 * 给定行数 n 和序数 k,返回第 n 行中第 k 个字符(k 从索引 1 开始)
 *
 * 1 <= n <= 30
 * 1 <= k <= 2^(n - 1)
 *
 * @author   Li.zongjie
 * @date     2022/10/20
 * @version  1.0
 */
public class Z4KthChar {

    public int kthGrammar(int n, int k) {
        /*
            思路:
                对于每一行,生成的下一行的长度都为当前行的 2 倍
                所以对于当前行的当前位置 k 的字符 c
                在下一行的位置 2 * k 的字符必然为 c(0 -> 0, 1 -> 1,下标从 0 开始)
                位置 2 * k + 1 的字符则为 c ^ 1(0 -> 1, 1 -> 0)
                从下标 1 开始的话,则对应的位置 2 * k - 1, 2 * k 的字符为 c, c ^ 1
         */
        if (n == 1) {
            return 0;
        }
        return kthGrammar(n - 1, (k + 1) >> 1) ^ (k & 1) ^ 1;
    }

    public int kthGrammarByLow(int n, int k) {
        /*
            思路:
                对于每行,前一半的字符作为基准字符,后一半的字符则为该字符的异或结果
                且前一半的字符与前一行的所有字符完全一致

         */
        int result = 0;
        int half = 1 << (n - 1);
        while (k != 1) {
            if (k > half) {
                k -= half;
                result ^= 1;
            }
            half >>= 1;
        }
        return result;
    }

    public int kthGrammarByBit(int n, int k) {
        /*
            思路:
                根据规律算法,可以发现最终结果其实只是在统计 k 中的二进制表示法中 1 个个数
                而由于位置从 1 开始,转换成二进制表达法中的位置 0,则需要减 1

         */
        return Integer.bitCount(k - 1) & 1;
    }
}
