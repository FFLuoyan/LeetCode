package org.zongjieli.leetcode.question.daily.year2021.month11.week2;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 普通遍历方法
     */
    static class Z7PrefixMapSimple{

        private Map<String, Integer> value = new HashMap<>();
        private int[] result = new int[]{0};

        public Z7PrefixMapSimple() {

        }

        public void insert(String key, int val) {
            value.put(key,val);
        }

        public int sum(String prefix) {
            result[0] = 0;
            value.forEach((k,v) -> {
                if (k.startsWith(prefix)){
                    result[0] += v;
                }
            });
            return result[0];
        }
    }

    /**
     * 前缀保留方法,每次插入时将前缀和计算完成
     * 使得插入时的时间消耗增加,但获取结果时非常迅速
     */
    static class Z7PrefixMapPrefix{
        private Map<String, Integer> valueMap = new HashMap<>();
        private Map<String, Integer> prefixMap = new HashMap<>();

        public Z7PrefixMapPrefix() {

        }

        public void insert(String key, int val) {
            Integer save = valueMap.get(key);

            if (save == null){
                // value
                valueMap.put(key, val);

                // prefix
                for (int i = 1 ; i <= key.length() ; i++){
                    String tempKey = key.substring(0, i);
                    prefixMap.merge(tempKey, val, Integer::sum);
                }
            } else if (save != val){
                // value
                valueMap.put(key, val);

                // prefix
                int add = val - save;
                for (int i = 1 ; i <= key.length() ; i++){
                    String tempKey = key.substring(0, i);
                    Integer v = prefixMap.get(tempKey);
                    prefixMap.put(tempKey, v + add);
                }
            }

        }

        public int sum(String prefix) {
            return prefixMap.getOrDefault(prefix, 0);
        }
    }


    public static void main(String[] args) {
        Z7PrefixMapPrefix prefixTest = new Z7PrefixMapPrefix();
        prefixTest.insert("apple", 3);
    }
}
