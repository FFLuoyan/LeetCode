package org.zongjieli.leetcode.question.daily.year2022.month9.week4;
/**
 * 给定一个整数数组 arr,数组中的每个整数互不相同
 * 另有一个由整数数组构成的数组 pieces,其中的整数也互不相同
 * 请以任意顺序连接 pieces 中的数组以形成 arr
 * 但是不允许对每个数组 pieces[i] 中的整数重新排序
 *
 * 如果可以连接 pieces 中的数组形成 arr,返回 true,否则返回 false
 *
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数互不相同
 * pieces 中的整数互不相同(也就是说,如果将 pieces 扁平化成一维数组,数组中的所有整数互不相同)
 *
 * @author   Li.zongjie
 * @date     2022/9/22
 * @version  1.0
 */
public class Z4ConnectArray {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] after = new int[101];
        boolean[] exists = new boolean[101];
        exists[arr[0]] = true;
        for (int i = 1 ; i < arr.length ; i++) {
            after[arr[i - 1]] = arr[i];
            exists[arr[i]] = true;
        }
        for (int[] piece : pieces) {
            if (!exists[piece[0]]) {
                return false;
            }
            for (int i = 1 ; i < piece.length ; i++) {
                if (!exists[piece[i]] || after[piece[i - 1]] != piece[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Z4ConnectArray test = new Z4ConnectArray();
        System.out.println(test.canFormArray(new int[]{85}, new int[][]{{85}}));
    }
}
