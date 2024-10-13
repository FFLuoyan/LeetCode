package org.zongjieli.leetcode.question.daily.year2024.month10.week2;

/**
 * 给定 2 枚相同的鸡蛋,和一栋从第 1 层到第 n 层共有 n 层楼的建筑
 * 已知存在楼层 f,满足 0 <= f <= n,任何从高于 f 的楼层落下的鸡蛋都会碎
 * 从 f 楼层或比它低的楼层落下的鸡蛋都不会碎
 * 每次操作可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下(满足 1 <= x <= n)
 * 如果鸡蛋碎了就不能再次使用它,如果某枚鸡蛋扔下后没有摔碎,则可以在之后的操作中重复使用这枚鸡蛋
 * 请计算并返回要确定 f 确切的值的最小操作次数是多少
 *
 * 1 <= n <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/10/13
 */
public class Z7MinTime {

    public int twoEggDrop(int n) {
        return (int) Math.ceil(Math.sqrt(2 * n + 0.25) - 0.5);
    }

    public static void main(String[] args) {
        Z7MinTime test = new Z7MinTime();
        // 2
        System.out.println(test.twoEggDrop(2));
    }

}
