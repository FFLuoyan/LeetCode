package org.zongjieli.leetcode.question.daily.year2021.month4.week3;

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

        int index = 1;
        while (index < nums.length){
            int compareIndex = index - 1;
            while (compareIndex >= 0 && isBigger(nums[compareIndex + 1],nums[compareIndex])){
                int temp = nums[compareIndex];
                nums[compareIndex] = nums[compareIndex + 1];
                nums[compareIndex + 1] = temp;
                compareIndex --;
            }
            index ++;
        }

        if (nums[0] == 0){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }

        return stringBuilder.toString();
    }

    private boolean isBigger(int first, int second){
        if (first == 0){
            return false;
        }
        if (second == 0){
            return true;
        }
        long firstBit = 10,secondBit = 10,firstCompare = first,secondCompare = second;
        while ((firstCompare /= 10) > 0){
            firstBit *= 10;
        }
        while ((secondCompare /= 10) > 0){
            secondBit *= 10;
        }
        return first * secondBit + second - second * firstBit - first > 0;
    }

    public String largestNumberFast(int[] nums) {
        int[][] compare = new int[nums.length][];
        int compareIndex = 0;
        while (compareIndex < nums.length){
            compare[compareIndex] = numToArray(nums[compareIndex]);

            int compareArrayIndex = compareIndex - 1;
            while (compareArrayIndex >= 0 && isBiggerFast(compare[compareArrayIndex + 1],compare[compareArrayIndex])){
                int[] temp = compare[compareArrayIndex + 1];
                int numTemp = nums[compareArrayIndex + 1];
                nums[compareArrayIndex + 1] = nums[compareArrayIndex];
                compare[compareArrayIndex + 1] = compare[compareArrayIndex];
                nums[compareArrayIndex] = numTemp;
                compare[compareArrayIndex] = temp;
                compareArrayIndex --;
            }

            compareIndex ++;
        }

        if (nums[0] == 0){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
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

    private boolean isBiggerFast(int[] first, int[] second){
        int index = -1;
        while (++index < first.length + second.length){
            int firstCompare = index < first.length ? first[index] : second[index - first.length];
            int secondCompare = index < second.length ? second[index] : first[index - second.length];
            if (firstCompare == secondCompare){
                continue;
            }
            return firstCompare > secondCompare;
        }
        return false;
    }


    public static void main(String[] args) {
        MaxNumber number = new MaxNumber();
        System.out.println(number.largestNumber(new int[]{1,54651,30,321,54}));;
    }
}
