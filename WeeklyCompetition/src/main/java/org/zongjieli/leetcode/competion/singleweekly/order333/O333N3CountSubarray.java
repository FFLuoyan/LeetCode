package org.zongjieli.leetcode.competion.singleweekly.order333;

/**
 * 给定一个正整数数组 nums
 * 如果数组 nums 的子集中的元素乘积是一个无平方因子数,则认为该子集是一个无平方子集
 * 无平方因子数是无法被除 1 之外任何平方数整除的数字
 * 返回数组 nums 中无平方且非空的子集数目
 * 因为答案可能很大,返回对 10^9 + 7 取余的结果
 * nums 的非空子集是可以由删除 nums 中一些元素(可以不删除,但不能全部删除)得到的一个数组
 * 如果构成两个子集时选择删除的下标不同,则认为这两个子集不同
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 30
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/19
 */
public class O333N3CountSubarray {

    int[][] factors = new int[][]{{}
            , {1}
            , {2}
            , {4}
            , {}
            , {16}
            , {6}
            , {64}
            , {}
            , {}
            , {18}
            , {1024}
            , {}
            , {4096}
            , {66}
            , {20}
            , {}
            , {65536}
            , {}
            , {262144}
            , {}
            , {68}
            , {1026}
            , {4194304}
            , {}
            , {}
            , {4098}
            , {}
            , {}
            , {268435456}
            , {22}};

    public int squareFreeSubsets(int[] nums) {
        int[] valueCount = new int[31];
        for (int num : nums) {
            valueCount[num]++;
        }
        int result = getCount(2, 0, 0, valueCount);
        if (valueCount[1] == 0) {
            return result;
        }
        long oc = 1L;
        while (valueCount[1] > 30) {
            oc = (oc << 30) % 1000000007;
            valueCount[1] -= 30;
        }
        oc = (oc << valueCount[1]) % 1000000007;
        return (int) ((result == 0 ? oc - 1 : oc * (result + 1) - 1) % 1000000007);
    }

    private int getCount(int index, int exist, int current, int[] count) {
        if (index == 31) {
            return current;
        }
        if (count[index] == 0 || factors[index].length == 0) {
            return getCount(index + 1, exist, current, count);
        }
        long result = 0;
        // 不要
        result += getCount(index + 1, exist, current, count);
        // 要
        if ((exist & factors[index][0]) == 0) {
            result += getCount(index + 1, exist | factors[index][0], current == 0 ? count[index] : (int) (((long) current) * count[index] % 1000000007), count);
        }
        return (int) (result % 1000000007);
    }

