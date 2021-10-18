package org.zongjieli.leetcode.question.daily.year2021.month10.week2;

/**
 * 给定一个非空数组,返回此数组中第三大的数
 * 如果不存在,则返回数组中最大的数
 *
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2021/10/9
 * @version  1.0
 */
public class Z3ThirdMax {

    public int thirdMax(int[] nums) {
        int a = nums[0];
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;

        for (int i = 1 ; i < nums.length ; i++){
            if (nums[i] == a){
                continue;
            }

            if (nums[i] > a){
                c = b;
                b = a;
                a = nums[i];
                continue;
            }

            if (b == Integer.MAX_VALUE){
                b = nums[i];
                continue;
            }

            if (b == nums[i]){
                continue;
            }

            if (b < nums[i]){
                c = b;
                b = nums[i];
                continue;
            }

            if (c == Integer.MAX_VALUE || c < nums[i]){
                c = nums[i];
            }
        }

        return c == Integer.MAX_VALUE ? a : c;
    }

    public static void main(String[] args) {
        Z3ThirdMax test = new Z3ThirdMax();
        System.out.println(test.thirdMax(new int[]{3,2,1}));
//        System.out.println(test.thirdMax(new int[]{2,2,3,1}));
//        System.out.println(test.thirdMax(new int[]{2,2,1}));
//        System.out.println(test.thirdMax(new int[]{2,1,1}));
//        System.out.println(test.thirdMax(new int[]{1,2,2,5,3,5}));
    }
}
