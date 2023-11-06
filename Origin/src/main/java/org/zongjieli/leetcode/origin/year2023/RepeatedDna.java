package org.zongjieli.leetcode.origin.year2023;

import java.util.ArrayList;
import java.util.List;

/**
 * DNA 序列由一系列核苷酸组成,缩写为 'A', 'C', 'G' 和 'T'
 * 例如, "ACGAATTCCG" 是一个 DNA序列
 * 在研究 DNA 时,识别 DNA 中的重复序列非常有用
 * 给定一个表示 DNA 序列的字符串 s
 * 返回所有在 DNA 分子中出现不止一次的长度为 10 的序列(子字符串)
 * 可以按任意顺序返回答案
 *
 * 0 <= s.length <= 10^5
 * s[i]=='A'、'C'、'G' or 'T'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/6
 */
public class RepeatedDna {

    private static final byte[] MAP = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>(s.length());
        if (s.length() <= 10) {
            return result;
        }
        int[] exists = new int[1048576];
        int current = 0, all = (1 << 20) - 1;
        byte[] values = s.getBytes();
        for (int i = 0; i < 9; i++) {
            current = (current << 2) + MAP[values[i]];
        }
        for (int i = 9; i < values.length; i++) {
            current = ((current << 2) + MAP[values[i]]) & all;
            if (exists[current]++ == 1) {
                result.add(new String(values, i - 9, 10));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        RepeatedDna test = new RepeatedDna();
        // [AAAAAAAAAA]
        System.out.println(test.findRepeatedDnaSequences("AAAAAAAAAAA"));
        // [AAAAACCCCC, CCCCCAAAAA]
        System.out.println(test.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

}
