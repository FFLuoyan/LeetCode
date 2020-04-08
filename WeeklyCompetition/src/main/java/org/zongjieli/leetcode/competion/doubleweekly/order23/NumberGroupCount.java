package org.zongjieli.leetcode.competion.doubleweekly.order23;

import java.util.Arrays;

/**
 * @ClassName: NumberGroupCount
 * @Description: 给定整数n,求出 1 到 n 的每个整数 10 进制表示下的数位和
 *               将数位和相等的数字放在同一个组中
 *               返回数字数目并列最多的组的数目
 * @Author: Zongjie.Li
 * @Date: 2020/4/4
 * @Version: 1.0
 **/
public class NumberGroupCount {
    public int countLargestGroup(int n) {
//        if (n < 10){
//            return n;
//        }
//        int[] numberCount = new int[37];
//
//        if (n < 100){
//            int row = (n / 10) + 1;
//            // row 代表数字可以堆叠的高度
//            // 如果 row > 10,则相同数位和的高度肯定有 2
//            int column = (n % 10) + 1;
//            // column 代表相同的个数,上一层相同的个数会得到继承
//            // 如果 column 为 10,则该层遍历完
//            int thisMax = 11 - row;
//            // 本层的最大可能值
//            return column < thisMax ? column : thisMax;
//        }
////        if (n < 1000){
////            int first = n / 100 + 1;
////
////        }




        int[] numberMap = new int[37];
        for (int i = 1 ; i <= n;i++){
            int temp = i;
            int firstValue = temp / 1000;
            temp = temp % 1000;
            int secondValue = temp / 100;
            temp = temp%100;
            int thirdValue = temp /10;
            int fourthValue = temp % 10;
            int number = firstValue + secondValue + thirdValue + fourthValue;
            numberMap[number]++;
        }
        System.out.println(Arrays.toString(numberMap));
        int max = 0;
        int size = 0;
        for (int number = 1;number < numberMap.length ; number++){
            if (numberMap[number] > max){
                max = numberMap[number];
                size = 1;
            } else if (numberMap[number] == max){
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {

        NumberGroupCount numberGroupCount = new NumberGroupCount();
        System.out.println(numberGroupCount.countLargestGroup(1000));
    }
}
