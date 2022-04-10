package org.zongjieli.leetcode.question.daily.year2022.month4.week2;

import java.util.HashSet;
import java.util.Set;

/**
 * 国际摩尔斯密码定义一种标准编码方式
 * 将每个字母对应于一个由一系列点和短线组成的字符串,比如:
 *  a: ".-"
 *  b: "-..."
 *  c: "-.-."
 *  d: "-.."
 *  e: "."
 *  f: "..-."
 *  g: "--."
 *  h: "...."
 *  i: ".."
 *  j: ".---"
 *  k: "-.-"
 *  l: ".-.."
 *  m: "--"
 *  n: "-."
 *  o: "---"
 *  p: ".--."
 *  q: "--.-"
 *  r: ".-."
 *  s: "..."
 *  t: "-"
 *  u: "..-"
 *  v: "...-"
 *  w: ".--"
 *  x: "-..-"
 *  y: "-.--"
 *  z: "--.."
 * 给定一个字符串数组 words
 * 每个单词可以写成每个字母对应摩尔斯密码的组合
 * 例如 "cab" 可以写成 "-.-..--...",(即 "-.-." + ".-" + "-..." 字符串的结合)
 * 我们将这样一个连接过程称作单词翻译
 * 对 words 中所有单词进行单词翻译
 * 返回不同单词翻译的数量
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 12
 * words[i] 由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2022/4/10
 * @version  1.0
 */
public class Z7UniqueMorse {

    private String[] morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> save = new HashSet<>(words.length);
        for (String word : words) {
            StringBuilder current = new StringBuilder();
            for (int i = 0 ; i < word.length() ; i++) {
                current.append(morse[word.charAt(i) - 'a']);
            }
            save.add(current.toString());
        }
        return save.size();
    }

    public static void main(String[] args) {
        Z7UniqueMorse test = new Z7UniqueMorse();
        // 2
        System.out.println(test.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
