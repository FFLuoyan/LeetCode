package org.zongjieli.leetcode.competion.singleweekly.order335;

/**
 * 考试中有 n 种类型的题目,给定一个整数 target 和一个下标从 0 开始的二维整数数组 types
 * 其中 types[i] = [countI, marksI] 表示第 i 种类型的题目有 countI 道,每道题目对应 marksI 分
 * 返回在考试中恰好得到 target 分的方法数,由于答案可能很大,结果需要对 10^9 +7 取余
 * 注意,同类型题目无法区分
 * 比如说,如果有 3 道同类型题目,那么解答第 1 和第 2 道题目
 * 与解答第 1 和第 3 道题目或者第 2 和第 3 道题目是相同的
 *
 * 1 <= target <= 1000
 * n == types.length
 * 1 <= n <= 50
 * types[i].length == 2
 * 1 <= countI, marksI <= 50
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/5
 */
public class O335N4CountMethod {

    public int waysToReachTarget(int target, int[][] types) {
        int[] save = new int[target + 1];
        save[0] = 1;
        for (int[] type : types) {
            int[] current = new int[target + 1];
            System.arraycopy(save, 0, current, 0, current.length);
            int c = type[1];
            for (int i = 1 ; i <= type[0] ; i++) {
                int value = c * i;
                for (int j = 0 ; j <= target - value ; j++) {
                    save[j + value] = (current[j] + save[j + value]) % 1000000007;
                }
            }
        }
        return save[target];
    }


    public static void main(String[] args) {
        O335N4CountMethod test = new O335N4CountMethod();
        System.out.println(test.waysToReachTarget(6, new int[][]{{6, 1}, {3, 2}, {2, 3}}));
    }
   
}
