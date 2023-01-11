package org.zongjieli.leetcode.question.daily.year2022.month12.week4;

/**
 * 给定两个字符串 word1 和 word2
 * 需要按下述方式构造一个新字符串 merge:
 * 如果 word1 或 word2 非空,选择下面选项之一继续操作:
 *  如果 word1 非空,将 word1 中的第一个字符附加到 merge 的末尾,并将其从 word1 中移除
 *  例如,word1 = "abc" 且 merge = "dv",在执行此选项操作之后,word1 = "bc",同时 merge = "dva"
 *  如果 word2 非空.将 word2 中的第一个字符附加到 merge 的末尾,并将其从 word2 中移除
 *  例如,word2 = "abc" 且 merge = "",在执行此选项操作之后,word2 = "bc",同时 merge = "a"
 * 返回你可以构造的字典序最大的合并字符串 merge
 * 长度相同的两个字符串 a 和 b 比较字典序大小,如果在 a 和 b 出现不同的第一个位置
 * a 中字符在字母表中的出现顺序位于 b 中相应字符之后
 * 就认为字符串 a 按字典序比字符串 b 更大
 * 例如,"abcd" 按字典序比 "abcc" 更大,因为两个字符串出现不同的第一个位置是第四个字符
 * 而 d 在字母表中的出现顺序位于 c 之后
 *
 * 1 <= word1.length, word2.length <= 3000
 * word1 和 word2 仅由小写英文组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/25
 */
public class Z6LargestString {

    public String largestMerge(String word1, String word2) {
        char[] v1 = word1.toCharArray(), v2 = word2.toCharArray();
        int i1 = 0, i2 = 0, ri = 0, l1 = v1.length, l2 = v2.length;
        char[] result = new char[l1 + l2];
        while (i1 < l1 && i2 < l2) {
            result[ri++] = compare(v1, v2, i1, i2, l1, l2) ? v1[i1++] : v2[i2++];
        }
        while (i1 < l1) {
            result[ri++] = v1[i1++];
        }
        while (i2 < l2) {
            result[ri++] = v2[i2++];
        }
        return new String(result);
    }

    public boolean compare(char[] v1, char[] v2, int i1, int i2, int l1, int l2) {
        while (i1 < l1 && i2 < l2 && v1[i1] == v2[i2]) {
            i1++;
            i2++;
        }
        return i2 == l2 || (i1 < l1 && v1[i1] > v2[i2]);
    }

    public static void main(String[] args) {
        Z6LargestString test = new Z6LargestString();
        // cbcabaaaaa
        System.out.println(test.largestMerge("cabaa", "bcaaa"));
    }

}
