package org.zongjieli.leetcode.algorithm.primary.array;

import java.util.Arrays;

/**
 * @ClassName: RotateArray
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/22
 * @Version: 1.0
 **/
public class RotateArray {

    public static void rotate(int[] nums,int left,int right){
        while (left < right){
            nums[left] ^= nums[right];
            nums[right] ^= nums[left];
            nums[left] ^= nums[right];
            left ++;
            right --;
        }
    }
    public static void rotateArray(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        rotate(nums,0,nums.length-1);
        rotate(nums,0,k-1);
        rotate(nums,k,nums.length-1);



//        int count = 0;
//        for (int changeStart = 0; changeStart < k; changeStart++) {
//            for (int indexChange = changeStart + k;;) {
//                if (indexChange >= nums.length) {
//                    indexChange -= nums.length;
//                    if (indexChange == changeStart) {
//                        break;
//                    }
//                }
//                nums[changeStart] ^= nums[indexChange];
//                nums[indexChange] ^= nums[changeStart];
//                nums[changeStart] ^= nums[indexChange];
//                count++;
//                indexChange += k;
//            }
//            if (nums.length == count + changeStart + 1) {
//                return;
//            }
//        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 6, 8, 4, 52, 0};
        int k = 3;
        rotateArray(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
