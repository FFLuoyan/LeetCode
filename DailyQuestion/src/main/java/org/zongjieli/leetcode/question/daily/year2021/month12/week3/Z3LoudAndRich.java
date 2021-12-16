package org.zongjieli.leetcode.question.daily.year2021.month12.week3;

import java.util.*;

/**
 * 有一组 n 个人作为实验对象,从 0 到 n - 1 编号
 * 其中每个人都有不同数目的钱,以及不同程度的安静值(quietness)
 * 为了方便起见,将编号为 x 的人简称为 "person x"
 * <p>
 * 给定一个数组 richer,其中 richer[i] = [ai, bi]
 * 表示 person ai 比 person bi 更有钱
 * 另给定一个整数数组 quiet,其中 quiet[i] 是 person i 的安静值
 * richer 中所给出的数据逻辑自恰
 * 也就是说,在 person x 比 person y 更有钱的同时,不会出现 person y 比 person x 更有钱的情况
 * <p>
 * 现在,返回一个整数数组 answer 作为答案
 * 其中 answer[x] = y 的前提是
 * 在所有拥有的钱肯定不少于 person x 的人中
 * person y 是最安静的人(也就是安静值 quiet[y] 最小的人)
 * <p>
 * n == quiet.length
 * 1 <= n <= 500
 * 0 <= quiet[i] < n
 * quiet 的所有值互不相同
 * 0 <= richer.length <= n * (n - 1) / 2
 * 0 <= ai, bi < n
 * ai != bi
 * richer 中的所有数对互不相同
 * 对 richer 的观察在逻辑上是一致的
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2021/12/15
 */
public class Z3LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] result = new int[quiet.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        // 直接比 person i 钱少的人
        int[][] temp = new int[quiet.length][quiet.length + 1];
        for (int[] pair : richer) {
            temp[pair[0]][temp[pair[0]][quiet.length]++] = pair[1];
            if (quiet[result[pair[1]]] > quiet[result[pair[0]]]) {
                setValue(temp, result, quiet, pair[1], result[pair[0]]);
            }
        }
        return result;
    }

    public void setValue(int[][] save, int[] result, int[] quiet, int loop, int value) {
        result[loop] = value;
        int[] list = save[loop];
        for (int i = 0 ; i < list[quiet.length] ; i++){
            if (quiet[result[list[i]]] > quiet[value]) {
                setValue(save, result, quiet, list[i], value);
            }
        }
    }

    public static void main(String[] args) {
        Z3LoudAndRich test = new Z3LoudAndRich();
        // [5,5,2,5,4,5,6,7]
        System.out.println(Arrays.toString(test.loudAndRich(new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}}, new int[]{3, 2, 5, 4, 6, 1, 7, 0})));
        // [0,0,0]
        System.out.println(Arrays.toString(test.loudAndRich(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 1, 2})));
        // [4,4,4,4,4]
        System.out.println(Arrays.toString(test.loudAndRich(new int[][]{{1, 0}, {3, 2}, {4, 3}, {2, 1}}, new int[]{4, 3, 2, 1, 0})));
    }
}
