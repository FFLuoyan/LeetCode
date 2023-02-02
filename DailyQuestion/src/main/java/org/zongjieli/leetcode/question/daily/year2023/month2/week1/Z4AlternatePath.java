package org.zongjieli.leetcode.question.daily.year2023.month2.week1;

import java.util.*;

/**
 * 在一个有向图中,节点分别标记为 0, 1, ..., n-1
 * 图中每条边为红色或者蓝色,且存在自环或平行边
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边
 * blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边
 * 返回长度为 n 的数组 answer
 * 其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度
 * 如果不存在这样的路径,那么 answer[x] = -1
 *
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/2
 */
public class Z4AlternatePath {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] redPath = new int[n][n];
        for (int[] redEdge : redEdges) {
            redPath[redEdge[0]][++redPath[redEdge[0]][0]] = redEdge[1];
        }
        int[][] bluePath = new int[n][n];
        for (int[] blueEdge : blueEdges) {
            bluePath[blueEdge[0]][++bluePath[blueEdge[0]][0]] = blueEdge[1];
        }
        int[] resultRed = alternatePath(n, redPath, bluePath);
        int[] resultBlue = alternatePath(n, bluePath, redPath);
        for (int i = 1; i < resultRed.length; i++) {
            resultRed[i] = Math.min(resultRed[i], resultBlue[i]);
            if (resultRed[i] == Integer.MAX_VALUE) {
                resultRed[i] = -1;
            }
        }
        resultRed[0] = 0;
        return resultRed;
    }

    public int[] alternatePath(int n, int[][] current, int[][] next) {
        int[] result = new int[n], type = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        if (current[0][0] == 0) {
            return result;
        }
        LinkedList<Integer> nextKey = new LinkedList<>();
        for (int i = 1; i <= current[0][0]; i++) {
            nextKey.add(current[0][i]);
        }
        int currentCount = 1, currentType = 1;
        while (!nextKey.isEmpty()) {
            int size = nextKey.size();
            while (--size >= 0) {
                int key = nextKey.poll();
                boolean isAdd = false;
                if (result[key] == Integer.MAX_VALUE) {
                    result[key] = currentCount;
                    type[key] = currentType;
                    isAdd = true;
                } else if ((currentType & type[key]) == 0) {
                    type[key] |= currentType;
                    isAdd = true;
                }
                if (isAdd && next[key][0] != 0) {
                    for (int i = 1; i <= next[key][0]; i++) {
                        nextKey.add(next[key][i]);
                    }
                }
            }
            currentCount++;
            currentType ^= 3;
            int[][] temp = current;
            current = next;
            next = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Z4AlternatePath test = new Z4AlternatePath();
        // 0, -1, -1
        System.out.println(Arrays.toString(test.shortestAlternatingPaths(3, new int[][]{{1, 2}}, new int[][]{{2, 1}})));
        // 0, 1, 2, 3, 7
        System.out.println(Arrays.toString(test.shortestAlternatingPaths(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{1, 2}, {2, 3}, {3, 1}})));
    }

}
