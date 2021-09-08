package org.zongjieli.leetcode.question.daily.year2021.month9.week1;

import java.util.Random;

/**
 * 已有方法 rand7() 可生成 1 到 7 范围内的均匀随机整数
 * 试写一个方法 rand10() 生成 1 到 10 范围内的均匀随机整数
 *
 * 不要使用系统的 Math.random() 方法。
 *
 * @author   Li.zongjie
 * @date     2021/9/6
 * @version  1.0
 */
public class Z7Rand7ToRand10 {
    public int rand10() {
        int base = 7;
        int value = rand7();
        while (true){
            int allValue = 7 * base;
            base = allValue % 10;
            int returnValue = allValue - base;

            int temp = 7 * (value - 1) + rand7();
            value = temp % 10;
            if (temp <= returnValue){
                return value == 0 ? 10 : value;
            }

        }
    }


    public int rand7(){
        return new Random().nextInt(7);
    }
}
