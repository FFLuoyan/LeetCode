package org.zongjieli.leetcode.question.daily.year2023.month2.week4;

/**
 * 在 x 轴上有一个一维的花园,花园长度为 n,从点 0 开始,到点 n 结束
 * 花园里总共有 n + 1 个水龙头,分别位于 [0, 1, ..., n]
 * 给定一个整数 n 和一个长度为 n + 1 的整数数组 ranges
 * 其中 ranges[i](下标从 0 开始)表示:
 *  如果打开点 i 处的水龙头,可以灌溉的区域为 [i -  ranges[i], i + ranges[i]]
 * 请返回可以灌溉整个花园的最少水龙头数目
 * 如果花园始终存在无法灌溉到的地方,请返回 -1
 *
 * 1 <= n <= 10^4
 * ranges.length == n + 1
 * 0 <= ranges[i] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/21
 */
public class Z2MinTaps {

    public int minTaps(int n, int[] ranges) {
        int[] save = new int[n + 101];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) {
                continue;
            }
            int position = i - ranges[i] + 100;
            save[position] = Math.max(i + ranges[i] + 100, save[position]);
        }
        return getMinTaps(0, 100, save, n + 100, 0);
    }

    public int getMinTaps(int start, int end, int[] save, int n, int count) {
        if (end >= n) {
            return count;
        }
        int ne = -1;
        for (int i = start ; i <= end ; i++) {
            if (save[i] > end && save[i] > ne) {
                ne = save[i];
            }
        }
        if (ne == -1) {
            return -1;
        }
        return getMinTaps(end, ne, save, n, count + 1);
    }

    public static void main(String[] args) {
        Z2MinTaps test = new Z2MinTaps();
        // 1
        System.out.println(test.minTaps(5, new int[]{3, 4, 1, 1, 0, 0}));
        // -1
        System.out.println(test.minTaps(4, new int[]{0, 0, 0, 0}));
        // 3
        System.out.println(test.minTaps(7, new int[]{1, 2, 1, 0, 2, 1, 0, 1}));
        // 10
        System.out.println(test.minTaps(70, new int[]{2, 4, 3, 1, 3, 0, 0, 0, 3, 0, 0, 4, 4, 4, 3, 5, 5, 1, 3, 4, 1, 2, 5, 2, 4, 4, 4, 1, 2, 1, 1, 1, 3, 1, 0, 4, 5, 5, 1, 4, 2, 3, 5, 4, 3, 0, 3, 1, 0, 5, 5, 4, 2, 4, 4, 2, 2, 1, 1, 5, 2, 4, 1, 5, 5, 2, 2, 4, 2, 4, 0}));
    }

}
