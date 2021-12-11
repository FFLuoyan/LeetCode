package org.zongjieli.leetcode.question.daily.year2021.month12.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给定两个整数数组 persons 和 times
 * 在选举中,第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的
 * 对于发生在时刻 t 的每个查询
 * 需要找出在 t 时刻在选举中领先的候选人的编号
 * 在 t 时刻投出的选票也将被计入查询之中
 * 在平局的情况下,最近获得投票的候选人将会获胜
 *
 * 实现 Z6ElectionOnline 类:
 *
 *  Z6ElectionOnline(int[] persons, int[] times)
 *      使用 persons 和 times 数组初始化对象
 *  int q(int t)
 *      根据前面描述的规则,返回在时刻 t 在选举中领先的候选人的编号
 *  
 * 1 <= persons.length <= 5000
 * times.length == persons.length
 * 0 <= persons[i] < persons.length
 * 0 <= times[i] <= 10^9
 * times 是一个严格递增的有序数组
 * times[0] <= t <= 10^9
 * 每个测试用例最多调用 10^4 次 q
 *
 * @author   Li.zongjie
 * @date     2021/12/11
 * @version  1.0
 */
public class Z6ElectionOnline {

    private TreeMap<Integer, Integer> timeMaxPerson;

    public Z6ElectionOnline(int[] persons, int[] times) {
        timeMaxPerson = new TreeMap<>();
        Map<Integer, Integer> timePersonCount = new HashMap<>(2 * times.length);
        int lastTime = times[0];
        timeMaxPerson.put(lastTime, persons[0]);
        timePersonCount.put(persons[0], 1);
        for (int i = 1 ; i < times.length ; i++){
            int lastPerson = timeMaxPerson.get(lastTime);
            lastTime = times[i];
            int lastCount = timePersonCount.get(lastPerson);
            int currentPersonCount = timePersonCount.getOrDefault(persons[i], 0) + 1;
            timePersonCount.put(persons[i], currentPersonCount);
            timeMaxPerson.put(lastTime, currentPersonCount >= lastCount ? persons[i] : lastPerson);
        }
    }

    public int q(int t) {
        return timeMaxPerson.floorEntry(t).getValue();
    }

    public static void main(String[] args) {
        Z6ElectionOnline test = new Z6ElectionOnline(new int[]{0,1,1,0,0,1,0}, new int[]{0,5,10,15,20,25,30});
        // 0 1 1 0 0 1
        System.out.println(test.q(3));
        System.out.println(test.q(12));
        System.out.println(test.q(25));
        System.out.println(test.q(15));
        System.out.println(test.q(24));
        System.out.println(test.q(8));
    }
}
