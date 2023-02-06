package org.zongjieli.leetcode.question.daily.year2022.month11.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 有一些二维坐标,如 "(1, 3)" 或 "(2, 0.5)"
 * 然后移除所有逗号,小数点和空格,得到一个字符串 S
 * 返回所有可能的原始字符串到一个列表中
 * 原始的坐标表示法不会存在多余的零
 * 所以不会出现类似于 "00", "0.0", "0.00", "1.0", "001", "00.01" 或一些其他更小的数来表示坐标
 * 此外,一个小数点前至少存在一个数,所以也不会出现 ".1" 形式的数字
 * 最后返回的列表可以是任意顺序的,而且注意返回的两个数字中间(逗号之后)都有一个空格
 *
 * 4 <= S.length <= 12
 * S[0] = "("
 * S[S.length - 1] = ")"
 * 且字符串 S 中的其他元素都是数字
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/6
 */
public class Z1VagueCoordinate {

    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 2 ; i < s.length() - 1 ; i++) {
            addResult(s.substring(1, i), s.substring(i, s.length() - 1), result);
        }
        return result;
    }

    public void addResult(String a, String b, List<String> result) {
        for (String ap : possibleNumber(a)) {
            for (String bp : possibleNumber(b)) {
                result.add("(" + ap + ", " + bp + ")");
            }
        }
    }

    public List<String> possibleNumber(String a) {
        List<String> list = new ArrayList<>();
        if (a.length() == 1) {
            list.add(a);
            return list;
        }
        if (a.charAt(0) == '0') {
            // 首位为 0,则必须为 0.XXX 形式
            if (a.charAt(a.length() - 1) == '0') {
                // 最后一个字符为 0,则不可能存在小数点
                return list;
            }
            list.add("0." + a.substring(1));
            return list;
        }
        list.add(a);
        if (a.charAt(a.length() - 1) == '0') {
            // 最后一个字符为 0,则不可能存在小数点
            return list;
        }
        for (int i = 1 ; i < a.length() ; i++) {
            list.add(a.substring(0, i) + "." + a.substring(i));
        }
        return list;
    }

    public static void main(String[] args) {
        Z1VagueCoordinate test = new Z1VagueCoordinate();
        // (1, 23), (12, 3), (1.2, 3), (1, 2.3)
        System.out.println(test.ambiguousCoordinates("(123)"));
        // (0, 1.23), (0, 12.3), (0, 123), (0.1, 2.3), (0.1, 23), (0.12, 3)
        System.out.println(test.ambiguousCoordinates("(0123)"));
        // (10, 0)
        System.out.println(test.ambiguousCoordinates("(100)"));
    }
}
