package org.zongjieli.leetcode.algorithm.primary.array;

/**
 * @ClassName: DeleteRepeat
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/15
 * @Version: 1.0
 **/
public class DeleteRepeat {

    public static int deleteRepeat(int[] nums) {
        nums = new int[10];
        for (int i = 0 ; i < nums.length ; i++) {
            nums[i] = i / 3;
        }

        int index = 0;
        if (nums.length > 0){
            for (int i = 0 ; i < nums.length - 1; i++){
                if (nums[i] != nums[i+1]){
                    nums[++index] = nums[i+1];
                }
            }
        }
        for (int i = 0 ; i < nums.length ; i++) {
            System.out.println(nums[i]);
        }
        return index + 1;
    }
    public static void main(String[] args) {
        deleteRepeat(null);
    }
}
