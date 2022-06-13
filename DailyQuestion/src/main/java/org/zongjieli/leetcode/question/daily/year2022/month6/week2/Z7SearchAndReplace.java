package org.zongjieli.leetcode.question.daily.year2022.month6.week2;

import java.util.LinkedList;
import java.util.List;

/**
 * 有一个单词列表 words 和一个模式  pattern
 * 想知道 words 中的哪些单词与模式匹配
 * 如果存在字母的排列 p,使得将模式中的每个字母 x 替换为 p(x) 之后
 * 我们就得到了所需的单词,那么单词与模式是匹配的
 * 字母的排列是从字母到字母的双射,每个字母映射到另一个字母,没有两个字母映射到同一个字母
 * 返回 words 中与给定模式匹配的单词列表
 * 可以按任何顺序返回答案
 *
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 *
 * @author   Li.zongjie
 * @date     2022/6/13
 * @version  1.0
 */
public class Z7SearchAndReplace {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        char[] pcs = pattern.toCharArray();
        List<String> result = new LinkedList<>();
        a: for (String word : words) {
            char[] w2p = new char[128];
            char[] p2w = new char[128];
            for (int i = 0; i < pcs.length; i++) {
                char w = word.charAt(i);
                char p = pcs[i];
                if (w2p[w] != 0) {
                    if (w2p[w] != p) {
                        continue a;
                    }
                    continue;
                }
                if (p2w[p] != 0) {
                    continue a;
                }
                w2p[w] = p;
                p2w[p] = w;
            }
            result.add(word);
        }
        return result;
    }
}
