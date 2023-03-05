package org.zongjieli.leetcode.competion.doubleweekly.order99;

import java.util.Arrays;

/**
 * 给定一个二维整数数组 ranges,其中 ranges[i] = [startI, endI]
 * 表示 startI 到 endI 之间(包括二者)的所有整数都包含在第 i 个区间中
 * 需要将 ranges 分成两个组(可以为空),满足:
 *  每个区间只属于一个组
 *  两个有交集的区间必须在同一个组内
 *  如果两个区间有至少一个公共整数,那么这两个区间是有交集的
 * 比方说,区间 [1, 3] 和 [2, 5] 有交集,因为 2 和 3 在两个区间中都被包含
 * 请返回将 ranges 划分成两个组的总方案数,由于答案可能很大,将它对 10^9 + 7 取余后返回
 *
 * 1 <= ranges.length <= 10^5
 * ranges[i].length == 2
 * 0 <= startI <= endI <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/4
 */
public class O99N3CountBlock {

    public int countWays(int[][] ranges) {
        int count = 1;
        Arrays.sort(ranges, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        int max = ranges[0][1];
        for (int i = 1 ; i < ranges.length ; i++) {
            if (ranges[i][0] > max) {
                count++;
            }
            max = Math.max(max, ranges[i][1]);
        }
        long result = 1L;
        while (count > 0) {
            result = (result * 2) % 1000000007;
            count--;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        O99N3CountBlock test = new O99N3CountBlock();
        // 2
        System.out.println(test.countWays(new int[][]{{34,56},{28,29},{12,16},{11,48},{28,54},{22,55},{28,41},{41,44}}));
    }

}
