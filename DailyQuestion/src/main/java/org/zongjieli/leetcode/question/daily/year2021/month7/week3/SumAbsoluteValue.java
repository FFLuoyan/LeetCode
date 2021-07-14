package org.zongjieli.leetcode.question.daily.year2021.month7.week3;

/**
 * 给你两个正整数数组 nums1 和 nums2,数组的长度都是 n
 * 数组 nums1 和 nums2 的绝对差值和定义为:
 *  所有 |nums1[i] - nums2[i]|(0 <= i < n) 的总和
 *
 * 你可以选用 nums1 中的任意一个元素来替换 nums1 中的至多一个元素以最小化绝对差值和
 * 在替换数组 nums1 中最多一个元素之后返回最小绝对差值和
 *
 * 因为答案可能很大，所以需要对 10^9 + 7 取余后返回
 * |x| 定义为：
 *  如果 x >= 0,值为 x
 *  如果 x <= 0,值为 -x
 *  
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 10^5
 * 1 <= nums1[i], nums2[i] <= 10^5
 *
 *
 * @author   Zongjie.Li
 * @date     2021/7/14
 * @version  1.0
 */
public class SumAbsoluteValue {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        boolean[] numsExist = new boolean[100001];
        for (int value : nums1) {
            numsExist[value] = true;
        }
        int max = 0;
        long result = 0;
        for (int i = 0; i < nums1.length; i++) {
            int abs = Math.abs(nums2[i] - nums1[i]);
            result += abs;
            if (abs > max){
                int maxDiff = abs - max;
                for (int j = nums2[i] ; j < nums2[i] + maxDiff && j <= 100000 ; j++){
                    if (numsExist[j]){
                        maxDiff = j - nums2[i];
                        max = abs - maxDiff;
                        break;
                    }
                }
                for (int j = nums2[i] ; j > nums2[i] - maxDiff && j >= 0 ; j--){
                    if (numsExist[j]){
                        maxDiff = nums2[i] - j;
                        max = abs - maxDiff;
                        break;
                    }
                }
            }
        }
        return (int) ((result - max) % 1000000007);
    }

    public static void main(String[] args) {
        SumAbsoluteValue test = new SumAbsoluteValue();
//        int[] nums1 = new int[]{1,2,3};
//        int[] nums2 = new int[]{2,3,4};
//        int[] nums1 = new int[]{1,7,5};
//        int[] nums2 = new int[]{2,3,5};
        int[] nums1 = new int[]{57,42,21,28,30,25,22,12,55,3,47,18,43,29,20,44,59,9,43,7,8,5,42,53,99,34,37,88,87,62,38,68,31,3,11,61,93,34,63,27,20,48,38,5,71,100,88,54,52,15,98,59,74,26,81,38,11,44,25,69,79,81,51,85,59,84,83,99,31,47,31,23,83,70,82,79,86,31,50,17,11,100,55,15,98,11,90,16,46,89,34,33,57,53,82,34,25,70,5,1};
        int[] nums2 = new int[]{76,3,5,29,18,53,55,79,30,33,87,3,56,93,40,80,9,91,71,38,35,78,32,58,77,41,63,5,21,67,21,84,52,80,65,38,62,99,80,13,59,94,21,61,43,82,29,97,31,24,95,52,90,92,37,26,65,89,90,32,27,3,42,47,93,25,14,5,39,85,89,7,74,38,12,46,40,25,51,2,19,8,21,62,58,29,32,77,62,9,74,98,10,55,25,62,48,48,24,21};
        System.out.println(test.minAbsoluteSumDiff(nums1,nums2));
    }
}
