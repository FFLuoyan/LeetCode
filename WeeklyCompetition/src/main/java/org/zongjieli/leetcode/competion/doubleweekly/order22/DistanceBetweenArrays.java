package org.zongjieli.leetcode.competion.doubleweekly.order22;

/**
 * @ClassName: DistanceBetweenArrays
 * @Description: 给定两个数组和一个整数d,计算两个数组的距离值
 *              距离值: 对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 的元素数目
 * @Author: Zongjie.Li
 * @Date: 2020/3/21
 * @Version: 1.0
 **/
public class DistanceBetweenArrays {

    public static void main(String[] args) {
        System.out.println(new DistanceBetweenArrays().findTheDistanceValue(new int[]{4,5,8},new int[]{10,9,1,8},2));
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int arr1Index = 0; arr1Index < arr1.length;arr1Index++){
            int arr2Index = 0;
            for ( ; arr2Index < arr2.length;arr2Index ++){
                if (arr1[arr1Index] >= arr2[arr2Index] - d && arr1[arr1Index] <= arr2[arr2Index] + d){
                    break;
                }
            }
            if (arr2Index == arr2.length){
                count ++;
            }
        }
        return count;
    }
}
