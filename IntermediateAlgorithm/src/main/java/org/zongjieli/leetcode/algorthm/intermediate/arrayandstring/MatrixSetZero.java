package org.zongjieli.leetcode.algorthm.intermediate.arrayandstring;

import java.util.Arrays;

/**
 * @ClassName: MatrixSetZero
 * @Description: 给定一个矩阵,如果一个元素为 0,则将其所在的行和列都设为 0,请使用原地算法
 * @Author: Zongjie.Li
 * @Date: 2020/4/11
 * @Version: 1.0
 **/
public class MatrixSetZero {
    public void setZeroes(int[][] matrix) {
        // 如果不使用额外空间,则使用矩阵本身的空间对有 0 的行和列进行记录
        // 用第一行与第一列记录当前的状态
        // 首先对矩阵进行一个全遍历,将状态保存
        // 再对状态进行遍历(行和列两种状态),将为 0 状态的行和列全部设置为0
        // (0,0) 的位置这里仅仅表示第一行的状态,第一列的状态用变量保存
        boolean columnClear = false;
        if (matrix[0][0] == 0){
            // 首先对 (0,0) 进行校验,如果这个坐标为0,则不需要对第一行和第一列的状态校验
            columnClear = true;
        } else {
            // 校验第一列的状态,保存在 (0,0) 的位置
            for (int columnIndex = 1;columnIndex < matrix[0].length ;columnIndex++){
                if (matrix[0][columnIndex] == 0){
                    matrix[0][0] = 0;
                    break;
                }
            }
            for (int rowIndex = 1;rowIndex < matrix.length;rowIndex++){
                if (matrix[rowIndex][0] == 0){
                    columnClear = true;
                    break;
                }
            }
        }

        for (int rowIndex = 1;rowIndex < matrix.length ; rowIndex++){
            // 遍历整个矩阵(除第一行与第一列),将状态保存
            for (int columnIndex = 1;columnIndex < matrix[rowIndex].length;columnIndex++){
                if (matrix[rowIndex][columnIndex] == 0){
                    matrix[0][columnIndex] = 0;
                    matrix[rowIndex][0] = 0;
                }
            }
        }

        // 根据矩阵列的状态将矩阵的每一列设置为 0,除了第一列
        for (int columnIndex = 1;columnIndex < matrix[0].length ;columnIndex++){
            if (matrix[0][columnIndex] == 0){
                for (int rowIndex = 1;rowIndex < matrix.length;rowIndex++){
                    matrix[rowIndex][columnIndex] = 0;
                }
            }
        }

        // 根据矩阵行的状态将矩阵的每一行设置为 0,包括第一行
        for (int rowIndex = 0;rowIndex<matrix.length;rowIndex++){
            if (matrix[rowIndex][0] == 0){
                for (int columnIndex = 1;columnIndex < matrix[rowIndex].length ;columnIndex++){
                    matrix[rowIndex][columnIndex] = 0;
                }
            }
        }

        // 根据 columnIndex 判断第一列的状态
        if (columnClear){
            for (int rowIndex = 0;rowIndex<matrix.length;rowIndex++){
                matrix[rowIndex][0] = 0;
            }
        }

    }

    public static void main(String[] args) {
        MatrixSetZero matrixSetZero = new MatrixSetZero();
        int[][] testArray = new int[][]{{1},{0}};
        matrixSetZero.setZeroes(testArray);
        for (int[] subarray : testArray){
            System.out.println(Arrays.toString(subarray));
        }

    }
}
