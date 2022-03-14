package org.zongjieli.leetcode.question.daily.year2022.month3.week2;
/**
 * 给定一棵根节点为 0 的二叉树,它总共有 n 个节点,节点编号为 0 到 n - 1
 * 同时给定一个下标从 0 开始的整数数组 parents 表示这棵树
 * 其中 parents[i] 是节点 i 的父节点,由于节点 0 是根,所以 parents[0] == -1
 * 一个子树的大小为这个子树内节点的数目,每个节点都有一个与之关联的分数
 * 求出某个节点分数的方法是,将这个节点和与它相连的边全部删除
 * 剩余部分是若干个非空子树,这个节点的分数为所有这些子树大小的乘积
 * 请返回有最高得分节点的数目
 *
 * n == parents.length
 * 2 <= n <= 10^5
 * parents[0] == -1
 * 对于 i != 0,有 0 <= parents[i] <= n - 1
 * parents 表示一棵二叉树
 *
 * @author   Li.zongjie
 * @date     2022/3/11
 * @version  1.0
 */
public class Z5CountMaxPoint {

    public int countHighestScoreNodes(int[] parents) {
        int length = parents.length;
        int[][] sons = new int[length][2];
        for (int i = 1 ; i < parents.length ; i++) {
            sons[parents[i]][sons[parents[i]][0] == 0 ? 0 : 1] = i;
        }
        long[] result = new long[]{0, 0};
        count(0, sons, result, length);
        return (int) result[1];
    }

    public int count(int root, int[][] sons, long[] result, int all) {
        int left = sons[root][0];
        if (left == 0) {
            countScore(all - 1, result);
            return 1;
        }
        int leftCount = count(left, sons, result, all);
        int right = sons[root][1];
        if (right == 0) {
            if (root == 0) {
                countScore(all - 1, result);
                return 0;
            }
            countScore(leftCount * (all - leftCount - 1), result);
            return leftCount + 1;
        }
        int rightCount = count(right, sons, result, all);
        if (root == 0) {
            countScore(leftCount * rightCount, result);
            return 0;
        }
        int subtree = leftCount + rightCount + 1;
        countScore(((long) (all - subtree)) * leftCount * rightCount, result);
        return subtree;
    }

    public void countScore(long score, long[] result) {
        if (score == result[0]) {
            result[1]++;
        } else if (score > result[0]) {
            result[0] = score;
            result[1] = 1;
        }
    }

    public static void main(String[] args) {
        Z5CountMaxPoint test = new Z5CountMaxPoint();
        // 3
        System.out.println(test.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
        // 2
        System.out.println(test.countHighestScoreNodes(new int[]{-1, 3, 3, 5, 7, 6, 0, 0}));
        // 2
        System.out.println(test.countHighestScoreNodes(new int[]{-1, 0}));
    }
}
