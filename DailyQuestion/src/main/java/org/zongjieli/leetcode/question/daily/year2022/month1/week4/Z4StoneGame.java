package org.zongjieli.leetcode.question.daily.year2022.month1.week4;
/**
 * Alice 和 Bob 再次设计了一款新的石子游戏
 * 现有一行 n 个石子,每个石子都有一个关联的数字表示它的价值
 * 给定一个整数数组 stones,其中 stones[i] 是第 i 个石子的价值
 * Alice 和 Bob 轮流进行自己的回合,Alice 先手
 * 每一回合,玩家需要从 stones 中移除任一石子
 * 如果玩家移除石子后,导致所有已移除石子的价值总和可以被 3 整除,那么该玩家就输掉游戏
 * 如果不满足上一条,且移除后没有任何剩余的石子,那么 Bob 将会直接获胜(即便是在 Alice 的回合)
 * 假设两位玩家均采用最佳决策,如果 Alice 获胜,返回 true,如果 Bob 获胜,返回 false
 *
 * 1 <= stones.length <= 10^5
 * 1 <= stones[i] <= 10^4
 *
 * @author   Li.zongjie
 * @date     2022/1/20
 * @version  1.0
 */
public class Z4StoneGame {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        /*
            游戏必然从 1 或者 2 开始
            按照路径 1 (1 2),或者 2 (2 1) 直至某个数字取完,其中括号表示循环
            Alice 要获胜则需要保证从 1 或者 2 开始,取至 1 或 2 还有剩余
            这个剩余必须被 Bob 拿到,否则会造成数字取完 Bob 直接获胜
         */
        int sub = count[1] - count[2];
        return (count[1] != 0 && sub != 1 && sub != 2 && ((count[1] <= count[2] ? 1 : 0) + count[0]) % 2 == 1)
                || (count[2] != 0 && sub != -1 && sub != -2 && ((count[2] <= count[1] ? 1 : 0) + count[0]) % 2 == 1);
    }

    public static void main(String[] args) {
        Z4StoneGame test = new Z4StoneGame();
        // true
        System.out.println(test.stoneGameIX(new int[]{77,74,12,63,95,23,19,91,48,87,26,22,21,30,41,10,22,80,14,36,62,29,13,3,15,47,71,1,95,21,43,84,62,70,10,86,70,9,38,30,51,32,75,87,73,8,54,64,35,22,68,75,4,59,69,82,27,9,20,32,64,59,58,48,32,21,15,20,75}));
        // false 1 2 2
        System.out.println(test.stoneGameIX(new int[]{5,1,2,4,3}));
        // false 3 2 4
        System.out.println(test.stoneGameIX(new int[]{15,20,10,13,14,15,5,2,3}));
        // false 41 28 30
        System.out.println(test.stoneGameIX(new int[]{2,33,90,62,43,21,96,20,18,84,74,61,100,5,11,4,67,96,18,6,68,82,32,76,33,93,33,71,32,30,63,37,46,95,51,63,77,63,84,52,78,66,76,66,9,73,92,79,65,29,42,64,46,84,95,71,15,68,55,9,22,64,56,83,52,47,38,19,59,32,89,29,56,84,57,90,96,19,38,13,49,65,93,8,30,15,12,40,84,7,6,75,36,31,6,78,64,33,49}));


    }
}
