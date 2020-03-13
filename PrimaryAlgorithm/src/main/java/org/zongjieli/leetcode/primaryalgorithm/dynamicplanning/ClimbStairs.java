package org.zongjieli.leetcode.primaryalgorithm.dynamicplanning;

/**
 * @ClassName: ClimbStairs
 * @Description: 爬楼梯,每次可以爬一格或者两格,总共爬n层有多少种爬法
 * @Author: Zongjie.Li
 * @Date: 2020/3/13
 * @Version: 1.0
 **/
public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(4));
    }

    public int climbStairs(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int level = 2;
        int first = 1;
        int second = 2;
        int num = 3;
        while (level ++ < n){
            num = first + second;
            first = second;
            second = num;
        }
        return num;
    }
}
