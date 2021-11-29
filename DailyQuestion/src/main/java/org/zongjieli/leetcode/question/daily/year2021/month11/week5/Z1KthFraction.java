package org.zongjieli.leetcode.question.daily.year2021.month11.week5;
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
        int[] fraction = new int[arr.length];
        fraction[0] = arr.length - 1;
        int th = 1;
        int minIndex = 0;
        while (true){
            for (int i = 0 ; i < fraction.length ; i++){
                if (fraction[i] == 0){
                    continue;
                }
                // min arr[minIndex] / arr[fraction[minIndex]]
                // compare arr[i] / arr[fraction[i]]
                if (arr[minIndex] * arr[fraction[i]] > arr[i] * arr[fraction[minIndex]]){
                    minIndex = i;
                }
            }
            if (th == k){
                return new int[]{arr[minIndex], arr[fraction[minIndex]]};
            }
            th++;

            if (fraction[minIndex + 1] == 0){
                fraction[minIndex + 1] = fraction[minIndex];
            }

            if (fraction[minIndex] > minIndex){
                fraction[minIndex]--;
            }

        }
    }
}
