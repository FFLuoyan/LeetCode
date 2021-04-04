package org.zongjieli.leetcode.question.daily.year2021.month3.week5;

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
        int[] counts = new int[1000];
        int sum = 0;
        for (int answer : answers) {
            counts[answer]--;
            if (counts[answer] < 0){
                sum += (answer + 1);
                counts[answer] += (answer + 1);
            }
        }
        return sum;
    }
}
