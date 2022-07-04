package org.zongjieli.leetcode.question.daily.year2022.month7.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定整数数组 arr,其中每个元素都不相同
 * 请找到所有具有最小绝对差的元素对,并且按升序的顺序返回
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 * @author   Li.zongjie
 * @date     2022/7/4
 * @version  1.0
 */
public class Z1MinSub {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int sub = Integer.MAX_VALUE;
        int[] save = new int[arr.length * 2];
        int ai = 0;
        for (int i = 1 ; i < arr.length ; i++) {
            int cs = arr[i] - arr[i - 1];
            if (cs <= sub) {
                if (cs < sub) {
                    ai = 0;
                    sub = cs;
                }
                save[ai++] = arr[i - 1];
                save[ai++] = arr[i];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0 ; i < ai ; i += 2) {
            result.add(Arrays.asList(save[i], save[i + 1]));
        }
        return result;
    }

    public static void main(String[] args) {
        Z1MinSub test = new Z1MinSub();
        System.out.println(test.minimumAbsDifference(new int[]{4, 2, 3, 1}));
    }
}
