package org.zongjieli.leetcode.question.daily.year2023.month10.week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * @date 2023/11/5
 */
public class Z7DuplicateDna {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() <= 10) {
            return result;
        }
        Map<Integer, Integer> exists = new HashMap<>();
        int current = 0, all = (1 << 20) - 1, value;
        byte[] values = s.getBytes();
        for (int i = 0; i < 9; i++) {
            value = values[i] == 'A' ? 0 : values[i] == 'C' ? 1 : values[i] == 'G' ? 2 : 3;
            current = (current << 2) + value;
        }
        for (int i = 9; i < values.length; i++) {
            value = values[i] == 'A' ? 0 : values[i] == 'C' ? 1 : values[i] == 'G' ? 2 : 3;
            current = ((current << 2) + value) & all;
            Integer exist = exists.get(current);
            if (exist == null) {
                exists.put(current, 1);
            } else if (exist == 1) {
                result.add(new String(values, i - 9, 10));
                exists.put(current, 2);
            }
        }
        return result;
    }

}
