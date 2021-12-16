package org.zongjieli.leetcode.question.daily.year2021.month12.week3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个点数组 points 和一个表示角度的整数 angle 及位置 location
 * 其中 location = [posX, posY] 且 points[i] = [xi, yi] 都表示 X-Y 平面上的整数坐标
 *
 * 不能进行移动改变位置,但可以通过自转调整观测角度
 * 换句话说,posX 和 posY 不能改变
 * 视野范围的角度用 angle 表示,这决定了观测任意方向时可以多宽
 * 设 d 为逆时针自转旋转的度数与正东方向的夹角
 * 那么视野就是角度范围 [d - angle/2, d + angle/2] 所指示的那片区域
 *
 * 对于每个点,如果改点位于视野范围中,那么就可以看到它
 * 同一个坐标上可以有多个点,所在的位置也可能存在一些点
 * 但不管怎么旋转,总是可以看到这些点,同时点不会阻碍看到其他点
 *
 * 返回能看到的点的最大数目
 *
 * 1 <= points.length <= 10^5
 * points[i].length == 2
 * location.length == 2
 * 0 <= angle < 360
 * 0 <= posX, posY, xi, yi <= 100
 *
 * @author   Li.zongjie
 * @date     2021/12/16
 * @version  1.0
 */
public class Z4MaxPoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int oX = location.get(0);
        int oY = location.get(1);
        List<Double> temp = points.stream().filter(point -> point.get(0) != oX || point.get(1) != oY).map(point -> Math.atan2(point.get(1) - oY, point.get(0) - oX)).sorted().collect(Collectors.toList());
        int locationPointCount = points.size() - temp.size();
        double min = angle * Math.PI / 180;
        int index = 0;
        while (index < temp.size() && temp.get(index) - min <= -Math.PI){
            temp.add(temp.get(index) + Math.PI + Math.PI);
            index++;
        }

        int startIndex = 0;
        int endIndex = 0;

        int result = 0;

        while (endIndex < temp.size()){
            if (temp.get(endIndex) - temp.get(startIndex) <= min){
                result = Math.max(result, endIndex - startIndex + 1);
                endIndex++;
            } else {
                startIndex++;
            }
        }

        return result + locationPointCount;
    }

    public static void main(String[] args) {
        Z4MaxPoints test = new Z4MaxPoints();
        // 2
//        System.out.println(test.visiblePoints(Arrays.asList(Arrays.asList(1,1), Arrays.asList(2,2), Arrays.asList(1,2), Arrays.asList(2,1)), 0, Arrays.asList(1,1)));
//        // 3
//        System.out.println(test.visiblePoints(Arrays.asList(Arrays.asList(2,1), Arrays.asList(2,2), Arrays.asList(3,3)), 90, Arrays.asList(1,1)));
//        // 4
//        System.out.println(test.visiblePoints(Arrays.asList(Arrays.asList(1,1), Arrays.asList(2,2), Arrays.asList(3,3), Arrays.asList(4,4), Arrays.asList(1,2), Arrays.asList(2,1)), 0, Arrays.asList(1,1)));
//        // 2
//        System.out.println(test.visiblePoints(Arrays.asList(Arrays.asList(0,0), Arrays.asList(0,2)), 90, Arrays.asList(1,1)));
        // 3
        System.out.println(test.visiblePoints(Arrays.asList(Arrays.asList(1,1), Arrays.asList(1,1), Arrays.asList(1,1)), 1, Arrays.asList(1,1)));
    }
}
