package org.zongjieli.leetcode.question.daily.year2022.month3.week5;
/**
 * 一位老师正在出一场由 n 道判断题构成的考试
 * 每道题的答案为 true(用 'T' 表示)或者 false(用 'F' 表示)
 * 老师想增加学生对自己做出答案的不确定性
 * 方法是最大化有连续相同结果的题数(也就是连续出现 true 或者连续出现 false)
 *
 * 给定一个字符串 answerKey,其中 answerKey[i] 是第 i 个问题的正确结果
 * 除此以外,还给定一个整数 k,表示能进行以下操作的最多次数:
 *  每次操作中,将问题的正确答案改为 'T' 或者 'F'(也就是将 answerKey[i] 改为 'T' 或者 'F')
 *
 * 请返回在不超过 k 次操作的情况下,最大连续 'T' 或者 'F' 的数目
 *
 * n == answerKey.length
 * 1 <= n <= 5 * 10^4
 * answerKey[i] 要么是 'T',要么是 'F'
 * 1 <= k <= n
 *
 * @author   Li.zongjie
 * @date     2022/3/29
 * @version  1.0
 */
public class Z2MaxWorry {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        byte[] answers = answerKey.getBytes();
        int l = answers.length, rf = k, rt = k, sf = 0, st = 0, max = 0;
        for (int i = 0 ; i < l ; i++) {
            if (answers[i] == 'F') {
                if (rf > 0) {
                    rf--;
                } else {
                    max = Math.max(max, i - sf);
                    while (answers[sf] == 'T') {
                        sf++;
                    }
                    sf++;
                }
            } else if (rt > 0) {
                rt--;
            } else {
                max = Math.max(max, i - st);
                while (answers[st] == 'F') {
                    st++;
                }
                st++;
            }
        }
        return Math.max(max, Math.max(l - st, l - sf));
    }

    public static void main(String[] args) {
        Z2MaxWorry test = new Z2MaxWorry();
        // 4
        System.out.println(test.maxConsecutiveAnswers("TTFF", 2));
    }
}
