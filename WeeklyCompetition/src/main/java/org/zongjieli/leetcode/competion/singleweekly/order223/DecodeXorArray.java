package org.zongjieli.leetcode.competion.singleweekly.order223;
/**
 * 解码异或后的数组
 * 未知整数数组 arr 由 n 个非负整数组成
 * 经编码后变成另一个整数数组 encoded
 * 其中 encoded[i] = arr[i] ^ arr[i+1]
 * 给定编码后的数组 encoded,及原数组的第一个元素 first(arr[0])
 * 请解码返回原数组 arr
 *
 * @author   Zongjie.Li
 * @date     2021/1/10
 * @version  1.0
 */
public class DecodeXorArray {

    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 0 ; i < encoded.length ; i++){
            arr[i + 1] = arr[i] ^ encoded[i];
        }
        return arr;
    }
}
