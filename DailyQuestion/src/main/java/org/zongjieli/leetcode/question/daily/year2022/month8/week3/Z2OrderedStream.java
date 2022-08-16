package org.zongjieli.leetcode.question.daily.year2022.month8.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 有 n 个 (id, value) 对,其中 id 是 1 到 n 之间的一个整数
 * value 是一个字符串,不存在 id 相同的两个 (id, value) 对
 * 设计一个流,以任意顺序获取 n 个 (id, value) 对
 * 并在多次调用时按 id 递增的顺序返回一些值
 * 实现 OrderedStream 类:
 *  Z2OrderedStream(int n)
 *      构造一个能接收 n 个值的流,并将当前指针 ptr 设为 1
 *  String[] insert(int id, String value)
 *      向流中存储新的 (id, value) 对,存储后:
 *      如果流存储有 id = ptr 的 (id, value) 对
 *      则找出从 id = ptr 开始的最长 id 连续递增序列
 *      并按顺序返回与这些 id 关联的值的列表
 *      然后将 ptr 更新为最后那个 id + 1
 *      否则,返回一个空列表
 *
 * 1 <= n <= 1000
 * 1 <= id <= n
 * value.length == 5
 * value 仅由小写字母组成
 * 每次调用 insert 都会使用一个唯一的 id
 * 恰好调用 n 次 insert
 *
 * @author   Li.zongjie
 * @date     2022/8/16
 * @version  1.0
 */
public class Z2OrderedStream {

    private String[] values;
    private int index = 1;
    private List<String> result;

    public Z2OrderedStream(int n) {
        values = new String[n + 2];
        result = new ArrayList<>(n);
    }

    public List<String> insert(int idKey, String value) {
        values[idKey] = value;
        if (values[index] == null) {
            return Collections.emptyList();
        }
        result.clear();
        while (values[index] != null) {
            result.add(values[index++]);
        }
        return result;
    }
}
