package org.zongjieli.leetcode.primaryalgorithm.dynamicplanning;

/**
 * @ClassName: MaxProfit
 * @Description: 股票买卖的最佳时机(只能买一次)
 * @Author: Zongjie.Li
 * @Date: 2020/3/14
 * @Version: 1.0
 **/
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] nums = new int[]{3,5,8,4,5,2,16,9,8,7,1,15};
        System.out.println(maxProfit.maxProfit(nums));
    }


    public int maxProfit(int[] prices){
        if (prices.length < 2){
            return  0;
        }
        int profit = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 1;i<prices.length ;i++){
            if (prices[i] < min){
                min = prices[i];
                max = min + profit;
            } else if (prices[i] > max){
                max = prices[i];
                profit = max - min;
            }
        }
        return profit;
    }
}
