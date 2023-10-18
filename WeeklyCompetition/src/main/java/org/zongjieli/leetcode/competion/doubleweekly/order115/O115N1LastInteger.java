package org.zongjieli.leetcode.competion.doubleweekly.order115;

import java.util.*;

/**
 * 给定一个下标从 0 开始的字符串数组 words
 * 其中 words[i] 要么是一个字符串形式的正整数,要么是字符串 "prev"
 * 从数组的开头开始遍历,对于 words 中的每个 "prev" 字符串,找到 words 中的上一个遍历的整数,定义如下:
 *  k 表示到当前位置为止的连续 "prev" 字符串数目(包含当前字符串)
 *  令下标从 0 开始的整数数组 nums 表示目前为止遍历过的所有整数
 *  同时用 nums_reverse 表示 nums 反转得到的数组
 *  那么当前 "prev" 对应的上一个遍历的整数是 nums_reverse 数组中下标为 (k - 1) 的整数
 *  如果 k 比目前为止遍历过的整数数目更多,那么上一个遍历的整数为 -1
 * 请返回一个整数数组,包含所有上一个遍历的整数
 *
 * 1 <= words.length <= 100
 * words[i] == "prev" 或 1 <= int(words[i]) <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/14
 */
public class O115N1LastInteger {

    public List<Integer> lastVisitedIntegers(List<String> words) {
        int[] nums = new int[101];
        int index = 0, preCount = 0;
        List<Integer> values = new ArrayList<>();
        for (String word : words) {
            if (word.equals("prev")) {
                preCount++;
                if (preCount > index) {
                    values.add(-1);
                } else {
                    values.add(nums[index - preCount]);
                }
            } else {
                nums[index++] = Integer.parseInt(word);
                preCount = 0;
            }
        }
        return values;
    }

}
