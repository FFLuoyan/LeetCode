package org.zongjieli.leetcode.question.daily.year2022.month3.week2;
/**
 * 给定一个表示数据的整数数组 data,返回它是否为有效的 UTF-8 编码
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节,遵循以下的规则:
 *  对于 1 字节的字符,字节的第一位设为 0,后面 7 位为这个符号的 unicode 码
 *  对于 n 字节的字符(n > 1),第一个字节的前 n 位都设为 1
 *      第 n+1 位设为 0,后面字节的前两位一律设为 10
 *      剩下的没有提及的二进制位,全部为这个符号的 unicode 码
 *
 * 输入是整数数组,只有每个整数的最低 8 个有效位用来存储数据
 * 这意味着每个整数只表示 1 字节的数据
 *
 * 1 <= data.length <= 2 * 10^4
 * 0 <= data[i] <= 255
 *
 * @author   Li.zongjie
 * @date     2022/3/14
 * @version  1.0
 */
public class Z7ValidUtf8 {
    public boolean validUtf8(int[] data) {
        int remain = 0;
        for (int current : data) {
            if (remain == 0) {
                if ((current & 128) == 0) {
                    continue;
                }
                if ((current & 64) == 0) {
                    return false;
                }
                if ((current & 32) == 0) {
                    remain = 1;
                } else if ((current & 16) == 0) {
                    remain = 2;
                } else if ((current & 8) == 0) {
                    remain = 3;
                } else {
                    return false;
                }
            } else {
                remain--;
                if ((current & 192) != 128) {
                    return false;
                }
            }
        }
        return remain == 0;
    }

    public static void main(String[] args) {
        Z7ValidUtf8 test = new Z7ValidUtf8();
        System.out.println(test.validUtf8(new int[]{197, 130, 1}));
    }
}
