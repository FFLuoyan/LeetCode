package org.zongjieli.leetcode.question.daily.year2021.month5.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有一堵矩形的,由 n 行砖块组成的砖墙
 * 这些砖块高度相同(也就是一个单位高),但是宽度不同
 * 每一行砖块的宽度之和应该相等
 *
 * 画一条自顶向下的,穿过最少砖块的垂线
 * 如果这条线只是从砖块的边缘经过,就不算穿过这块砖
 * 不能沿着墙的两个垂直边缘之一画线,这样显然是没有穿过一块砖的
 *
 * 给定一个二维数组 wall,该数组包含这堵墙的相关信息
 * 其中 wall[i] 是一个代表从左至右每块砖的宽度的数组
 * 需要找出怎样画才能使这条线穿过的砖块数量最少,并且返回穿过的砖块数量
 *
 * n == wall.length
 * 1 <= n <= 10^4
 * 1 <= wall[i].length <= 10^4
 * 1 <= sum(wall[i].length) <= 2 * 10^4
 * 对于每一行 i,sum(wall[i]) 应当是相同的
 * 1 <= wall[i][j] <= 2^31 - 1
 *
 * @author   Zongjie.Li
 * @date     2021/5/2
 * @version  1.0
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> breakPoints = new HashMap<>();
        int[] index = new int[]{0};
        wall.forEach(row -> {
            index[0] = 0;
            for (int i = 0 ; i < row.size() - 1 ; i++){
                index[0] += row.get(i);
                breakPoints.merge(index[0], 1, Integer::sum);
            }
        });
        return wall.size() - (breakPoints.size() == 0 ? 0 : breakPoints.values().stream().mapToInt(Integer::intValue).max().getAsInt());
    }

    public static void main(String[] args) {
        BrickWall wall = new BrickWall();
        System.out.println(wall.leastBricks(wall.wallTest1()));
        System.out.println(wall.leastBricks(wall.wallTest2()));

    }

    public List<List<Integer>> wallTest1(){
        List<List<Integer>> wallTest = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(2);
        row1.add(1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(1);
        row2.add(2);
        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(3);
        row3.add(2);
        List<Integer> row4 = new ArrayList<>();
        row4.add(2);
        row4.add(4);
        List<Integer> row5 = new ArrayList<>();
        row5.add(3);
        row5.add(1);
        row5.add(2);
        List<Integer> row6 = new ArrayList<>();
        row6.add(1);
        row6.add(3);
        row6.add(1);
        row6.add(1);
        wallTest.add(row1);
        wallTest.add(row2);
        wallTest.add(row3);
        wallTest.add(row4);
        wallTest.add(row5);
        wallTest.add(row6);
        return wallTest;
    }

    public List<List<Integer>> wallTest2(){
        List<List<Integer>> wallTest = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        wallTest.add(row1);
        wallTest.add(row2);
        wallTest.add(row3);
        return wallTest;
    }
}
