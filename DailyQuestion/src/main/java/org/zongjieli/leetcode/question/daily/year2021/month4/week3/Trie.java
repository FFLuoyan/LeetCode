package org.zongjieli.leetcode.question.daily.year2021.month4.week3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Trie:前缀树,一种树形数据结构
 * 用于高效地存储和检索字符串数据集中的键
 * 这一数据结构有相当多的应用情景,例如自动补完和拼写检查
 *
 * 请实现 Trie 类:
 *
 *  Trie() 初始化前缀树对象。
 *  void insert(String word) 向前缀树中插入字符串 word
 *  boolean search(String word) 如果字符串 word 在前缀树中,返回 true (即,在检索之前已经插入),否则返回 false
 *  boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix,返回 true,否则返回 false
 *
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 *
 * @author   Zongjie.Li
 * @date     2021/4/14
 * @version  1.0
 */
public class Trie {

    private Map<Object,Map> storage;

    /** Initialize your data structure here. */
    public Trie() {
        storage = new HashMap<>(32);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Object,Map> search = storage;
        for (int index = 0 ; index < word.length() ; index++){
            search = search.computeIfAbsent(word.charAt(index), f -> new HashMap<>(32));
        }
        search.put(Boolean.TRUE, Collections.emptyMap());
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Map<Object,Map> search = storage;
        for (int index = 0 ; index < word.length() ; index++){
            search = search.get(word.charAt(index));
            if (search == null){
                return false;
            }
        }
        return search.containsKey(Boolean.TRUE);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Map<Object,Map> search = storage;
        for (int index = 0 ; index < prefix.length() ; index++){
            search = search.get(prefix.charAt(index));
            if (search == null){
                return false;
            }
        }
        return true;
    }
}
