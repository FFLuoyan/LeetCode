package org.zongjieli.leetcode.question.daily.year2023.month1.week3;

import java.util.*;

/**
 * 有一个需要密码才能打开的保险箱,密码是 n 位数,密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个
 * 可以随意输入密码,保险箱会自动记住最后 n 位输入,如果匹配,则能够打开保险箱
 * 举个例子,假设密码是 "345",可以输入 "012345" 来打开它,只是输入了 6 个字符
 * 请返回一个能打开保险箱的最短字符串
 *
 * n 的范围是 [1, 4]
 * k 的范围是 [1, 10]
 * k^n 最大可能为 4096
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/10
 */
public class Z2CrackSafe {

    public String crackSafe(int n, int k) {
        if (n == 1) {
            StringBuilder v = new StringBuilder();
            for (char i = '0' ; i < k + '0'; i++) {
                v.append(i);
            }
            return v.toString();
        }
        Map<String, LinkedList<Character>> count = new HashMap<>();
        addMap(count, "", 0, n, k);
        int length = 1;
        for (int i = 0 ; i < n ; i++) {
            length *= k;
        }
        length += n - 1;
        char[] values = new char[length];
        for (int i = 0 ; i < n - 1 ; i++) {
            values[i] = '0';
        }
        for (int i = n - 1 ; i < length ; i++) {
            StringBuilder next = new StringBuilder();
            for (int j = i - n + 1 ; j < i ; j++) {
                next.append(values[j]);
            }
            LinkedList<Character> chars = count.get(next.toString());
            if (!chars.isEmpty()) {
                values[i] = chars.pollFirst();
            } else {
                while (--i >= 0) {
                    next = new StringBuilder();
                    for (int j = i - n + 1 ; j < i ; j++) {
                        next.append(values[j]);
                    }
                    chars = count.get(next.toString());
                    if (!chars.isEmpty()) {
                        chars.addLast(values[i]);
                        values[i] = chars.pollFirst();
                        break;
                    } else {
                        chars.addLast(values[i]);
                    }
                }
            }
        }
        return new String(values);
    }

    public void addMap(Map<String, LinkedList<Character>> count, String current, int index, int n, int k) {
        if (index == n - 1) {
            LinkedList<Character> v = new LinkedList<>();
            count.put(current, v);
            for (char c = '0'; c < k + '0'; c++) {
                v.add(c);
            }
        } else {
            for (char c = '0' ; c < k + '0'; c++) {
                addMap(count, current + c, index + 1, n, k);
            }
        }
    }

    public static void main(String[] args) {
        Z2CrackSafe test = new Z2CrackSafe();
        System.out.println(test.crackSafe(1, 2));
    }
}
