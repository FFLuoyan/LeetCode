package org.zongjieli.leetcode.competion.singleweekly.order180;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: LuckyNumberInMatrixArray
 * @Description:    给定一个矩阵,求出矩阵中的所有幸运数,幸运数指的是
 *                  同一行的所有元素中最小
 *                  同一列的所有元素中最大
 *                  矩阵中的数字各不相同
 * @Author: Zongjie.Li
 * @Date: 2020/3/15
 * @Version: 1.0
 **/
public class LuckyNumberInMatrixArray {
    public static void main(String[] args) {
        LuckyNumberInMatrixArray luckyNumberInMatrixArray = new LuckyNumberInMatrixArray();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(luckyNumberInMatrixArray.luckyNumbers(matrix));
    }

    public List<Integer> luckyNumbers(int[][] matrix){
        //  先解决问题,再考虑优化
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int line = 0 ; line < matrix.length ; line ++){
            int min = matrix[line][0];
            int minIndex = 0;
            for (int column = 1; column < matrix[line].length ; column++){
                if (matrix[line][column] < min){
                    min = matrix[line][column];
                    minIndex = column;
                }
            }
            //  此时求出了每行的最小值及下标
            //  min = matrix[line][minIndex];
            boolean isLucky = true;
            for (int maxLine = 0;maxLine < matrix.length ;maxLine ++){
                if (matrix[maxLine][minIndex] > min){
                    isLucky = false;
                    break;
                }
            }
            if (isLucky){
                luckyNumbers.add(min);
            }
        }
        return luckyNumbers;
    }
}
