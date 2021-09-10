package org.zongjieli.leetcode.question.daily.year2021.month9.week2;
/**
 * 一个班级里有 n 个学生,编号为 0 到 n - 1
 * 每个学生会依次回答问题,编号为 0 的学生先回答，,然后是编号为 1 的学生,以此类推
 * 直到编号为 n - 1 的学生,然后老师会重复这个过程,重新从编号为 0 的学生开始回答问题
 *
 * 给一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k
 * 一开始粉笔盒里总共有 k 支粉笔
 * 当编号为 i 的学生回答问题时,他会消耗 chalk[i] 支粉笔
 * 如果剩余粉笔数量严格小于 chalk[i],那么学生 i 需要补充粉笔
 *
 * 请你返回需要补充粉笔的学生编号
 *
 * chalk.length == n
 * 1 <= n <= 10^5
 * 1 <= chalk[i] <= 10^5
 * 1 <= k <= 10^9
 *
 * @author   Li.zongjie
 * @date     2021/9/10
 * @version  1.0
 */
public class Z5FindSupplement {
    public int chalkReplacer(int[] chalk, int k) {
        if (k < chalk[0]){
            return 0;
        }
        int i = 0;
        while (++i < chalk.length){
            if ((chalk[i] += chalk[i - 1]) > k){
                return i;
            }
        }
        k %= chalk[chalk.length - 1];
        i = -1;
        while (k >= chalk[++i]){ }
        return i;
    }

    public static void main(String[] args) {
        Z5FindSupplement test = new Z5FindSupplement();
        System.out.println(test.chalkReplacer(new int[]{5,1,5},22));
        System.out.println(test.chalkReplacer(new int[]{3,4,1,2},25));
    }
}
