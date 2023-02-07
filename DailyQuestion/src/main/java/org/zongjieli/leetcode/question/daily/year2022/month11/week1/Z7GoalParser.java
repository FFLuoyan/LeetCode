package org.zongjieli.leetcode.question.daily.year2022.month11.week1;

/**
 * 请设计一个可以解释字符串 command 的 Goal 解析器
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 * Goal 解析器会将
 *  "G" 解释为字符串 "G"
 *  "()" 解释为字符串 "o"
 *  "(al)" 解释为字符串 "al"
 * 然后,按原顺序将经解释得到的字符串连接成一个字符串
 * 给定字符串 command,返回 Goal 解析器对 command 的解释结果
 *
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/7
 */
public class Z7GoalParser {

    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        byte[] values = command.getBytes();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 'G') {
                result.append('G');
            } else if (values[i] == ')') {
                result.append('o');
            } else if (values[i] == 'a') {
                result.append('a');
                result.append('l');
                i += 2;
            }
        }
        return result.toString();
    }

}
