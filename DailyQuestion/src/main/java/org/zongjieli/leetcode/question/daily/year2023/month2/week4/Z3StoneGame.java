package org.zongjieli.leetcode.question.daily.year2023.month2.week4;

/**
 * 许多堆石子排成一行,每堆都有正整数颗石子 piles[i],游戏以谁手中的石子最多来决出胜负
 * 爱丽丝和鲍勃轮流进行,爱丽丝先开始,最初 M = 1
 * 在每个玩家的回合中,该玩家可以拿走剩下的前 X 堆的所有石子,其中 1 <= X <= 2M,然后,令 M = max(M, X)
 * 游戏一直持续到所有石子都被拿走
 * 假设爱丽丝和鲍勃都发挥出最佳水平,返回爱丽丝可以得到的最大数量的石头
 *
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/22
 */
public class Z3StoneGame {

    public int stoneGameII(int[] piles) {
        int[][] add = new int[piles.length][piles.length];
        for (int i = 0 ; i < piles.length ; i++) {
            add[i][i] = piles[i];
            for (int j = i + 1 ; j < piles.length ; j++) {
                add[i][j] = add[i][j - 1] + piles[j];
            }
        }
        int[][] save = new int[piles.length][2 * piles.length];
        return getMaxAlice(0, 1, add, save);
    }

    public int getMaxAlice(int index, int m, int[][] add, int[][] save) {
        if (index >= add.length) {
            return 0;
        }
        int mi = index + 2 * m - 1;
        if (mi >= add.length) {
            return add[index][add.length - 1];
        }
        if (save[index][m] != 0) {
            return save[index][m];
        }
        int min = Integer.MAX_VALUE, remain = add[index][add.length - 1];
        for (int i = index ; i <= mi ; i++) {
            int nm = Math.max(m, i - index + 1);
            min = Math.min(getMaxAlice(i + 1, nm, add, save), min);
        }
        return save[index][m] = remain - min;
    }

    public static void main(String[] args) {
        Z3StoneGame test = new Z3StoneGame();
        // 10
        System.out.println(test.stoneGameII(new int[]{2, 7, 9, 4, 4}));
        // 115357
        System.out.println(test.stoneGameII(new int[]{7468, 6245, 9261, 3958, 1986, 1074, 5677, 9386, 1408, 1384, 8811, 3885, 9678, 8470, 8893, 7514, 4941, 2148, 5217, 5425, 5307, 747, 1253, 3518, 5238, 5834, 9133, 8391, 6100, 3362, 7807, 2581, 6121, 7684, 8744, 9584, 4068, 7204, 4285, 8635}));
    }

}
