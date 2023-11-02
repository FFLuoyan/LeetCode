package org.zongjieli.leetcode.origin.year2023;

/**
 * 总计有 n 个环,环的颜色可以是红、绿、蓝中的一种
 * 这些环分布穿在 10 根编号为 0 到 9 的杆上
 * 给定一个长度为 2n 的字符串 rings,表示这 n 个环在杆上的分布
 * rings 中每两个字符形成一个 颜色位置对,用于描述每个环:
 *  第 i 对中的第一个字符表示第 i 个环的颜色('R'、'G'、'B')
 *  第 i 对中的第二个字符表示第 i 个环的位置,也就是位于哪根杆上('0' 到 '9')
 * 例如,"R3G2B1" 表示:
 *  共有 n == 3 个环
 *  红色的环在编号为 3 的杆上
 *  绿色的环在编号为 2 的杆上
 *  蓝色的环在编号为 1 的杆上
 * 找出所有集齐全部三种颜色环的杆,并返回这种杆的数量
 *
 * rings.length == 2 * n
 * 1 <= n <= 100
 * 如 i 是 偶数,则 rings[i] 的值可以取 'R'、'G' 或 'B'(下标从 0 开始计数)
 * 如 i 是 奇数,则 rings[i] 的值可以取 '0' 到 '9' 中的一个数字(下标从 0 开始计数)
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/2
 */
public class PoleAndRing {

    public int countPoints(String rings) {
        int[] poles = new int[10];
        char[] ringArray = rings.toCharArray();
        for (int i = 0; i < ringArray.length; i += 2) {
            int poleIndex = ringArray[i + 1] - '0';
            char color = ringArray[i];
            poles[poleIndex] |= (color == 'R' ? 1 : color == 'G' ? 2 : 4);
        }
        int result = 0;
        for (int pole : poles) {
            if (pole == 7) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PoleAndRing test = new PoleAndRing();
        // 1
        System.out.println(test.countPoints("B0B6G0R6R0R6G9"));
        // 1
        System.out.println(test.countPoints("B0R0G0R9R0B0G0"));
    }

}
