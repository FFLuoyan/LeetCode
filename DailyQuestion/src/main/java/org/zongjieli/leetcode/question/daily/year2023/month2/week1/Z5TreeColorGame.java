package org.zongjieli.leetcode.question.daily.year2023.month2.week1;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 有两位极客玩家参与了一场二叉树着色的游戏
 * 游戏中,给出二叉树的根节点 root,树上总共有 n 个节点
 * 且 n 为奇数,其中每个节点上的值从 1 到 n 各不相同
 * 最开始时:
 * 一号玩家从 [1, n] 中取一个值 x(1 <= x <= n)
 * 二号玩家也从 [1, n] 中取一个值 y(1 <= y <= n) 且 y != x
 * 一号玩家给值为 x 的节点染上红色,而二号玩家给值为 y 的节点染上蓝色
 * 之后两位玩家轮流进行操作,一号玩家先手
 * 每一回合,玩家选择一个被他染过色的节点,将所选节点一个未着色的邻节点(即左右子节点、或父节点)进行染色
 * 一号玩家染红色,二号玩家染蓝色
 * 如果(且仅在此种情况下)当前玩家无法找到这样的节点来染色时,其回合就会被跳过
 * 若两个玩家都没有可以染色的节点时,游戏结束,着色节点最多的那位玩家获得胜利
 * 现在二号玩家,根据所给出的输入,假如存在一个 y 值可以确保赢得这场游戏,则返回 true
 * 若无法获胜,就请返回 false
 *
 * 树中节点数目为 n
 * 1 <= x <= n <= 100
 * n 是奇数
 * 1 <= Node.val <= n
 * 树中所有值互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/3
 */
public class Z5TreeColorGame {

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] count = new int[]{0, 0, 0};
        countNodes(root, x, count, 0);
        int half = n / 2;
        return count[0] > half || count[1] > half || count[2] > half;
    }

    public void countNodes(TreeNode root, int x, int[] values, int type) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            countNodes(root.left, x, values, 1);
            countNodes(root.right, x, values, 2);
        } else {
            values[type]++;
            countNodes(root.left, x, values, type);
            countNodes(root.right, x, values, type);
        }
    }

}
