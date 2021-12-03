package org.zongjieli.leetcode.question.daily.year2021.month11.week5;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 给定一个按递增顺序排序的数组 arr 和一个整数 k
 * 数组 arr 由 1 和若干素数组成,且其中所有整数互不相同
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j
 * 可以得到分数 arr[i] / arr[j]
 *
 * 以长度为 2 的整数数组返回第 k 个最小的分数
 * answer[0] == arr[i] 且 answer[1] == arr[j]
 *
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 10^4
 * arr[0] == 1
 * arr[i] 是一个 素数,i > 0
 * arr 中的所有数字互不相同,且按严格递增排序
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 *
 * @author   Li.zongjie
 * @date     2021/11/29
 * @version  1.0
 */
public class Z1KthFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        TreeSet<int[]> save = new TreeSet<>((a,b) -> Integer.compare(arr[a[0]] * arr[b[1]], arr[a[1]] * arr[b[0]]));
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = i + 1 ; j < arr.length ; j++){
                save.add(new int[]{i, j});
                if (save.size() > k){
                    save.pollLast();
                }
            }
        }
        int[] index = save.last();
        return new int[]{arr[index[0]], arr[index[1]]};
    }

    public static void main(String[] args) {
        Z1KthFraction test = new Z1KthFraction();
        // 2,5
        System.out.println(Arrays.toString(test.kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3)));
        // 13,17
        System.out.println(Arrays.toString(test.kthSmallestPrimeFraction(new int[]{1,13,17,59}, 6)));
    }
}
