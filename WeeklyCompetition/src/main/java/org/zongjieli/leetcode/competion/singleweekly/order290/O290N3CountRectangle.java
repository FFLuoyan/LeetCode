package org.zongjieli.leetcode.competion.singleweekly.order290;

import org.zongjieli.leetcode.base.Tree;

import java.util.*;

/**
 * 给定一个二维整数数组 rectangles
 * 其中 rectangles[i] = [li, hi] 表示第 i 个矩形长为 li 高为 hi
 * 给定一个二维整数数组 points
 * 其中 points[j] = [xj, yj] 是坐标为 (xj, yj) 的一个点
 *
 * 第 i 个矩形的左下角在 (0, 0) 处,右上角在 (li, hi)
 *
 * 请返回一个整数数组 count,长度为 points.length
 * 其中 count[j] 是包含第 j 个点的矩形数目
 *
 * 如果 0 <= xj <= li 且 0 <= yj <= hi
 * 那么我们说第 i 个矩形包含第 j 个点
 * 如果一个点刚好在矩形的边上,这个点也被视为被矩形包含
 *
 * 1 <= rectangles.length, points.length <= 5 * 10^4
 * rectangles[i].length == points[j].length == 2
 * 1 <= li, xj <= 10^9
 * 1 <= hi, yj <= 100
 * 所有 rectangles 互不相同
 * 所有 points 互不相同
 *
 * @author   Li.zongjie
 * @date     2022/4/24
 * @version  1.0
 */
public class O290N3CountRectangle {

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] result = new int[points.length];
        TreeMap<Integer, List<Integer>> save = new TreeMap<>();
        for (int[] rectangle : rectangles) {
            save.computeIfAbsent(rectangle[1], k -> new ArrayList<>()).add(rectangle[0]);
        }
        save.forEach((k,v ) -> v.sort(Integer::compareTo));

        for (int i = 0; i < points.length; i++) {
            int l = points[i][0];
            Map.Entry<Integer, List<Integer>> lengths = save.ceilingEntry(points[i][1]);
            while (lengths != null) {
                int ch = lengths.getKey();
                List<Integer> ls = lengths.getValue();
                int left = 0, right = ls.size() - 1;
                if (ls.get(0) >= l) {
                    result[i] += ls.size();
                } else if (ls.get(right) < l) {
                    result[i] += 0;
                } else {
                    while (left < right) {
                        int middle = (left + right) / 2;
                        if (ls.get(middle) < l) {
                            left = middle + 1;
                        } else {
                            right = middle;
                        }
                    }
                    result[i] += (ls.size() - left);
                }
                lengths = save.higherEntry(ch);
            }
        }
        return result;
    }
}
