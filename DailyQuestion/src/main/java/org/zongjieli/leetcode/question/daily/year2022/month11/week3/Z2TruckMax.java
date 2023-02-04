package org.zongjieli.leetcode.question.daily.year2022.month11.week3;

import java.util.Arrays;

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
        int[] count = new int[1001];
        for (int[] boxType : boxTypes) {
            count[boxType[1]] += boxType[0];
        }
        int result = 0;
        for (int i = 1000 ; i > 0 ; i--) {
            if (truckSize <= count[i]) {
                return result + truckSize * i;
            }
            truckSize -= count[i];
            result += count[i] * i;
        }
        return result;
    }

}
