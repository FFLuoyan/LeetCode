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
        int[] save = new int[boxTypes.length];
        for (int i = 0; i < boxTypes.length; i++) {
            save[i] = (boxTypes[i][1] << 10) + boxTypes[i][0];
        }
        Arrays.sort(save);
        int result = 0;
        for (int i = save.length - 1; i >= 0; i--) {
            int count = save[i] & 1023, number = save[i] >> 10;
            if (truckSize <= count) {
                return truckSize * number + result;
            }
            truckSize -= count;
            result += number * count;
        }
        return result;
    }

}
