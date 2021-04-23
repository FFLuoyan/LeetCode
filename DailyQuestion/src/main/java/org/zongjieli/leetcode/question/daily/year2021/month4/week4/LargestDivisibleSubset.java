package org.zongjieli.leetcode.question.daily.year2021.month4.week4;

import java.util.*;

/**
 * 给你一个由无重复正整数组成的集合 nums
 * 请你找出并返回其中最大的整除子集 answer
 * 子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 *   answer[i] % answer[j] == 0 或 answer[j] % answer[i] == 0
 * 如果存在多个有效解子集,返回其中任何一个均可
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 10^9
 *
 * @author   Zongjie.Li
 * @date     2021/4/23
 * @version  1.0
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        // 对于符合条件的 List,如果还想继续添加数据,则只需要满足,可以整除 List 中的最大数即可
        // 所以,在符合条件的 List 中,如果 List 中的最大数相等,则后续限制条件一致
        // 所以只需要保留一个最大长度的 List 即可(长度相同任意一条 List 均可)
        List<List<Integer>> results = new ArrayList<>(nums.length);

        for (int i = 0 ; i < nums.length ; i++){
            List<Integer> result = null;
            for (int j = i - 1 ; j >= 0 ; j--){
                List<Integer> temp = results.get(j);
                int lastNumber = temp.get(temp.size() - 1);
                if (nums[i] % lastNumber == 0){
                    result = result == null ? temp : (result.size() > temp.size() ? result : temp);
                }
            }
            if (result == null){
                result = new ArrayList<>();
            }
            List<Integer> addResult = new ArrayList<>(result);
            addResult.add(nums[i]);
            results.add(addResult);
        }
        List<Integer> result = results.get(0);
        for (List list : results){
            if (list.size() > result.size()){
                result = list;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        LargestDivisibleSubset test = new LargestDivisibleSubset();
        System.out.println(test.largestDivisibleSubset(new int[]{1,2,3}));
        System.out.println(test.largestDivisibleSubset(new int[]{5,9,18,54,108,540,90,180,360,720}));
    }

}
