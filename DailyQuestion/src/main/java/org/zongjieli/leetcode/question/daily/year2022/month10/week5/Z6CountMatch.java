package org.zongjieli.leetcode.question.daily.year2022.month10.week5;

import java.util.List;

/**
 * 给定一个数组 items,其中 items[i] = [typeI, colorI, nameI]
 * 描述第 i 件物品的类型、颜色以及名称
 * 另给定一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则
 * 如果第 i 件物品能满足下述条件之一,则认为该物品与给定的检索规则匹配:
 *  ruleKey == "type" 且 ruleValue == typeI
 *  ruleKey == "color" 且 ruleValue == colorI
 *  ruleKey == "name" 且 ruleValue == nameI
 * 统计并返回匹配检索规则的物品数量
 *
 * 1 <= items.length <= 10^4
 * 1 <= typeI.length, colorI.length, nameI.length, ruleValue.length <= 10
 * ruleKey 等于 "type"、"color" 或 "name"
 * 所有字符串仅由小写字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/10/31
 */
public class Z6CountMatch {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ruleIndex = "type".equals(ruleKey) ? 0 : "color".equals(ruleKey) ? 1 : 2;
        return (int) items.stream().filter(item -> item.get(ruleIndex).equals(ruleValue)).count();
    }
}
