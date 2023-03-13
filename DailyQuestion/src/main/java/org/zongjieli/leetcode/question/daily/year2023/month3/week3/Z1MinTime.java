package org.zongjieli.leetcode.question.daily.year2023.month3.week3;

/**
 * 正在参加一场比赛,给定两个正整数 initialEnergy 和 initialExperience 分别表示初始精力和初始经验
 * 另给定两个下标从 0 开始的整数数组 energy 和 experience,长度均为 n
 * 将会依次对上 n 个对手,第 i 个对手的精力和经验分别用 energy[i] 和 experience[i] 表示
 * 当对上对手时,需要在经验和精力上都严格超过对手才能击败他们,然后在可能的情况下继续对上下一个对手
 * 击败第 i 个对手会使经验增加 experience[i],但会将精力减少 energy[i]
 * 在开始比赛前,可以训练几个小时,每训练一个小时,可以选择将增加经验增加 1 或者将精力增加 1
 * 返回击败全部 n 个对手需要训练的最少小时数目
 *
 * n == energy.length == experience.length
 * 1 <= n <= 100
 * 1 <= initialEnergy, initialExperience, energy[i], experience[i] <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/13
 */
public class Z1MinTime {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int result = 0;
        for (int e : energy) {
            result += e;
        }
        result = initialEnergy > result ? 0 : result - initialEnergy + 1;
        for (int i : experience) {
            if (initialExperience <= i) {
                result += (i - initialExperience + 1);
                initialExperience = i + 1;
            }
            initialExperience += i;
        }
        return result;
    }

}
