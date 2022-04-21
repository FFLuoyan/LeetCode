package org.zongjieli.leetcode.question.daily.year2022.month4.week4;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 给定一个由若干单词组成的句子 sentence,单词间由空格分隔
 * 每个单词仅由大写和小写英文字母组成
 * 请将句子转换为 "山羊拉丁文(Goat Latin)",一种类似于猪拉丁文 - Pig Latin 的虚构语言
 * 山羊拉丁文的规则如下:
 *  如果单词以元音开头('a', 'e', 'i', 'o', 'u'),在单词后添加 "ma"
 *      例如,单词 "apple" 变为 "applema"
 *  如果单词以辅音字母开头(即非元音字母),移除第一个字符并将它放到末尾,之后再添加"ma"
 *      例如,单词 "goat" 变为 "oatgma"
 *  根据单词在句子中的索引,在单词最后添加与索引相同数量的字母'a',索引从 1 开始
 *      例如,在第一个单词后添加 "a",在第二个单词后添加 "aa",以此类推
 * 返回将 sentence 转换为山羊拉丁文后的句子
 *
 * 1 <= sentence.length <= 150
 * sentence 由英文字母和空格组成
 * sentence 不含前导或尾随空格
 * sentence 中的所有单词由单个空格分隔
 *
 * @author   Li.zongjie
 * @date     2022/4/21
 * @version  1.0
 */
public class Z4GoatLatin {

    public String toGoatLatin(String sentence) {
        StringBuilder current = new StringBuilder("ma");
        return Arrays
                .stream(sentence.split(" "))
                .map(word -> {
                    current.append('a');
                    char first = word.charAt(0);
                    if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u' || first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U') {
                        return word + current.toString();
                    }
                    return word.substring(1) + first + current.toString();
                })
                .collect(Collectors.joining(" "));
    }
}
