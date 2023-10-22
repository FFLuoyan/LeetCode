package org.zongjieli.leetcode.question.daily.year2023.month10.week4;

import java.util.Arrays;

/**
 * 一个厨师收集了他 n 道菜的满意程度 satisfaction,这个厨师做出每道菜的时间都是 1 单位时间
 * 一道菜的 like-time 系数定义为烹饪这道菜结束的时间(包含之前每道菜所花费的时间)乘以这道菜的满意程度
 * 也就是 time[i] * satisfaction[i]
 * 返回厨师在准备了一定数量的菜肴后可以获得的最大 like-time 系数总和
 * 可以按任意顺序安排做菜的顺序,也可以选择放弃做某些菜来获得更大的总和
 *
 * n == satisfaction.length
 * 1 <= n <= 500
 * -1000 <= satisfaction[i] <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/22
 */
public class Z7MaxScore {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int result = 0, add = 0, sub = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            int current = satisfaction[i];
            if (current >= 0) {
                add += current;
            } else {
                sub -= current;
            }
            if (add <= sub) {
                return result;
            }
            result += (add - sub);
        }
        return result;
    }

    public static void main(String[] args) {
        Z7MaxScore test = new Z7MaxScore();
        // 14
        System.out.println(test.maxSatisfaction(new int[]{-1, -8, 0, 5, -7}));
    }

}
