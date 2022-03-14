package org.zongjieli.leetcode.question.daily.year2022.month3.week3;

import java.util.*;

/**
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅
 * 并且他们都有一个表示最喜爱餐厅的列表,每个餐厅的名字用字符串表示
 * 现在需要帮助他们用最少的索引和找出他们共同喜爱的餐厅
 * 如果答案不止一个,则输出所有答案并且不考虑顺序,可以假设答案总是存在
 *
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30 
 * list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成
 * list1 的所有字符串都是唯一的
 * list2 中的所有字符串都是唯一的
 *
 * @author   Li.zongjie
 * @date     2022/3/14
 * @version  1.0
 */
public class Z1ListIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> save = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            save.put(list1[i], i);
        }
        List<String> result = new ArrayList<>();
        int max = list1.length + list2.length;
        for (int i = 0; i < list2.length && i <= max; i++) {
            String current = list2[i];
            if (!save.containsKey(current)) {
                continue;
            }
            int sum = save.get(current) + i;
            if (sum > max) {
                continue;
            }
            if (sum < max) {
                max = sum;
                result.clear();
            }
            result.add(current);
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Z1ListIndexSum test = new Z1ListIndexSum();
        System.out.println(Arrays.toString(test.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
    }
}
