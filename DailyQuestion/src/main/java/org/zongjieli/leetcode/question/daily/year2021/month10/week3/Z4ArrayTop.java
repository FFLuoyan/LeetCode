package org.zongjieli.leetcode.question.daily.year2021.month10.week3;
/**
 * 符合下列属性的数组 arr 称为 山峰数组(山脉数组)
 *  1. arr.length >= 3
 *  2. 存在 i (0 < i < arr.length - 1) 使得:
 *      arr[0] < arr[1] < ... arr[i-1] < arr[i]
 *      arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 * 给定由整数组成的山峰数组 arr
 * 返回任何满足
 *  arr[0] < arr[1] < ... arr[i - 1] < arr[i]
 *  arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i
 * 即山峰顶部
 *
 * @author   Li.zongjie
 * @date     2021/10/14
 * @version  1.0
 */
public class Z4ArrayTop {
    public int peakIndexInMountainArray(int[] arr) {
        int index = 0;
        for (int i = 1 ; i < arr.length ; i++){
            if (arr[i] < arr[index]){
                break;
            }
            index = i;
        }
        return index;
    }

    public static void main(String[] args) {
        Z4ArrayTop test = new Z4ArrayTop();
        System.out.println(test.peakIndexInMountainArray(new int[]{0,2,1,0}));
    }
}
