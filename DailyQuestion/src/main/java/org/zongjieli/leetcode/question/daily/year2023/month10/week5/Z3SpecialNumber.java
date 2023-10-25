package org.zongjieli.leetcode.question.daily.year2023.month10.week5;

/**
 * 给定一个正整数 n,请返回 n 的惩罚数
 * n 的惩罚数定义为所有满足以下条件 i 的数的平方和:
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串
 * 且这些子字符串对应的整数值之和等于 i
 *
 * 1 <= n <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/25
 */
public class Z3SpecialNumber {

    int[] resultArray = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 82, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 182, 1478, 1478, 1478, 1478, 1478, 1478, 1478, 1478, 1478, 3503, 3503, 3503, 3503, 3503, 3503, 3503, 3503, 3503, 3503, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 6528, 13252, 13252, 13252, 13252, 13252, 13252, 13252, 13252, 13252, 21533, 21533, 21533, 21533, 21533, 21533, 21533, 21533, 31334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 41334, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 96559, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 184768, 320929, 457829, 457829, 457829, 457829, 457829, 457829, 457829, 457829, 457829, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 601470, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 772866, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1204515, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 1660140, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2154349, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 2725885, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 3353149, 4179430, 4179430, 4179430, 4179430, 4179430, 4179430, 4179430, 4179430, 4179430, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5022154, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 5915179, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 6844475, 7824575, 8806656, 8806656, 8806656, 8806656, 8806656, 8806656, 8806656, 8806656, 9804657, 10804657};

    public int punishmentNumber(int n) {
        return resultArray[n];
    }

    public static void main(String[] args) {
        Z3SpecialNumber test = new Z3SpecialNumber();
        // 182
        System.out.println(test.punishmentNumber(10));
        // 10804657
        System.out.println(test.punishmentNumber(1000));
    }
}
