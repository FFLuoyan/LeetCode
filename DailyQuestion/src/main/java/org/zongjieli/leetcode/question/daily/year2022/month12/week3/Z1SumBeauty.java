package org.zongjieli.leetcode.question.daily.year2022.month12.week3;

/**
 * 一个字符串的美丽值定义为:出现频率最高字符与出现频率最低字符的出现次数之差
 * 比方说,"abaacc" 的美丽值为 3 - 1 = 2
 * 给定一个字符串 s,请你返回它所有子字符串的美丽值之和
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/11
 */
public class Z1SumBeauty {

    public int beautySum(String s) {
        int sum = 0;
        byte[] values = s.getBytes();
        for (int i = 0 ; i < values.length ; i++) {
            sum += startBeautySum(values, i);
        }
        return sum;
    }

    public int startBeautySum(byte[] values, int start) {
        int sum = 0, max = 1;
        int[] count = new int[26];
        for (; start < values.length ; start++) {
            max = Math.max(max, ++count[values[start] - 'a']);
            int min = max;
            for (int i : count) {
                if (i > 0) {
                    min = Math.min(i, min);
                }
            }
            sum += (max - min);
        }
        return sum;
    }

    public static void main(String[] args) {
        Z1SumBeauty test = new Z1SumBeauty();
        // 5
        System.out.println(test.beautySum("aabcb"));
    }
}
