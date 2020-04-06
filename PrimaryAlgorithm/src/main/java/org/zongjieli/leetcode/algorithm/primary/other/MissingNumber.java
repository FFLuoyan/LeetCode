package org.zongjieli.leetcode.algorithm.primary.other;

/**
 * @ClassName: MissingNumber
 * @Description: 给定一个包含 0 - n 中 n 个数的序列,找出序列中不存在的那个数
 * @Author: Zongjie.Li
 * @Date: 2020/4/2
 * @Version: 1.0
 **/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean[] numberExists = new boolean[nums.length + 1];
        for (int index : nums){
            numberExists[index] = true;
        }
        for (int index = 0; index < numberExists.length ; index++){
            if (!numberExists[index]){
                return index;
            }
        }
        return 0;
    }

    // 可以使用位运算,也可以用高斯公式求和再相减

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{3,1,2,0,5}));
    }
}
