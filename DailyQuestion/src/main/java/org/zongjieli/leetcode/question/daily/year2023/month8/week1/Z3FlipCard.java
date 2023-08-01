package org.zongjieli.leetcode.question.daily.year2023.month8.week1;

/**
 * 在桌子上有 N 张卡片,每张卡片的正面和背面都写着一个正数(正面与背面上的数有可能不一样)
 * 可以先翻转任意张卡片,然后选择其中一张卡片
 * 如果选中的那张卡片背面的数字 X 与任意一张卡片的正面的数字都不同,那么这个数字是目标数字
 * 返回目标数字中最小的数(找到这些数中的最小值)呢
 * 如果没有一个数字符合要求的,输出 0
 * 其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字
 * 如果通过翻转卡片来交换正面与背面上的数,那么当初在正面的数就变成背面的数,背面的数就变成正面的数
 *
 * 1 <= fronts.length == backs.length <= 1000
 * 1 <= fronts[i] <= 2000
 * 1 <= backs[i] <= 2000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/2
 */
public class Z3FlipCard {

    public int flipGame(int[] fronts, int[] backs) {
        boolean[] invalid = new boolean[2001];
        boolean[] number = new boolean[2001];
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                invalid[fronts[i]] = true;
            } else {
                number[fronts[i]] = true;
                number[backs[i]] = true;
            }
        }
        for (int i = 1 ; i <= 2000 ; i++) {
            if (number[i] && !invalid[i]) {
                return i;
            }
        }
        return 0;
    }

}
