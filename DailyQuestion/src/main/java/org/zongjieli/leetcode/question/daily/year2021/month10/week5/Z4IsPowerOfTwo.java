package org.zongjieli.leetcode.question.daily.year2021.month10.week5;

/**
 * 给定正整数 N,按任何顺序(包括原始顺序)将数字重新排序,注意其前导数字不能为零
 * 如果可以通过上述方式得到 2 的幂,返回 true,否则返回 false
 *
 * @author   Li.zongjie
 * @date     2021/10/28
 * @version  1.0
 */
public class Z4IsPowerOfTwo {

    private long[] values = new long[]{1, 2, 4, 8, 32, 61, 64, 521, 652, 821, 4210, 8420, 9640, 9821, 66553, 86431, 87632, 644221, 732110, 885422, 8765410, 8888630, 9444310, 9752210, 55443332, 77766211, 88766410, 866554432, 877432211, 987653210, 8774432110L, 8876444321L};

    public boolean reorderedPowerOf2(int n) {
        int[] count = new int[10];
        while (n > 0){
            int last = n % 10;
            count[last]++;
            n /= 10;
        }
        long max = 0;
        for (int i = 9 ; i >= 0 ; i--){
            while (count[i]-- > 0){
                max *= 10;
                max += i;
            }
        }
        for (long l : values) {
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
