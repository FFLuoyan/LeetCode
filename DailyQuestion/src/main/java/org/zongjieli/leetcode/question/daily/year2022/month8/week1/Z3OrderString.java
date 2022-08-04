package org.zongjieli.leetcode.question.daily.year2022.month8.week1;

import java.util.Arrays;

/**
 * 给定一个字符串 s 和一个整数 k
 * 可以从 s 的前 k 个字母中选择一个,并把它加到字符串的末尾
 * 返回在应用上述步骤的任意数量的移动后,字典上最小的字符串
 *
 * 1 <= k <= S.length <= 1000
 * s 只由小写字母组成。
 *
 * @author   Li.zongjie
 * @date     2022/8/3
 * @version  1.0
 */
public class Z3OrderString {

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            int l = s.length();
            char[] sRepeat = new char[2 * l];
            for (int i = 0 ; i < l ; i++) {
                char cc = s.charAt(i);
                sRepeat[i] = cc;
                sRepeat[i + l] = cc;
            }
            int start = 0;
            for (int i = 1 ; i < l ; i++) {
                char cc = sRepeat[start];
                char nc = sRepeat[i];
                if (nc > cc) {
                    continue;
                }
                for (int j = 1 ; j < l && nc == cc; j++) {
                    nc = sRepeat[i + j];
                    cc = sRepeat[start + j];
                }
                if (cc > nc) {
                    start = i;
                }
            }
            return new String(sRepeat, start, l);
        }
        char[] result = s.toCharArray();
        Arrays.sort(result);
        return new String(result);
    }

    public static void main(String[] args) {
        Z3OrderString test = new Z3OrderString();
        // acb
        System.out.println(test.orderlyQueue("cba", 1));
        // bczfjtvxerzbrvigplen
        System.out.println(test.orderlyQueue("enbczfjtvxerzbrvigpl", 1));
    }
}
