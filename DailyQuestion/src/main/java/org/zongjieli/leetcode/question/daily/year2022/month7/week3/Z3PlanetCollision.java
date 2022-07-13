package org.zongjieli.leetcode.question.daily.year2022.month7.week3;

import java.util.Arrays;

/**
 * 给定一个整数数组 asteroids 表示在同一行的行星
 * 对于数组中的每一个元素,其绝对值表示行星的大小
 * 正负表示行星的移动方向(正表示向右移动,负表示向左移动)
 * 每一颗行星以相同的速度移动
 * 找出碰撞后剩下的所有行星
 * 碰撞规则:
 *  两个行星相互碰撞,较小的行星会爆炸
 *  如果两颗行星大小相同,则两颗行星都会爆炸
 *  两颗移动方向相同的行星,永远不会发生碰撞
 *
 * 2 <= asteroids.length <= 10^4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *
 * @author   Li.zongjie
 * @date     2022/7/13
 * @version  1.0
 */
public class Z3PlanetCollision {

    public int[] asteroidCollision(int[] asteroids) {
        int l = asteroids.length;
        int[] rl = new int[l];
        int i = 0, ri = 0;
        while (i < l) {
            if (ri == 0 || asteroids[i] > 0 || rl[ri - 1] < 0) {
                rl[ri++] = asteroids[i++];
            } else if (-asteroids[i] < rl[ri - 1]) {
                i++;
            } else if (-asteroids[i] > rl[ri - 1]) {
                ri--;
            } else {
                i++;
                ri--;
            }
        }
        int[] result = new int[ri];
        System.arraycopy(rl, 0, result, 0, ri);
        return result;
    }

    public static void main(String[] args) {
        Z3PlanetCollision test = new Z3PlanetCollision();
        // 5, 10
        System.out.println(Arrays.toString(test.asteroidCollision(new int[]{5, 10, -5})));
        // []
        System.out.println(Arrays.toString(test.asteroidCollision(new int[]{8, -8})));
        // 10
        System.out.println(Arrays.toString(test.asteroidCollision(new int[]{10, 2, -5})));
        // -2, -2, -2
        System.out.println(Arrays.toString(test.asteroidCollision(new int[]{-2, -2, 1, -2})));
    }
}
