package org.zongjieli.leetcode.question.daily.year2022.month2.week4;
/**
 * n 张多米诺骨牌排成一行,将每张多米诺骨牌垂直竖立
 * 在开始时,同时把一些多米诺骨牌向左或向右推
 * 每过一秒,倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌
 * 同样地,倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时
 * 由于受力平衡,该骨牌仍然保持不变
 * 就这个问题而言,我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力
 * 给定一个字符串 dominoes 表示这一行多米诺骨牌的初始状态,其中:
 *  dominoes[i] = 'L',表示第 i 张多米诺骨牌被推向左侧,
 *  dominoes[i] = 'R',表示第 i 张多米诺骨牌被推向右侧,
 *  dominoes[i] = '.',表示没有推动第 i 张多米诺骨牌
 * 返回表示最终状态的字符串
 * n == dominoes.length
 * 1 <= n <= 10^5
 * dominoes[i] 为 'L'、'R' 或 '.'
 *
 * @author   Li.zongjie
 * @date     2022/2/21
 * @version  1.0
 */
public class Z1Domino {
    public String pushDominoes(String dominoes) {
        char[] dominoesChars = dominoes.toCharArray();

        int start = -1;
        boolean isRight = false;

        for (int i = 0 ; i < dominoesChars.length ; i++) {
            if (dominoesChars[i] == '.') {
                continue;
            }
            if (dominoesChars[i] == 'L') {
                if (isRight) {
                    boolean isBlank = (start + i) % 2 == 0;
                    int end = (start + i + 1) / 2;
                    for (int j = start + 1 ; j < end ; j++) {
                        dominoesChars[j] = 'R';
                    }
                    isRight = false;
                    start = isBlank ? end : end - 1;
                }

                for (int j = start + 1; j < i ; j++) {
                    dominoesChars[j] = 'L';
                }
                start = i;
            } else if (isRight) {
                for (int j = start + 1; j < i ; j++) {
                    dominoesChars[j] = 'R';
                }
                start = i;
            } else {
                isRight = true;
                start = i;
            }
        }

        if (isRight) {
            for (int i = start + 1; i < dominoesChars.length ; i++) {
                dominoesChars[i] = 'R';
            }
        }
        return new String(dominoesChars);
    }

    public static void main(String[] args) {
        Z1Domino test = new Z1Domino();
        // RR.L
        System.out.println(test.pushDominoes("RR.L"));
        // LL.RR.LLRRLL..
        System.out.println(test.pushDominoes(".L.R...LR..L.."));
    }
}
