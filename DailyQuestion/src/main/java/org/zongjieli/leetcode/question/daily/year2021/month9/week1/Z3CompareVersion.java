package org.zongjieli.leetcode.question.daily.year2021.month9.week1;
/**
 *
 * 给你两个版本号 version1 和 version2,请你比较它们
 *
 * 版本号由一个或多个修订号组成,各修订号由一个 '.' 连接
 * 每个修订号由多位数字组成,可能包含前导零
 * 每个版本号至少包含一个字符,修订号从左到右编号,下标从 0 开始
 * 最左边的修订号下标为 0,下一个修订号下标为 1,以此类推
 *
 * 例如,2.5.33 和 0.1 都是有效的版本号
 *
 * 比较版本号时,请按从左到右的顺序依次比较它们的修订号
 * 比较修订号时,只需比较忽略任何前导零后的整数值
 * 也就是说,修订号 1 和修订号 001 相等
 * 如果版本号没有指定某个下标处的修订号,则该修订号视为 0
 * 例如,版本 1.0 小于版本 1.1
 * 因为它们下标为 0 的修订号相同
 * 而下标为 1 的修订号分别为 0 和 1,0 < 1
 *
 * 返回规则如下：
 *
 * 如果 version1 > version2 返回 1
 * 如果 version1 < version2 返回 -1
 * 除此之外返回 0
 *
 * 1 <= version1.length, version2.length <= 500
 * version1 和 version2 仅包含数字和 '.'
 * version1 和 version2 都是有效版本号
 * version1 和 version2 的所有修订号都可以存储在 32 位整数中
 *
 * @author   Li.zongjie
 * @date     2021/9/1
 * @version  1.0
 */
public class Z3CompareVersion {
    public int compareVersion(String version1, String version2) {
        int v1 = 0;
        int v2 = 0;
        int vL1 = version1.length();
        int vL2 = version2.length();
        while (v1 < vL1 || v2 < vL2){
            int value1 = 0;
            int value2 = 0;

            while (v1 < vL1){
                char c = version1.charAt(v1++);
                if (c == '.'){
                    break;
                }
                value1 = value1 * 10 + c - '0';
            }

            while (v2 < vL2){
                char c = version2.charAt(v2++);
                if (c == '.'){
                    break;
                }
                value2 = value2 * 10 + c - '0';
            }

            if (value1 > value2){
                return 1;
            }

            if (value1 < value2){
                return -1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Z3CompareVersion test = new Z3CompareVersion();
        System.out.println(test.compareVersion("1.01","1.001"));
    }
}
