package org.zongjieli.leetcode.question.daily.year2021.month10.week4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 请设计一个数据结构,支持添加新单词和查找字符串是否与任何先前添加的字符串匹配
 *
 * 实现词典类 WordDictionary:
 *
 *  WordDictionary() 初始化词典对象
 *  void addWord(word) 将 word 添加到数据结构中,之后可以对它进行匹配
 *  bool search(word) 如果数据结构中存在字符串与 word 匹配,则返回 true,否则返回  false
 *      word 中可能包含一些 '.',每个 '.' 都可以表示任何一个字母
 *
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 *
 * @author   Li.zongjie
 * @date     2021/10/19
 * @version  1.0
 */
public class Z2AddAndSearch {

    private Map<Character, Map> dict;

    public Z2AddAndSearch() {
        this.dict = new HashMap<>();
    }

    public void addWord(String word) {
        Map<Character, Map> letter = dict;
        for (int i = 0 ; i < word.length() ; i++){
            char currentChar = word.charAt(i);
            letter = letter.computeIfAbsent(currentChar, k -> new HashMap<>());
        }
        letter.put('.',null);
    }

    public boolean search(String word) {
        LinkedList<Map<Character, Map>> search = new LinkedList<>();
        search.add(dict);
        for (int i = 0 ; i < word.length() ; i++){
            int length = search.size();
            if (length == 0){
                return false;
            }
            char currentChar = word.charAt(i);
            if (currentChar != '.'){
                for (int j = 0 ; j < length ; j++){
                    Map<Character, Map> temp = search.pollFirst();
                    Map<Character, Map> next = temp.get(currentChar);
                    if (next != null){
                        search.addLast(next);
                    }
                }
            } else {
                for (int j = 0 ; j < length ; j++){
                    Map<Character, Map> temp = search.pollFirst();
                    temp.forEach((k,v) -> {
                        if (k != '.'){
                            search.addLast(v);
                        }
                    });
                }
            }
        }

        for (Map<Character, Map> map : search){
            if (map.containsKey('.')){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Z2AddAndSearch test = new Z2AddAndSearch();
        test.addWord("abc");
        System.out.println(test.search("..a"));
        System.out.println(test.search("a.c"));
        System.out.println(test.search("ab."));
    }
}
