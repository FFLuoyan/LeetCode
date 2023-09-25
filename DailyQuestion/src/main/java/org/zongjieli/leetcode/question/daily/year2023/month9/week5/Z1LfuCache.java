package org.zongjieli.leetcode.question.daily.year2023.month9.week5;

import java.util.TreeSet;

/**
 * 请你为最不经常使用(LFU)缓存算法设计并实现数据结构
 * 实现 Z1LfuCache 类:
 *  Z1LfuCache(int capacity):
 *      用数据结构的容量 capacity 初始化对象
 *  int get(int key):
 *      如果键 key 存在于缓存中,则获取键的值,否则返回 -1
 *  void put(int key, int value):
 *      如果键 key 已存在,则变更其值,如果键不存在,请插入键值对
 *      当缓存达到其容量 capacity 时,则应该在插入新项之前,移除最不经常使用的项
 *      在此问题中,当存在平局(即两个或更多个键具有相同使用频率)时,应该去除最近最久未使用的键
 * 为了确定最不常使用的键,可以为缓存中的每个键维护一个使用计数器,使用计数最小的键是最久未使用的键
 * 当一个键首次插入到缓存中时,它的使用计数器被设置为 1(由于 put 操作)
 * 对缓存中的键执行 get 或 put 操作,使用计数器的值将会递增
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行
 *
 * 1 <= capacity <= 10^4
 * 0 <= key <= 10^5
 * 0 <= value <= 10^9
 * 最多调用 2 * 10^5 次 get 和 put 方法
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/25
 */
public class Z1LfuCache {

    int size = 0;

    int operate = 0;

    int capacity;

    Cache[] values = new Cache[100000];

    TreeSet<Cache> valueSorted = new TreeSet<>((a, b) -> a.frequency == b.frequency ? Integer.compare(a.operate, b.operate) : Integer.compare(a.frequency, b.frequency));

    class Cache {

        int key;

        int value;

        int frequency = 1;

        int operate;

        Cache(int key, int value, int operate) {
            this.key = key;
            this.value = value;
            this.operate = operate;
        }
    }

    public Z1LfuCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Cache get = values[key];
        if (get == null) {
            return -1;
        }
        valueSorted.remove(get);
        get.frequency++;
        get.operate = operate++;
        valueSorted.add(get);
        return get.value;
    }

    public void put(int key, int value) {
        Cache cache = values[key];
        if (cache != null) {
            valueSorted.remove(cache);
            cache.value = value;
            cache.frequency++;
            cache.operate = operate++;
            valueSorted.add(cache);
        } else if (valueSorted.size() < capacity) {
            cache = new Cache(key, value, operate++);
            values[key] = cache;
            valueSorted.add(cache);
        } else {
            cache = valueSorted.pollFirst();
            values[cache.key] = null;
            cache = new Cache(key, value, operate++);
            values[key] = cache;
            valueSorted.add(cache);
        }
    }


    public static void main(String[] args) {
        Z1LfuCache test;
        test = new Z1LfuCache(2);
        test.put(1, 1); test.put(2, 2);
        // 1
        System.out.println(test.get(1));
        test.put(3, 3);
        // -1
        System.out.println(test.get(2));
        // 3
        System.out.println(test.get(3));
        test.put(4, 4);
        // -1
        System.out.println(test.get(1));
        // 3
        System.out.println(test.get(3));
        // 4
        System.out.println(test.get(4));
    }
}
