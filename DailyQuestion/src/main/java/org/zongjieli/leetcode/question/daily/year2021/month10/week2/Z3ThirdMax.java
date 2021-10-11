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
        int[] value = new int[3];
        int count = 1;
        value[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            if (nums[i] == value[0]){
                continue;
            }
            if (count == 1){
                count = 2;
                value[1] = nums[i];
                continue;
            }
            if (nums[i] == value[1]){
                continue;
            }
            if (count == 2){
                count = 3;
                value[2] = nums[i];
                continue;
            }
            if (value[2] == nums[i]){
                continue;
            }

            int index = value[0] > value[1] ? 1 : 0;
            index = value[index] > value[2] ? 2 : index;
            if (value[index] < nums[i]){
                value[index] = nums[i];
            }
        }
        return count == 1 ? value[0] : (count == 2 ? Math.max(value[0],value[1]) : Math.min(Math.min(value[0],value[1]),value[2]));
    }

    public static void main(String[] args) {
        Z3ThirdMax test = new Z3ThirdMax();
//        System.out.println(test.thirdMax(new int[]{2,2,3,1}));
//        System.out.println(test.thirdMax(new int[]{2,2,1}));
//        System.out.println(test.thirdMax(new int[]{2,1,1}));
        System.out.println(test.thirdMax(new int[]{1,2,2,5,3,5}));
    }
}
