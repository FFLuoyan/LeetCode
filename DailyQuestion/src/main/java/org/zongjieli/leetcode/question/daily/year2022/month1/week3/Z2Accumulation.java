package org.zongjieli.leetcode.question.daily.year2022.month1.week3;
/**
 * 累加数是一个字符串,组成它的数字可以形成累加序列
 * 一个有效的累加序列必须至少包含 3 个数
 * 除了最开始的两个数以外,字符串中的其他数都等于它之前两个数相加的和
 * 给定一个只包含数字 '0'-'9' 的字符串
 * 编写一个算法来判断给定输入是否是累加数
 * 如果是,返回 true,否则返回 false
 *
 * 说明: 累加序列里的数,除数字 0 之外,不会 以 0 开头
 * 所以不会出现 1, 2, 03 或者 1, 02, 3 的情况
 *
 * 1 <= num.length <= 35
 * num 仅由数字(0 - 9)组成
 *
 * @author   Li.zongjie
 * @date     2022/1/11
 * @version  1.0
 */
public class Z2Accumulation {
    public boolean isAdditiveNumber(String num) {
        for (int firstSize = 1 ; firstSize <= num.length() - 1 - firstSize ; firstSize++){
            long first = Long.parseLong(num.substring(0, firstSize));
            for (int secondSize = 1 ; Math.max(firstSize, secondSize) <= num.length() - firstSize - secondSize ; secondSize++){
                long second = Long.parseLong(num.substring(firstSize, firstSize + secondSize));
                if (isAdditiveNumber(first, second, num.substring(firstSize + secondSize))){
                    return true;
                }
                if (second == 0){
                    break;
                }
            }
            if (first == 0){
                break;
            }
        }
        return false;
    }

    public boolean isAdditiveNumber(long before, long current, String remain){
        long temp = current;
        current = before + current;
        before = temp;
        String next = String.valueOf(current);
        if (!remain.startsWith(next)){
            return false;
        }
        if (next.length() == remain.length()){
            return true;
        }
        return isAdditiveNumber(before, current, remain.substring(next.length()));
    }

    public static void main(String[] args) {
        Z2Accumulation test = new Z2Accumulation();
        System.out.println(test.isAdditiveNumber("12315"));
    }
}
