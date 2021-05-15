package org.zongjieli.leetcode.competion.doubleweekly.order52;
/**
 * 给定两个整数 memory1 和 memory2
 * 分别表示两个内存条剩余可用内存的位数
 * 现在有一个程序每秒递增的速度消耗着内存
 *
 * 在第 i 秒(秒数从 1 开始)
 * 有 i 位内存被分配到剩余内存较多的内存条
 * 如果两者一样多,则分配到第一个内存条
 * 如果两者剩余内存都不足 i 位
 * 那么程序将意外退出
 *
 * 请返回一个数组
 * 包含 [crashTime, memory1crash, memory2crash]
 * 其中 crashTime 是程序意外退出的时间(单位为秒)
 * memory1crash 和 memory2crash 分别是两个内存条最后剩余内存的位数
 *
 * 0 <= memory1, memory2 <= 2^31 - 1
 *
 * @author   Zongjie.Li
 * @date     2021/5/15
 * @version  1.0
 */
public class OutOfMemory {
    public int[] memLeak(int memory1, int memory2) {
        int[] result = new int[3];
        for (int i = 1 ; i < Integer.MAX_VALUE ; i++){
            if (memory2 > memory1){
                if (memory2 < i){
                    result[0] = i;
                    break;
                } else {
                    memory2 -= i;
                }
            } else if (memory1 < i){
                result[0] = i;
                break;
            } else {
                memory1 -= i;
            }
        }
        result[1] = memory1;
        result[2] = memory2;
        return result;
    }
}
