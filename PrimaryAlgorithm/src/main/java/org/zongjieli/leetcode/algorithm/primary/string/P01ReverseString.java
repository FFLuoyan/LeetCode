package org.zongjieli.leetcode.algorithm.primary.string;
/**
 * 编写一个函数,其作用是将输入的字符串反转过来
 * 输入字符串以字符数组 char[] 的形式给出
 *
 * 不要给另外的数组分配额外的空间
 * 必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
 *
 * 可以假设数组中的所有字符都是 ASCII 码表中的可打印字符
 *
 * @author   Li.zongjie
 * @date     2021/9/18
 * @version  1.0
 */
public class P01ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
