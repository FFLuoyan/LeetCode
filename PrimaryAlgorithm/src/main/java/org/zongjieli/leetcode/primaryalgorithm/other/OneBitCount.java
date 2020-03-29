package org.zongjieli.leetcode.primaryalgorithm.other;

/**
 * @ClassName: OneBitCount
 * @Description: 根据输入的数字,返回二进制中位数为 1 的个数
 * @Author: Zongjie.Li
 * @Date: 2020/3/28
 * @Version: 1.0
 **/
public class OneBitCount {
    public int hammingWeight(int n) {
        int count = n & 1;
        while (n != 0){
            count += ((n >>>= 1) & 1);
        }
        return count;
    }

    public int hammingWeightDecrease(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        OneBitCount oneBitCount = new OneBitCount();
        System.out.println(oneBitCount.hammingWeight(11));
    }
}
