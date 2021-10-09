package org.zongjieli.leetcode.question.daily.year2021.month10.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有 DNA 都由一系列缩写为 'A','C','G' 和 'T' 的核苷酸组成
 * 例如: "ACGAATTCCG"
 * 在研究 DNA 时,识别 DNA 中的重复序列有时会对研究非常有帮助
 * 编写一个函数来找出所有目标子串
 * 目标子串的长度为 10,且在 DNA 字符串 s 中出现次数超过一次
 *
 * 0 <= s.length <= 10^5
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * @author   Li.zongjie
 * @date     2021/10/8
 * @version  1.0
 */
public class Z5RepeatedDna {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>(2 * s.length());
        if (s.length() <= 10){
            return result;
        }
        short[] count = new short[1048576];
        int value = 0;
        for (int i = 0 ; i < 10 ; i++){
            char c = s.charAt(i);
            int cI = c == 'A' ? 0 : (c == 'C' ? 1 : (c == 'G' ? 2 : 3));
            value = value << 2;
            value += cI;
        }
        count[value]++;

        char[] temp = new char[10];
        for (int i = 10 ; i < s.length() ; i++){
            char c = s.charAt(i);
            int cI = c == 'A' ? 0 : (c == 'C' ? 1 : (c == 'G' ? 2 : 3));
            value = (((value << 2) + cI) & 1048575);
            count[value]++;
            if (count[value] == 2){
                int a = value;
                for (int j = 9 ; j >= 0 ; j--){
                    int last = a & 3;
                    temp[j] = last == 0 ? 'A' : (last == 1 ? 'C' : (last == 2 ? 'G' : 'T'));
                    a = a >> 2;
                }
                result.add(new String(temp));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Z5RepeatedDna test = new Z5RepeatedDna();
//        System.out.println(test.findRepeatedDnaSequences("AAAAAAAAAAA"));
        System.out.println(test.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
