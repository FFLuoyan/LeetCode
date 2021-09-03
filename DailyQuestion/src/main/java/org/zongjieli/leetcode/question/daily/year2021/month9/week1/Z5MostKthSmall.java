package org.zongjieli.leetcode.question.daily.year2021.month9.week1;

import java.util.*;

/**
 * 设计一个算法,找出数组中最小的 k 个数,以任意顺序返回这 k 个数均可
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * @author   Li.zongjie
 * @date     2021/9/3
 * @version  1.0
 */
public class Z5MostKthSmall {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0 || arr.length == 0){
            return new int[0];
        }

        TreeMap<Integer,Integer> resultMap = new TreeMap<>();
        for (int i = 0 ; i < k ; i++){
            resultMap.merge(arr[i], 1, Integer::sum);
        }
        for (int i = k ; i < arr.length ; i++){
            Map.Entry<Integer,Integer> entry = resultMap.lastEntry();
            if (arr[i] < entry.getKey()){
                resultMap.merge(arr[i], 1, Integer::sum);
                resultMap.computeIfPresent(entry.getKey(),(key,o) -> o == 1 ? null : o - 1);
            }
        }

        int[] result = new int[k];
        int[] index = new int[]{0};
        resultMap.forEach((key,value) -> {
            for (int i = 1 ; i <= value ; i++){
                result[index[0]++] = key;
            }
        });

        return result;
    }

    public static void main(String[] args) {
        Z5MostKthSmall test = new Z5MostKthSmall();
        System.out.println(Arrays.toString(test.smallestK(new int[]{7, 7, 7, 7, 2, 4, 6, 8, 1 , 1}, 4)));
    }
}
