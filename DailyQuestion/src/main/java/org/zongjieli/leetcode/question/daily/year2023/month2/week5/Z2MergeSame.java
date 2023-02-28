package org.zongjieli.leetcode.question.daily.year2023.month2.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个二维整数数组 items1 和 items2,表示两个物品集合,每个数组 items 有以下特质:
 * items[i] = [valueI, weightI] 其中 valueI 表示第 i 件物品的价值,weightI 表示第 i 件物品的重量
 * items 中每件物品的价值都是唯一的
 * 请返回一个二维数组 ret,其中 ret[i] = [valueI, weightI]
 * weightI 是所有价值为 valueI 物品的重量之和
 * 注意: ret 应该按价值升序排序后返回
 *
 * 1 <= items1.length, items2.length <= 1000
 * items1[i].length == items2[i].length == 2
 * 1 <= valueI, weightI <= 1000
 * items1 中每个 valueI 都是唯一的
 * items2 中每个 valueI 都是唯一的
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/28
 */
public class Z2MergeSame {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] count = new int[1001];
        for (int[] value : items1) {
            count[value[0]] += value[1];
        }
        for (int[] value : items2) {
            count[value[0]] += value[1];
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                result.add(Arrays.asList(i, count[i]));
            }
        }
        return result;
    }

}
