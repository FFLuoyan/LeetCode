package org.zongjieli.leetcode.competion.singleweekly.order180;

import org.zongjieli.leetcode.primaryalgorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BstToBalanceBst
 * @Description: 将传入的二叉搜索树转变成平衡二叉搜索树
 * @Author: Zongjie.Li
 * @Date: 2020/3/15
 * @Version: 1.0
 **/
public class BstToBalanceBst {
    public TreeNode balanceBst(TreeNode root){
        List<TreeNode> bstValues = new ArrayList<>();
        bstValues = bstToArray(root,bstValues);
        root = arrayToTree(0,bstValues.size() - 1,bstValues);
        return root;
    }

    public List<TreeNode> bstToArray(TreeNode root,List bstValues){
        if (root != null){
            bstToArray(root.left,bstValues);
            bstValues.add(root);
            bstToArray(root.right, bstValues);
        }
        return bstValues;
    }

    public TreeNode arrayToTree(int start,int end,List<TreeNode> nodeList){
        if (start > end){
            return null;
        }
        int index = (end - start) / 2 + start;
        TreeNode node = nodeList.get(index);
        node.left = arrayToTree(start,index - 1,nodeList);
        node.right = arrayToTree(index + 1,end,nodeList);
        return node;
    }


    public static void main(String[] args) {
        BstToBalanceBst bstToBalanceBst = new BstToBalanceBst();
        TreeNode test = bstToBalanceBst.balanceBst(TreeNode.binarySearchTree());
        System.out.println(test.val);
    }
}
