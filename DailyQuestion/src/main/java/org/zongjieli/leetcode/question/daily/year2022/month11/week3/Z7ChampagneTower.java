package org.zongjieli.leetcode.question.daily.year2022.month11.week3;

/**
 * 把玻璃杯摆成金字塔的形状,其中第一层有 1 个玻璃杯,第二层 有 2 个,依次类推到第 100 层
 * 每个玻璃杯 (250ml) 将盛有香槟
 * 从顶层的第一个玻璃杯开始倾倒一些香槟,当顶层的杯子满了
 * 任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯
 * 当左右两边的杯子也满了,就会等流量的流向它们左右两边的杯子,依次类推
 * 当最底层的玻璃杯满了,香槟会流到地板上
 * 例如:
 * 在倾倒一杯香槟后,最顶层的玻璃杯满了
 * 倾倒了两杯香槟后,第二层的两个玻璃杯各自盛放一半的香槟
 * 在倒三杯香槟后,第二层的香槟满了-此时总共有三个满的玻璃杯
 * 在倒第四杯后,第三层中间的玻璃杯盛放了一半的香槟,他两边的玻璃杯各自盛放了四分之一的香槟
 * 现在当倾倒了非负整数杯香槟后,返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例(i 和 j 都从0开始)
 *
 * 0 <= poured <= 10^9
 * 0 <= query_glass <= query_row < 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/2
 */
public class Z7ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] lastRow = new double[]{poured};
        for (int row = 1 ; row <= query_row ; row++) {
            double[] currentRow = new double[lastRow.length + 1];
            for (int i = 0; i < lastRow.length; i++) {
                double lastRemain = (lastRow[i] - 1) * 0.5;
                if (lastRemain > 0) {
                    currentRow[i] += lastRemain;
                    currentRow[i + 1] += lastRemain;
                }
            }
            lastRow = currentRow;
        }
        return Math.min(lastRow[query_glass], 1);
    }

    public static void main(String[] args) {
        Z7ChampagneTower test = new Z7ChampagneTower();
        // 0.5
        System.out.println(test.champagneTower(2, 1, 1));
    }

}
