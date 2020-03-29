package org.zongjieli.leetcode.competion.singleweekly.order182;

/**
 * @ClassName: CountTeams
 * @Description: 有 n 名士兵站成一排,每个士兵都有自己独一无二的评分
 * 每 3 名士兵可以组成一个作战单位
 * 作战单位的要求 i < j < k
 * 同时他们的评分要递增或者递减
 * 请计算可以组件的最大单位数量
 * 每个士兵可以是多个作战单位的一部分
 * @Author: Zongjie.Li
 * @Date: 2020/3/29
 * @Version: 1.0
 **/
public class CountTeams {
    public int numTeams(int[] rating) {
        int count = 0;
        for (int firstNumber = 0; firstNumber < rating.length; firstNumber++) {
            for (int secondNumber = firstNumber + 1; secondNumber < rating.length; secondNumber++) {
                boolean isIncrease = rating[secondNumber] > rating[firstNumber];
                for (int thirdNumber = secondNumber + 1; thirdNumber < rating.length; thirdNumber++) {
                    if ((isIncrease && rating[thirdNumber] > rating[secondNumber]) || (!isIncrease && rating[thirdNumber] < rating[secondNumber])) {
                        // 如果是递增而且第三个数大于第二个数 或者递减且第三个数小于第二个数
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountTeams countTeams = new CountTeams();
        System.out.println(countTeams.numTeams(new int[]{1,2,3,4,5}));
    }
}
