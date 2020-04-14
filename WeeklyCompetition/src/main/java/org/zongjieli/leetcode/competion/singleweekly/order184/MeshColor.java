package org.zongjieli.leetcode.competion.singleweekly.order184;

/**
 * @ClassName: MeshColor
 * @Description: 给一个 N * 3 的格子上色,只能红黄绿三种颜色之一给每一个格子上色
 * 且确保相邻格子颜色不同(相同水平或者垂直边的格子颜色不同)
 * 给出网格的行数 n,返回涂色的方案数,由于答案可能会非常大,请返回答案对 10^9 + 7取余的结果
 * @Author: Zongjie.Li
 * @Date: 2020/4/13
 * @Version: 1.0
 **/
public class MeshColor {

    /**
     * 循环递归暴力破解
     *
     * @param n Param Description
     * @return int
     * @Author Zongjie.Li
     * @Date 2020/4/13
     * @Version 1.0
     */
    public int numOfWays(int n) {
        if (n == 1) {
            return 12;
        }
        int[][] grids = new int[n][3];
        int count = setColor(grids, 0, 0, 0);
//        System.out.println(count);
        return count;
    }


    public int setColor(int[][] grids, int row, int position, int count) {
        if (row == grids.length - 1) {
            // 如果为最后一行
            if (position == 2) {
                // 如果为最后一个位置
                for (int color = 0; color < 3; color++) {
                    // 循环颜色
                    if (grids[row][position - 1] != color && grids[row - 1][position] != color) {
//                        System.out.println("Grid:");
//                        for (int listIndex = 0;listIndex < grids.length;listIndex++){
//                            System.out.println(Arrays.toString(grids[listIndex]));
//                        }
//                        System.out.println("Over");
                        count++;
                    }
                }
                if (count > 1000000007){
                    return  count - 1000000007;
                }
                return count;
            } else if (position == 1) {
                // 此时为最后一行的中间那个位置
                for (int color = 0; color < 3; color++) {
                    if (grids[row][position - 1] != color && grids[row - 1][position] != color) {
                        grids[row][position] = color;
                        count = setColor(grids, row, position + 1, count);
                    }
                }
                return count;
            } else {
                // 此时为最后一行的第一个位置
                for (int color = 0; color < 3; color++) {
                    if (grids[row - 1][position] != color) {
                        grids[row][position] = color;
                        count = setColor(grids, row, position + 1, count);
                    }
                }
                return count;
            }
        } else if (row == 0) {
            // 如果是第一行
            if (position == 2) {
                // 如果是最后一个位置
                for (int color = 0; color < 3; color++) {
                    // 如果此时为第一行
                    if (grids[row][position - 1] != color) {
                        grids[row][position] = color;
                        count = setColor(grids, row + 1, 0, count);
                    }
                }
                return count;
            } else if (position == 1) {
                // 如果是中间位置
                for (int color = 0; color < 3; color++) {
                    // 如果此时为第一行
                    if (grids[row][position - 1] != color) {
                        grids[row][position] = color;
                        count = setColor(grids, row, 2, count);
                    }
                }
                return count;
            } else {
                // 第一行第一个位置,不需要判断
                for (int color = 0; color < 3; color++) {
                    grids[row][position] = color;
                    count = setColor(grids, row, 1, count);
                }
                return count;
            }
        } else {
            // 如果为中间行
            if (position == 2) {
                // 如果是最后一个位置
                for (int color = 0; color < 3; color++) {
                    // 如果此时为第一行
                    if (grids[row][position - 1] != color && grids[row - 1][position] != color) {
                        grids[row][position] = color;
                        count = setColor(grids, row + 1, 0, count);
                    }
                }
                return count;
            } else if (position == 1) {
                // 如果是中间位置
                for (int color = 0; color < 3; color++) {
                    // 如果此时为第一行
                    if (grids[row][position - 1] != color && grids[row - 1][position] != color) {
                        grids[row][position] = color;
                        count = setColor(grids, row, 2, count);
                    }
                }
                return count;
            } else {
                // 第一个位置,不需要判断
                for (int color = 0; color < 3; color++) {
                    if (grids[row - 1][position] != color){
                        grids[row][position] = color;
                        count = setColor(grids, row, 1, count);
                    }
                }
                return count;
            }
        }
}

    public static void main(String[] args) {
        MeshColor meshColor = new MeshColor();
        System.out.println(meshColor.numOfWays(5000));
    }
}
