package org.zongjieli.leetcode.competion.singleweekly.order257;

import java.nio.file.Watchable;
import java.util.Map;
import java.util.TreeMap;

/**
 * 你正在参加一个多角色游戏,每个角色都有两个主要属性：攻击 和 防御
 * 给你一个二维整数数组 properties,其中 properties[i] = [attackI, defenseI]
 * 表示游戏中第 i 个角色的属性
 *
 * 如果存在一个其他角色的攻击和防御等级都严格高于该角色的攻击和防御等级
 * 则认为该角色为弱角色,更正式地,如果认为角色 i 弱于存在的另一个角色 j
 * 那么 attackJ > attackI 且 defenseJ > defenseI
 *
 * 返回弱角色的数量
 *
 * 2 <= properties.length <= 10^5
 * properties[i].length == 2
 * 1 <= attackI, defenseI <= 10^5
 *
 * @author   Li.zongjie
 * @date     2021/9/5
 * @version  1.0
 */
public class WeakRole {
    public int numberOfWeakCharacters(int[][] properties) {
        TreeMap<Integer,Integer> attackMaxDefense = new TreeMap<>();
        for (int[] property : properties) {
            int attack = property[0];
            int defence = property[1];

            if (attack == 1 || defence == 1){
                continue;
            }

            Map.Entry<Integer,Integer> attackEntry = attackMaxDefense.ceilingEntry(attack);
            if (attackEntry != null && attackEntry.getValue() >= defence){
                continue;
            }

            Integer attackKey = attack;
            attackMaxDefense.put(attackKey,defence);
            while ((attackKey = attackMaxDefense.lowerKey(attackKey)) != null){
                int defenceValue = attackMaxDefense.get(attackKey);
                if (defenceValue > defence){
                    break;
                }
                attackMaxDefense.remove(attackKey);
            }

        }

        int result = 0;
        for (int[] property : properties) {
            Map.Entry<Integer,Integer> role = attackMaxDefense.higherEntry(property[0]);
            if (role != null && role.getValue() > property[1]){
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        WeakRole test = new WeakRole();
        System.out.println(test.numberOfWeakCharacters(new int[][]{new int[]{5,5},new int[]{6,3},new int[]{3,6}})); // 0
        System.out.println(test.numberOfWeakCharacters(new int[][]{new int[]{1,5},new int[]{10,4},new int[]{4,3}}));// 1
        System.out.println(test.numberOfWeakCharacters(new int[][]{new int[]{2,2},new int[]{3,3}})); // 1
        System.out.println(test.numberOfWeakCharacters(new int[][]{new int[]{7,9},new int[]{10,7},new int[]{6,9},new int[]{10,4},new int[]{7,5},new int[]{7,10}})); // 2
        System.out.println(test.numberOfWeakCharacters(new int[][]{new int[]{10,1},new int[]{5,1},new int[]{7,10},new int[]{4,1},new int[]{5,9},new int[]{6,9},new int[]{7,2},new int[]{1,10}})); // 4
        System.out.println(test.numberOfWeakCharacters(new int[][]{new int[]{1,7},new int[]{1,7},new int[]{7,5},new int[]{9,6},new int[]{10,10},new int[]{10,6},new int[]{4,5},new int[]{9,5}})); // 6
    }
}
