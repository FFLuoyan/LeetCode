package org.zongjieli.leetcode.question.daily.year2021.month3.week5;

import java.util.HashMap;
import java.util.Map;

/**
 * 森林中,每个兔子都有颜色,其中一些兔子(可能是全部)告诉你好友多少其他的兔子和自己有相同的颜色
 * 我们将这些回答放在 answer 数组里
 *
 * 返回森林中兔子的最少数量
 *
 * @author   Zongjie.Li
 * @date     2021/4/4
 * @version  1.0
 */
public class RabbitInForest {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> color = new HashMap<>(2 * answers.length);
        for (int answer : answers) {
            color.compute(answer,(k,v) -> v == null ? 1 : v + 1);
        }
        return color.entrySet().stream().mapToInt(entity -> {
            int group = entity.getKey() + 1;
            int number = entity.getValue();
            int remain = number % group;
            return ((remain > 0 ? 1 : 0) +number / group) * group;
        }).sum();
    }
}
