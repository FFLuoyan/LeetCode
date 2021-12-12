package org.zongjieli.leetcode.competion.singleweekly.order271;
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
 * @author   Li.zongjie
 * @date     2021/12/12
 * @version  1.0
 */
public class RingAndRod {
    public int countPoints(String rings) {
        boolean[][] exists = new boolean[10][3];
        for (int i = 0 ; i < rings.length() ; i+= 2){
            char color = rings.charAt(i);
            exists[rings.charAt(i + 1) - '0'][color == 'R' ? 0 : color == 'G' ? 1 : 2] = true;
        }
        int count = 0;
        for (boolean[] exist : exists) {
            if (exist[0] && exist[1] && exist[2]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RingAndRod test = new RingAndRod();
        System.out.println(test.countPoints("B0B6G0R6R0R6G9"));
    }
}
