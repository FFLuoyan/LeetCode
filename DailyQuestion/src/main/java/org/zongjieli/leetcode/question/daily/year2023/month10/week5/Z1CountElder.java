package org.zongjieli.leetcode.question.daily.year2023.month10.week5;

/**
 * 给定一个下标从 0 开始的字符串 details,details 中每个元素都是一位乘客的信息
 * 信息用长度为 15 的字符串表示,表示方式如下:
 *  前十个字符是乘客的手机号码
 *  接下来的一个字符是乘客的性别
 *  接下来两个字符是乘客的年龄
 *  最后两个字符是乘客的座位号
 * 请返回乘客中年龄严格大于 60 岁的人数
 *
 * 1 <= details.length <= 100
 * details[i].length == 15
 * details[i] 中的数字只包含 '0' 到 '9'
 * details[i][10] 是 'M','F' 或者 'O' 之一
 * 所有乘客的手机号码和座位号互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/23
 */
public class Z1CountElder {

    public int countSeniors(String[] details) {
        int result = 0, a;
        for (String detail : details) {
            if ((a = detail.charAt(11)) > '6' || (a == '6' && detail.charAt(12) > '0')) {
                result++;
            }
        }
        return result;
    }

}
