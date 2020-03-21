package org.zongjieli.leetcode.competion.singleweekly.order171;

/**
 * @ClassName: BitOverturnOrOperator
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/12
 * @Version: 1.0
 **/
public class BitOverturnOrOperator {
    public static int minFlips(int a, int b, int c) {
        int orValue = a | b;
        int differentValue = orValue ^ c;
        //  每一个 1 代表此处值不相等
        int count = 0;
        for (int i = 0; i < 31; i++) {
            int bitValue = 1 << i;
            if (bitValue == (differentValue & bitValue)) {
                // 如果相等说明此处是1
                if (bitValue == (c & bitValue)) {
                    // c 此处有值
                    count++;
                } else if ((a & bitValue) == (b & bitValue)) {
                    // c 无值,则判断a,b是否有值
                    count += 2;
                } else {
                    // 只有一个有值
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minFlips(2, 2, 0));
    }
}
