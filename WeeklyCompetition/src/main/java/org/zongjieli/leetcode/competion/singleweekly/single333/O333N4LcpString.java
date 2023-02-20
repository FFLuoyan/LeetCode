package org.zongjieli.leetcode.competion.singleweekly.single333;

/**
 * 对任一由 n 个小写英文字母组成的字符串 word,定义一个 n x n 的矩阵,并满足:
 *  lcp[i][j] 等于子字符串 word[i, ..., n-1] 和 word[j, ..., n-1] 之间的最长公共前缀的长度
 * 给定一个 n x n 的矩阵 lcp,返回与 lcp 对应的、按字典序最小的字符串 word
 * 如果不存在这样的字符串,则返回空字符串
 * 对于长度相同的两个字符串 a 和 b
 * 如果在 a 和 b 不同的第一个位置
 * 字符串 a 的字母在字母表中出现的顺序先于 b 中的对应字母
 * 则认为字符串 a 按字典序比字符串 b 小
 * 例如,"aabd" 在字典上小于 "aaca"
 * 因为二者不同的第一位置是第三个字母,而 'b' 先于 'c' 出现
 *
 * 1 <= n == lcp.length == lcp[i].length <= 1000
 * 0 <= lcp[i][j] <= n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/19
 */
public class O333N4LcpString {

    public String findTheString(int[][] lcp) {
        int length = lcp.length;
        int[] same = new int[length];
        for (int i = 0; i < length; i++) {
            same[i] = i;
        }
        for (int i = 0; i < length; i++) {
            int[] row = lcp[i];
            for (int j = 0 ; j < i ; j++) {
                if (row[j] != lcp[j][i]) {
                    return "";
                }
            }
            if (row[i] != length - i) {
                return "";
            }
            for (int j = i + 1 ; j < length ; j++) {
                int maxSame = row[j];
                if (j + maxSame > length) {
                    return "";
                }
                for (int k = 0 ; k < maxSame ; k++) {
                    int fj = findFather(same, j);
                    int fi = findFather(same, i);
                    if (fj < fi) {
                        same[fi] = same[fj];
                    } else {
                        same[fj] = same[fi];
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            int[] row = lcp[i];
            for (int j = i + 1 ; j < length ; j++) {
                if (j + row[j] == length) {
                    continue;
                }
                if (findFather(same, j + row[j]) == findFather(same, i + row[j])) {
                    return "";
                }
            }
        }
        char[] result = new char[length];
        char current = 'a';
        for (int i = 0; i < result.length; i++) {
            char fc = result[findFather(same, i)];
            if (fc != 0) {
                result[i] = fc;
            } else if (current <= 'z') {
                result[i] = current++;
            } else {
                return "";
            }
        }
        return new String(result);
    }

    private int findFather(int[] same, int i) {
        while (i != same[i]) {
            i = same[i];
        }
        return i;
    }

    public static void main(String[] args) {
        O333N4LcpString test = new O333N4LcpString();
        // ""
        System.out.println(test.findTheString(new int[][]{{2, 2}, {2, 1}}));
        // abab
        System.out.println(test.findTheString(new int[][]{{4, 0, 2, 0}, {0, 3, 0, 1}, {2, 0, 2, 0}, {0, 1, 0, 1}}));
    }

}
