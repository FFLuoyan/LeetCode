package org.zongjieli.leetcode.question.daily.year2023.month5.week1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定三个整数 x、y 和 bound,返回值小于或等于 bound 的所有强整数组成的列表
 * 如果某一整数可以表示为 x^i + y^j,其中整数 i >= 0 且 j >= 0,那么该整数是一个强整数
 * 可以按任何顺序返回答案,在答案中每个值最多出现一次
 *
 * 1 <= x, y <= 100
 * 0 <= bound <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/5/2
 */
public class Z2StrongNumber {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        int all = 2;
        if (y == 1) {
            if (bound >= all) {
                result.add(all);
            }
        } else {
            int base = 1;
            while (all <= bound) {
                result.add(all);
                all -= base;
                base *= y;
                all += base;
            }
        }
        if (x != 1) {
            int first = x;
            while (first <= bound) {
                all = first + 1;
                if (y == 1) {
                    if (bound >= all) {
                        result.add(all);
                    }
                } else {
                    int base = 1;
                    while (all <= bound) {
                        result.add(all);
                        all -= base;
                        base *= y;
                        all += base;
                    }
                }
                first *= x;
            }
        }
        return new ArrayList<>(result);
    }

}
