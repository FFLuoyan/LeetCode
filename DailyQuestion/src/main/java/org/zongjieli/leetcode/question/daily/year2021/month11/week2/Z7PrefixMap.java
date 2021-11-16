package org.zongjieli.leetcode.question.daily.year2021.month11.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现一个 MapSum 类,支持两个方法,insert 和 sum
 *  MapSum()
 *      初始化 MapSum 对象
 *  void insert(String key, int val)
 *      插入 key-val 键值对,字符串表示键 key,整数表示值 val
 *      如果键 key 已经存在,那么原来的键值对将被替代成新的键值对
 * int sum(string prefix)
 *      返回所有以该前缀 prefix 开头的键 key 的值的总和
 *
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 *
 * @author   Li.zongjie
 * @date     2021/11/16
 * @version  1.0
 */
public class Z7PrefixMap {

    private Map<String, Integer> value = new HashMap<>();

    public Z7PrefixMap() {

    }

    public void insert(String key, int val) {
        value.put(key,val);
    }

    public int sum(String prefix) {
        AtomicInteger result = new AtomicInteger();
        value.forEach((k,v) -> {
            if (k.startsWith(prefix)){
                result.addAndGet(v);
            }
        });
        return result.get();
    }
}
