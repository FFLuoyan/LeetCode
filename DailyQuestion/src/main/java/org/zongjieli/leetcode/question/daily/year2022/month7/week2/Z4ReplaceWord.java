package org.zongjieli.leetcode.question.daily.year2022.month7.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 在英语中,有一个叫做词根(root)的概念
 * 可以在词根后面添加其他一些词组成另一个较长的单词
 * 我们称这个词为继承词(successor)
 * 例如,词根 an,跟随着单词 other(其他)
 * 可以形成新的单词 another(另一个)
 * 现在给定一个由许多词根组成的词典 dictionary
 * 和一个用空格分隔单词形成的句子 sentence
 * 需要将句子中的所有继承词用词根替换掉
 * 如果继承词有许多可以形成它的词根,则用最短的词根替换它
 * 输出替换之后的句子
 *
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成
 * sentence 中单词的总量在范围 [1, 1000] 内
 * sentence 中每个单词的长度在范围 [1, 1000] 内
 * sentence 中单词之间由一个空格隔开
 * sentence 没有前导或尾随空格
 *
 * @author   Li.zongjie
 * @date     2022/7/8
 * @version  1.0
 */
public class Z4ReplaceWord {

    class DirTree {
        DirTree[] value = new DirTree[27];
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        DirTree dic = new DirTree();
        dictionary.forEach(d -> {
            DirTree cd = dic;
            for (int i = 0 ; i < d.length() ; i++) {
                int c = d.charAt(i) - 'a';
                if (cd.value[c] == null) {
                    cd.value[c] = new DirTree();
                }
                cd = cd.value[c];
            }
            cd.value[26] = cd;
        });
        return Arrays.stream(sentence.split(" ")).map(s -> {
            DirTree cd = dic;
            for (int i = 0 ; i < s.length() && cd != null ; i++) {
                if (cd.value[26] != null) {
                    return s.substring(0, i);
                }
                cd = cd.value[s.charAt(i) - 'a'];
            }
            return s;
        }).collect(Collectors.joining(" "));
    }
}
