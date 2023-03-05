package org.zongjieli.leetcode.question.daily.year2023.month2.week5;

/**
 * 正在经营一座摩天轮,该摩天轮共有 4 个座舱,每个座舱最多可以容纳 4 位游客
 * 可以逆时针轮转座舱,但每次轮转都需要支付一定的运行成本 runningCost
 * 摩天轮每次轮转都恰好转动 1 / 4 周
 * 给定一个长度为 n 的数组 customers
 * customers[i] 是在第 i 次轮转(下标从 0 开始)之前到达的新游客的数量
 * 这也意味着必须在新游客到来前轮转 i 次
 * 每位游客在登上离地面最近的座舱前都会支付登舱成本 boardingCost
 * 一旦该座舱再次抵达地面,他们就会离开座舱结束游玩
 * 可以随时停下摩天轮,即便是在服务所有游客之前
 * 如果决定停止运营摩天轮,为了保证所有游客安全着陆,将免费进行所有后续轮转
 * 注意,如果有超过 4 位游客在等摩天轮,那么只有 4 位游客可以登上摩天轮
 * 其余的需要等待下一次轮转
 * 返回最大化利润所需执行的最小轮转次数
 * 如果不存在利润为正的方案,则返回 -1
 *
 * n == customers.length
 * 1 <= n <= 10^5
 * 0 <= customers[i] <= 50
 * 1 <= boardingCost, runningCost <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/5
 */
public class Z7MaxProfit {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int max = 0, currentProfit = 0, wait = 0, result = -1, currentTime = 0;
        for (int customer : customers) {
            wait += customer;
            if (wait >= 4) {
                wait -= 4;
                currentProfit += 4 * boardingCost;
            } else {
                currentProfit += wait * boardingCost;
                wait = 0;
            }
            currentProfit -= runningCost;
            ++currentTime;
            if (currentProfit > max) {
                max = currentProfit;
                result = currentTime;
            }
        }
        while (wait > 0) {
            if (wait >= 4) {
                wait -= 4;
                currentProfit += 4 * boardingCost;
            } else {
                currentProfit += wait * boardingCost;
                wait = 0;
            }
            currentProfit -= runningCost;
            ++currentTime;
            if (currentProfit > max) {
                max = currentProfit;
                result = currentTime;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z7MaxProfit test = new Z7MaxProfit();
        // 3
        System.out.println(test.minOperationsMaxProfit(new int[]{8, 3}, 5, 6));
        // 3
        System.out.println(test.minOperationsMaxProfit(new int[]{1, 0, 3}, 61, 55));
    }

}
