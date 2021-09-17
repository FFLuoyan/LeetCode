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
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int sortedIndex;
        while ((sortedIndex = fastSort(arr,startIndex, endIndex)) != k){
            if (sortedIndex < k){
                startIndex = sortedIndex + 1;
            } else {
                endIndex = sortedIndex - 1;
            }
        }
        return Arrays.copyOf(arr, k);
    }

    public int fastSort(int[] arr, int startIndex, int endIndex){
        int base = arr[startIndex];
        while (startIndex < endIndex){
            while (startIndex < endIndex){
                if (arr[endIndex] < base){
                    arr[startIndex++] = arr[endIndex];
                    break;
                }
                endIndex--;
            }
            while (startIndex < endIndex){
                if (arr[startIndex] >= base){
                    arr[endIndex--] = arr[startIndex];
                    break;
                }
                startIndex++;
            }
        }
        arr[startIndex] = base;
        return startIndex;
    }

    public static void main(String[] args) {
        Z5MostKthSmall test = new Z5MostKthSmall();
//        System.out.println(Arrays.toString(test.smallestK(new int[]{7, 7, 7, 7, 2, 4, 6, 8, 1 , 1}, 4)));
//        System.out.println(Arrays.toString(test.smallestK(new int[]{}, 0)));
        System.out.println(Arrays.toString(test.smallestK(new int[]{1}, 1)));
    }
}
