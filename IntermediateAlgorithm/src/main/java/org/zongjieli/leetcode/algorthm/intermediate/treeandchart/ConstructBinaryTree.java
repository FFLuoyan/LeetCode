package org.zongjieli.leetcode.algorthm.intermediate.treeandchart;

import org.zongjieli.leetcode.algorithm.primary.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ConstructBinaryTree
 * @Description: 根据中序遍历以及前序遍历构建二叉树(没有重复元素)
 * @Author: Zongjie.Li
 * @Date: 2020/5/6
 * @Version: 1.0
 **/
public class ConstructBinaryTree {

    private Map<Integer,Integer> valueIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length ==0 || inorder.length == 0){
            return null;
        }
        for (int i = 0 ; i < inorder.length ; i++){
            valueIndex.put(inorder[i],i);
        }
        return buildTree(preorder,0,inorder.length - 1,0,preorder.length - 1);
    }


    public TreeNode buildTree( int[] preorder,int inStart,int inEnd,int preStart,int preEnd){
        TreeNode root = new TreeNode(preorder[preStart]);
        int middleNodeIndex = valueIndex.get(preorder[preStart]);

        if (inStart <= middleNodeIndex - 1){
            root.left  = buildTree(preorder,inStart,middleNodeIndex - 1,preStart + 1,preStart + middleNodeIndex - inStart);
        }
        if (middleNodeIndex + 1 <= inEnd){
            root.right = buildTree(preorder,middleNodeIndex + 1,inEnd,preEnd - inEnd + middleNodeIndex + 1,preEnd);
        }
        return root;
    }

    public TreeNode buildTreeByAnotherRecursion(int[] preorder){
        TreeNode root = new TreeNode(preorder[0]);

        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        TreeNode root = constructBinaryTree.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.println(root.val);
    }
}
