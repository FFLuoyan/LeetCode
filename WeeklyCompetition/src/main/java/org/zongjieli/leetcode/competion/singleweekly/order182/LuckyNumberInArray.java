package org.zongjieli.leetcode.competion.singleweekly.order182;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName: LuckyNumberInArray
 * @Description: 在整数数组中,如果一个整数的出现频次和数值大小相等,就称这个整数为幸运数
 *              返回这个幸运数,如果存在多个幸运数,则返回最大的那个
 *              如果不含幸运数,则返回 - 1
 * @Author: Zongjie.Li
 * @Date: 2020/3/29
 * @Version: 1.0
 **/
public class LuckyNumberInArray {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int number : arr){
            Integer numberTimes = countMap.get(number);
            if (numberTimes != null){
                countMap.put(number,numberTimes + 1);
            } else {
                countMap.put(number,1);
            }
        }
        int lucky = -1;
        Iterator<Map.Entry<Integer,Integer>> countIterator = countMap.entrySet().iterator();
        while (countIterator.hasNext()){
            Map.Entry<Integer,Integer> valueEntity = countIterator.next();
            if (valueEntity.getKey().equals(valueEntity.getValue())){
                lucky = lucky > valueEntity.getKey() ? lucky : valueEntity.getKey();
            }
        }
        return lucky;
    }

    public static void main(String[] args) {
        LuckyNumberInArray luckyNumberInArray = new LuckyNumberInArray();
        System.out.println(luckyNumberInArray.findLucky(null));
    }
}
