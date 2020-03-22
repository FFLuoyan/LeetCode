package org.zongjieli.leetcode.competion.singleweekly.order181;

import java.util.LinkedList;

/**
 * @ClassName: CreatArray
 * @Description: 按照指定顺序创建目标数组
 * 对于给定的数组 nums 和 index,在目标数组 target 中的 index 位置插入 num
 * @Author: Zongjie.Li
 * @Date: 2020/3/22
 * @Version: 1.0
 **/
public class CreatArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> targetArray = new LinkedList<>();
        for (int arrayIndex = 0; arrayIndex < nums.length; arrayIndex++) {
            targetArray.add(index[arrayIndex], nums[arrayIndex]);
        }
        int[] target = new int[nums.length];
        for (int i = 0; i < target.length; ) {
            target[i++] = targetArray.poll();
        }
        return target;

    }

    public static void main(String[] args) {

    }
}
