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
        int[] save = new int[n + 1];
        int ci = 1;
        for (int[] dislike : dislikes) {
            int left = dislike[0], right = dislike[1], gl = save[left], gr = save[right], gra;
            if (gl == 0) {
                if (gr == 0) {
                    save[left] = ci;
                    save[right] = -ci;
                    ci++;
                } else {
                    save[left] = -gr;
                }
            } else if (gr == 0) {
                save[right] = -save[left];
            } else if (gl == gr) {
                return false;
            } else if (Math.abs(gl) != (gra = Math.abs(gr))){
                for (int i = 0; i < save.length; i++) {
                    int current = save[i];
                    if (Math.abs(current) == gra) {
                        save[i] = current == gr ? -gl : gl;
                    }
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Z7PersonDivision test = new Z7PersonDivision();
        // false
        System.out.println(test.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
    }
}
