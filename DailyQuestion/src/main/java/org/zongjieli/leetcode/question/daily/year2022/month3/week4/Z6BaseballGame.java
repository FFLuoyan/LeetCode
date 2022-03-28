package org.zongjieli.leetcode.question.daily.year2022.month3.week4;

import java.util.LinkedList;

/**
 * 一场采用特殊赛制的棒球比赛,这场比赛由若干回合组成
 * 过去几回合的得分可能会影响以后几回合的得分
 *
 * 比赛开始时,记录是空白的,存在一个记录操作的字符串列表 ops
 * 其中 ops[i] 是需要记录的第 i 项操作,ops 遵循下述规则:
 *
 *  整数 x: 表示本回合新获得分数 x
 *  "+":    表示本回合新获得的得分是前两次得分的总和,数据保证记录此操作时前面总是存在两个有效的分数
 *  "D":    表示本回合新获得的得分是前一次得分的两倍,数据保证记录此操作时前面总是存在一个有效的分数
 *  "C":    表示前一次得分无效,将其从记录中移除,数据保证记录此操作时前面总是存在一个有效的分数
 *
 * 请返回记录中所有得分的总和
 *
 * 1 <= ops.length <= 1000
 * ops[i] 为 "C"、"D"、"+",或者一个表示整数的字符串,整数范围是 [-3 * 10^4, 3 * 10^4]
 * 对于 "+" 操作,题目数据保证记录此操作时前面总是存在两个有效的分数
 * 对于 "C" 和 "D" 操作,题目数据保证记录此操作时前面总是存在一个有效的分数
 *
 * @author   Li.zongjie
 * @date     2022/3/28
 * @version  1.0
 */
public class Z6BaseballGame {

    public int calPoints(String[] ops) {
        int[] values = new int[ops.length];
        int ci = 0;
        int all = 0;
        for (String op : ops) {
            switch (op) {
                case "D":
                    values[ci] = 2 * values[ci - 1];
                    all += values[ci++];
                    break;
                case "+":
                    values[ci] = values[ci - 1] + values[ci - 2];
                    all += values[ci++];
                    break;
                case "C":
                    all -= values[--ci];
                    break;
                default:
                    values[ci] = Integer.parseInt(op);
                    all += values[ci++];
                    break;
            }
        }
        return all;
    }

    public static void main(String[] args) {
        Z6BaseballGame test = new Z6BaseballGame();
        // 30
        System.out.println(test.calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}
