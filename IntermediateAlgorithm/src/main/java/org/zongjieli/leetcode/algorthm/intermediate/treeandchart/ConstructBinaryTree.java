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

    private int recursionPreIndex = 0;
    private Map<Integer,Integer> valueIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length ==0 || inorder.length == 0){
            return null;
        }
        for (int i = 0 ; i < inorder.length ; i++){
            valueIndex.put(inorder[i],i);
        }
//        return buildTree(preorder,0,inorder.length - 1,0,preorder.length - 1);
        return buildTreeByAnotherRecursion(preorder,Integer.MAX_VALUE);
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

    public TreeNode buildTreeByAnotherRecursion(int[] preorder,int maxIndex){
        if (recursionPreIndex == preorder.length){
            return null;
        }
        int valueInIndex = valueIndex.get(preorder[recursionPreIndex]);
        // 下一个节点值大于上一个节点的包含范围,则直接返回 null
        if (valueInIndex > maxIndex){
            return null;
        }
        TreeNode root = new TreeNode(preorder[recursionPreIndex]);
        recursionPreIndex ++;
        root.left = buildTreeByAnotherRecursion(preorder,valueInIndex);
        root.right = buildTreeByAnotherRecursion(preorder,maxIndex);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        TreeNode root = constructBinaryTree.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.println(root.val);
    }
}
