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
        byte[] values = s.getBytes();
        int sum = 0, length = values.length;
        for (int i = 0 ; i < length ; i++) {
            int min = 1, max = 1, minIndex = values[i] - 'a', index, v;
            int[] count = new int[26];
            count[minIndex]++;
            for (int j = i + 1 ; j < length ; j++) {
                if ((v = ++count[index = values[j] - 'a']) > max) {
                    max = v;
                }
                if (v < min) {
                    min = v;
                    minIndex = index;
                } else if (index == minIndex) {
                    min = length;
                    for (int countIndex = 0; countIndex < 26; countIndex++) {
                        if (count[countIndex] > 0 && count[countIndex] < min) {
                            min = count[countIndex];
                            minIndex = countIndex;
                        }
                    }
                }
                sum += (max - count[minIndex]);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Z1SumBeauty test = new Z1SumBeauty();
        // 5
        System.out.println(test.beautySum("aabcb"));
        // 0
        System.out.println(test.beautySum("x"));
    }
}
