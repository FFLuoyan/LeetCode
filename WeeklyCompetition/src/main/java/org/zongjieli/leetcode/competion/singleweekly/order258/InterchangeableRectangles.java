package org.zongjieli.leetcode.competion.singleweekly.order258;

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
        // width:height:number
        long result = 0;
        Map<Integer, Map<Integer,Integer>> save = new HashMap<>();
        for (int[] rectangle : rectangles) {
            int gcd = greatestCommonDivisor(rectangle[0],rectangle[1]);
            Map<Integer,Integer> countMap = save.computeIfAbsent(rectangle[0] / gcd,k -> new HashMap<>());
            result += (countMap.merge(rectangle[1] / gcd,1,Integer::sum) - 1);
        }
        return result;
    }

    private int greatestCommonDivisor(int a, int b){
        int remain = a % b;
        if (remain == 0){
            return b;
        }
        return greatestCommonDivisor(b,remain);
    }
}
