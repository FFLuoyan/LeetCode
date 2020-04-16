package org.zongjieli.leetcode.algorthm.intermediate.arrayandstring;

/**
 * @ClassName: MaxLengthOfNoRepeatSubstring
 * @Description: 给定一个字符串,找出不含有重复字符串的最长子串的长度
 * @Author: Zongjie.Li
 * @Date: 2020/4/16
 * @Version: 1.0
 **/
public class MaxLengthOfNoRepeatSubstring {
    public int lengthOfLongestSubstring(String s) {
        boolean[] numberValue = new boolean[128];
        int maxLength = 0;
        int nowLength = 0;
        int startStringIndex = 0;
        for (int i = 0 ; i < s.length() ; i++){
            nowLength ++;
            // 对于每一个字符,进行重复性判断
            int value = s.charAt(i);
            // 获取字符在数值表中的下标
            if (numberValue[value]){
                // 如果该字符已经存在了,则从当前连续的字符串中进行查找
                // 直到查找出来了重复的字符
                // 开始下一轮重复数据的积累
                for (int j = startStringIndex ; j < i ; j ++){
                    int startValue = s.charAt(j);
                    // 获取开始字符在数值映射表中的下标
                    // 每比较一次,当前循环的无重复子串的长度都会减少
                    nowLength --;
                    startStringIndex ++;
                    numberValue[startValue] = false;
                    if (value == startValue){
                        // 如果两个值相等,说明此位置的值重复了
                        // 结束循环,开始下一轮的计数
                        numberValue[value] = true;
                        break;
                    }
                }
            } else {
                numberValue[value] = true;
                maxLength = nowLength > maxLength ? nowLength : maxLength;
            }
        }
        return maxLength;
    }
}
