package org.zongjieli.leetcode.question.daily.year2021.month3.week4;
/**
 * 给定一个整数序列:a1,a2,a3,...,an
 * 一个 132 模式的子序列被定义为当 i < j < k 时,ai < ak < aj
 * 设计一个算法,当给定 n 个数字的序列时,验证这个序列中是否含有 132 模式的子序列
 *
 *
 * @author   Zongjie.Li
 * @date     2021/3/24
 * @version  1.0
 */
public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        int[] mines = new int[nums.length];
        int[] maxes = new int[nums.length];
        mines[0] = nums[0];
        maxes[0] = nums[0];
        int index = 1;
        for (int n : nums){
            int minMin = mines[0];
            for (int i = 0 ; i < index ; i++){
                if (mines[i] < minMin){
                    minMin = mines[i];
                }
                if (mines[i] < n ){
                    if (maxes[i] > n){
                        return true;
                    } else {
                        maxes[i] = n;
                    }
                }
            }
            if (n < minMin){
                mines[index] = n;
                maxes[index++] = n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Find132Pattern pattern = new Find132Pattern();
        System.out.println(pattern.find132pattern(new int[]{1,4,0,-3,-1,-2}));
    }
}
