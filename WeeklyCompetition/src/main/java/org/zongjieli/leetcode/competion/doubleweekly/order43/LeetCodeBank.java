package org.zongjieli.leetcode.competion.doubleweekly.order43;
/**
 * 小明周一的时候在银行存入 1 元
 * 从周二至周日,每天都比前一天多存 1 元
 * 在接下来的每周一,都会比前一周周一多存 1 元
 * 给出一个 n,返回第 n 天结束的时候她在银行存了多少钱
 *
 * @author   Zongjie.Li
 * @date     2021/1/9
 * @version  1.0
 */
public class LeetCodeBank {
    public int totalMoney(int n){
        int week = n / 7;
        int day = n % 7;
        int money = 0;
        int weekMoney = 28;
        for (int i = 0;i < week ; i++){
            money += weekMoney;
            weekMoney += 7;
        }
        for (int i = 0 ; i < day ; i++){
            money += (++week);
        }
        return money;
    }


    public static void main(String[] args) {
        LeetCodeBank leetCodeBank = new LeetCodeBank();
        System.out.println(leetCodeBank.totalMoney(8));
    }
}
