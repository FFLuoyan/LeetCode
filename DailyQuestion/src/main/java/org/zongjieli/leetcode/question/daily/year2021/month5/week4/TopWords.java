package org.zongjieli.leetcode.question.daily.year2021.month5.week4;

import java.util.*;

/**
 * 给一非空的单词列表,返回前 k 个出现次数最多的单词
 *
 * 返回的答案应该按单词出现频率由高到低排序
 * 如果不同的单词有相同出现频率,按字母顺序排序
 *
 * 假定 k 总为有效值,1 ≤ k ≤ 集合元素数
 * 输入的单词均由小写字母组成
 *
 * @author   Zongjie.Li
 * @date     2021/5/20
 * @version  1.0
 */
public class TopWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String>[] results = new List[words.length];
        results[0] = new ArrayList<>();
        Map<String,Integer> countMap = new HashMap<>();
        for (String word : words) {
            Integer wordListIndex = countMap.get(word);
            if (wordListIndex == null){
                countMap.put(word,0);
                results[0].add(word);
            } else {
                results[wordListIndex].remove(word);
                int nextIndex = wordListIndex + 1;
                countMap.put(word,nextIndex);
                List<String> nextWordList = results[nextIndex];
                if (nextWordList == null){
                    nextWordList = new ArrayList<>();
                    results[nextIndex] = nextWordList;
                }
                nextWordList.add(word);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = words.length - 1; i >= 0 ; i--){
            if (results[i] == null){
                continue;
            }
            results[i].sort(String::compareTo);
            for (String s : results[i]) {
                result.add(s);
                if (result.size() == k){
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TopWords test = new TopWords();
        String[] testString = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(test.topKFrequent(testString,2));
    }
}
