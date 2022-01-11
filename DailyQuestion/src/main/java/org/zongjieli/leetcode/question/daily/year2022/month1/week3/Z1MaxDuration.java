package org.zongjieli.leetcode.question.daily.year2022.month1.week3;
/**
 * LeetCode 设计了一款新式键盘,正在测试其可用性
 * 测试人员将会点击一系列键(总计 n 个),每次一个
 *
 * 给定一个长度为 n 的字符串 keysPressed
 * 其中 keysPressed[i] 表示测试序列中第 i 个被按下的键
 * releaseTimes 是一个升序排列的列表,其中 releaseTimes[i] 表示松开第 i 个键的时间
 * 字符串和数组的下标都从 0 开始,第 0 个键在时间为 0 时被按下,接下来每个键都恰好在前一个键松开时被按下
 * 测试人员想要找出按键持续时间最长的键
 * 第 i 次按键的持续时间为 releaseTimes[i] - releaseTimes[i - 1]
 * 第 0 次按键的持续时间为 releaseTimes[0]
 * 注意,测试期间,同一个键可以在不同时刻被多次按下,而每次的持续时间都可能不同
 * 请返回单次按键持续时间最长的键,如果有多个这样的键,则返回按字母顺序排列最大的那个键
 *
 * releaseTimes.length == n
 * keysPressed.length == n
 * 2 <= n <= 1000
 * 1 <= releaseTimes[i] <= 10^9
 * releaseTimes[i] < releaseTimes[i+1]
 * keysPressed 仅由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2022/1/11
 * @version  1.0
 */
public class Z1MaxDuration {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char result = keysPressed.charAt(0);
        int resultTime = releaseTimes[0];
        int time;
        for (int i = 1 ; i < releaseTimes.length ; i++){
            time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > resultTime){
                resultTime = time;
                result = keysPressed.charAt(i);
            } else if (time == resultTime){
                char current = keysPressed.charAt(i);
                result = current > result ? current : result;
            }
        }
        return result;
    }
}
