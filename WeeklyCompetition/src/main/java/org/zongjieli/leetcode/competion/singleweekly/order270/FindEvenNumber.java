package org.zongjieli.leetcode.competion.singleweekly.order270;

import java.util.Arrays;

/**
 * 给定一个整数数组 digits,其中每个元素是一个数字(0 - 9),数组中可能存在重复元素
 * 需要找出所有满足下述条件且互不相同的整数
 *  该整数由 digits 中的三个元素按任意顺序依次连接组成
 *  该整数不含前导零
 *  该整数是一个偶数
 * 例如,给定的 digits 是 [1, 2, 3]
 * 整数 132 和 312 满足上面列出的全部条件
 * 将找出的所有互不相同的整数按递增顺序排列,并以数组形式返回
 *
 * 3 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author   Li.zongjie
 * @date     2021/12/5
 * @version  1.0
 */
public class FindEvenNumber {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }
        int[] save = new int[1000];
        int index = 0;
        int a,b,c;
        for (int i = 100 ; i < 1000 ; i += 2){
            a = i % 10;
            b = (i / 10) % 10;
            c = i / 100;
            if (--count[a] >= 0 & --count[b] >= 0 & --count[c] >= 0){
                save[index++] = i;
            }
            count[a]++;
            count[b]++;
            count[c]++;
        }
        int[] result = new int[index];
        System.arraycopy(save, 0, result, 0, index);
        return result;
    }

    public static void main(String[] args) {
        FindEvenNumber test = new FindEvenNumber();
        System.out.println(Arrays.toString(test.findEvenNumbers(new int[]{2, 1, 3, 0})));
    }
}
