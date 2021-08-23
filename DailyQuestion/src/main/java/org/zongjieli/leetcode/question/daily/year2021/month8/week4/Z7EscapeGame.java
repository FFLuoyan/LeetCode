package org.zongjieli.leetcode.question.daily.year2021.month8.week4;
/**
 * 你在进行一个简化版的吃豆人游戏
 *
 * 你从 [0, 0] 点开始出发,你的目的地是 target = [xTarget, yTarget]
 * 地图上有一些阻碍者,以数组 ghosts 给出
 * 第 i 个阻碍者从 ghosts[i] = [xi, yi] 出发
 * 所有输入均为整数坐标
 *
 * 每一回合,你和阻碍者们可以同时向东、西、南、北四个方向移动
 * 每次可以移动到距离原位置 1 个单位的新位置
 * 当然,也可以选择不动,所有动作同时发生
 *
 * 如果你可以在任何阻碍者抓住你之前到达目的地(阻碍者可以采取任意行动方式)
 * 则被视为逃脱成功
 * 如果你和阻碍者同时到达了一个位置(包括目的地)
 * 都不算是逃脱成功。
 *
 * 只有在你有可能成功逃脱时,输出 true;否则,输出 false
 *
 * 1 <= ghosts.length <= 100
 * ghosts[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * 同一位置可能有多个阻碍者
 * target.length == 2
 * -10^4 <= xTarget, yTarget <= 10^4
 *
 * @author   Li.zongjie
 * @date     2021/8/23
 * @version  1.0
 */
public class Z7EscapeGame {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int route = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int prevent = (ghost[0] > target[0] ? ghost[0] - target[0] : target[0] - ghost[0]) + (ghost[1] > target[1] ? ghost[1] - target[1] : target[1] - ghost[1]);
            if (prevent <= route){
                return false;
            }
        }
        return true;
    }
}
