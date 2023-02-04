package org.zongjieli.leetcode.question.daily.year2022.month11.week3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 请将一些箱子装在一辆卡车上
 * 给定一个二维数组 boxTypes
 * 其中 boxTypes[i] = [numberOfBoxesI, numberOfUnitsPerBoxI]:
 *  numberOfBoxesI 是类型 i 的箱子的数量
 *  numberOfUnitsPerBoxI 是类型 i 每个箱子可以装载的单元数量
 * 整数 truckSize 表示卡车上可以装载箱子的最大数量
 * 只要箱子数量不超过 truckSize,就可以选择任意箱子装到卡车上
 *
 * 返回卡车可以装载单元的最大总数
 *
 * 1 <= boxTypes.length <= 1000
 * 1 <= numberOfBoxesI, numberOfUnitsPerBoxI <= 1000
 * 1 <= truckSize <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/4
 */
public class Z2TruckMax {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[1]));
        int result = 0;
        for (int i = boxTypes.length - 1; i >= 0; i--) {
            if (truckSize > boxTypes[i][0]) {
                truckSize -= boxTypes[i][0];
                result += boxTypes[i][1] * boxTypes[i][0];
            } else {
                result += boxTypes[i][1] * truckSize;
                return result;
            }
        }
        return result;
    }

}
