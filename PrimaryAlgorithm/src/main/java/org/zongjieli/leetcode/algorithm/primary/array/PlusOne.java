package org.zongjieli.leetcode.algorithm.primary.array;

import java.util.Arrays;

/**
 * @ClassName: PlusOne
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/26
 * @Version: 1.0
 **/
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1 ; i >= 0 ; i--){
            if (digits[i] == 9){
                digits[i] = 0;
            } else {
                digits[i] ++;
                return digits;
            }
            if (i == 0) {
                break;
            }
        }
        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 5, 2, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));
    }
}
