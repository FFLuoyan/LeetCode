package org.zongjieli.leetcode.question.daily.year2022.month2.week4;
/**
 * 给定一组正整数,相邻的整数之间将会进行浮点除法操作
 * 例如,[2,3,4] -> 2 / 3 / 4
 *
 * 但是可以在任意位置添加任意数目的括号来改变算数的优先级
 * 需要找出怎么添加括号才能得到最大的结果,并且返回相应的字符串格式的表达式
 * 表达式不应该含有冗余的括号
 *
 * 输入数组的长度在 [1, 10] 之间
 * 数组中每个元素的大小都在 [2, 1000] 之间
 * 每个测试用例只有一个最优除法解
 *
 * @author   Li.zongjie
 * @date     2022/2/28
 * @version  1.0
 */
public class Z7OptimalDivision {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        } else if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        } else {
            StringBuilder result = new StringBuilder();
            result.append(nums[0]).append("/(").append(nums[1]);
            for (int i = 2 ; i < nums.length ; i++) {
                result.append("/").append(nums[i]);
            }
            result.append(")");
            return result.toString();
        }
    }
}
