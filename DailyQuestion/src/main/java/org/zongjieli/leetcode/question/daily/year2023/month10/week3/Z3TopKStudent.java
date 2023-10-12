package org.zongjieli.leetcode.question.daily.year2023.month10.week3;

import java.util.*;

/**
 * 给定两个字符串数组 positive_feedback 和 negative_feedback
 * 分别包含表示正面的和负面的词汇,不会有单词同时是正面的和负面的
 * 一开始,每位学生分数为 0,每个正面的单词会给学生的分数加 3 分,每个负面的词会给学生的分数减 1 分
 * 给定 n 个学生的评语,用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示
 * 其中 student_id[i] 表示这名学生的 ID,这名学生的评语是 report[i],每名学生的 ID 互不相同
 * 给定一个整数 k,请返回按照得分从高到低最顶尖的 k 名学生,如果有多名学生分数相同,ID 越小排名越前
 *
 * 1 <= positive_feedback.length, negative_feedback.length <= 10^4
 * 1 <= positive_feedback[i].length, negative_feedback[j].length <= 100
 * positive_feedback[i] 和 negative_feedback[j] 都只包含小写英文字母
 * positive_feedback 和 negative_feedback 中不会有相同单词
 * n == report.length == student_id.length
 * 1 <= n <= 10^4
 * report[i] 只包含小写英文字母和空格 ' '
 * report[i] 中连续单词之间有单个空格隔开
 * 1 <= report[i].length <= 100
 * 1 <= student_id[i] <= 10^9
 * student_id[i] 的值互不相同
 * 1 <= k <= n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/11
 */
public class Z3TopKStudent {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> scoreMap = new HashMap<>();
        for (String s : positive_feedback) {
            scoreMap.put(s, 3);
        }
        for (String s : negative_feedback) {
            scoreMap.put(s, -1);
        }
        int[][] studentScore = new int[student_id.length][2];
        int index = 0;
        for (int i = 0; i < student_id.length; i++) {
            int score = 0;
            for (String s : report[i].split(" ")) {
                score += scoreMap.getOrDefault(s, 0);
            }
            studentScore[index][0] = student_id[i];
            studentScore[index++][1] = score;
        }
        Arrays.sort(studentScore, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        List<Integer> result = new ArrayList<>(k);
        index = 0;
        while (k-- > 0) {
            result.add(studentScore[index++][0]);
        }
        return result;
    }

}
