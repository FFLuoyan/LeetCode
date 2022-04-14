package org.zongjieli.leetcode.question.daily.year2022.month4.week2;

/**
 * 给定一个数组 nums,请完成两类查询
 *
 *  其中一类查询要求更新数组 nums 下标对应的值
 *  另一类查询要求返回数组 nums 中索引 left 和索引 right 之间(包含)的 nums 元素的和,其中 left <= right
 *
 * 实现 Z1AreaSearch 类:
 *
 *  Z1AreaSearch(int[] nums)
 *      用整数数组 nums 初始化对象
 *  void update(int index, int val)
 *      将 nums[index] 的值更新为 val
 *  int sumRange(int left, int right)
 *      返回数组 nums 中索引 left 和索引 right 之间(包含)的 nums 元素的和 
 *      即 nums[left] + nums[left + 1], ..., nums[right]
 *
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * 调用 update 和 sumRange 方法次数不大于 3 * 10^4 
 *
 * @author   Li.zongjie
 * @date     2022/4/13
 * @version  1.0
 */
public class Z1AreaSearch {

    private int[][] values;

    public Z1AreaSearch(int[] nums) {
        int length = nums.length;
        int size = 1;
        while (length > 1) {
            length = (length + 1) / 2;
            size++;
        }
        values = new int[size][];
        values[0] = nums;
        int[] current;
        for (int i = 1 ; i < size ; i++) {
            current = values[i] = new int[((length = nums.length) + 1) / 2];
            for (int j = 0 ; j < length ; j++) {
                current[j / 2] += nums[j];
            }
            nums = current;
        }
    }

    public void update(int index, int val) {
        int add = val - values[0][index];
        for (int[] value : values) {
            value[index] += add;
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        return leftValue(right) - leftValue(left - 1);
    }

    public int leftValue(int n) {
        int size = n + 1, bit = 0;
        while (size > 0) {
            bit++;
            size >>= 1;
        }
        int result = 0, bv = 1 << (bit - 1);
        size = n + 1;
        while (--bit >= 0) {
            if ((size & bv) > 0) {
                result += values[bit][(size >> bit) - 1];
            }
            bv >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Z1AreaSearch test = new Z1AreaSearch(new int[]{-1});
        // -1
        System.out.println(test.sumRange(0, 0));
        test.update(0, 1);
        // 1
        System.out.println(test.sumRange(0, 0));
    }
}
