package org.zongjieli.leetcode.algorithm.primary.string;

import java.util.Arrays;

/**
 * @ClassName: StrString
 * @Description: KMP to strString
 * @Author: Zongjie.Li
 * @Date: 2020/1/4
 * @Version: 1.0
 **/
public class StrString {
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        int[] kmpArr = new int[needleArr.length];
        //  building KMP array
        for (int i = 1, compareIndex = 0; i < needleArr.length; i++) {
            //  the kmpArr[0] is always 0
            //  the compareIndex is the value of kmpArr[i-1]
            while (needleArr[i] != needleArr[compareIndex] && compareIndex-- != 0) {
                //  the kmp value is different from the comparision value or the comparision value is 0
                //  it means that the KMP value matching fails at this time
                //  but the time the substring index range (i - compareIndex) to (i - 1)
                //  is same as substring index range 0 to (compareIndex - 1)
                //  you now need to check the array 0 to (compareIndex - 1) not array range 0 to i
                //  just check the value needleArr[kmpArr[compareIndex]] by loop
                compareIndex = kmpArr[compareIndex];
            }
            //  the kmp value
            //  if match success,the kmpAttr[i](kmp Value) is the value (compareIndex + 1)
            //  if match fail,the compareIndex is -1,the kmp value should be 0
            kmpArr[i] = ++compareIndex;
        }
        System.out.println(Arrays.toString(kmpArr));
        int hIndex = 0, nIndex = 0;
        for (; haystackArr.length - hIndex >= needleArr.length - nIndex && nIndex < needleArr.length; hIndex++, nIndex++) {
            //  if remain check length less than the remain needle length,the loop should break
            while (haystackArr[hIndex] != needleArr[nIndex] && nIndex-- > 0) {
                nIndex = kmpArr[nIndex];
            }
        }
        //  if the check finish,the nIndex is equal to the length of the needle
        return nIndex == needleArr.length ? hIndex - nIndex : -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("acabcabdcabcabca", "cabcabdcabcabca"));
    }
}
