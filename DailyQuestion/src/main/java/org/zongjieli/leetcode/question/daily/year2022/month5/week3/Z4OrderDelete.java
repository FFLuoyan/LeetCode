package org.zongjieli.leetcode.question.daily.year2022.month5.week3;
/**
 * 给顶由 n 个小写字母字符串组成的数组 strs
 * 其中每个字符串长度相等
 * 这些字符串可以每个一行,排成一个网格
 * 例如,strs = ["abc", "bce", "cae"] 可以排列为:
 *  abc
 *  bce
 *  cae
 * 需要找出并删除不是按字典序升序排列的列
 * 在上面的例子 (下标从 0 开始) 中
 * 列 0 ('a','b','c') 和列 2 ('c','e','e') 都是按升序排列的
 * 而列 1 ('b','c','a') 不是,所以要删除列 1
 * 返回你需要删除的列数
 *
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 1000
 * strs[i] 由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2022/5/13
 * @version  1.0
 */
public class Z4OrderDelete {

    public int minDeletionSize(String[] strs) {
        int length = strs[0].length(), result = 0;
        for (int i = 0 ; i < length ; i++) {
            char base = strs[0].charAt(i);
            for (int j = 1 ; j < strs.length ; j++) {
                char current = strs[j].charAt(i);
                if (current < base) {
                    result++;
                    break;
                }
                base = current;
            }
        }
        return result;
    }
}
