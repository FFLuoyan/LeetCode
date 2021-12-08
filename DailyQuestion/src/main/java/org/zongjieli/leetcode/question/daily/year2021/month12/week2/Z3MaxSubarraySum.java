package org.zongjieli.leetcode.question.daily.year2021.month12.week2;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个整数 k
 * 找出三个长度为 k,互不重叠,且 3 * k 项的和最大的子数组,并返回这三个子数组
 * 以下标的数组形式返回结果,数组中的每一项分别指示每个子数组的起始位置(下标从 0 开始)
 * 如果有多个结果,返回字典序最小的一个
 *
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] < 2^16
 * 1 <= k <= floor(nums.length / 3)
 *
 * @author   Li.zongjie
 * @date     2021/12/8
 * @version  1.0
 */
public class Z3MaxSubarraySum {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] value = new int[nums.length - k + 1];
        for (int i = 0 ; i < k ; i++){
            value[0] += nums[i];
        }
        for (int i = k ; i < nums.length ; i++){
            value[i - k + 1] = value[i - k] + nums[i] - nums[i - k];
        }
        int allMax = value[0] + value[k] + value[2 * k];
        int [] result = new int[]{0, k, 2 * k};
        /*
            i 取 0
            j 取 k
            查找 l 的最大值,并记录下标 index2
            在 [k,index2 - k] 中查找 j 的最大值
            记录此时 j + l 的最大值及下标 index1,index2
            遍历 j,从 index2 - k 开始,找到一个比 j 更大的下标 index1
            查找 l 的最大值
         */
        for (int i = 0 ; i < value.length - 2 * k; ){

            int index2 = findMax(value,i + 2 * k, value.length - 1);
            int index1 = findMax(value, i + k, index2 - k);

            int[] max = new int[]{index1, index2, value[index1] + value[index2]};

            for (int j = index2 - k + 1 ; j < value.length - k ; j++){
                if (value[j] > value[max[0]]){
                    int index = findMax(value, j + k, value.length - 1);
                    j = findMax(value, j, index - k);
                    int tempMax = value[j] + value[index];
                    if (tempMax >= max[2]){
                        max[0] = j;
                        max[1] = index;
                        max[2] = tempMax;
                    }
                }
            }

            int iTemp = findMax(value, 0, max[0] - k);
            if (value[iTemp] + max[2] > allMax){
                result[0] = iTemp;
                result[1] = max[0];
                result[2] = max[1];
                allMax = value[iTemp] + max[2];
            }
            i = max[0] - k + 1;
        }

        return result;
    }

    public int findMax(int[] array, int startIndex, int endIndex){
        int index = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++){
            index = array[i] > array[index] ? i : index;
        }
        return index;
    }

    public static void main(String[] args) {
        Z3MaxSubarraySum test = new Z3MaxSubarraySum();
        // 0,3,5
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2)));
        // 0,2,4
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{1,2,1,2,1,2,1,2,1}, 2)));
        // 0,1,2
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{1,1,1,1,1,1}, 1)));
        // 1,4,7
        System.out.println(Arrays.toString(test.maxSumOfThreeSubarrays(new int[]{7,13,20,19,19,2,10,1,1,19}, 3)));
    }
}
