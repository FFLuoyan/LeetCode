package org.zongjieli.leetcode.question.daily.year2022.month3.week3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个有 n 个服务器的计算机网络,服务器编号为 0 到 n - 1
 * 同时给定一个二维整数数组 edges
 * 其中 edges[i] = [ui, vi] 表示服务器 ui 和 vi 之间有一条信息线路
 * 在一秒内它们之间可以传输任意数目的信息
 * 再给定一个长度为 n 且下标从 0 开始的整数数组 patience
 *
 * 题目保证所有服务器都是相通的
 * 也就是说一个信息从任意服务器出发
 * 都可以通过这些信息线路直接或间接地到达任何其他服务器
 *
 * 编号为 0 的服务器是主服务器,其他服务器为数据服务器
 * 每个数据服务器都要向主服务器发送信息,并等待回复
 * 信息在服务器之间按最优线路传输,也就是说每个信息都会以最少时间到达主服务器
 * 主服务器会处理所有新到达的信息并立即按照每条信息来时的路线反方向发送回复信息
 *
 * 在 0 秒的开始,所有数据服务器都会发送各自需要处理的信息
 * 从第 1 秒开始,每一秒最开始时,每个数据服务器都会检查它是否收到了主服务器的回复信息(包括新发出信息的回复信息):
 *  如果还没收到任何回复信息,那么该服务器会周期性重发信息
 *      数据服务器 i 每 patience[i] 秒都会重发一条信息
 *      也就是说,数据服务器 i 在上一次发送信息给主服务器后的 patience[i] 秒后会重发一条信息给主服务器
 *  否则,该数据服务器不会重发信息
 *
 * 当没有任何信息在线路上传输或者到达某服务器时,该计算机网络变为空闲状态
 * 请返回计算机网络变为空闲状态的最早秒数
 *
 * 提示:
 *  n == patience.length
 *  2 <= n <= 10^5
 *  patience[0] == 0
 *  对于 1 <= i < n ，满足 1 <= patience[i] <= 10^5
 *  1 <= edges.length <= min(10^5, n * (n - 1) / 2)
 *  edges[i].length == 2
 *  0 <= ui, vi < n
 *  ui != vi
 *  不会有重边
 *  每个服务器都直接或间接与别的服务器相连
 *
 * @author   Li.zongjie
 * @date     2022/3/21
 * @version  1.0
 */
public class Z7NetFree {

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        Map<Integer, Set<Integer>> serverLinks = new HashMap<>();
        for (int[] edge : edges) {
            serverLinks.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            serverLinks.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        Map<Integer, Set<Integer>> serverLength = new HashMap<>();
        Set<Integer> currentServers = new HashSet<>();
        currentServers.add(0);

        int[] current = new int[]{1, 0};
        boolean[] serverExists = new boolean[n];
        serverExists[0] = true;

        while (current[0] < n) {
            Set<Integer> nextServers = new HashSet<>();
            currentServers.forEach(currentServer -> {
                Set<Integer> currentServerLinks = serverLinks.get(currentServer);
                currentServerLinks.forEach(l -> {
                    if (!serverExists[l]) {
                        serverExists[l] = true;
                        current[0]++;
                        nextServers.add(l);
                    }
                });
            });
            serverLength.put(++current[1], currentServers = nextServers);
        }

        return serverLength.entrySet().stream().map(e -> {
            int returnTime = 2 * e.getKey();
            return e.getValue().stream().map(s -> {
                if (patience[s] >= returnTime) {
                    return returnTime + 1;
                }
                return returnTime % patience[s] != 0 ? (returnTime / patience[s]) * patience[s] + returnTime + 1 : (returnTime / patience[s] - 1) * patience[s] + returnTime + 1;
            }).max(Integer::compareTo).get();
        }).max(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        Z7NetFree test = new Z7NetFree();
        // 8
        System.out.println(test.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 2, 1}));
        // 3
        System.out.println(test.networkBecomesIdle(new int[][]{{0, 1}}, new int[]{0, 10000}));
    }
}
