package org.zongjieli.leetcode.origin.year2022.month2;

/**
 * 给定一个下标从 0 开始的整数数组 nums
 * 现定义两个数字的串联是由这两个数值串联起来形成的新数字
 * 例如,15 和 49 的串联是 1549
 * nums 的串联值最初等于 0,执行下述操作直到 nums 变为空:
 *  如果 nums 中存在不止一个数字,分别选中 nums 中的第一个元素和最后一个元素
 *  将二者串联得到的值加到 nums 的串联值上,然后从 nums 中删除第一个和最后一个元素
 *  如果仅存在一个元素,则将该元素的值加到 nums 的串联值上,然后删除这个元素
 * 返回执行完所有操作后 nums 的串联值
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/11
 */
public class LinkArray {

    public long findTheArrayConcVal(int[] nums) {
        long result = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            result += linkValue(nums[left++], nums[right--]);
        }
        return left == right ? result + nums[left] : result;
    }

    public int linkValue(int a, int b) {
        int[] values = new int[5];
        int index = 0;
        while (b > 0) {
            values[index++] = b % 10;
            b /= 10;
        }
        while (--index >= 0) {
            a = a * 10 + values[index];
        }
        return a;
    }


    public long findTheArrayConcVal2(int[] nums) {
        long result = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[right] >= 10000) {
                result = result + nums[left] * 100000L + nums[right];
            } else if (nums[right] >= 1000) {
                result = result + nums[left] * 10000L + nums[right];
            } else if (nums[right] >= 100) {
                result = result + nums[left] * 1000L + nums[right];
            } else if (nums[right] >= 10) {
                result = result + nums[left] * 100L + nums[right];
            } else {
                result = result + nums[left] * 10L + nums[right];
            }
            left++;
            right--;
        }
        if (left == right) {
            result += nums[left];
        }
        return result;
    }

}
