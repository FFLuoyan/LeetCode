package org.zongjieli.leetcode.question.daily.year2023.month12.week1;

/**
 * 车上最初有 capacity 个空座位,车只能向一个方向行驶(也就是说,不允许掉头或改变方向)
 * 给定整数 capacity 和一个数组 trips
 * trip[i] = [numPassengersI, fromI, toI] 表示第 i 次旅行有 numPassengersI 乘客
 * 接他们和放他们的位置分别是 fromI 和 toI,这些位置是从汽车的初始位置向东的公里数
 * 当且仅当可以在所有给定的行程中接送所有乘客时,返回 true,否则请返回 false
 *
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersI <= 100
 * 0 <= fromI < toI <= 1000
 * 1 <= capacity <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/4
 */
public class Z6DriveCar {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] remains = new int[1001];
        for (int[] trip : trips) {
            remains[trip[1]] += trip[0];
            remains[trip[2]] -= trip[0];
        }
        int max = 0;
        for (int remain : remains) {
            if ((max += remain) > capacity) {
                return false;
            }
        }
        return true;
    }

}
