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
        HashMap<Integer, List<Integer>> nextStoneStep = new HashMap<>();
        List<Integer> firstStep = new ArrayList<>();
        firstStep.add(1);
        nextStoneStep.put(1,firstStep);
        for (int stoneIndex = 1 ; stoneIndex < stones.length ; stoneIndex++){
            int nextStone = stones[stoneIndex];
            List<Integer> stoneStep = nextStoneStep.get(nextStone);
            if (stoneStep != null && !stoneStep.isEmpty()){
                for (int step : stoneStep) {
                    for (int addStep = step + 1; addStep >= step - 1 && addStep > 0; addStep--) {
                        int canStone = nextStone + addStep;
                        List<Integer> saveStoneStep = nextStoneStep.computeIfAbsent(canStone, k -> new ArrayList<>());
                        if (!saveStoneStep.contains(addStep)){
                            saveStoneStep.add(addStep);
                        }
                    }
                }
            }
            nextStoneStep.entrySet().removeIf(entry -> entry.getKey() < nextStone);
        }
        return nextStoneStep.get(stones[stones.length - 1]) != null;
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
