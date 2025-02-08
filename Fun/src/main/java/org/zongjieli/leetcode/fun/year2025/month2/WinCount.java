package org.zongjieli.leetcode.fun.year2025.month2;

/**
 * A、B两人打乒乓球,先比对方多胜 winNeed 局的一方赢得比赛
 * 如果经过 sum 局比赛 A 才获胜
 * 那么这 sum 局比赛的胜负排列共有种
 * 例如:
 *  "胜负胜负胜负胜负胜胜胜" 是一种 11 局多胜 3 局的排列
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/2/8
 */
public class WinCount {

    public int WinCount(int sum, int winNeed) {
        int[] count = new int[2 * winNeed + 1];
        count[winNeed] = 1;
        // count 表示当前情况下的净胜局数,其中 count[0] 表示当前净胜 -winNeed 局
        while (--sum >= 0) {
            int[] next = new int[count.length];
            for (int i = 1; i < count.length - 1; i++) {
                next[i + 1] += count[i];
                next[i - 1] += count[i];
            }
            count = next;
        }
        return count[2 * winNeed];
    }

    public static void main(String[] args) {
        WinCount test = new WinCount();
        // 81
        System.out.println(test.WinCount(11, 3));
    }
}
