package org.zongjieli.leetcode.competion.singleweekly.order181;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName: FourFactorNumber
 * @Description: 返回给定的数组中恰有四个因数的这些整数的因数和
 * 四因数: 因式分解以后恰好有4个因数
 * @Author: Zongjie.Li
 * @Date: 2020/3/22
 * @Version: 1.0
 **/
public class FourFactorNumber {
    public int sumFourDivisors(int[] nums) {
        int[] numberTable = new int[100001];
        int[] primeNumbers = new int[50000];
        int primeNumberLength = 2;
        primeNumbers[0] = 2;
        primeNumbers[1] = 3;
        for (int primeNumber = 4; primeNumber < 50000; primeNumber++) {
            int calculateIndex = 0;
            for (; calculateIndex < primeNumberLength; calculateIndex++) {
                if (primeNumber % primeNumbers[calculateIndex] == 0) {
                    break;
                }
            }
            if (calculateIndex == primeNumberLength) {
                primeNumbers[primeNumberLength++] = primeNumber;
            }
        }
//        System.out.println(Arrays.toString(primeNumbers));
        for (int i = 0; i < primeNumberLength; i++) {
            int secondLength = 100000 / primeNumbers[i];
            for (int j = i + 1; j < secondLength; j++) {
                int index = primeNumbers[i] * primeNumbers[j];
                if (index < 100001) {
                    numberTable[index] = index + primeNumbers[i] + primeNumbers[j] + 1;
                }
            }
        }
        for (int i = 0 ; primeNumbers[i] < 47 ; i++ ){
            int count = primeNumbers[i] * primeNumbers[i];
            int index = primeNumbers[i] * count;
            numberTable[index] = 1 + primeNumbers[i] + count + index;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += numberTable[nums[i]];
        }
//        System.out.println(Arrays.toString(numberTable));
        return count;
    }

    public static void main(String[] args) {
        FourFactorNumber fourFactorNumber = new FourFactorNumber();
        System.out.println(fourFactorNumber.sumFourDivisors(new int[]{21, 4, 7}));
    }
}
