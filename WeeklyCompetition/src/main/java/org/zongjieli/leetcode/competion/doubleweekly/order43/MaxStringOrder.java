package org.zongjieli.leetcode.competion.doubleweekly.order43;
/**
 * 给定一个字符串及两个数字 x,y
 * 删除字符串中的 "ab" 可以得到 x 分
 * 删除字符串中的 "ba" 可以得到 y 分
 * 返回对 s 字符串执行上述若干操作后的能得到的最大得分
 *
 * @author   Zongjie.Li
 * @date     2021/1/9
 * @version  1.0
 */
public class MaxStringOrder {

    public int maximumGain(String s,int x,int y){
        int score = 0;

        String bigger;
        String small;
        int bigScore;
        int smallScore;

        if (x > y){
            bigger = "ab";
            small = "ba";
            bigScore = x;
            smallScore = y;
        } else {
            bigger = "ba";
            small = "ab";
            bigScore = y;
            smallScore = x;
        }

        while (true){
            int length = s.length();
            int tempLength = length;
            s = s.replaceAll(bigger,"");
            while (tempLength != s.length()){
                tempLength = s.length();
                s = s.replaceAll(bigger,"");
            }

            int afterLength = s.length();
            if (length != afterLength){
                score += (length - afterLength) * bigScore / 2;
            }

            length = afterLength;
            s = s.replaceAll(small,"");
            afterLength = s.length();
            if (afterLength == length){
                break;
            } else {
                score += (length - afterLength) * smallScore / 2;
            }

        }

        return score;
    }

    public static void main(String[] args) {
        MaxStringOrder order = new MaxStringOrder();
        System.out.println(order.maximumGain("aabbaaxybbaabb",5,4));
    }

}
