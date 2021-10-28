package org.zongjieli.leetcode.question.daily.year2021.month10.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定正整数 N,按任何顺序(包括原始顺序)将数字重新排序,注意其前导数字不能为零
 * 如果可以通过上述方式得到 2 的幂,返回 true,否则返回 false
 *
 * @author   Li.zongjie
 * @date     2021/10/28
 * @version  1.0
 */
public class Z4IsPowerOfTwo {

    private long[][] values = new long[][]{
            {}
            ,{8, 4, 2, 1}
            ,{64, 32, 61}
            ,{521, 652, 821}
            ,{9821, 9640, 8420, 4210}
            ,{66553, 87632, 86431}
            ,{885422, 644221, 732110}
            ,{8888630, 9444310, 9752210, 8765410}
            ,{88766410, 55443332, 77766211}
            ,{987653210, 866554432, 877432211}
            ,{9998855432L, 9997664422L, 8876444321L, 8774432110L}};

    public boolean reorderedPowerOf2(int n) {
        int[] count = new int[10];
        int bit = 0;
        while (n > 0){
            int last = n % 10;
            count[last]++;
            n /= 10;
            bit++;
        }
        long max = 0;
        for (int i = 9 ; i >= 0 ; i--){
            while (count[i]-- > 0){
                max *= 10;
                max += i;
            }
        }
        for (long l : values[bit]) {
            if (max == l){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Z4IsPowerOfTwo test = new Z4IsPowerOfTwo();
        System.out.println(test.reorderedPowerOf2(4096));
    }
}
