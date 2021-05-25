package org.zongjieli.leetcode.competion.singleweekly.order242;

/**
 * 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump
 * 一开始在下标 0 处,且该位置的值一定为 '0'
 * 当同时满足如下条件时,你可以从下标 i 移动到下标 j 处
 *
 *  i + minJump <= j <= min(i + maxJump, s.length - 1) 且
 *  s[j] == '0'.
 *
 * 如果你可以到达 s 的下标 s.length - 1 处
 * 请你返回 true
 * 否则返回 false
 *
 * 2 <= s.length <= 10^5
 * s[i] 要么是 '0' ，要么是 '1'
 * s[0] == '0'
 * 1 <= minJump <= maxJump < s.length
 *
 * @author   Zongjie.Li
 * @date     2021/5/23
 * @version  1.0
 */
public class DumpGame {

    public boolean canReach(String s, int minJump, int maxJump) {
        char[] sChar = s.toCharArray();
        int sLength = sChar.length;
        int lastIndex = sLength - 1;
        if (sChar[lastIndex] == '1'){
            return false;
        }
        boolean[] canReach = new boolean[sLength];
        canReach[0] = true;
        int current = 0;
        int minIndex;
        int maxIndex = 0;
        while (current <= maxIndex){
            if (!canReach[current]){
                current++;
                continue;
            }
            minIndex = current + minJump;
            int startIndex = minIndex > maxIndex ? minIndex : maxIndex + 1;
            if (startIndex > lastIndex){
                current++;
                continue;
            }
            maxIndex = current + maxJump;
            if (maxIndex >= lastIndex){
                return true;
            }
            for (int i = startIndex ; i <= maxIndex ; i++){
                canReach[i] = sChar[i] == '0';
            }
            current++;
        }
        return false;
    }

    public static void main(String[] args) {
        DumpGame test = new DumpGame();
        StringBuilder maxS = new StringBuilder();
        for (int i = 0 ; i < 50000 ; i++){
            maxS.append("0");
        }
        for (int i = 0 ; i < 49999 ; i++){
            maxS.append("1");
        }
        System.out.println(test.canReach("011010",2,3));
        System.out.println(test.canReach("00111010",3,5));
        System.out.println(test.canReach(maxS.toString() + "0",1,49999));
    }
}
