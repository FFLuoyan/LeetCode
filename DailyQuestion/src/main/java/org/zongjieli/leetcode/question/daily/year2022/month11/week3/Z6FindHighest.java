package org.zongjieli.leetcode.question.daily.year2022.month11.week3;

/**
 * 有一个自行车手打算进行一场公路骑行,这条路线总共由 n + 1 个不同海拔的点组成
 * 自行车手从海拔为 0 的点 0 开始骑行
 * 给定一个长度为 n 的整数数组 gain
 * 其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差(0 <= i < n)
 * 请返回最高点的海拔
 *
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/3
 */
public class Z6FindHighest {

    public int largestAltitude(int[] gain) {
        int result = 0, current = 0;
        for (int i : gain) {
            result = Math.max(result, current += i);
        }
        return result;
    }

}
