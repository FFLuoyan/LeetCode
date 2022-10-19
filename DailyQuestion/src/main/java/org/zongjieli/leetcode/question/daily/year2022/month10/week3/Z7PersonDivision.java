package org.zongjieli.leetcode.question.daily.year2022.month10.week3;

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
        /*
            思路:
                互相有联系的人,可以组成一个联系团
                联系团分成左右两份,如果存在某一个联系的两个人在同一边
                则无法分组,返回 false
                遍历 dislikes,当每个 dislike 中存在至少一人在当前联系团中
                判断当前联系是否合法,并将新的联系加入联系团
                需要注意的是,因为一次遍历可能会有一些属于当前联系团的联系由于位置靠前而没有被加入联系团
                所以需要循环遍历,直至一次遍历没有新的联系加入联系团
                则当前联系团中包含了所有 dislikes 中相关联系对的所有联系关系
                这里需要注意的是,对于 dislikes,可能存在不止一个联系团
                所以需要再次执行上述操作,直至将所有联系团处理完毕
         */
        int[] save = new int[n + 1];
        int reformat = dislikes.length, remain = reformat - 1;
        while (remain > 1) {
            if (reformat == remain + 1) {
                save[dislikes[0][0]] = 2;
            }
            remain = reformat - 1;
            reformat = 0;
            for (int i = 0 ; i <= remain ; i++) {
                int left = dislikes[i][0], right = dislikes[i][1], sl = save[left], sr = save[right];
                if (sl == 0) {
                    if (sr == 0) {
                        dislikes[reformat++] = dislikes[i];
                    } else {
                        save[left] = sr ^ 1;
                    }
                } else if (sr == 0) {
                    save[right] = sl ^ 1;
                } else if (sl == sr) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Z7PersonDivision test = new Z7PersonDivision();
        // false
        System.out.println(test.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
        // false
        System.out.println(test.possibleBipartition(5, new int[][]{{1, 2}, {3, 4}, {4, 5}, {3, 5}}));
    }
}
