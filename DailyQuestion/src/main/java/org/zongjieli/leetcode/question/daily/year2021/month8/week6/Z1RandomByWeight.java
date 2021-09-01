package org.zongjieli.leetcode.question.daily.year2021.month8.week6;

import java.util.Random;
import java.util.TreeMap;

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

    private TreeMap<Integer,Integer> map;
    private int sum;
    private Random random = new Random();

    public Z1RandomByWeight(int[] w) {
        map = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            map.put(sum,i);
            sum += w[i];
        }
    }

    public int pickIndex() {
        int v = random.nextInt(sum);
        return map.floorEntry(v).getValue();
    }

    public static void main(String[] args) {
        Z1RandomByWeight test = new Z1RandomByWeight(new int[]{1,2,3});
        for (int i = 0 ; i < 10 ; i++){
            test.pickIndex();
        }
    }
}
