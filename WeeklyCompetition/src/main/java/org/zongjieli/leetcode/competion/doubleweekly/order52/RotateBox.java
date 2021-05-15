package org.zongjieli.leetcode.competion.doubleweekly.order52;

import java.util.Arrays;

/**
 * 给定一个 m x n 的字符矩阵 box
 * 它表示一个箱子的侧视图
 * 箱子的每一个格子可能为：
 *
 * '#' 表示石头
 * '*' 表示固定的障碍物
 * '.' 表示空位置
 *
 * 这个箱子被顺时针旋转 90 度
 * 由于重力原因,部分石头的位置会发生改变
 * 每个石头会垂直掉落,直到它遇到障碍物、另一个石头或者箱子的底部
 * 重力不会影响障碍物的位置,同时箱子旋转不会产生惯性,也就是说石头的水平位置不会发生改变
 *
 * 题目保证初始时 box 中的石头要么在一个障碍物上,要么在另一个石头上,要么在箱子的底部
 * 请返回一个 n x m的矩阵,表示按照上述旋转后,箱子内的结果
 *
 * m == box.length
 * n == box[i].length
 * 1 <= m, n <= 500
 * box[i][j] 只可能是 '#','*' 或者 '.'
 *
 * @author   Zongjie.Li
 * @date     2021/5/15
 * @version  1.0
 */
public class RotateBox {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        for (int i = 0 ; i < m ; i ++){
            char[] row = box[i];
            int lastStone = row.length - 1;
            int resultColumn = m - i - 1;
            for (int j = lastStone ; j >= 0 ; j--){
                if (row[j] == '*'){
                    lastStone = j - 1;
                    result[j][resultColumn] = '*';
                } else if (row[j] == '#'){
                    result[lastStone--][resultColumn] = '#';
                }
            }
            for (int j = 0 ; j < n ; j++){
                if (result[j][resultColumn] == 0){
                    result[j][resultColumn] = '.';
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RotateBox test = new RotateBox();
        System.out.println(Arrays.deepToString(test.rotateTheBox(test.rotateTheBox(new char[][]{{'#', '#'}, {'#', '#'}}))));
    }
}
