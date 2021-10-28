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
    public boolean reorderedPowerOf2(int n) {
        int[] count = new int[10];
        while (n > 0){
            int last = n % 10;
            count[last]++;
            n /= 10;
        }

        int zero = 1;
        for (int i = 1 ; i <= count[0] ; i++){
            zero *= 10;
        }

        long max = 0;

        for (int i = 9 ; i > 0 ; i--) {
            for (int j = count[i] ; j > 0 ; j--){
                max = (10 * max) + i;
            }
        }

        max *= zero;

        int minStart = (int) (max % 10);
        int min = minStart * zero;

        for (int i = 1 ; i < count[minStart] ; i++){
            min *= 10;
            min += minStart;
        }

        for (int i = minStart + 1 ; i < count.length; i++) {
            for (int j = count[i] ; j > 0 ; j--){
                min = (10 * min) + i;
            }
        }

        long minPower = 1;
        while ((min &= (~minPower)) != 0){
            minPower <<= 1;
        }

        while (minPower <= max){
            int[] powerCount = new int[10];
            long temp = minPower;
            while (temp > 0){
                int last = (int) (temp % 10);
                powerCount[last]++;
                temp /= 10;
            }
            int i = 0;
            for (; i < 10 ; i++){
                if (powerCount[i] != count[i]){
                    break;
                }
            }
            if (i == 10){
                return true;
            }
            minPower <<= 1;
        }

        return false;
    }

    public static void main(String[] args) {
        Z4IsPowerOfTwo test = new Z4IsPowerOfTwo();
        System.out.println(test.reorderedPowerOf2(4096));
    }
}
