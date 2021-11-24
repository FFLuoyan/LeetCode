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
        int[] result = new int[10];
        result[0] = save['z'];
        result[2] = save['w'];
        result[4] = save['u'];
        result[6] = save['x'];
        result[8] = save['g'];

        result[3] = save['h'] - result[8];
        result[5] = save['f'] - result[4];
        result[7] = save['s'] - result[6];

        result[1] = save['o'] - result[0] - result[2] - result[4];
        result[9] = (save['n'] - result[1] - result[7]) / 2;

        char[] chars = new char[s.length()];
        int index = 0;

        for (int i = 0 ; i <= 9 ; i++){
            for (int j = 0 ; j < result[i] ; j++){
                chars[index++] = (char) (i + '0');
            }
        }
        return new String(chars, 0, index);
    }
}
