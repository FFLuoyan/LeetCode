package org.zongjieli.leetcode.question.daily.year2023.month11.week1;

import org.zongjieli.leetcode.base.TreeNext;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树
 * @see TreeNext
 * 填充它的每个 next 指针,让这个指针指向其下一个右侧节点
 * 如果找不到下一个右侧节点,则将 next 指针设置为 NULL
 * 初始状态下,所有 next 指针都被设置为 NULL
 *
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 * 进阶:
 *  只能使用常量级额外空间
 *  使用递归解题也符合要求,本题中递归程序的隐式栈空间不计入额外空间复杂度
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/3
 */
public class Z5FillNext {

    List<TreeNext> leftList = new ArrayList<>();

    public TreeNext connect(TreeNext root) {
        connect(root, 0);
        return root;
    }

    public void connect(TreeNext root, int level) {
        if (root == null) {
            return;
        }
        if (level == leftList.size()) {
            leftList.add(root);
        } else {
            leftList.get(level).next = root;
            leftList.set(level, root);
        }
        connect(root.left, ++level);
        connect(root.right, level);
    }

}
