package org.zongjieli.leetcode.question.daily.year2022.month7.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设计一个使用单词列表进行初始化的数据结构
 * 单词列表中的单词互不相同,如果给出一个单词
 * 请判定能否只将这个单词中一个字母换成另一个字母
 * 使得所形成的新单词存在于构建的字典中
 *
 * 实现 Z1MagicDic 类:
 *  Z1MagicDic()
 *      初始化对象
 *  void buildDict(String[] dictionary)
 *      使用字符串数组 dictionary 设定该数据结构
 *      dictionary 中的字符串互不相同
 *  bool search(String searchWord)
 *      给定一个字符串 searchWord
 *      判定能否只将字符串中一个字母换成另一个字母
 *      使得所形成的新字符串能够与字典中的任一字符串匹配
 *      如果可以,返回 true,否则返回 false
 *
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串互不相同
 * 1 <= searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 *
 * @author   Li.zongjie
 * @date     2022/7/13
 * @version  1.0
 */
public class Z1MagicDic {

    private Map<Integer, List<String>> dic = new HashMap<>(100);

    public Z1MagicDic() {

    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            dic.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s);
        }
    }

    public boolean search(String searchWord) {
        List<String> words = dic.get(searchWord.length());
        if (words == null) {
            return false;
        }
        for (String word : words) {
            int count = 0;
            for (int i = 0 ; i < word.length() ; i++) {
                if (word.charAt(i) != searchWord.charAt(i) && count++ > 0) {
                    break;
                }
            }
            if (count == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        Z1MagicDic test = new Z1MagicDic();
//        test.buildDict(new String[]{"hello", "leetcode"});
//        // true
//        System.out.println(test.search("hhllo"));

        Z1MagicDic test = new Z1MagicDic();
        test.buildDict(new String[]{"hello", "hallo", "leetcode", "judge"});
        // true
        System.out.println(test.search("juage"));
    }
}
