package org.zongjieli.leetcode.question.daily.year2021.month12.week5;

import java.util.Arrays;

/**
 * 在社交媒体网站上有 n 个用户,给定一个整数数组 ages,其中 ages[i] 是第 i 个用户的年龄
 * 如果下述任意一个条件为真,那么用户 x 将不会向用户 y(x != y)发送好友请求:
 *  age[y] <= 0.5 * age[x] + 7
 *  age[y] > age[x]
 *  age[y] > 100 && age[x] < 100
 * 否则,x 将会向 y 发送一条好友请求
 *
 * 注意,如果 x 向 y 发送一条好友请求,y 不必也向 x 发送一条好友请求
 * 另外,用户不会向自己发送好友请求
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 *
 * n == ages.length
 * 1 <= n <= 2 * 10^4
 * 1 <= ages[i] <= 120
 *
 * @author   Li.zongjie
 * @date     2021/12/27
 * @version  1.0
 */
public class Z1FriendTimes {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int result = 0;
        for (int i = 0 ; i < ages.length ; i++){
            int half = (ages[i] >> 1) + 7;
            for (int j = i - 1 ; j >= 0 ; j--){
                if (ages[j] <= half){
                    break;
                }
                result++;
            }
            for (int j = i + 1; j < ages.length ; j++){
                if (ages[j] <= half || ages[j] > ages[i]){
                    break;
                }
                result++;
            }
        }
        return result;
    }
}
