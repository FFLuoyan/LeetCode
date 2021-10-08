package org.zongjieli.leetcode.question.daily.year2021.month10.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<String> result = new ArrayList<>();
        if (s.length() <= 10){
            return result;
        }
        Map<String,Boolean> save = new HashMap<>(2 * s.length());
        for (int i = 10 ; i <= s.length() ; i++){
            String value = s.substring(i - 10, i);
            save.merge(value,false, (old,v) -> true);
        }
        save.forEach((k,v) -> {
            if (v){
                result.add(k);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        Z5RepeatedDna test = new Z5RepeatedDna();
        System.out.println(test.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
