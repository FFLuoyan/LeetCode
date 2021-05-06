package org.zongjieli.leetcode.question.daily.year2021.month4.week5;

import java.util.*;

/**
 * 一只青蛙想要过河
 * 假定河流被等分为若干个单元格并且在每一个单元格内都有可能放有一块石子(也有可能没有)
 * 青蛙可以跳上石子,但是不可以跳入水中
 * 给你石子的位置列表 stones(用单元格序号升序表示)
 * 请判定青蛙能否成功过河(即能否在最后一步跳至最后一块石子上)
 *
 * 开始时,青蛙默认已站在第一块石子上
 * 并可以假定它第一步只能跳跃一个单位(即只能从单元格 1 跳至单元格 2)
 * 如果青蛙上一步跳跃了 k 个单位,那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位
 * 另请注意,青蛙只能向前方(终点的方向)跳跃
 *
 * 2 <= stones.length <= 2000
 * 0 <= stones[i] <= 2^31 - 1
 * stones[0] == 0
 *
 * @author   Zongjie.Li
 * @date     2021/4/29
 * @version  1.0
 */
public class FrogCrossRiver {
    public boolean canCross(int[] stones) {
        TreeMap<Integer,HashSet<Integer>> stonesStep = new TreeMap<>();
        for (int stone : stones) {
            stonesStep.put(stone,new HashSet<>());
        }
        HashSet<Integer> firstStone = stonesStep.get(1);
        if (firstStone == null){
            return false;
        }
        firstStone.add(1);
        int lastStone = stones[stones.length - 1];
        for (int i = 1; i < stones.length; i++) {
            int stone = stones[i];
            HashSet<Integer> currentStep = stonesStep.get(stone);
            currentStep.forEach(step -> {
                for (int j = step + 1 ; j > Math.max(0,step - 2) ; j--){
                    HashSet<Integer> steps = stonesStep.get(stone + j);
                    if (steps != null){
                        steps.add(j);
                    }
                }
            });
            if (!stonesStep.get(lastStone).isEmpty()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FrogCrossRiver test = new FrogCrossRiver();
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println(test.canCross(a));
        System.out.println(test.canCross(new int[]{0,1,3,6,10,15,16,21}));
        System.out.println(test.canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(test.canCross(new int[]{0,1,3,6,7}));
        System.out.println(test.canCross(new int[]{0,2}));
    }
}
