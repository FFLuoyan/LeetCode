package org.zongjieli.leetcode.question.daily.year2021.month8.week6;

import java.util.Random;

/**
 * 给定一个正整数数组 w,其中 w[i] 代表下标 i 的权重(下标从 0 开始)
 * 请写一个函数 pickIndex,它可以随机地获取下标 i,选取下标 i 的概率与 w[i] 成正比
 *
 * 例如,对于 w = [1, 3],挑选下标 0 的概率为 1 / (1 + 3) = 0.25(即 25%)
 * 而选取下标 1 的概率为 3 / (1 + 3) = 0.75(即,75%)
 *
 * 也就是说,选取下标 i 的概率为 w[i] / sum(w)
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex 将被调用不超过 10000 次
 *
 * @author   Li.zongjie
 * @date     2021/9/1
 * @version  1.0
 */
public class Z1RandomByWeight {

    private int[] value;
    private Random random = new Random();

    public Z1RandomByWeight(int[] w) {
        value = w;
        for (int i = 1; i < w.length; i++) {
            value[i] += value[i - 1];
        }
    }

    public int pickIndex() {
        int left = 0;
        int right = value.length - 1;
        int v = random.nextInt(value[right]) + 1;
        while (left < right){
            int middle = (left + right) / 2;
            if (value[middle] >= v){
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Z1RandomByWeight test = new Z1RandomByWeight(new int[]{1,2,3});
        for (int i = 1 ; i <= 6 ; i++){
            System.out.println(test.pickIndex());
        }
    }
}
