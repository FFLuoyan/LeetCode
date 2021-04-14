package org.zongjieli.leetcode.question.daily.year2021.month4.week3;

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
//public class Trie {
//
//    private Object[] storage;
//
//    /** Initialize your data structure here. */
//    public Trie() {
//        storage = new Object[27];
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        Object[] search = storage;
//        for (int index = 0 ; index < word.length() ; index++){
//            int searchIndex = word.charAt(index) - 'a';
//            if (search[searchIndex] == null){
//                search[searchIndex] = new Object[27];
//            }
//            search = (Object[]) search[searchIndex];
//        }
//        search[26] = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        Object[] search = storage;
//        for (int index = 0 ; index < word.length() ; index++){
//            int searchIndex = word.charAt(index) - 'a';
//            if (search[searchIndex] == null){
//                return false;
//            }
//            search = (Object[]) search[searchIndex];
//        }
//        return search[26] != null;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        Object[] search = storage;
//        for (int index = 0 ; index < prefix.length() ; index++){
//            int searchIndex = prefix.charAt(index) - 'a';
//            if (search[searchIndex] == null){
//                return false;
//            }
//            search = (Object[]) search[searchIndex];
//        }
//        return true;
//    }
//
//}


public class Trie {

    private Trie[] storage;
    private boolean end;

    /** Initialize your data structure here. */
    public Trie() {
        storage = new Trie[26];
        end = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie search = this;
        for (int index = 0 ; index < word.length() ; index++){
            int searchIndex = word.charAt(index) - 'a';
            if (search.storage[searchIndex] == null){
                search.storage[searchIndex] = new Trie();
            }
            search = search.storage[searchIndex];
        }
        search.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie search = this;
        for (int index = 0 ; index < word.length() ; index++){
            int searchIndex = word.charAt(index) - 'a';
            if (search.storage[searchIndex] == null){
                return false;
            }
            search = search.storage[searchIndex];
        }
        return search != null && search.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie search = this;
        for (int index = 0 ; index < prefix.length() ; index++){
            int searchIndex = prefix.charAt(index) - 'a';
            if (search.storage[searchIndex] == null){
                return false;
            }
            search = search.storage[searchIndex];
        }
        return search != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
