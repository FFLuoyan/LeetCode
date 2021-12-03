package org.zongjieli.leetcode.question.daily.year2021.month12.week1;

/**
 * 给定一个整数数组 nums 和一个整数 k,按以下方法修改该数组:
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i]
 * 重复这个过程恰好 k 次,可以多次选择同一个下标 i
 * 以这种方式修改数组后,返回数组可能的最大和
 *
 * 1 <= nums.length <= 10^4
 * -100 <= nums[i] <= 100
 * 1 <= k <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2021/12/3
 */
public class Z5ReverseMax {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] count = new int[201];
        for (int num : nums) {
            count[num + 100]++;
        }
        int index = 0;
        while (index < 100 && k > 0){
            int min = Math.min(k, count[index]);
            k -= min;
            count[index] -= min;
            count[200 - index] += min;
            index = k > 0 ? index + 1 : index;
        }

        int sum = 0;
        int minIndex = 200;
        for (int i = index ; i < 201 ; i++){
            sum += i * count[i];
            minIndex = i < minIndex && count[i] != 0 ? i : minIndex;
        }
        return sum - nums.length * 100 + ((k & 1) == 0 ? 0 : ( 200 - 2 * minIndex));
    }

    public static void main(String[] args) {
        Z5ReverseMax test = new Z5ReverseMax();
        // 6
        System.out.println(test.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        // 11
        System.out.println(test.largestSumAfterKNegations(new int[]{-2, 5, 0, 2, -2}, 3));
        // 5
        System.out.println(test.largestSumAfterKNegations(new int[]{-4, -2, -3}, 4));
        // 13
        System.out.println(test.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}
