package org.zongjieli.leetcode.competion.singleweekly.order270;

import java.util.*;

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
        Set<Integer> result = new HashSet<>();
        for (int i = 0 ; i < digits.length ; i++){
            if (digits[i] == 0){
                continue;
            }
            for (int j = 0 ; j < digits.length ; j++){
                if (j == i){
                    continue;
                }
                for (int k = 0 ; k < digits.length ; k++){
                    if (k == i || k == j || digits[k] % 2 != 0){
                        continue;
                    }
                    result.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }

        int[] r = new int[result.size()];
        Iterator<Integer> i = result.iterator();
        int index = 0;
        while (i.hasNext()){
            r[index++] = i.next();
        }
        Arrays.sort(r);
        return r;
    }
}
