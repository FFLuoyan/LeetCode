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
        int base = 10;
        if (s.length() <= base){
            return result;
        }
        int[] charToBin = new int['U'];
        byte[] binToByte = new byte[4];
        charToBin['A'] = 0;
        binToByte[0] = 'A';
        charToBin['C'] = 1;
        binToByte[1] = 'C';
        charToBin['G'] = 2;
        binToByte[2] = 'G';
        charToBin['T'] = 3;
        binToByte[3] = 'T';

        short[] count = new short[1048576];
        int value = 0;
        for (int i = 0 ; i < base ; i++){
            value = (value << 2) | charToBin[s.charAt(i)];
        }
        count[value]++;

        byte[] subS = new byte[base];
        for (int i = base ; i < s.length() ; i++){
            value = ((value << 2) | charToBin[s.charAt(i)]) & 1048575;
            count[value]++;
            if (count[value] == 2){
                int temp = value;
                for (int j = 9 ; j >= 0 ; j--){
                    subS[j] = binToByte[temp & 3];
                    temp >>= 2;
                }
                result.add(new String(subS));
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
