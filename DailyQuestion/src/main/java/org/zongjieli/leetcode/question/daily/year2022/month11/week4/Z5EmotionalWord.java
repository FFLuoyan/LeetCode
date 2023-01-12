package org.zongjieli.leetcode.question.daily.year2022.month11.week4;

/**
 * 有时候人们会用重复写一些字母来表示额外的感受
 * 比如 "hello" -> "heeellooo", "hi" -> "hiii"
 * 将相邻字母都相同的一串字符定义为相同字母组,例如:"h", "eee", "ll", "ooo"
 * 对于一个给定的字符串 S,如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同
 * 我们将这个单词定义为可扩张的(stretchy)
 * 扩张操作定义如下:
 *  选择一个字母组(包含字母 c),然后往其中添加相同的字母 c 使其长度达到 3 或以上
 * 例如,以 "hello" 为例,可以对字母组 "o" 扩张得到 "hellooo"
 * 但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3
 * 此外,我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"
 * 如果 s = "helllllooo",那么查询词 "hello" 是可扩张的
 * 因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s
 * 输入一组查询单词,输出其中可扩张的单词数量
 *
 * 1 <= s.length, words.length <= 100
 * 1 <= words[i].length <= 100
 * s 和所有在 words 中的单词都只由小写字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/12
 */
public class Z5EmotionalWord {

    public int expressiveWords(String s, String[] words) {
        int sl = s.length(), vl = 0, result = 0;
        char[] chars = new char[sl], scs = s.toCharArray();
        int[] count = new int[sl];
        for (int i = 0 ; i < sl ;) {
            char c = scs[i];
            int cc = 1;
            while (++i < sl && scs[i] == c) {
                cc++;
            }
            chars[vl] = c;
            count[vl++] = cc;
        }
        for (String word : words) {
            int ci = 0, wi = 0, wl = word.length();
            char[] wcs = word.toCharArray();
            char wc;
            while (wi < wl && ci < vl && (wc = wcs[wi]) == chars[ci]) {
                int wn = 1;
                while (++wi < wl && wcs[wi] == wc) {
                    wn++;
                }
                int cn = count[ci];
                if (wn == cn || (cn >= 3 && cn > wn)) {
                    ci++;
                }
            }
            if (ci == vl && wi == wl) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z5EmotionalWord test = new Z5EmotionalWord();
        // 1
        System.out.println(test.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        // 0
        System.out.println(test.expressiveWords("heeellooo", new String[]{"heeelloooworld"}));
        // 0
        System.out.println(test.expressiveWords("aaa", new String[]{"aaaa"}));
        // 1
        System.out.println(test.expressiveWords("ggkyyyyffffbbhddddrxxsiixccqqqqkmmmiiiiiivvvyyuuujccuuuhhhhwssssnnttoyuuuussggttttfeeeebbbbeedddddqq", new String[]{"ggkyyfbbhdrxxsiixccqkmmiiivvvyyujccuuuhhwsnnttoyuuussggtttfeeebbbeedddqq"}));
    }

}
