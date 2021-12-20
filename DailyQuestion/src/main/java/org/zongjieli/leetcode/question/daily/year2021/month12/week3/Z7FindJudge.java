package org.zongjieli.leetcode.question.daily.year2021.month12.week3;
/**
 * 小镇里有 n 个人,按从 1 到 n 的顺序编号
 * 传言称,这些人中有一个暗地里是小镇法官
 *
 * 如果小镇法官真的存在,那么:
 *  小镇法官不会信任任何人
 *  每个人(除了小镇法官)都信任这位小镇法官
 *  只有一个人同时满足属性 1 和属性 2
 *
 * 给定一个数组 trust,其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人
 * 如果小镇法官存在并且可以确定他的身份,请返回该法官的编号;否则返回 -1
 *
 * 1 <= n <= 1000
 * 0 <= trust.length <= 10^4
 * trust[i].length == 2
 * trust 中的所有trust[i] = [ai, bi] 互不相同
 * ai != bi
 * 1 <= ai, bi <= n
 *
 * @author   Li.zongjie
 * @date     2021/12/19
 * @version  1.0
 */
public class Z7FindJudge {
    public int findJudge(int n, int[][] trust) {
        boolean[] aTrust = new boolean[n + 1];
        int[] trustB = new int[n + 1];
        for (int[] t : trust) {
            aTrust[t[0]] = true;
            trustB[t[1]]++;
        }
        for (int i = 1 ; i <= n ; i++){
            if (!aTrust[i] && trustB[i] == n - 1){
                return i;
            }
        }
        return -1;
    }
}
