package org.zongjieli.leetcode.question.daily.year2022.month10.week4;
/**
 * 一家农场从左到右种植了一排果树,这些树用一个整数数组 fruits 表示
 * 其中 fruits[i] 是第 i 棵树上的水果种类
 * 想要尽可能多地收集水果,然而农场的主人设定了一些严格的规矩,必须按照要求采摘水果:
 *  只有两个篮子,并且每个篮子只能装单一类型的水果,每个篮子能够装的水果总量没有限制
 *  可以选择任意一棵树开始采摘,你必须从每棵树(包括开始采摘的树)上恰好摘一个水果
 *  采摘的水果应当符合篮子中的水果类型,每采摘一次,将会向右移动到下一棵树,并继续采摘
 *  一旦你走到某棵树前,但水果不符合篮子的水果类型,那么就必须停止采摘
 * 给定一个整数数组 fruits,返回你可以收集的水果的最大数目
 *
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 *
 * @author   Li.zongjie
 * @date     2022/10/17
 * @version  1.0
 */
public class Z1FruitBasket {

    public int totalFruit(int[] fruits) {
        int result = 0;
        int a = -1, b = -1, as = 0, l = -1, ls = 0;
        for (int fruit : fruits) {
            if (a == -1) {
                a = fruit;
                as = 1;
            } else if (a == fruit || b == fruit) {
                as++;
            } else if (b == -1) {
                b = fruit;
                as++;
            } else {
                result = Math.max(as, result);
                a = l;
                as = ls + 1;
                b = fruit;
            }
            if (fruit == l) {
                ls++;
            } else {
                l = fruit;
                ls = 1;
            }
        }
        return Math.max(result, as);
    }
}
