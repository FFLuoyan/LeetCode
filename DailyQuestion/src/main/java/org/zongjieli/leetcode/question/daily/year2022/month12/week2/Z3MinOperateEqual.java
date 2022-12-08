package org.zongjieli.leetcode.question.daily.year2022.month12.week2;

/**
 * 给定两个长度可能不等的整数数组 nums1 和 nums2
 * 两个数组中的所有值都在 1 到 6 之间(包含 1 和 6)
 * 每次操作中,可以选择任意数组中的任意一个整数,将它变成 1 到 6 之间任意的值(包含 1 和 6)
 * 请返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数
 * 如果无法使两个数组的和相等,请返回 -1
 *
 * 1 <= nums1.length, nums2.length <= 10^5
 * 1 <= nums1[i], nums2[i] <= 6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/7
 */
public class Z3MinOperateEqual {

    public int minOperations(int[] nums1, int[] nums2) {
        int[] bigger = new int[7], small = new int[7];
        for (int i : nums1) {
            bigger[i]++;
        }
        for (int i : nums2) {
            small[i]++;
        }
        int bs = 0, ss = 0;
        for (int i = 0; i < bigger.length; i++) {
            bs += i * bigger[i];
        }
        for (int i = 0; i < small.length; i++) {
            ss += i * small[i];
        }
        if (bs == ss) {
            return 0;
        }

        if (bs < ss) {
            int temp = bs;
            bs = ss;
            ss = temp;
            int[] ta = bigger;
            bigger = small;
            small = ta;
        }

        int value = bs - ss;
        int count = 0;
        for (int i = 5; i >= 1; i--) {
            int cn = (bigger[i + 1] + small[6 - i]);
            count += cn;
            value -= i * cn;
            if (value == 0) {
                return count;
            } else if (value < 0) {
                return count + (value) / i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Z3MinOperateEqual test = new Z3MinOperateEqual();
        // 3
        System.out.println(test.minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}));
        // 1
        System.out.println(test.minOperations(new int[]{5,2,1,5,2,2,2,2,4,3,3,5}, new int[]{1,4,5,5,6,3,1,3,3}));
    }

}
