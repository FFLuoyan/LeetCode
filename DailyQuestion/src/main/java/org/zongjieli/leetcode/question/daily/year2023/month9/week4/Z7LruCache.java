package org.zongjieli.leetcode.question.daily.year2023.month9.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * 请设计并实现一个满足 LRU(最近最少使用)缓存约束的数据结构
 * 实现 LRUCache 类:
 *  LRUCache(int capacity):
 *      以正整数作为容量 capacity 初始化 LRU 缓存
 *  int get(int key):
 *      如果关键字 key 存在于缓存中,则返回关键字的值,否则返回 -1
 *  void put(int key, int value):
 *      如果关键字 key 已经存在,则变更其数据值 value
 *      如果不存在,则向缓存中插入该组 key-value
 *      如果插入操作导致关键字数量超过 capacity,则应该逐出最久未使用的关键字
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 10^5
 * 最多调用 2 * 10^5 次 get 和 put
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/24
 */
public class Z7LruCache {

    int capacity;

    Map<Integer, Cache> cacheMap;

    Cache nextFirst = new Cache(0, -1, null, null);
    Cache beforeLast = new Cache(0, -1, null, null);

    class Cache {

        int key;

        int value;

        Cache before;

        Cache next;

        Cache(int key, int value, Cache before, Cache next) {
            this.key = key;
            this.value = value;
            this.before = before;
            this.next = next;
        }
    }

    public Z7LruCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
        nextFirst.next = beforeLast;
        beforeLast.before = nextFirst;
    }

    public int get(int key) {
        Cache current = cacheMap.get(key);
        if (current == null) {
            return -1;
        }
        Cache last = beforeLast.before;
        if (current != last) {
            Cache before = current.before;
            Cache next = current.next;
            before.next = next;
            next.before = before;
            current.before = last;
            current.next = beforeLast;
            last.next = current;
            beforeLast.before = current;
        }
        return current.value;
    }

    public void put(int key, int value) {
        Cache current = cacheMap.get(key);
        Cache last = beforeLast.before;
        if (current != null) {
            current.value = value;
            if (current == last) {
                return;
            }
            Cache before = current.before;
            Cache next = current.next;
            before.next = next;
            next.before = before;
            current.before = last;
            current.next = beforeLast;
            last.next = current;
            beforeLast.before = current;
        } else {
            current = new Cache(key, value, last, beforeLast);
            cacheMap.put(key, current);
            last.next = current;
            beforeLast.before = current;
            if (cacheMap.size() > capacity) {
                Cache first = nextFirst.next;
                nextFirst.next = first.next;
                first.next.before = nextFirst;
                cacheMap.remove(first.key);
            }
        }
    }

    public static void main(String[] args) {
        Z7LruCache test;
        test = new Z7LruCache(2);
        test.put(1, 1); test.put(2, 2);
        // 1
        System.out.println(test.get(1));
        test.put(3, 3);
        // -1
        System.out.println(test.get(2));
        test.put(4, 4);
        // -1
        System.out.println(test.get(1));
        // 3
        System.out.println(test.get(3));
        // 4
        System.out.println(test.get(4));

        test = new Z7LruCache(1);
        test.put(2, 1);
        // 1
        System.out.println(test.get(2));
        test.put(3, 2);
        // -1
        System.out.println(test.get(2));
        // 2
        System.out.println(test.get(3));
    }
}
