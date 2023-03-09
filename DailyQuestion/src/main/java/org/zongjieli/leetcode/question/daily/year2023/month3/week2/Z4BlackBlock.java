package org.zongjieli.leetcode.question.daily.year2023.month3.week2;

/**
 * 给定一个长度为 n 下标从 0 开始的字符串 blocks
 * blocks[i] 要么是 'W' 要么是 'B',表示第 i 块的颜色
 * 字符 'W' 和 'B' 分别表示白色和黑色
 * 给定一个整数 k,表示想要连续黑色块的数目
 * 每一次操作中,可以选择一个白色块将它涂成黑色块
 * 请返回至少出现一次连续 k 个黑色块的最少操作次数
 *
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] 要么是 'W',要么是 'B'
 * 1 <= k <= n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/9
 */
public class Z4BlackBlock {

    public int minimumRecolors(String blocks, int k) {
        byte[] values = blocks.getBytes();
        int result, wCount = 0;
        for (int i = 0 ; i < k ; i++) {
            if (values[i] == 'W') {
                wCount++;
            }
        }
        result = (wCount *= 21);
        for (int i = k ; i < values.length ; i++) {
            result = Math.min(wCount += (values[i] - values[i - k]), result);
        }
        return result / 21;
    }

}
