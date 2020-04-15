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
    public int numOfWaysByRecursion(int n) {
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
                if (count > 1000000007) {
                    return count - 1000000007;
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
                    if (grids[row - 1][position] != color) {
                        grids[row][position] = color;
                        count = setColor(grids, row, 1, count);
                    }
                }
                return count;
            }
        }
    }

    public int numOfWays(int n) {
        if (n == 1) {
            return 12;
        }
        int[] grids = new int[n * 3];
        int count = 0;
        for (int index = 0; index < grids.length; ) {
            if (index == grids.length - 1) {
                // 说明是最后一个
                for (int color = 1; color < 4; color++) {
                    if (grids[index - 1] != color && grids[index - 3] != color) {
                        count++;
                        if (count > 1000000007) {
                            count -= 1000000007;
                        }
                    }
                }
                // 继续从上一个节点开始循环
                index--;
            } else if (index == 0) {
                if (grids[0] == 3) {
                    // 如果回溯至第一个节点,说明此时遍历完毕,则终止循环
                    break;
                } else {
                    grids[0]++;
                    index++;
                }
            } else if (index < 3) {
                // 第一行的节点,只需要与自己前一个节点进行比较
                if (grids[index] == 0) {
                    // 如果为 -1 说明前移过,此时应该从 0 开始计算
                    for (int color = 1; color < 4; color++) {
                        if (grids[index - 1] != color) {
                            grids[index] = color;
                            index++;
                            break;
                        }
                    }
                } else {
                    // 此时遍历是从前往后,应该在原数据基础上进行加减
                    boolean valueChange = false;
                    for (int color = grids[index] + 1; color < 4; color++) {
                        if (color != grids[index - 1]) {
                            grids[index] = color;
                            valueChange = true;
                            break;
                        }
                    }
                    if (valueChange) {
                        // 颜色的值进行了更改
                        index++;
                    } else {
                        // 没有合适的值,返回上一个节点
                        grids[index] = 0;
                        index--;
                    }
                }
            } else if (index % 3 == 0) {
                // 为首位节点,只需要比较 index -3 的位置即可
                if (grids[index] == 0) {
                    // 如果为 -1 说明前移过,此时应该从 0 开始计算
                    for (int color = 1; color < 4; color++) {
                        if (grids[index - 3] != color) {
                            grids[index] = color;
                            index++;
                            break;
                        }
                    }
                } else {
                    // 此时遍历是从后往前,应该在原数据基础上进行加减
                    boolean valueChange = false;
                    for (int color = grids[index] + 1; color < 4; color++) {
                        if (color != grids[index - 3]) {
                            grids[index] = color;
                            valueChange = true;
                            break;
                        }
                    }
                    if (valueChange) {
                        // 颜色的值进行了更改
                        index++;
                    } else {
                        // 没有合适的值,返回上一个节点
                        grids[index] = 0;
                        index--;
                    }
                }
            } else {
                // 此时为非第一行的非首个节点,需要比较前一个节点,与上一行同一个位置的节点
                if (grids[index] == 0) {
                    // 如果为 -1 说明前移过,此时应该从 0 开始计算
                    for (int color = 1; color < 4; color++) {
                        if (grids[index - 3] != color && grids[index - 1] != color) {
                            grids[index] = color;
                            index++;
                            break;
                        }
                    }
                } else {
                    // 此时遍历是从前往后,应该在原数据基础上进行加减
                    boolean valueChange = false;
                    for (int color = grids[index] + 1; color < 4; color++) {
                        if (color != grids[index - 3] && grids[index - 1] != color) {
                            grids[index] = color;
                            valueChange = true;
                            break;
                        }
                    }
                    if (valueChange) {
                        // 颜色的值进行了更改
                        index++;
                    } else {
                        // 没有合适的值,返回上一个节点
                        grids[index] = 0;
                        index--;
                    }
                }
            }
        }
        return count;
    }

    public int numOfWaysByMath(int n) {
        if (n == 1){
            return 12;
        }
        int remainNumber = 1000000007;
        long doubleNumber = 6;
        long ThreeNumber = 6;
        for (int i = 1 ; i < n;i++){
            if (doubleNumber > remainNumber){
                doubleNumber %= remainNumber;
            }
            if (ThreeNumber > remainNumber){
                ThreeNumber %= remainNumber;
            }
            long nextDoubleNumber = (doubleNumber << 1) + (ThreeNumber << 1) + doubleNumber;
            long nextThreeNumber = (doubleNumber << 1) + (ThreeNumber << 1);
            doubleNumber = nextDoubleNumber;
            ThreeNumber = nextThreeNumber;
        }
        return Long.valueOf((doubleNumber + ThreeNumber) % remainNumber).intValue();
    }

    public static void main(String[] args) {
        MeshColor meshColor = new MeshColor();
        System.out.println(meshColor.numOfWaysByMath(5000));
    }
}
