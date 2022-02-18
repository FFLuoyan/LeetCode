package org.zongjieli.leetcode.question.daily.year2022.month2.week3;
/**
 * 有一个无向的型图,由 n 个编号从 1 到 n 的节点组成
 * 星型图有一个中心节点,并且恰有 n - 1 条边将中心节点与其他每个节点连接起来
 *
 * 给定一个二维整数数组 edges,其中 edges[i] = [ui, vi]
 * 表示在节点 ui 和 vi 之间存在一条边
 * 请找出并返回 edges 所表示星型图的中心节点
 *
 * 3 <= n <= 10^5
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 *
 * 题目数据给出的 edges 表示一个有效的星型图
 *
 * @author   Li.zongjie
 * @date     2022/2/18
 * @version  1.0
 */
public class Z5FindCenter {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
