package org.zongjieli.leetcode.question.daily.year2022.month10.week1;

/**
 * 给定一个字符串形式的电话号码 number
 * number 由数字、空格 ' '、和破折号 '-' 组成
 * 请按下述方式重新格式化电话号码
 *  首先删除所有的空格和破折号
 *  其次将数组从左到右每 3 个一组分块,直到剩下 4 个或更少数字,剩下的数字将按下述规定再分块
 *      2 个数字: 单个含 2 个数字的块
 *      3 个数字: 单个含 3 个数字的块
 *      4 个数字: 两个分别含 2 个数字的块
 * 最后用破折号将这些块连接起来
 * 注意,重新格式化过程中不应该生成仅含 1 个数字的块,并且最多生成两个含 2 个数字的块
 * 返回格式化后的电话号码
 *
 * 2 <= number.length <= 100
 * number 由数字和字符 '-' 及 ' ' 组成
 * number 中至少含 2 个数字
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/2
 */
public class Z6ReformatPhoneNumber {

    public String reformatNumber(String number) {
        char[] result = new char[200];
        int index = 0;
        for (char c : number.toCharArray()) {
            if (c != ' ' && c != '-') {
                result[index++] = c;
                if ((index & 3) == 3) {
                    result[index++] = '-';
                }
            }
        }
        int last = index & 3;
        if (last == 0) {
            return new String(result, 0, index - 1);
        }
        if (last == 1) {
            result[index - 2] = result[index - 3];
            result[index - 3] = '-';
        }
        return new String(result, 0, index);
    }

}
