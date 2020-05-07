package org.zongjieli.leetcode.algorthm.intermediate.treeandchart;

import org.zongjieli.leetcode.algorithm.primary.tree.TreeNode;

/**
 * @ClassName: ConstructBinaryTree
 * @Description: 根据中序遍历以及前序遍历构建二叉树(没有重复元素)
 * @Author: Zongjie.Li
 * @Date: 2020/5/6
 * @Version: 1.0
 **/
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length ==0 || inorder.length == 0){
            return null;
        }
        return buildTree(inorder,preorder,0,preorder.length - 1,0,inorder.length - 1);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder,int preStart,int preEnd,int inStart,int inEnd){
        TreeNode root = new TreeNode(inorder[inStart]);
        int middleNodeIndex = preStart;
        while (preorder[middleNodeIndex] != inorder[inStart]){
            // 如果前序遍历节点值不等于中序遍历的中点值,说明子树位置没有改变
            middleNodeIndex++;
        }
        // 此时 inorder[inStart] == preOrder[middleNodeIndex]
        // middleNodeIndex 节点的位置即为前序遍历中中点的位置
        if (preStart <= middleNodeIndex - 1){
            root.left = buildTree(preorder,inorder,preStart,middleNodeIndex - 1,inStart + 1,inStart + middleNodeIndex - preStart);
        }
        if (middleNodeIndex + 1 <= preEnd){
            root.right = buildTree(preorder,inorder,middleNodeIndex + 1,preEnd,inEnd - preEnd + middleNodeIndex + 1,inEnd);
        }
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        TreeNode root = constructBinaryTree.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.println(root.val);
    }
}
