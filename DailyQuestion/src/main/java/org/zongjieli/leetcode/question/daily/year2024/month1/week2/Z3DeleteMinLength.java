package org.zongjieli.leetcode.question.daily.year2024.month1.week2;

/**
 * 给定一个仅由大写英文字符组成的字符串 s
 * 可以对此字符串执行一些操作,在每一步操作中
 * 可以从 s 中删除任一个 "AB" 或 "CD" 子字符串
 * 通过执行操作,删除所有 "AB" 和 "CD" 子串,返回可获得的最终字符串的最小可能长度
 * 注意,删除子串后,重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串
 *
 * 1 <= s.length <= 100
 * s 仅由大写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/11
 */
public class Z3DeleteMinLength {

    public int minLength(String s) {
        char[] nextString = s.toCharArray();
        int endIndex = 0, length = nextString.length;
        for (int i = 1 ; i < length ; i++) {
            if (endIndex >= 0 && ((nextString[i] == 'B' && nextString[endIndex] == 'A')
                    || (nextString[i] == 'D' && nextString[endIndex] == 'C'))) {
                endIndex--;
                continue;
            }
            nextString[++endIndex] = nextString[i];
        }
        return endIndex + 1;
    }

    public static void main(String[] args) {
        Z3DeleteMinLength test = new Z3DeleteMinLength();
        // 2
        System.out.println(test.minLength("ABFCACDB"));
    }

}
