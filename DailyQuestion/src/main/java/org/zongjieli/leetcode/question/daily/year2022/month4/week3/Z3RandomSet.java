package org.zongjieli.leetcode.question.daily.year2022.month4.week3;

import java.util.*;

/**
 * 实现 RandomizedSet 类:
 *  RandomizedSet()
 *      初始化 RandomizedSet 对象
 *  bool insert(int val)
 *      当元素 val 不存在时,向集合中插入该项,并返回 true,否则返回 false
 *  bool remove(int val)
 *      当元素 val 存在时,从集合中移除该项,并返回 true,否则返回 false
 *  int getRandom()
 *      随机返回现有集合中的一项(测试用例保证调用此方法时集合中至少存在一个元素)
 *      每个元素应该有相同的概率被返回
 *
 * 实现类的所有函数,并满足每个函数的平均时间复杂度为 O(1)
 *
 * -2^31 <= val <= 2^31 - 1
 * 最多调用 insert、remove 和 getRandom 函数 2 * 10^5 次
 * 在调用 getRandom 方法时,数据结构中至少存在一个 元素
 *
 * @author   Li.zongjie
 * @date     2022/4/13
 * @version  1.0
 */
public class Z3RandomSet {

    private int[] randomValues = new int[8];
    private Map<Integer, Integer> values = new HashMap<>();

    public Z3RandomSet() { }

    public boolean insert(int val) {
        if (values.containsKey(val)) {
            return false;
        }
        int nextIndex = values.size();
        values.put(val, nextIndex);
        if (nextIndex == randomValues.length) {
            int[] newRandomValues = new int[2 * nextIndex];
            System.arraycopy(randomValues, 0, newRandomValues, 0, nextIndex);
            randomValues = newRandomValues;
        }
        randomValues[nextIndex] = val;
        return true;
    }

    public boolean remove(int val) {
        Integer vi = values.get(val);
        if (vi == null) {
            return false;
        }
        values.remove(val);
        int length = values.size();
        if (vi == length) {
            return true;
        }
        randomValues[vi] = randomValues[length];
        values.put(randomValues[length], vi);
        return true;
    }

    public int getRandom() {
        return randomValues[new Random().nextInt(values.size())];
    }

    public static void main(String[] args) {
        Z3RandomSet test = new Z3RandomSet();
        test.insert(0);
        test.insert(1);
        test.remove(0);
        test.insert(2);
        test.remove(1);
        // 2
        System.out.println(test.getRandom());
    }
}
