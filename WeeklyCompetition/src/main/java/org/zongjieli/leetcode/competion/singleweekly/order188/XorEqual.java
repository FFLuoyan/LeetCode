package org.zongjieli.leetcode.competion.singleweekly.order188;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: XorEqual
 * @Description: 给定一个整数数组, 从数组中取三个下标 i,j,k 其中 0 <= i < j <= k < arr.length
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 返回令 a = b 成立的三元组(i,j,k)的数目
 * @Author: Zongjie.Li
 * @Date: 2020/5/10
 * @Version: 1.0
 **/
public class XorEqual {
    public int countTriplets(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0;

        for (int middleIndex = 0;middleIndex < arr.length - 1 ; middleIndex++){
            int a = arr[middleIndex];
            Map<Integer,Integer> beforeValueNumber = new HashMap<>();
            beforeValueNumber.put(a,1);
            for(int i = middleIndex - 1 ; i >= 0 ; i--){
                a ^= arr[i];
                Integer numberCount = beforeValueNumber.get(a);
                if (numberCount == null){
                    beforeValueNumber.put(a,1);
                }else {
                    beforeValueNumber.put(a,numberCount + 1);
                }
            }
            int b = 0;
            for (int i = middleIndex + 1;i< arr.length ; i++){
                b ^= arr[i];
                Integer numberCount = beforeValueNumber.get(b);
                if (numberCount != null){
                    count += numberCount;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        XorEqual xorEqual = new XorEqual();
        System.out.println(xorEqual.countTriplets(new int[]{2,3,1,6,7}));
    }
}
