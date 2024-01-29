package org.zongjieli.leetcode.question.daily.year2024.month1.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电子游戏 "辐射 4" 中
 * 任务 "通向自由" 要求玩家到达名为 "Freedom Trail Ring" 的金属表盘
 * 并使用表盘拼写特定关键词才能开门
 * 给定一个字符串 ring,表示刻在外环上的编码
 * 给定另一个字符串 key,表示需要拼写的关键词
 * 需要算出能够拼写关键词中所有字符的最少步数
 * 最初,ring 的第一个字符与 12:00 方向对齐
 * 需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐
 * 然后按下中心按钮,以此逐个拼写完 key 中的所有字符
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中
 *  可以将 ring 顺时针或逆时针旋转一个位置,计为 1 步
 *      旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐
 *      并且这个字符必须等于字符 key[i]
 *  如果字符 key[i] 已经对齐到 12:00 方向
 *  需要按下中心按钮进行拼写,这也将算作 1 步
 *  按完之后,可以开始拼写 key 的下一个字符 (下一阶段) 直至完成所有拼写
 *
 * 1 <= ring.length, key.length <= 100
 * ring 和 key 只包含小写英文字母
 * 保证字符串 key 一定可以由字符串 ring 旋转拼出
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/29
 */
public class Z1FreedomRoad {

    public int findRotateSteps(String ring, String key) {
        // 维护每一个位置到对应的 26 个字符的所有可能方案
        char[] ringValues = ring.toCharArray(), keyChars = key.toCharArray();
        List<Integer>[] charIndexes = new List[26];
        for (int i = 0; i < ringValues.length; i++) {
            if (charIndexes[ringValues[i] - 'a'] == null) {
                charIndexes[ringValues[i] - 'a'] = new ArrayList<>();
            }
            charIndexes[ringValues[i] - 'a'].add(i);
        }
        Map<Integer, Integer> positionCount = new HashMap<>(), next;
        positionCount.put(0, 0);
        for (char need : keyChars) {
            next = new HashMap<>();
            for (Integer charIndex : charIndexes[need - 'a']) {
                int minCount = Integer.MAX_VALUE, left, right, temp;
                for (Map.Entry<Integer, Integer> entry : positionCount.entrySet()) {
                    left = charIndex;
                    right = entry.getKey();
                    if (left > right) {
                        temp = left;
                        left = right;
                        right = temp;
                    }
                    minCount = Math.min(minCount, Math.min(right - left, left + ringValues.length - right) + 1 + entry.getValue());
                }
                next.put(charIndex, minCount);
            }
            positionCount = next;
        }
        int result = Integer.MAX_VALUE;
        for (Integer value : positionCount.values()) {
            result = Math.min(result, value);
        }
        return result;
    }

    public static void main(String[] args) {
        Z1FreedomRoad test = new Z1FreedomRoad();
        // 4
//        System.out.println(test.findRotateSteps("godding", "gd"));
        // 13
        System.out.println(test.findRotateSteps("pqwcx", "cpqwx"));
    }

}
