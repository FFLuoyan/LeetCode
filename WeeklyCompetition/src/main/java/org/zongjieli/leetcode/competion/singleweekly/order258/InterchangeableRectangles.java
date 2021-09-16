package org.zongjieli.leetcode.competion.singleweekly.order258;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * 用一个下标从 0 开始的二维整数数组 rectangles 来表示 n 个矩形
 * 其中 rectangles[i] = [widthI, heightI] 表示第 i 个矩形的宽度和高度
 * 如果两个矩形 i 和 j(i < j)的宽高比相同,则认为这两个矩形可互换
 * 更规范的说法是,两个矩形满足 widthI/heightI == widthJ/heightJ(使用实数除法而非整数除法)
 * 则认为这两个矩形可互换
 *
 * 计算并返回 rectangles 中有多少对可互换矩形
 *
 * n == rectangles.length
 * 1 <= n <= 10^5
 * rectangles[i].length == 2
 * 1 <= widthI, heightI <= 10^5
 *
 * @author   Li.zongjie
 * @date     2021/9/12
 * @version  1.0
 */
public class InterchangeableRectangles {

    public long interchangeableRectangles(int[][] rectangles) {
        Map<String, Integer> save = new HashMap<>(2 * rectangles.length);
        long count = 0;
        for (int[] rectangle : rectangles) {
            String value = new BigDecimal(rectangle[0]).divide(new BigDecimal(rectangle[1]),8, RoundingMode.HALF_UP).toString();
            count += (save.merge(value,1,Integer::sum) - 1);
        }
        return count;
    }
}
