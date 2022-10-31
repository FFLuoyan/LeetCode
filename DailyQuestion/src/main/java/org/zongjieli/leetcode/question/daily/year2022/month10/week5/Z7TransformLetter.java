package org.zongjieli.leetcode.question.daily.year2022.month10.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s,通过将字符串 s 中的每个字母转变大小写,可以获得一个新的字符串
 *
 * 返回所有可能得到的字符串集合,以任意顺序返回输出
 *
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/10/31
 */
public class Z7TransformLetter {

    public List<String> letterCasePermutation(String s) {
        byte[] values = s.getBytes();
        List<String> result = new ArrayList<>();
        addToResult(result, 0, values);
        return result;
    }

    public void addToResult(List<String> result, int currentIndex, byte[] values) {
        if (currentIndex >= values.length) {
            result.add(new String(values));
        } else if (values[currentIndex] <= 57) {
            // 数字
            addToResult(result, currentIndex + 1, values);
        } else if (values[currentIndex] <= 'Z') {
            // 大写字母
            values[currentIndex] += 32;
            addToResult(result, currentIndex + 1, values);
            values[currentIndex] -= 32;
            addToResult(result, currentIndex + 1, values);
        } else {
            // 小写字母
            values[currentIndex] -= 32;
            addToResult(result, currentIndex + 1, values);
            values[currentIndex] += 32;
            addToResult(result, currentIndex + 1, values);
        }
    }
}
