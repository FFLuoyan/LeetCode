package org.zongjieli.leetcode.competion.doubleweekly.order26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SimplestFraction
 * @Description: 给定一个整数 n,返回所有 0 - 1 之间(不包括 0,1)
 * 满足分母小于等于 n 的最简分数,分数可以以任意顺序返回
 * @Author: Zongjie.Li
 * @Date: 2020/5/16
 * @Version: 1.0
 **/
public class SimplestFraction {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        int[] checkValue = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        Map<Integer, Boolean> valueMap = new HashMap<>(checkValue.length);
        for (int i = 0; i < checkValue.length; i++) {
            if (checkValue[i] <= n) {
                valueMap.put(checkValue[i], true);
            } else {
                break;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (valueMap.get(i) != null) {
                for (int j = 1; j < i; j++) {
                    result.add(j + "/" + i);
                }
            } else {
                for (int j = 1; j < i; j++) {
                    boolean canAdd = true;
                    for (int checkIndex = 0; checkIndex < checkValue.length; checkIndex++) {
                        if (j < checkValue[checkIndex]) {
                            break;
                        } else {
                            if (j % checkValue[checkIndex] == 0 && i % checkValue[checkIndex] == 0){
                                canAdd = false;
                                break;
                            }
                        }
                    }
                    if (canAdd){
                        result.add(j + "/" + i);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SimplestFraction simplestFraction = new SimplestFraction()
                ;
        System.out.println(simplestFraction.simplifiedFractions(6));
    }
}
