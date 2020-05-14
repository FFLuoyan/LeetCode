package org.zongjieli.leetcode.algorthm.intermediate.treeandchart;

import org.zongjieli.leetcode.algorithm.primary.tree.TreeNode;

/**
 * @ClassName: KthSmallestNode
 * @Description: 计算二叉搜索树中第 K 小的元素
 * @Author: Zongjie.Li
 * @Date: 2020/5/14
 * @Version: 1.0
 **/
public class KthSmallestNode {
    public int kthSmallest(TreeNode root, int k) {
        int[] value = new int[]{0,0};
        kthSmallest(root,value,k);
        return value[1];
    }

    public void kthSmallest(TreeNode root,int[] value, int k) {
        if (value[0] < k){
            if (root.left != null){
                kthSmallest(root.left,value,k);
            }
            if (++value[0] == k){
                value[1] = root.val;
            }
            if (root.right != null){
                kthSmallest(root.right,value,k);
            }
        }
    }
}
