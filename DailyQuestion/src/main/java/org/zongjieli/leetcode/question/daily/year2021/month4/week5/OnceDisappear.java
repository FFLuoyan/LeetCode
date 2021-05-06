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
     *
     * IMP:
     * 如果将值注入 b 的同时删除 a 的值
     * 即 00 -> 10 -> 01 -> 00 构成的循环则可以更简便,同时更合理
     * 在进行运算处理的时候,一般情况下,有 a,b -> a 和 a,b -> b 两种映射
     * 两种映射均基于 a,b 的当前值
     * 改变某一个数的值的时候,另一个数的映射方式会有所改变
     * 从而可以产生更简便的运算函数
     */
    public int singleNumberByByteCount(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            a = ~b & (a ^ num);
            b = ~a & (b ^ num);
        }
        return a;
    }

    public static void main(String[] args) {
        OnceDisappear test = new OnceDisappear();
        System.out.println(test.singleNumberByByteCount(new int[]{2,2,23,2}));
        System.out.println(test.singleNumberByByteCount(new int[]{-2,-2,1,1,4,1,4,4,-4,-2}));

    }
}
