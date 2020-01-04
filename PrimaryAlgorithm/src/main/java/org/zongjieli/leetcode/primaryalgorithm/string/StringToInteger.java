package org.zongjieli.leetcode.primaryalgorithm.string;

/**
 * @ClassName: StringToInteger
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/4
 * @Version: 1.0
 **/
public class StringToInteger {
    public static int myAtoi(String str) {
        char[] strCharArr = str.toCharArray();
        long numberResolve = 1L;
        int resolveIndex = 0;
        for (int getIndex = 0; getIndex < strCharArr.length; getIndex++) {
            if (strCharArr[getIndex] != ' ') {
                // if the character isn't blank,check positive or negative
                if (strCharArr[getIndex] == '+') {
                    resolveIndex = resolveNumber(strCharArr, getIndex + 1);
                } else if (strCharArr[getIndex] == '-') {
                    numberResolve = -1;
                    resolveIndex = resolveNumber(strCharArr, getIndex + 1);
                } else if (strCharArr[getIndex] >= '0' && strCharArr[getIndex] <= '9') {
                    resolveIndex = resolveNumber(strCharArr, getIndex);
                } else {
                    //  can't resolve
                    return 0;
                }
                //  once a char not blank is found,the number resolve start
                //  and the loop is over
                break;
            }
        }
        if (resolveIndex == 0) {
            return 0;
        }
        if (resolveIndex > 10) {
            return numberResolve > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        numberResolve = numberResolve * Long.valueOf(String.valueOf(strCharArr, 0, resolveIndex));
        return numberResolve > Integer.MAX_VALUE ? Integer.MAX_VALUE : numberResolve < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) numberResolve;
    }

    public static int resolveNumber(char[] charArr, int startIndex) {
        //  resolve number in char array;

        // trim zero
        while (startIndex < charArr.length && charArr[startIndex] == '0') {
            startIndex++;
        }
        int setIndex = 0;
        while (startIndex < charArr.length) {
            if (charArr[startIndex] >= '0' && charArr[startIndex] <= '9') {
                //  set number string this character array
                charArr[setIndex++] = charArr[startIndex];
            } else {
                //  the continued number is over
                break;
            }
            startIndex++;
        }
        return setIndex;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-000000000000000001"));
    }
}
