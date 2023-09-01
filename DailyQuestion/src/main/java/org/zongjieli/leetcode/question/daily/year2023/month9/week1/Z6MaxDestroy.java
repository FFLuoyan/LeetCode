package org.zongjieli.leetcode.question.daily.year2023.month9.week1;

/**
 * 给定一个长度为 n,下标从 0 开始的整数数组 forts,表示一些城堡
 * forts[i] 可以是 -1,0,1,其中:
 *  -1 表示第 i 个位置没有城堡
 *  0 表示第 i 个位置有一个敌人的城堡
 *  1 表示第 i 个位置有一个己方的城堡
 * 现在需要决定,将军队从某个己方的城堡位置 i 移动到一个空的位置 j,满足:
 *  0 <= i, j <= n - 1
 * 军队经过的位置只有敌人的城堡,正式的,对于所有 min(i,j) < k < max(i,j) 的 k,都满足 forts[k] == 0
 * 当军队移动时,所有途中经过的敌人城堡都会被摧毁
 * 请返回最多可以摧毁的敌人城堡数目
 * 如果无法移动军队,或者没有己方的城堡,请返回 0
 *
 *1 <= forts.length <= 1000
 * -1 <= forts[i] <= 1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/2
 */
public class Z6MaxDestroy {

    public int captureForts(int[] forts) {
        int start = 0, si = 0, result = 0, fort;
        for (int i = 0; i < forts.length; i++) {
            fort = forts[i];
            if (fort != 0) {
                if (start + fort == 0) {
                    result = Math.max(result, i - si - 1);
                }
                start = fort;
                si = i;
            }
        }
        return result;
    }

}
