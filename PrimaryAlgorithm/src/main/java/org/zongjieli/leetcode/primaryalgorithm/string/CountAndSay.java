package org.zongjieli.leetcode.primaryalgorithm.string;

/**
 * @ClassName: CountAndSay
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/7
 * @Version: 1.0
 **/
public class CountAndSay {
    public static String countAndSay(int n) {
        String lookSequence = "1";
        char[] seqArr;
        StringBuilder seqBuilder = new StringBuilder();
        for (int i = 1; i < n; i++) {
            seqArr = lookSequence.toCharArray();
            int count = 1, equalIndex = 0;
            for (int index = 1; index < seqArr.length; index++) {
                if (seqArr[index] == seqArr[equalIndex]) {
                    count++;
                } else {
                    seqBuilder.append(count);
                    seqBuilder.append(seqArr[equalIndex]);
                    equalIndex = index;
                    count = 1;
                }
            }
            seqBuilder.append(count);
            seqBuilder.append(seqArr[equalIndex]);
            lookSequence = seqBuilder.toString();
            seqBuilder.delete(0, seqBuilder.length());
        }
        return lookSequence;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
