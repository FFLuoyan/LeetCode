package org.zongjieli.leetcode.competion.doubleweekly.order23;

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
        System.out.println(numberGroupCount.countLargestGroup(13));
    }
}
