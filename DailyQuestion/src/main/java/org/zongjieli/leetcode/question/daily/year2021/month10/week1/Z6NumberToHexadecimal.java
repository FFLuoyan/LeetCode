package org.zongjieli.leetcode.question.daily.year2021.month10.week1;
/**
 * 给定一个整数,编写一个算法将这个数转换为十六进制数
 * 对于负整数,我们通常使用补码运算方法
 *
 *  十六进制中所有字母(a-f)都必须是小写
 *  十六进制字符串中不能包含多余的前导零
 *      如果要转化的数为 0,那么以单个字符 '0' 来表示
 *      对于其他情况,十六进制字符串中的第一个字符将不会是 0 字符
 *  给定的数确保在 32 位有符号整数范围内
 *  不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法
 *
 * @author   Li.zongjie
 * @date     2021/10/21
 * @version  1.0
 */
public class Z6NumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0){
            return "0";
        }
        char[] hex = new char[8];
        int index = 7;
        while (num != 0){
            int last = num & 15;
            hex[index--] = (char) (last <= 9 ? last + '0' : last - 10 + 'a');
            num >>>= 4;
        }
        return new String(hex,index + 1,7-index);
    }

    public static void main(String[] args) {
        Z6NumberToHexadecimal test = new Z6NumberToHexadecimal();
        System.out.println(test.toHex(26));
        System.out.println(test.toHex(Integer.MIN_VALUE));
    }
}
