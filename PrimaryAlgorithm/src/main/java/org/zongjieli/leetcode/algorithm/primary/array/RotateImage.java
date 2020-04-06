package org.zongjieli.leetcode.algorithm.primary.array;

import java.util.Arrays;

/**
 * @ClassName: RotateImage
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/30
 * @Version: 1.0
 **/
public class RotateImage {
    public static void rotateImage(int[][] matrix) {
        int rowLoopLength = matrix.length / 2;
        int columnLoopLength = matrix.length % 2 == 1 ? rowLoopLength + 1 : rowLoopLength;
        for (int rowIndex = 0; rowIndex < rowLoopLength; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnLoopLength; columnIndex++) {
                int rowChange = matrix.length - 1 - rowIndex;
                int columnChange = matrix.length - 1 - columnIndex;
                int temp = matrix[columnChange][rowIndex];
                matrix[columnChange][rowIndex] = matrix[rowChange][columnChange];
                matrix[rowChange][columnChange] = matrix[columnIndex][rowChange];
                matrix[columnIndex][rowChange] = matrix[rowIndex][columnIndex];
                matrix[rowIndex][columnIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // int[][] matrix = new int[][]{{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 10}, {11, 12, 13, 14}};
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Before Rotate: ");
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
        rotateImage(matrix);
        System.out.println("After Rotate: ");
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }
}
