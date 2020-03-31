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

    public int bitCount(int n){
        return Integer.bitCount(n);
        // 原生的汉明重量算法,源码为
        //        i = i - ((i >>> 1) & 0x55555555);                 ……1
        //        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);  ……2
        //        i = (i + (i >>> 4)) & 0x0f0f0f0f;                 ……3
        //        i = i + (i >>> 8);                                ……4
        //        i = i + (i >>> 16);                               ……5
        //        return i & 0x3f;                                  ……6
        // 源码的方法其实并不算难,关键在于第一步的理解,0x 为16进制的表达式
        // 在 16 进制中,将 4 位的运算符通过一个数字进行表示
        // 所以 16 进制的 5 对应的二进制码为 0101
        // 将 i 又移一位并进行与运算,可以将移位前该位置的 1 的状态表示出来
        // 再与原值进行相减,可以将数值进行映射
        // 经过该运算后 11 会被映射成 10 表示 2,即有 2 个位均为 1
        // 10 与 01 均会被映射成 01,表示 1,即 1 位的个数为 1
        // 00 则被映射成00
        // 现在 i 已经变成了可以表示整数位数的形式,这其实是一个扩位的映射
        // 原来的 32 位是互相分散的位,现在将位整理成 2 个一组的形式,每一组的值代表该组位 1 的个数
        // 第二步,则是继续合并,将 2 个一组的形式合并成 4 个一组
        // 通过移位两格并相加,得出 4 位中位 1 的数量
        // 原值被表示成 0100 0010 0001 的样子
        // 同样 移位 4 格 与 8 格,16 格
        // 每进行一次移动,则表示位数的有效值的最大值是翻倍的
        // 在只用 1 位表达 1 位的有效值时,需要 1 个位值
        // 2 位时,需要 2 个
        // 4 位时,需要 3 个,8 位 4 个,32 位只需要 6 位
        // 所以最后的计算,只需要映射出最后的 6 位即可
    }

    public static void main(String[] args) {
        OneBitCount oneBitCount = new OneBitCount();
        System.out.println(oneBitCount.hammingWeight(11));
    }
}
