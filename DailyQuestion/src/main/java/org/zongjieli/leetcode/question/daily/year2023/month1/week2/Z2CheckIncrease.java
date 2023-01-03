package org.zongjieli.leetcode.question.daily.year2023.month1.week2;

/**
 * 句子是由若干 token 组成的一个列表,token 间用单个空格分隔,句子没有前导或尾随空格
 * 每个 token 要么是一个由数字 0-9 组成的不含前导零的正整数
 * 要么是一个由小写英文字母组成的单词
 *
 * 示例: "a puppy has 2 eyes 4 legs" 是一个由 7 个 token 组成的句子
 * "2" 和 "4" 是数字,其他像 "puppy" 这样的 tokens 属于单词
 * 给定一个表示句子的字符串 s,需要检查 s 中的全部数字是否从左到右严格递增
 * 即,除了最后一个数字,s 中的每个数字都严格小于它右侧的数字
 *
 * 如果满足题目要求,返回 true,否则返回 false
 *
 * 3 <= s.length <= 200
 * s 由小写英文字母、空格和数字 0 到 9 组成(包含 0 和 9)
 * s 中数字 token 的数目在 2 和 100 之间(包含 2 和 100)
 * s 中的 token 之间由单个空格分隔
 * s 中至少有两个数字
 * s 中的每个数字都是一个小于 100 的正数,且不含前导零
 * s 不含前导或尾随空格
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/3
 */
public class Z2CheckIncrease {

    public boolean areNumbersAscending(String s) {
        byte[] values = s.getBytes();
        int before = -1, current = 0;
        for (int i = 0; i < values.length; i++) {
            while (i < values.length && values[i] >= '0' && values[i] <= '9') {
                current = 10 * current + values[i++] - '0';
            }
            if (current > 0) {
                if (before >= current) {
                    return false;
                }
                before = current;
                current = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Z2CheckIncrease test = new Z2CheckIncrease();
        // true
        System.out.println(test.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }

}
