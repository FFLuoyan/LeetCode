package org.zongjieli.leetcode.question.daily.year2021.month11.week4;
/**
 * 给定一个字符串 s,其中包含字母顺序打乱的用英文单词表示的若干数字(0-9)
 * 按升序返回原始的数字
 *
 * 1 <= s.length <= 10^5
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 *
 * @author   Li.zongjie
 * @date     2021/11/24
 * @version  1.0
 */
public class Z3FormatNumber {

    // e: zero one three five seven eight night
    // f: four five
    // g: eight
    // h: three eight
    // i: five six eight nine
    // n: one seven nine
    // o: zero one two four
    // r: zero three four
    // s: six seven
    // t: two three eight
    // u: four
    // v: five seven
    // w: two
    // x: six
    // z: zero

    public String originalDigits(String s) {
        int[] save = new int[128];
        for (int i = 0 ; i < s.length() ; i++){
            save[s.charAt(i)]++;
        }
        char[] chars = new char[s.length()];
        int index = 0;
        // 0
        int count = save['z'];
        for (int i = 0 ; i < count ; i++){
            chars[index++] = '0';
        }

        // 1
        count = save['o'] - count - save['w'] - save['u'];
        for (int i = 0 ; i < count ; i++){
            chars[index++] = '1';
        }

        // 2
        count = save['w'];
        for (int i = 0 ; i < count ; i++){
            chars[index++] = '2';
        }

        // 3
        count = save['h'] - save['g'];
        for (int i = 0 ; i < count ; i++){
            chars[index++] = '3';
        }

        // 4
        count = save['u'];
        for (int i = 0 ; i < count ; i++){
            chars[index++] = '4';
        }

        // 5
        count = save['f'] - count;
        for (int i = 0 ; i < count ; i++){
            chars[index++] = '5';
        }

        // 6
        count = save['x'];
        for (int i = 0 ; i < count ; i++){
            chars[index++] = '6';
        }

        // 7
        count = save['s'] - count;
        for (int i = 0 ; i < count ; i++){
            chars[index++] = '7';
        }

        // 8
        count = save['g'];
        for (int i = 0 ; i < count ; i++){
            chars[index++] = '8';
        }

        // 9
        count = save['i'] - save['x'] - count - save['f'] + save['u'];
        for (int i = 0 ; i < count ; i++){
            chars[index++] = '9';
        }

        return new String(chars, 0, index);
    }
}
