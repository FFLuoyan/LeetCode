package org.zongjieli.leetcode.question.daily.year2022.month3.week5;

import java.util.Map;
import java.util.TreeMap;

/**
 * 给定一个长度为偶数的整数数组 arr,只有对 arr 进行重组后可以满足
 *  对于每个 0 <= i < len(arr) / 2,都有 arr[2 * i + 1] = 2 * arr[2 * i] 
 * 时返回 true,否则返回 false
 *
 * 0 <= arr.length <= 3 * 10^4
 * arr.length 是偶数
 * -10^5 <= arr[i] <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/4/1
 * @version  1.0
 */
public class Z5DoubleArray {

    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> positiveAndZero = new TreeMap<>();
        TreeMap<Integer, Integer> negative = new TreeMap<>();
        for (int i : arr) {
            if (i < 0) {
                negative.merge(-i, 1, Integer::sum);
            } else {
                positiveAndZero.merge(i, 1, Integer::sum);
            }
        }
        Integer zero = positiveAndZero.remove(0);
        if (zero != null && (zero % 2 == 1)) {
            return false;
        }
        return validTree(positiveAndZero) && validTree(negative);
    }

    public boolean validTree(TreeMap<Integer, Integer> save) {
        Map.Entry<Integer, Integer> first;
        while ((first = save.pollFirstEntry()) != null) {
            int dv = first.getKey() * 2;
            int c = first.getValue();
            Integer dc = save.get(dv);
            if (dc == null || dc < c) {
                return false;
            }
            if (dc == c) {
                save.remove(dv);
            } else {
                save.put(dv, dc - c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Z5DoubleArray test = new Z5DoubleArray();
        // false
        System.out.println(test.canReorderDoubled(new int[]{3, 1, 3, 6}));
        // true
        System.out.println(test.canReorderDoubled(new int[]{4, -2, 2, -4}));
    }
}
