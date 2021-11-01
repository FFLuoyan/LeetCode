package org.zongjieli.leetcode.question.daily.year2021.month11.week1;
/**
 * 给定一个偶数长度的数组
 * 其中不同的数字代表着不同种类的糖果
 * 每一个数字代表一个糖果
 * 需要把这些糖果平均分给一个弟弟和一个妹妹
 * 返回妹妹可以获得的最大糖果的种类数
 *
 * 数组的长度为[2, 10,000]，并且确定为偶数。
 * 数组中数字的大小在范围[-100,000, 100,000]内
 *
 * @author   Li.zongjie
 * @date     2021/11/1
 * @version  1.0
 */
public class Z1DistributeCandies {
    public int distributeCandies(int[] candyType) {
        int[] record = new int[8192];
        int half = candyType.length >> 1;
        int count = 0;
        int index;
        int v;
        for (int i : candyType) {
            i += 100000;
            index = i >> 5;
            v = 1 << (i & 31);
            if ((record[index] & v) == 0){
                record[index] |= v;
                count++;
                if (count == half){
                    return half;
                }
            }
        }
        return count;
    }
}
