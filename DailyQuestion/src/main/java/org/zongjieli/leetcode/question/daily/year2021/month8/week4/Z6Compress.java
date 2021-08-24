package org.zongjieli.leetcode.question.daily.year2021.month8.week4;

/**
 * 给你一个字符数组 chars,请使用下述算法压缩
 * 从一个空字符串 s 开始,对于 chars 中的每组连续重复字符
 *  如果这一组长度为 1,则将字符追加到 s 中
 *  否则,需要向 s 追加字符,后跟这一组的长度
 * 压缩后得到的字符串 s 不应该直接返回,需要转储到字符数组 chars 中
 * 需要注意的是,如果组长度为 10 或 10 以上,则在 chars 数组中会被拆分为多个字符
 * 请在修改完输入数组后,返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题
 *
 * 1 <= chars.length <= 2000
 * chars[i] 可以是小写英文字母、大写英文字母、数字或符号
 *
 * @author   Li.zongjie
 * @date     2021/8/23
 * @version  1.0
 */
public class Z6Compress {
    public int compress(char[] chars) {
        char currentChar = chars[0];
        int count = 1;
        int index = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == currentChar){
                count++;
                continue;
            }

            currentChar = chars[i];
            if (count == 1){
                chars[index++] = currentChar;
                continue;
            }

            int reverse = 0;
            int reverseCount = 0;
            while (count > 0){
                reverse = 10 * reverse + (count % 10);
                count /= 10;
                reverseCount++;
            }

            while (reverseCount-- > 0){
                chars[index++] = Character.forDigit((reverse % 10),10);
                reverse /= 10;
            }

            count = 1;
            chars[index++] = currentChar;
        }

        if (count > 1){
            int reverse = 0;
            int reverseCount = 0;
            while (count > 0){
                reverse = 10 * reverse + (count % 10);
                count /= 10;
                reverseCount++;
            }
            while (reverseCount-- > 0){
                chars[index++] = Character.forDigit((reverse % 10),10);
                reverse /= 10;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Z6Compress test = new Z6Compress();
        System.out.println(test.compress(new char[]{'a','a','a','a','a','a','a','a','a','a','a','b','a','a','b','a','a','b','a','a','b','a','a','b','a','a','b','a','a','b','a','a','b'}));
    }
}
