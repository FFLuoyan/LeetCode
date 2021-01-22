package org.zongjieli.leetcode.question.daily.year2021.month1;

import java.util.LinkedList;
import java.util.List;

/**
 * 对于非负整数 X 而言,X 的数组形式 A
 * 为 X 按照每位数字从左到右的顺序形成
 *
 * X:12385,A:[1,2,3,8,5]
 *
 * 给定非负整数 X 的数组形式 A
 * 返回整数 X + K 的数组形式
 *
 * @author   Zongjie.Li
 * @date     2021/1/22
 * @version  1.0
 */
public class ArrayAdd {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int index = A.length - 1 ; index >= 0 ; index --){
            int sum = K % 10 + A[index];
            K /= 10;
            if (sum >= 10){
                sum -= 10;
                K ++;
            }
            result.addFirst(sum);
        }
        while (K > 0){
            result.addFirst(K%10);
            K /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayAdd arrayAdd = new ArrayAdd();
        System.out.println(arrayAdd.addToArrayForm(new int[]{7,1,5,9,9,9,6,4, 8,7,},425613220));
    }

}
