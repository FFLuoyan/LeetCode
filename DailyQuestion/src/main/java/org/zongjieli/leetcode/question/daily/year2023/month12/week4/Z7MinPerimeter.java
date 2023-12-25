package org.zongjieli.leetcode.question.daily.year2023.month12.week4;

/**
 * 给定一个用无限二维网格表示的花园,每一个整数坐标处都有一棵苹果树
 * 整数坐标 (i, j) 处的苹果树有 |i| + |j| 个苹果
 * 买下正中心坐标是 (0, 0) 的一块正方形土地,且每条边都与两条坐标轴之一平行
 * 给定一个整数 neededApples,请返回土地的最小周长
 * 使得至少有 neededApples 个苹果在土地里面或者边缘上
 * |x| 的值定义为:
 *  如果 x >= 0,那么值为 x
 *  如果 x < 0,那么值为 -x
 *
 * 1 <= neededApples <= 10^15
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/25
 */
public class Z7MinPerimeter {

    public long minimumPerimeter(long neededApples) {
        long min = 0, max = 100000;
        while (min < max) {
            long value = (min + max) / 2;
            if (value * (value + 1) * (2 * value + 1) * 2 >= neededApples) {
                max = value;
            } else {
                min = value + 1;
            }
        }
        return 8 * min;
    }
}
