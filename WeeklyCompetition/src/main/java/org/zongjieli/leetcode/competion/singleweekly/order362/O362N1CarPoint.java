package org.zongjieli.leetcode.competion.singleweekly.order362;

import java.util.List;

/**
 * 给定一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标
 * 对于任意下标 i,nums[i] = [startI, endI]
 * 其中 startI 是第 i 辆车的起点, endI 是第 i 辆车的终点
 * 返回数轴上被车任意部分覆盖的整数点的数目
 *
 * 1 <= nums.length <= 100
 * nums[i].length == 2
 * 1 <= startI <= endI <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/10
 */
public class O362N1CarPoint {

    public int numberOfPoints(List<List<Integer>> nums) {
        int[] count = new int[102];
        for (List<Integer> num : nums) {
            count[num.get(0)]++;
            count[num.get(1) + 1]--;
        }
        int result = 0;
        for (int i = 1 ; i <= 100 ; i++) {
            if ((count[i] += count[i - 1]) > 0) {
                result++;
            }
        }
        return result;
    }

}
