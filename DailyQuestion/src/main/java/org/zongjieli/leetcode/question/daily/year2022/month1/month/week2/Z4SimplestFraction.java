package org.zongjieli.leetcode.question.daily.year2022.month1.month.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n,请返回所有 0 到 1 之间(不包括 0 和 1)
 * 满足分母小于等于  n 的最简分数
 * 分数可以以任意顺序返回
 *
 * 1 <= n <= 100
 *
 * @author   Li.zongjie
 * @date     2022/2/10
 * @version  1.0
 */
public class Z4SimplestFraction {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>(n * n);
        for (int i = 1 ; i < n ; i++){
            for (int j = i + 1 ; j <= n ; j++){
                if (maxCommon(j, i) == 1){
                    result.add(i + "/" + j);
                }
            }
        }
        return result;
    }

    public int maxCommon(int a,int b){
        if ((a %= b) == 0){
            return b;
        }
        return maxCommon(b, a);
    }
}
