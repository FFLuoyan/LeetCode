package org.zongjieli.leetcode.algorithm.primary.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TwoSum
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/26
 * @Version: 1.0
 **/
public class TwoSum {
    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> numberMap = new HashMap<>(nums.length);
        for (int index = 0 ; index < nums.length ; index ++) {
            Integer otherIndex = numberMap.get(target - nums[index]);
            if (otherIndex == null){
                numberMap.put(nums[index],index);
            } else {
                return new int[]{otherIndex,index};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4},6)));
    }
}
