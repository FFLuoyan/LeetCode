package org.zongjieli.leetcode.question.daily.year2022.month8.week1;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一个二叉树的根 root 和两个整数 val 和 depth
 * 在给定的深度 depth 处添加一个值为 val 的节点行
 * 注意,根节点 root 位于深度 1
 * 加法规则如下:
 *  给定整数 depth,对于深度为 depth - 1 的每个非空树节点 cur
 *      创建两个值为 val 的树节点作为 cur 的左子树根和右子树根
 *  cur 原来的左子树应该是新的左子树根的左子树
 *  cur 原来的右子树应该是新的右子树根的右子树
 *  如果 depth == 1 意味着 depth - 1 根本没有深度
 *      那么创建一个树节点,值 val 作为整个原始树的新根,而原始树就是新根的左子树
 *
 * 节点数在 [1, 10^4] 范围内
 * 树的深度在 [1, 10^4]范围内
 * -100 <= Node.val <= 100
 * -10^5 <= val <= 10^5
 * 1 <= depth <= the depth of tree + 1
 *
 * @author   Li.zongjie
 * @date     2022/8/5
 * @version  1.0
 */
public class Z5TreeAddRow {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        addRow(root, val, depth - 1, 1);
        return root;
    }

    public void addRow(TreeNode root, int val, int tr, int cr) {
        if (root == null) {
            return;
        }
        if (tr == cr) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return;
        }
        addRow(root.left, val, tr, cr + 1);
        addRow(root.right, val, tr, cr + 1);
    }
}
