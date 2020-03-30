package org.zongjieli.leetcode.primaryalgorithm.other;

/**
 * @ClassName: HammingDistance
 * @Description: 计算两个数的汉明距离
 *               汉明距离: 两个相同长度的字对应的二进制中位不同的数量
 *               汉明重量: 对于一个字的二进制中,位为 1 的数量
 * @Author: Zongjie.Li
 * @Date: 2020/3/30
 * @Version: 1.0
 **/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n != 0){
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
