package org.zongjieli.leetcode.question.daily.year2021.month10.week4;

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

    private boolean isEnd = false;

    private Z2AddAndSearch[] values = new Z2AddAndSearch[26];

    public Z2AddAndSearch() {
    }

    public void addWord(String word, int index) {
        if (index == word.length()){
            isEnd = true;
            return;
        }
        char currentChar = word.charAt(index);
        int valueIndex = currentChar - 'a';
        if (values[valueIndex] == null){
            values[valueIndex] = new Z2AddAndSearch();
        }
        values[valueIndex].addWord(word, index + 1);
    }

    public void addWord(String word) {
        addWord(word,0);
    }

    public boolean search(String word, int index){
        if (index == word.length()){
            return isEnd;
        }
        char currentChar = word.charAt(index);

        if (currentChar != '.'){
            int valueIndex = currentChar - 'a';
            if (values[valueIndex] == null){
                return false;
            }
            return values[valueIndex].search(word, index + 1);
        }
        for (int i = 0 ; i < 26 ; i++){
            if (values[i] == null){
                continue;
            }
            if (values[i].search(word, index + 1)){
                return true;
            }
        }
        return false;
    }

    public boolean search(String word) {
        return search(word,0);
    }

    public static void main(String[] args) {
        Z2AddAndSearch test = new Z2AddAndSearch();
        test.addWord("abc");
        System.out.println(test.search("..a"));
        System.out.println(test.search("a.c"));
        System.out.println(test.search("ab."));

        test.addWord("a");
        test.addWord("a");
        System.out.println(test.search(".a"));
        System.out.println(test.search("a."));
        System.out.println(test.search("..a"));
    }
}
