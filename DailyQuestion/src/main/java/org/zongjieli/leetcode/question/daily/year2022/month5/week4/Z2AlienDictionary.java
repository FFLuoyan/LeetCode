package org.zongjieli.leetcode.question.daily.year2022.month5.week4;
/**
 * 某种外星语也使用英文小写字母,但可能顺序 order 不同
 * 字母表的顺序 (order) 是一些小写字母的排列
 *
 * 给定一组用外星语书写的单词 words 以及其字母表的顺序 order
 * 只有当给定的单词在这种外星语中按字典序排列时返回 true,否则返回 false
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母
 *
 * @author   Li.zongjie
 * @date     2022/5/17
 * @version  1.0
 */
public class Z2AlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[128];
        for (int i = 0 ; i < order.length() ; i++) {
            orders[order.charAt(i)] = i;
        }
        a: for (int i = 1 ; i < words.length ; i++) {
            String f = words[i - 1];
            String s = words[i];
            int fl = f.length(), sl = s.length();
            int l = Math.min(fl, sl);
            for (int j = 0 ; j < l ; j++) {
                int fo = orders[f.charAt(j)], so = orders[s.charAt(j)];
                if (fo > so) {
                    return false;
                } else if (so > fo) {
                    continue a;
                }
            }
            if (fl > sl) {
                return false;
            }
        }
        return true;
    }
}
