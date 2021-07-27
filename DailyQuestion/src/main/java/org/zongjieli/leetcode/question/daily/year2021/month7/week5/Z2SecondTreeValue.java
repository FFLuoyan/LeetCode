package org.zongjieli.leetcode.question.daily.year2021.month7.week5;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.Arrays;

/**
 * 给定一个非空特殊的二叉树,每个节点都是正数,并且每个节点的子节点数量只能为 2 或 0
 * 如果一个节点有两个子节点的话,那么该节点的值等于两个子节点中较小的一个
 * 更正式地说,root.val = min(root.left.val, root.right.val) 总成立
 *
 * 给出这样的一个二叉树,你需要输出所有节点中的第二小的值
 * 如果第二小的值不存在的话,输出 -1
 *
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 2^31 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 *
 * @author   Zongjie.Li
 * @date     2021/7/27
 * @version  1.0
 */
public class Z2SecondTreeValue {
    public int findSecondMinimumValue(TreeNode root) {
        int[] values = new int[26];
        saveValue(root,values);
        int index = 26 - values[25];
        values[25] = 0;
        Arrays.sort(values);
        int min = values[index];
        while (index < values.length){
            if (values[index] != min){
                return values[index];
            }
            index++;
        }
        return  -1;
    }

    public void saveValue(TreeNode root,int[] values){
        if (root != null){
            values[values[25]++] = root.val;
            saveValue(root.left,values);
            saveValue(root.right,values);
        }
    }

    public static void main(String[] args) {
        Z2SecondTreeValue test = new Z2SecondTreeValue();
        System.out.println(test.findSecondMinimumValue(TreeNode.MIN_TREE));
    }
}
