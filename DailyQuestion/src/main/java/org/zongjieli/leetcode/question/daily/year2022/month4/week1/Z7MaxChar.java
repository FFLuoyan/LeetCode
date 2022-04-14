package org.zongjieli.leetcode.question.daily.year2022.month4.week1;
/**
 * 给定一个排序后的字符列表 letters
 * 列表中只包含小写英文字母
 * 另给出一个目标字母 target
 * 请寻找在这一有序列表里比目标字母大的最小字母
 * 在比较时,字母是依序循环出现的,举个例子:
 *  如果目标字母 target = 'z'
 *  字符列表为 letters = ['a', 'b'],则答案返回 'a'
 *
 * 2 <= letters.length <= 10^4
 * letters[i] 是一个小写字母
 * letters 按非递减顺序排序
 * letters 最少包含两个不同的字母
 * target 是一个小写字母
 *
 * @author   Li.zongjie
 * @date     2022/4/14
 * @version  1.0
 */
public class Z7MaxChar {

    public char nextGreatestLetter(char[] letters, char target) {
        int result = target;
        for (char letter : letters) {
            result = letter > target ? result <= target ? letter : Math.min(result, letter) : result <= target ? Math.min(result, letter) : result;
        }
        return (char) result;
    }

    public static void main(String[] args) {
        Z7MaxChar test = new Z7MaxChar();
        System.out.println(test.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
    }
}
