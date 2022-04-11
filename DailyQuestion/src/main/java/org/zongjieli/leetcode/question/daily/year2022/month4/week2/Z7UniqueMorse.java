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

    private int[] move = new int[]{2, 4, 4, 3, 1, 4, 3, 4, 2, 4, 3, 4, 2, 2, 3, 4, 4, 3, 3, 1, 3, 4, 3, 4, 4, 4};
    private int[] value = new int[]{1, 8, 10, 4, 0, 2, 6, 0, 0, 7, 5, 4, 3, 2, 7, 6, 13, 2, 0, 1, 1, 1, 3, 9, 11, 12};

    public int uniqueMorseRepresentations(String[] words) {
        Set<Long> save = new HashSet<>(words.length);
        for (String word : words) {
            long v = 0;
            for (int i = 0 ; i < word.length() ; i++) {
                int index = word.charAt(i) - 'a';
                v = (v << move[index]) + value[index];
            }
            save.add(v);
        }
        return save.size();
    }

    public static void main(String[] args) {
        Z7UniqueMorse test = new Z7UniqueMorse();
        // 2
        System.out.println(test.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
