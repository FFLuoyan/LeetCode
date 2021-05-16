package org.zongjieli.leetcode.competion.singleweekly.order241;
/**
 * 给一个二进制字符串 s
 * 现需要将其转化为一个交替字符串
 * 请计算并返回转化所需的最小字符交换次数
 * 如果无法完成转化,返回 -1
 *
 * 交替字符串是指:相邻字符之间不存在相等情况的字符串
 * 例如,字符串 "010" 和 "1010" 属于交替字符串
 * 但 "0100" 不是
 *
 * 任意两个字符都可以进行交换,不必相邻
 *
 * 1 <= s.length <= 1000
 * s[i] 的值为 '0' 或 '1'
 *
 * @author   Zongjie.Li
 * @date     2021/5/16
 * @version  1.0
 */
public class MinExchange {
    public int minSwaps(String s) {
        // 单数,相差 1 可以
        // 双数必须相等
        int length = s.length();
        if ((length & 1) == 1){
            // 单数
            int oneCount = 0;
            int onePosition = 0;
            for (int i = 0 ; i < length ; i++){
                char value = s.charAt(i);
                if (value == '1'){
                    oneCount++;
                    if ((i & 1) == 0){
                        onePosition++;
                    }
                }
            }
            if (oneCount == (length / 2) + 1){
                return oneCount - onePosition;
            } else if (oneCount == (length / 2)){
                return onePosition;
            } else {
                return -1;
            }
        } else {
            // 双数
            int oneCount = 0;
            int onePosition = 0;
            for (int i = 0 ; i < length ; i++){
                char value = s.charAt(i);
                if (value == '1'){
                    oneCount++;
                    if ((i & 1) == 0){
                        onePosition++;
                    }
                }
            }
            if (oneCount == length / 2){
                return Math.min(onePosition,oneCount - onePosition);
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        MinExchange test = new MinExchange();
        System.out.println(test.minSwaps("1"));
    }
}
