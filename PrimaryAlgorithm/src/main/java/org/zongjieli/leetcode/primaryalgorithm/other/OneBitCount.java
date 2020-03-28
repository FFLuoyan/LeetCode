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
        int match = 1;
        int count = 0;
        for (int time = 0;time <32;time++){
            if ((n&match) == match){
                count ++;
            }
            match <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        OneBitCount oneBitCount = new OneBitCount();
        System.out.println(oneBitCount.hammingWeight(11));
    }
}
