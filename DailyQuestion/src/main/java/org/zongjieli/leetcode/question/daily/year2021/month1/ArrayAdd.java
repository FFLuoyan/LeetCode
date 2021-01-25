package org.zongjieli.leetcode.question.daily.year2021.month1;

import java.util.ArrayList;
import java.util.Collections;
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
        for (int index = A.length - 1 ; index >= 0 || K > 0;){
            if (index >= 0){
                K += A[index--];
            }
            result.addFirst(K % 10);
            K /= 10;
        }
        return result;
    }

    public List<Integer> addToArrayFormByArray(int[] A, int K) {
        int[] answer = new int[A.length > 5 ? A.length + 1 : 6];
        int valueIndex = answer.length;
        int addIndex = A.length - 1;
        while (addIndex >= 0 || K > 0){
            if (addIndex >= 0){
                K += A[addIndex --];
            }
            answer[--valueIndex] = K % 10;
            K /= 10;
        }
        List<Integer> result = new ArrayList<>(answer.length);
        for (int i = valueIndex ; i < answer.length ; i++){
            result.add(answer[i]);
        }
        return result;
    }

    public List<Integer> addToArrayFormByReverse(int[] A, int K) {
        List<Integer> result = new ArrayList<>(A.length > 5 ? A.length + 1 : 6);
        int addIndex = A.length - 1;
        while (addIndex >= 0 || K > 0){
            if (addIndex >= 0){
                K += A[addIndex --];
            }
            result.add(K % 10);
            K /= 10;
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayAdd arrayAdd = new ArrayAdd();
        System.out.println(arrayAdd.addToArrayForm(new int[]{8,7},782));
        System.out.println(arrayAdd.addToArrayFormByArray(new int[]{ 8,7},782));
        System.out.println(arrayAdd.addToArrayFormByReverse(new int[]{ 8,7},782));
    }

}
