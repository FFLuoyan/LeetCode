package org.zongjieli.leetcode.algorithm.primary.string;

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
        boolean isPositive = true;
        int resolveIndex = 0;
        for (; resolveIndex < strCharArr.length; resolveIndex++) {
            if (strCharArr[resolveIndex] == ' ') {
                continue;
            }
            // if the character isn't blank,check positive or negative
            if (strCharArr[resolveIndex] == '+') {
                resolveIndex++;
                break;
            }
            if (strCharArr[resolveIndex] == '-') {
                resolveIndex++;
                isPositive = false;
                break;
            }
            if (strCharArr[resolveIndex] >= '0' && strCharArr[resolveIndex] <= '9') {
                break;
            }
            //  can't resolve
            return 0;
        }
        // trim zero
        while (resolveIndex < strCharArr.length && strCharArr[resolveIndex] == '0') {
            resolveIndex++;
        }
        long numberGet = 0;
        long numberResolve = 0;
        while (resolveIndex < strCharArr.length && strCharArr[resolveIndex] >= '0' && strCharArr[resolveIndex] <= '9') {
            numberGet = numberGet * 10 + strCharArr[resolveIndex] - 48;
            numberResolve = isPositive ? numberGet : -numberGet;
            if (numberResolve > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (numberResolve < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            resolveIndex++;
        }
        return (int) numberResolve;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("    0004554"));
    }
}
