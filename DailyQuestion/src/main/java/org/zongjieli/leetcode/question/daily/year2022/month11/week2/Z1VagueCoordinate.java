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
        char[] values = s.toCharArray();
        char[] coordinates = new char[values.length + 4];
        coordinates[0] = '(';
        for (int i = 1 ; i < values.length - 2 ; i++) {
            possibleNumber(values, i, coordinates, 1, result);
        }
        return result;
    }

    public void possibleNumber(char[] values, int vi, char[] coordinates, int ci, List<String> result) {
        // ci 为 1 时表示为前半部分
        boolean isFirst = ci == 1;
        int startIndex = isFirst ? 1 : vi, endIndex = isFirst ? vi : values.length - 2;
        if (startIndex == endIndex) {
            coordinates[ci++] = values[endIndex++];
            checkAndAdd(values, endIndex, coordinates, ci, result);
        } else if (values[startIndex] == '0') {
            // 首位为 0,则必须为 0.XXX 形式
            if (values[endIndex] == '0') {
                // 最后一个字符为 0,则不可能存在小数点,矛盾
                return;
            }
            coordinates[ci++] = '0';
            coordinates[ci++] = '.';
            while (++startIndex <= endIndex) {
                coordinates[ci++] = values[startIndex];
            }
            checkAndAdd(values, startIndex, coordinates, ci, result);
        } else {
            // 先放整数,再塞入小数点
            int startCi = ci;
            while (startIndex <= endIndex) {
                coordinates[ci++] = values[startIndex++];
            }
            checkAndAdd(values, startIndex, coordinates, ci, result);
            if (values[endIndex] != '0') {
                // 最后一个字符不为 0,每个位置插入小数点
                int nextCi = ci-- + 1;
                while (ci > startCi) {
                    coordinates[ci + 1] = coordinates[ci];
                    coordinates[ci--] = '.';
                    checkAndAdd(values, startIndex, coordinates, nextCi, result);
                }
            }
        }
    }

    public void checkAndAdd(char[] values, int vi, char[] coordinates, int ci, List<String> result) {
        if (vi == values.length - 1) {
            coordinates[ci++] = ')';
            result.add(new String(coordinates, 0, ci));
        } else {
            coordinates[ci++] = ',';
            coordinates[ci++] = ' ';
            possibleNumber(values, vi, coordinates, ci, result);
        }
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
