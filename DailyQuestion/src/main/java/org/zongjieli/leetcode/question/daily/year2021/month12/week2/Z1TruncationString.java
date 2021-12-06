package org.zongjieli.leetcode.question.daily.year2021.month12.week2;
/**
 * 句子是一个单词列表,列表中的单词之间用单个空格隔开,且不存在前导或尾随空格
 * 每个单词仅由大小写英文字母组成(不含标点符号)
 *
 * 例如,"Hello World"、"HELLO" 和 "hello world hello world" 都是句子
 * 给定一个句子 s​​​​​​ 和一个整数 k​​​​​​,请将 s​​ 截断,使截断后的句子仅含前 k​​​​​​ 个单词
 * 返回截断 s​​​​​​ 后得到的句子
 *
 * 1 <= s.length <= 500
 * k 的取值范围是 [1,  s 中单词的数目]
 * s 仅由大小写英文字母和空格组成
 * s 中的单词之间由单个空格隔开
 * 不存在前导或尾随空格
 *
 * @author   Li.zongjie
 * @date     2021/12/6
 * @version  1.0
 */
public class Z1TruncationString {
    public String truncateSentence(String s, int k) {
        int count = 1;
        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == ' ' && count++ == k){
                return s.substring(0, i);
            }
        }
        return s;
    }
}
