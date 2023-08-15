package org.zongjieli.leetcode.question.daily.year2023.month8.week3;

/**
 * n 个朋友在玩游戏,这些朋友坐成一个圈,按顺时针方向从 1 到 n 编号
 * 从第 i 个朋友的位置开始顺时针移动 1 步会到达第 (i + 1) 个朋友的位置(1 <= i < n)
 * 而从第 n 个朋友的位置开始顺时针移动 1 步会回到第 1 个朋友的位置
 * 游戏规则如下:
 *  第 1 个朋友接球
 *  接着,第 1 个朋友将球传给距离他顺时针方向 k 步的朋友
 *  然后,接球的朋友应该把球传给距离他顺时针方向 2 * k 步的朋友
 *  接着,接球的朋友应该把球传给距离他顺时针方向 3 * k 步的朋友,以此类推
 * 换句话说,在第 i 轮中持有球的那位朋友需要将球传递给距离他顺时针方向 i * k 步的朋友
 * 当某个朋友第 2 次接到球时,游戏结束
 * 在整场游戏中没有接到过球的朋友是输家
 * 给定参与游戏的朋友数量 n 和一个整数 k
 * 请按升序排列返回包含所有输家编号的数组 answer 作为答案
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/16
 */
public class Z3GameLose {

    public int[] circularGameLosers(int n, int k) {
        boolean[] get = new boolean[n + 1];
        int current = 1, number = 1;
        while (!get[current]) {
            get[current] = true;
            current = (current + k * number++ - 1) % n + 1;
        }
        number = n - number + 1;
        int[] result = new int[number];
        for (int j = get.length - 1; j >= 1; j--) {
            if (!get[j]) {
                result[--number] = j;
            }
        }
        return result;
    }

}
