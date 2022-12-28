package org.zongjieli.leetcode.question.daily.year2022.month12.week5;

/**
 * 给定一个只包含字符 'a'，'b' 和 'c' 的字符串 s
 * 可以执行下面这个操作(5 个步骤)任意次:
 *  选择字符串 s 一个非空的前缀,这个前缀的所有字符都相同
 *  选择字符串 s 一个非空的后缀,这个后缀的所有字符都相同
 *  前缀和后缀在字符串中任意位置都不能有交集
 *  前缀和后缀包含的所有字符都要相同
 *  同时删除前缀和后缀
 * 请返回对字符串 s 执行上面操作任意次以后(可能 0 次)能得到的最短长度
 *
 * 1 <= s.length <= 10^5
 * s 只包含字符 'a'，'b' 和 'c'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/28
 */
public class Z3MinLength {

    public int minimumLength(String s) {
        byte[] values = s.getBytes();
        int si = 0, ei = values.length - 1;
        while (si < ei && values[si] == values[ei]) {
            byte value = values[si];
            while (++si < ei && values[si] == value){}
            while (--ei > si && values[ei] == value){}
        }
        return ei - si + 1;
    }

}