    public static void main(String[] args) {
        O333N3CountSubarray test = new O333N3CountSubarray();
        // 3
        System.out.println(test.squareFreeSubsets(new int[]{3, 4, 4, 5}));
        // 15
        System.out.println(test.squareFreeSubsets(new int[]{11, 2, 19, 7, 9, 27}));
        // 3
        System.out.println(test.squareFreeSubsets(new int[]{26, 6, 6}));
        // 243589229
        System.out.println(test.squareFreeSubsets(new int[]{15,5,7,10,21,11,21,8,20,27,4,13,22,29,24,24,8,1,27,29,30,29,27,19,18,29,25,8,23,9,13,18,11,15,21,1,9,27,17,14,25,16,22,9,30,20,24,5,15,13,29,21,12,4,27,20,3,16,26,30,20,26,13,27,26,9,21,19,14,14,3,3,11,15,13,17,19,11,15,17,8,16,26,27,5,20,27,25,21,25,5,4,22,9,11,11,5,2,28,5,9,28,21,19,10,22,16,23,23,28,15,1,28,19,29,12,8,5,17,6,16,15,11,6,9,16,21,18,2,3,26,13,16,1,29,19,30,16,28,2,27,7,13,4,27,8,26,7,23,16,16,5,24,26,24,23,6,6,30,6,24,20,17,24,13,2,5,3,17,21,23,28,14,6,15,4,10,29,16,28,24,12,22,4,5,14,20,13,4,20,23,10,4,13,20,27,20,5,15,5,28,5,15,8,5,19,19,19,8,24,19,7,23,22,23,6,15,18,28,17,9,14,10,24,30,15,3,27,22,23,16,26,24,13,6,5,16,17,14,15,24,24,22,8,3,14,30,11,6,29,19,3,28,25,26,18,23,13,4,29,9,20,5,5,26,19,23,11,12,19,20,8,18,19,20,13,13,18,29,20,11,18,6,26,8,30,17,29,17,10,13,1,28,6,7,21,16,3,22,16,15,30,27,17,24,4,6,25,1,2,4,4,26,9,4,11,18,22,5,26,14,27,25,17,23,9,15,6,22,20,10,28,29,4,26,21,22,15,24,22,10,16,30,27,20,15,20,30,1,25,1,4,1,26,25,21,14,15,20,16,7,15,10,10,19,4,13,1,19,6,12,28,30,2,22,23,18,3,7,17,15,24,24,25,7,20,6,23,1,27,27,23,28,19,21,10,4,24,11,10,3,28,14,1,11,23,15,3,22,7,25,16,6,26,16,11,1,3,14,14,8,8,30,27,1,22,26,23,17,29,21,11,25,5,16,20,14,30,11,6,9,5,7,21,24,4,15,19,17,21,6,15,1,28,26,26,10,9,8,2,27,22,14,30,13,11,6,20,17,15,2,20,7,15,24,18,28,7,11,28,21,26,4,5,30,5,17,30,12,24,10,3,5,19,12,15,26,20,28,1,5,23,21,27,7,16,14,12,3,13,20,2,3,14,16,7,17,10,26,18,25,18,8,15,19,19,5,1,10,15,7,8,15,12,5,22,10,29,14,3,25,24,16,3,14,5,28,18,10,18,7,12,14,3,6,7,22,6,5,5,11,4,1,6,29,13,20,14,5,28,27,3,27,25,12,22,18,13,25,9,14,6,26,20,24,2,23,1,13,19,12,27,18,11,12,18,15,26,21,20,15,28,4,2,12,25,15,6,26,15,12,22,11,10,1,6,9,2,21,24,21,3,6,1,16,26,4,11,23,1,15,15,5,3,2,5,13,7,9,13,4,16,6,27,14,21,10,25,10,17,28,1,10,19,8,1,29,21,4,21,7,11,17,16,9,10,15,29,9,30,11,23,4,20,9,22,12,23,10,30,9,11,6,1,23,21,28,9,8,25,14,10,11,6,30,3,7,19,18,25,22,3,23,24,30,24,12,23,26,15,11,4,6,12,29,15,30,8,17,21,2,15,28,14,27,23,12,12,10,21,11,15,27,18,23,2,2,26,6,24,20,2,26,4,5,5,1,23,29,12,30,20,13,11,27,13,8,13,17,12,6,1,13,3,24,27,21,28,30,24,20,1,8,2,3,8,4,28,16,13,25,26,9,14,1,17,5,11,9,11,10,10,11,4,6,10,20,15,10,27,19,3,10,7,13,24,26,21,23,29,18,23,28,28,27,2,14,19,15,3,21,6,22,7,4,2,11,17,3,22,1,14,17,8,25,24,2,16,28,10,12,18,24,11,21,19,13,29,28,6,19,2,20,1,28,4,8,20,24,12,20,27,16,5,17,25,8,1,4,21,8,22,16,24,9,24,8,27,7,27,7,3,9,7,13,27,22,2,3,23,7,26,11,28,28,26,3,7,13,23,29,15,24,18,6,12,26,30,28,21,30,29,16,11,26,13,12,29,27,2,20,24,11,15,19,2,29,5,20,24,15,9,12,1,29,1,24,16,23,17,5,28,23,21,6,10,17,24,15,23,3,30,27,18,18,15,27,18,22,7,14,29,10,15,25,8,20,26,6,14,2,7,24,1,13,4,23,7,18,20,28,29,13,30,27,2,7,11,14,13,22,9,21,6,21,6,22,30,23,22}));
    }

}