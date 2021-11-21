package org.zongjieli.leetcode.competion.singleweekly.order268;
/**
 * 街上有 n 栋房子整齐地排成一列
 * 每栋房子都粉刷上了漂亮的颜色
 * 给定一个下标从 0 开始且长度为 n 的整数数组 colors
 * 其中 colors[i] 表示第  i 栋房子的颜色
 * 返回两栋颜色不同房子之间的最大距离
 * 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j)
 * 其中 abs(x) 是 x 的绝对值
 *
 * n == colors.length
 * 2 <= n <= 100
 * 0 <= colors[i] <= 100
 * 生成的测试数据满足至少存在 2 栋颜色不同的房子
 *
 * @author   Li.zongjie
 * @date     2021/11/21
 * @version  1.0
 */
public class FarthestRoom {
    public int maxDistance(int[] colors) {
        int length = colors.length - 1;
        while (length > 1){
            for (int i = 0 ; i < colors.length - length ; i++){
                if (colors[i] != colors[i + length]){
                    return length;
                }
            }
            length--;
        }
        return length;
    }
}
