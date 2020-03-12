package org.zongjieli.leetcode.primaryalgorithm.tree;

/**
 * @ClassName: SortedArrayToBst
 * @Description: 将有序数组转化为二叉搜索树
 * @Author: Zongjie.Li
 * @Date: 2020/3/12
 * @Version: 1.0
 **/
public class SortedArrayToBst {
    public static void main(String[] args) {
        SortedArrayToBst sortedArrayToBst = new SortedArrayToBst();
        TreeToList treeToList = new TreeToList();
        int[] nums = new int[]{-10, -3, 5, 6, 7, 8, 12};
        treeToList.levelOrder(sortedArrayToBst.sortedArrayToBstByRecursion(nums)).forEach(list -> System.out.println(list));

    }

    public TreeNode sortedArrayToBstByRecursion(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        return sortedSubarrayToBstByRecursion(0,nums.length - 1,nums);
    }

    public TreeNode sortedSubarrayToBstByRecursion(int start,int end,int[] nums){
        int length = end - start;
        if (length == 0){
            return new TreeNode(nums[start]);
        }
        if (length > 0){
            int fatherIndex = length / 2 + start;
            TreeNode node = new TreeNode(nums[fatherIndex]);
            node.left = sortedSubarrayToBstByRecursion(start,fatherIndex - 1,nums);
            node.right = sortedSubarrayToBstByRecursion(fatherIndex + 1,end,nums);
            return node;
        }
        return null;
    }
}
