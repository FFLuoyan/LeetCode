package org.zongjieli.leetcode.primaryalgorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: PascalTriangle
 * @Description: 帕斯卡三角形,每一行的数等于上一行的两个数相加
 *               这样组成的三角形叫做帕斯卡三角形
 *               帕斯卡三角形的最早记录在中国,由中国南宋数学家杨辉记录在九章算法当中
 *               帕斯卡的发现比杨辉晚了 393 年,比贾宪晚了 600年(原作已失,主要内容被杨辉抄录)
 * @Author: Zongjie.Li
 * @Date: 2020/4/1
 * @Version: 1.0
 **/
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int row = 0 ;row<numRows ; row++){
            List<Integer> triangleRow = new ArrayList<>(row + 1);
            pascalTriangle.add(triangleRow);
            triangleRow.add(1);
            if (row == 0){
                continue;
            }
            List<Integer> rowBefore = pascalTriangle.get(row - 1);
            for (int column = 1 ;column < rowBefore.size();column ++){
                triangleRow.add(rowBefore.get(column) + rowBefore.get(column - 1));
            }
            triangleRow.add(1);
        }
        return pascalTriangle;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        pascalTriangle.generate(10).forEach(list -> System.out.println(list));
    }
}
