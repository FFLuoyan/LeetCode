package array;

/**
 * @ClassName: StockTrading
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/21
 * @Version: 1.0
 **/
public class StockTrading {
    public static int maxProfit(int[] prices){
        if (prices.length < 2){
            return 0;
        }
        int profit = 0;
        for (int index = 1;index < prices.length ; index++){
            if (prices[index] > prices[index -1]){
                profit += prices[index] - prices[index -1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,5,7,4,6,2,8,9,6};
        System.out.println(maxProfit(prices));
    }
}
