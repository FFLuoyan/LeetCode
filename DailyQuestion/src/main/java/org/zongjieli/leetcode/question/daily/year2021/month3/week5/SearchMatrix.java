package org.zongjieli.leetcode.question.daily.year2021.month3.week5;
/**
 * 搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m × n 矩阵中是否存在一个目标值
 * 该矩阵具有如下特性
 *
 *     1.每行的整数从左到右按升序排列
 *     2.每行的第一个整数大于前一行的最后一个整数
 *
 * @author   Zongjie.Li
 * @date     2021/3/30
 * @version  1.0
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int minIndex = 0;
        int maxIndex = row * column - 1;

        while (minIndex <= maxIndex){
            int checkIndex = (minIndex + maxIndex) / 2;
            int checkRow = checkIndex / column;
            int checkColumn = checkIndex % column;
            int compareValue = matrix[checkRow][checkColumn];
            if (compareValue == target){
                return true;
            }
            if (compareValue < target){
                minIndex = checkIndex + 1;
            } else {
                maxIndex = checkIndex - 1;
            }
        }
        return false;
    }
}
