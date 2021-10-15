package org.zongjieli.leetcode.question.daily.year2021.month10.week3;
/**
 * 给定一个正整数 n,输出外观数列的第 n 项
 *
 * 外观数列是一个整数序列,从数字 1 开始
 * 序列中的每一项都是对前一项的描述
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *  countAndSay(1) = "1"
 *  countAndSay(n) 是对 countAndSay(n-1) 的描述
 *  然后转换成另一个数字字符串
 *
 * 前五项如下：
 *  1.     1
 *  2.     11
 *  3.     21
 *  4.     1211
 *  5.     111221
 *
 * 第一项是数字 1
 * 第二项,描述第一项,这个数是 1 即 "一个 1",记作 "11"
 * 第三项,描述第二项,这个数是 11 即 "二个 1",记作 "21"
 * 第四项,描述第三项,这个数是 21 即 "一个 2 + 一个 1",记作 "1211"
 * 第五项,描述第四项,这个数是 1211 即 "一个 1 + 一个 2 + 二个 1",记作 "111221"
 *
 * 要描述一个数字字符串,首先要将字符串分割为最小数量的组
 * 每个组都由连续的最多相同字符组成
 * 然后对于每个组,先描述字符的数量,然后描述字符,形成一个描述组
 * 要将描述转换为数字字符串
 * 先将每组中的字符数量用数字替换,再将所有描述组连接起来
 *
 * @author   Li.zongjie
 * @date     2021/10/15
 * @version  1.0
 */
public class Z5LookArray {

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2 ; i <= n ; i++){
            StringBuilder stringBuilder = new StringBuilder(2 * result.length());
            int count = 1;
            char currentChar = result.charAt(0);
            for (int j = 1 ; j < result.length() ; j++){
                char nextChar = result.charAt(j);
                if (nextChar == currentChar){
                    count++;
                } else {
                    stringBuilder.append(count);
                    stringBuilder.append(currentChar);
                    currentChar = nextChar;
                    count = 1;
                }
            }
            stringBuilder.append(count);
            stringBuilder.append(currentChar);
            result = stringBuilder.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        Z5LookArray test = new Z5LookArray();
        System.out.println(test.countAndSay(4));
    }
}
