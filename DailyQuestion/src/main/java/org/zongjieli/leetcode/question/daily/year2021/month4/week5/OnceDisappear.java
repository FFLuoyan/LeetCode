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

    /**
     * 位计数法的原理在于
     * 每一个整数都由 32 位的比特构成
     * 而要在目标数组中找出目标数字则意味着
     * 所有出现 3 次的数字,在某一个比特位上则出现了 3 次
     * 统计每一个比特位上数字出现的总次数
     * 除以 3 的余数就是目标数字在当前比特位的值
     * 就可以得到目标数字
     *
     * 我们用两个数 a,b 统计目标位的比特值
     * 遍历数组中的所有比特值并放入 a,b 中
     * 首先将值放入 a 中
     * 如果 a 中比特位已经有值,则放入 b 中
     * 如果 b 的比特位也有值,说明该位的值已经出现了三次
     * 将 a,b 中该位的值删除
     */
    public int singleNumberByByteCount(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            // num 中的 0 位均为无效位,无需考虑
            // 有效位可分为几个部分
            // a 中没有的
            //   放入 a 中
            // a 中有的,b 中没有的
            //   放入 b 中
            // a 中有的,b 中也有的
            //   从 a,b 中删除
            int aDiff = num ^ a;
            int aZero = aDiff & num;
            a += aZero;
            num -= aZero;
            int bDiff = num ^ b;
            int bZero = bDiff & num;
            b += bZero;
            num -= bZero;
            a -= num;
            b -= num;
        }
        return a;
    }

    public static void main(String[] args) {
        OnceDisappear test = new OnceDisappear();
        System.out.println(test.singleNumberByByteCount(new int[]{2,2,23,2}));
        System.out.println(test.singleNumberByByteCount(new int[]{-2,-2,1,1,4,1,4,4,-4,-2}));

    }
}
