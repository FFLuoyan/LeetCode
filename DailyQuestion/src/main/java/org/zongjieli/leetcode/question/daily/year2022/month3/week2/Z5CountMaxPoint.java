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

    private int length;
    private long max = 0;
    private int count = 0;

    public int countHighestScoreNodes(int[] parents) {
        length = parents.length;
        int[] lefts = new int[length];
        int[] rights = new int[length];
        for (int i = 1 ; i < length ; i++) {
            if (lefts[parents[i]] == 0) {
                lefts[parents[i]] = i;
            } else {
                rights[parents[i]] = i;
            }
        }
        count(0, lefts, rights);
        return count;
    }

    public int count(int root, int[] lefts, int[] rights) {
        int left = lefts[root];
        int right = rights[root];
        int leftCount = left == 0 ? 0 : count(left, lefts, rights);
        int rightCount = right == 0 ? 0 : count(right, lefts, rights);
        int parent = root == 0 ? length - leftCount - rightCount : length - leftCount - rightCount - 1;
        countScore(((long) parent) * (leftCount == 0 ? 1 : leftCount) * (rightCount == 0 ? 1 : rightCount));
        return length - parent;
    }

    public void countScore(long score) {
        if (score == max) {
            count++;
        } else if (score > max) {
            max = score;
            count = 1;
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
