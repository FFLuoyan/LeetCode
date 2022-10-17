package org.zongjieli.leetcode.question.daily.year2022.month10.week3;

import java.util.*;

/**
 * 给定一组 n 人(编号为 1, 2, ..., n)
 * 把每个人分进任意大小的两组
 * 每个人都可能不喜欢其他人,那么他们不应该属于同一组
 *
 * 给定整数 n 和数组 dislikes,其中 dislikes[i] = [ai, bi]
 * 表示不允许将编号为 ai 和  bi的人归入同一组
 * 当可以用这种方法将所有人分进两组时,返回 true,否则返回 false
 *
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 10^4
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 *
 * @author   Li.zongjie
 * @date     2022/10/17
 * @version  1.0
 */
public class Z7PersonDivision {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, Set<Integer>[]> save = new HashMap<>();
        for (int[] dislike : dislikes) {
            Set<Integer>[] gl = save.get(dislike[0]);
            Set<Integer>[] gr = save.get(dislike[1]);
            if (gl == null) {
                if (gr == null) {
                    Set<Integer>[] group = new Set[]{new HashSet<>(), new HashSet<>()};
                    group[0].add(dislike[0]);
                    group[1].add(dislike[1]);
                    save.put(dislike[0], group);
                    save.put(dislike[1], group);
                } else {
                    (gr[0].contains(dislike[1]) ? gr[1] : gr[0]).add(dislike[0]);
                    save.put(dislike[0], gr);
                }
            } else if (gr == null) {
                (gl[0].contains(dislike[0]) ? gl[1] : gl[0]).add(dislike[1]);
                save.put(dislike[1], gl);
            } else if (gl[0] != gr[0]) {
                boolean isLeft = gr[0].contains(dislike[1]);
                Set<Integer> second = isLeft ? gr[0] : gr[1];
                Set<Integer> secondOther = isLeft ? gr[1] : gr[0];
                isLeft = gl[0].contains(dislike[0]);
                Set<Integer> first = isLeft ? gl[0] : gl[1];
                Set<Integer> firstOther = isLeft ? gl[1] : gl[0];
                second.addAll(firstOther);
                secondOther.addAll(first);
                gl[0] = gr[0];
                gl[1] = gr[1];
            } else if ((gl[0].contains(dislike[0]) && gl[0].contains(dislike[1])) || (gl[1].contains(dislike[0]) && gl[1].contains(dislike[1]))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Z7PersonDivision test = new Z7PersonDivision();
        System.out.println(test.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
    }
}
