package org.zongjieli.leetcode.question.daily.year2022.month7.week3;

import java.util.Arrays;
import java.util.LinkedList;

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
        LinkedList<Integer> rl = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                rl.addLast(asteroid);
                continue;
            }
            while (!rl.isEmpty() && rl.getLast() > 0 && Math.abs(asteroid) > rl.getLast()) {
                rl.pollLast();
            }
            if (rl.isEmpty() || rl.getLast() < 0) {
                rl.addLast(asteroid);
            }
            if (Math.abs(asteroid) == rl.getLast()) {
                rl.pollLast();
            }
        }
        int[] result = new int[rl.size()];
        for (int i = 0; i < rl.size(); i++) {
            result[i] = rl.get(i);
        }
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
    }
}
