package org.zongjieli.leetcode.question.daily.year2025.month1.week2;

/**
 * 给定两个字符串 word1 和 word2
 * 如果一个字符串 x 重新排列后,word2 是重排字符串的前缀
 * 那么称字符串 x 是合法的
 * 请返回 word1 中合法子字符串的数目
 *
 *  1 <= word1.length <= 10^5
 * 1 <= word2.length <= 10^4
 * word1 和 word2 都只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/1/9
 */
public class Z4CountValidSubstring {

    public long validSubstringCount(String word1, String word2) {
        byte[] need = word2.getBytes();
        byte[] all = word1.getBytes();
        int[] needCount = new int[26];
        int[] currentCount = new int[26];
        int countSum = 0;
        int currentIndex = 0;
        long result = 0;
        for (byte b : need) {
            if (needCount[b - 'a']++ == 0) {
                countSum++;
            }
        }
        for (int i = 0; i < all.length; i++) {
            int current = all[i] - 'a';
            if (++currentCount[current] == needCount[current]) {
                if (--countSum == 0) {
                    result+= all.length - i;
                    while (currentIndex <= i) {
                        int delete = all[currentIndex++] - 'a';
                        if (--currentCount[delete] < needCount[delete]) {
                            countSum++;
                            break;
                        } else {
                            result+= all.length - i;
                        }
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Z4CountValidSubstring test= new Z4CountValidSubstring();
        // 1
        System.out.println(test.validSubstringCount("bcca", "abc"));
    }
}
