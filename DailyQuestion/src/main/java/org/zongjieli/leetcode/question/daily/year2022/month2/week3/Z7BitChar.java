package org.zongjieli.leetcode.question.daily.year2022.month2.week3;
/**
 * 有两种特殊字符:
 *
 * 第一种字符可以用一比特 0 表示
 * 第二种字符可以用两比特(10 或 11)表示
 *
 * 给定一个以 0 结尾的二进制数组 bits
 * 如果最后一个字符必须是一个一比特字符则返回 true
 *
 * 1 <= bits.length <= 1000
 * bits[i] 为 0 或 1
 *
 * @author   Li.zongjie
 * @date     2022/3/3
 * @version  1.0
 */
public class Z7BitChar {
    public boolean isOneBitCharacter(int[] bits) {
        int count = 0;
        for (int i = bits.length - 2 ; i >= 0 && bits[i] == 1 ; i--) {
            count++;
        }
        return count % 2 == 0;
    }
}
