package org.zongjieli.leetcode.question.daily.year2024.month1.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串数组 words1 和 words2
 * 请返回在两个字符串数组中都恰好出现一次的字符串的数目
 *
 * 1 <= words1.length, words2.length <= 1000
 * 1 <= words1[i].length, words2[j].length <= 30
 * words1[i] 和 words2[j] 都只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/12
 */
public class Z5CountOnce {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> count = new HashMap<>();
        for (String s : words1) {
            count.merge(s, 10000, Integer::sum);
        }
        for (String s : words2) {
            count.merge(s, 1, Integer::sum);
        }
        int result = 0;
        for (Integer value : count.values()) {
            if (value == 10001) {
                result++;
            }
        }
        return result;
    }

}
