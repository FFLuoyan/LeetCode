package org.zongjieli.leetcode.question.daily.year2021.month4.week3;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums
 * 重新排列每个数的顺序,每个数不可拆分
 * 使之组成一个最大的整数
 *
 * 输出结果可能非常大,所以需要返回一个字符串而不是整数
 *
 * @author   Zongjie.Li
 * @date     2021/4/12
 * @version  1.0
 */
public class MaxNumber {
    public String largestNumber(int[] nums) {
        int[][] compare = new int[nums.length][];
        int compareIndex = 0;
        while (compareIndex < nums.length){
            compare[compareIndex] = numToArray(nums[compareIndex]);

            int compareArrayIndex = compareIndex - 1;
            while (compareArrayIndex >= 0 && isBigger(compare[compareArrayIndex + 1],compare[compareArrayIndex])){
                int[] temp = compare[compareArrayIndex + 1];
                compare[compareArrayIndex + 1] = compare[compareArrayIndex];
                compare[compareArrayIndex] = temp;
                compareArrayIndex --;
            }

            compareIndex ++;
        }

        if (compare[0][0] == 0){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] ints : compare) {
            for (int anInt : ints) {
                stringBuilder.append(anInt);
            }
        }

        return stringBuilder.toString();
    }

    public int[] numToArray(int num){
        if (num == 0){
            return new int[]{0};
        }
        int bit = num;
        int bitCount = 0;
        while (bit > 0){
            bit = bit / 10;
            bitCount ++;
        }
        int[] numArray = new int[bitCount];
        while (num > 0){
            numArray[--bitCount] = num % 10;
            num /= 10;
        }
        return numArray;
    }

    private boolean isBigger(int[] first, int[] second){
        int firstIndex = 0;
        int secondIndex = 0;
        while (first[firstIndex] == second[secondIndex]){
            firstIndex++;
            secondIndex++;
            if (firstIndex == first.length){
                if (secondIndex == second.length){
                    return false;
                }
                firstIndex -= first.length;
                continue;
            }
            secondIndex %= second.length;
        }
        return first[firstIndex] > second[secondIndex];
    }

    public static void main(String[] args) {
        MaxNumber number = new MaxNumber();
        System.out.println(Arrays.toString(number.numToArray(10)));
        System.out.println(number.largestNumber(new int[]{1,54651,30,321,54}));;
    }
}
