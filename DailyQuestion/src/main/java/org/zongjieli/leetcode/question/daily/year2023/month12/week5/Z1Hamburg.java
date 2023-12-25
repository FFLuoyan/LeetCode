package org.zongjieli.leetcode.question.daily.year2023.month12.week5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 圣诞活动预热开始啦,汉堡店推出了全新的汉堡套餐
 * 为了避免浪费原料,请帮他们制定合适的制作计划
 * 给定两个整数 tomatoSlices 和 cheeseSlices,分别表示番茄片和奶酪片的数目
 * 不同汉堡的原料搭配如下:
 *  巨无霸汉堡: 4 片番茄和 1 片奶酪
 *  小皇堡: 2 片番茄和 1 片奶酪
 * 请以 [total_jumbo, total_small]([巨无霸汉堡总数,小皇堡总数])的格式返回恰当的制作方案
 * 使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0
 * 如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0,就请返回 []
 *
 * 0 <= tomatoSlices <= 10^7
 * 0 <= cheeseSlices <= 10^7
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/25
 */
public class Z1Hamburg {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int min = 2 * cheeseSlices, max = 4 * cheeseSlices;
        if (tomatoSlices < min || tomatoSlices > max || tomatoSlices % 2 == 1) {
            return Collections.emptyList();
        }
        int remain = tomatoSlices / 2 - cheeseSlices;
        return Arrays.asList(remain, cheeseSlices - remain);
    }

    public static void main(String[] args) {
        Z1Hamburg test = new Z1Hamburg();
        // [1, 6]
        System.out.println(test.numOfBurgers(16, 7));
    }

}
