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
        Map<String, Integer> count1 = new HashMap<>(), count2 = new HashMap<>();
        for (String s : words1) {
            count1.merge(s, 1, Integer::sum);
        }
        for (String s : words2) {
            count2.merge(s, 1, Integer::sum);
        }
        int result = 0;
        for (Map.Entry<String, Integer> entry : count2.entrySet()) {
            if (entry.getValue() == 1 && count1.getOrDefault(entry.getKey(), 0) == 1) {
                result++;
            }
        }
        return result;
    }

}
