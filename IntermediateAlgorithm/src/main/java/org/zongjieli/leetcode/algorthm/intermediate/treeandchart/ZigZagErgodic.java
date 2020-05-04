package org.zongjieli.leetcode.algorthm.intermediate.treeandchart;

import org.zongjieli.leetcode.algorithm.primary.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: ZigZagErgodic
 * @Description: 返回给定二叉树的锯齿状层次遍历
 * @Author: Zongjie.Li
 * @Date: 2020/5/1
 * @Version: 1.0
 **/
public class ZigZagErgodic {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        LinkedList<TreeNode> waitNodes = new LinkedList<>();
        boolean leftToRight = true;
        waitNodes.add(root);
        while (waitNodes.size() != 0){
            int count = waitNodes.size();
            LinkedList<Integer> currentList = new LinkedList<>();
            while (count > 0){
                TreeNode currentNode = waitNodes.pollFirst();
                currentList.addLast(currentNode.val);
                count --;
                if (leftToRight){
                    // 如果当前循环为从左至右,则下一轮循环为从右至左
                    // 最左的节点放在最后
                    if (currentNode.left != null){
                        waitNodes.add(count,currentNode.left);
                    }
                    if (currentNode.right != null){
                        waitNodes.add(count,currentNode.right);
                    }
                } else {
                    if (currentNode.right != null){
                        waitNodes.add(count,currentNode.right);
                    }
                    if (currentNode.left != null){
                        waitNodes.add(count,currentNode.left);
                    }
                }
            }
            result.add(currentList);
            leftToRight = leftToRight ? false : true;
        }
        return result;
    }
}
