package org.zongjieli.leetcode.question.daily.year2021.month4.week5;

import java.util.TreeMap;

/**
 * 一个整数数组 nums,除某个元素仅出现一次外,其余每个元素都恰出现三次
 * 请找出并返回那个只出现了一次的元素
 *
 * 1 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * @author   Zongjie.Li
 * @date     2021/4/30
 * @version  1.0
 */
public class OnceDisappear {
    public int singleNumberByMap(int[] nums) {
        TreeMap<Integer,Boolean> count = new TreeMap<>();
        for (int num : nums) {
            Boolean canDelete = count.get(num);
            if (canDelete == null){
                count.put(num,Boolean.FALSE);
            } else if (canDelete){
                count.remove(num);
            } else {
                count.put(num,Boolean.TRUE);
            }
        }
        return count.firstKey();
    }

    public int singleNumberByByteCount(int[] nums) {
        int[] sum = new int[32];
        for (int num : nums) {
            int index = 31;
            while (num != 0){
                sum[index--] += num % 2;
                num >>>= 1;
            }
        }
        int count = 0;
        for (int i : sum) {
            count <<= 1;
            i %= 3;
            count += i;
        }
        return count;
    }

    public static void main(String[] args) {
        OnceDisappear test = new OnceDisappear();
        System.out.println(test.singleNumberByByteCount(new int[]{2,2,23,2}));
        System.out.println(test.singleNumberByByteCount(new int[]{-2,-2,1,1,4,1,4,4,-4,-2}));

    }
}
