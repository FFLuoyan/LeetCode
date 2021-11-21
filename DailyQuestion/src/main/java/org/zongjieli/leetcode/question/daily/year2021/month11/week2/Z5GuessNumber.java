package org.zongjieli.leetcode.question.daily.year2021.month11.week2;

/**
 * 一个猜数游戏的游戏规则如下:
 *
 *  我从 1 到 n 之间选择一个数字
 *  你来猜我选了哪个数字
 *  如果你猜到正确的数字,就会赢得游戏
 *  如果你猜错了,那么我会告诉你,我选的数字比你的更大或者更小,并且你需要继续猜数
 *  每当你猜了数字 x 并且猜错了的时候,你需要支付金额为 x 的现金
 *   如果你花光了钱,就会输掉游戏
 *  给你一个特定的数字 n,返回能够确保你获胜的最小现金数,不管我选择那个数字
 *
 *  1 <= n <= 200
 *
 * @author   Li.zongjie
 * @date     2021/11/12
 * @version  1.0
 */
public class Z5GuessNumber {

//    new int[]{0, 0, 1, 2, 4, 6, 8, 10, 12, 14, 16, 18, 21, 24, 27, 30, 34, 38, 42, 46, 49, 52, 55, 58, 61, 64, 67, 70, 73, 76, 79, 82, 86, 90, 94, 98, 102, 106, 110, 114, 119, 124, 129, 134, 139, 144, 149, 154, 160, 166, 172, 178, 182, 186, 190, 194, 198, 202, 206, 210, 214, 218, 222, 226, 230, 234, 238, 242, 246, 250, 254, 258, 262, 266, 270, 274, 278, 282, 286, 290, 295, 300, 305, 310, 315, 320, 325, 330, 335, 340, 345, 350, 355, 360, 365, 370, 376, 382, 388, 394, 400, 406, 412, 418, 424, 430, 436, 442, 448, 454, 460, 466, 473, 480, 487, 494, 501, 508, 515, 522, 529, 536, 543, 550, 555, 560, 565, 570, 575, 580, 585, 590, 595, 600, 605, 610, 615, 620, 625, 630, 635, 640, 645, 650, 655, 660, 666, 674, 680, 686, 692, 698, 703, 708, 713, 718, 723, 728, 733, 738, 743, 748, 753, 758, 763, 768, 773, 778, 783, 788, 793, 798, 803, 808, 813, 818, 823, 828, 833, 838, 843, 848, 853, 858, 863, 868, 873, 878, 883, 888, 893, 898, 904, 910, 916, 922, 928, 934, 940, 946, 952}[n];

    public int getMoneyAmount(int n) {
        /*
            这是一个动态规划的题目,要计算 n 个数保证获胜的最小金额
            分为两部分考虑,首先要保证游戏获胜,再考虑获胜时的金额
            有 f(a,b) 表示从 a 至 b 最小的获胜金额
            题目则转变为求 f(1,n) 的值
            对于每一个 a <= m <= b 时
            g(m) = m + math.max(f(a,m - 1),f(m + 1,b))
            为此时保证获胜的金额
            而保证获胜的最小金额则为 g(m) (a <= m <= b) 的最小值
         */
        int[][] save = new int[n + 1][n + 1];
        // 对于第 i 行 save[i], 0 - i 的数据均为 0,不具有使用意义
        for (int i = n ; i >= 1 ; i--){
            // 从第 n 行往 0 循环,第 n 行只有一条数据 save[n][n]
            for (int j = i + 1 ; j <= n ; j++){
                // 对于第 i 行,循环遍历至 n,依次求出 f(i,j) 的最小值
                int min = i + save[i + 1][j];
                for (int k = i + 1 ; k < j ; k++){
                    min = Math.min(min, k + Math.max(save[i][k - 1], save[k + 1][j]));
                }
                save[i][j] = min;
            }
        }
        return save[1][n];
    }

    public static void main(String[] args) {
        Z5GuessNumber test = new Z5GuessNumber();

        for (int i = 0 ; i < 200 ; i++){
            System.out.println("I-" + i + ": " + test.getMoneyAmount(i));
        }
    }

}