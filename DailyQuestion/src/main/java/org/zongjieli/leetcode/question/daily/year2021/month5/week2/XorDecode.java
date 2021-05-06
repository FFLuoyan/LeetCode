package org.zongjieli.leetcode.question.daily.year2021.month5.week2;
/**
 * 未知整数数组 arr 由 n 个非负整数组成
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded
 * 其中 encoded[i] = arr[i] XOR arr[i + 1]
 *
 * 例如,arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3]
 *
 * 给定编码后的数组 encoded 和原数组 arr 的第一个元素 first(arr[0])
 * 请解码返回原数组 arr,可以证明答案存在并且是唯一的
 *
 * XOR: 异或
 *
 * 2 <= n <= 10^4
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 10^5
 * 0 <= first <= 10^5
 *
 * @author   Zongjie.Li
 * @date     2021/5/6
 * @version  1.0
 */
public class XorDecode {
    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 1 ; i < result.length ; i++){
            result[i] = encoded[i - 1] ^ result[i - 1];
        }
        return result;
    }
}
