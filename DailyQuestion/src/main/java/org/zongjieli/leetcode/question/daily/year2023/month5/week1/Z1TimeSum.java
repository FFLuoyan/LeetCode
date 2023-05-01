package org.zongjieli.leetcode.question.daily.year2023.month5.week1;

/**
 * 公司里有 n 名员工,每个员工的 ID 都是独一无二的,编号从 0 到 n - 1
 * 公司的总负责人通过 headID 进行标识
 * 在 manager 数组中,每个员工都有一个直属负责人,其中 manager[i] 是第 i 名员工的直属负责人
 * 对于总负责人,manager[headID] = -1,题目保证从属关系可以用树结构显示
 * 公司总负责人想要向公司所有员工通告一条紧急消息
 * 他将会首先通知他的直属下属们,然后由这些下属通知他们的下属,直到所有的员工都得知这条紧急消息
 * 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属
 * 也就是说在 informTime[i] 分钟后,他的所有直属下属都可以开始传播这一消息
 * 返回通知所有员工这一紧急消息所需要的分钟数
 *
 * 1 <= n <= 10^5
 * 0 <= headID < n
 * manager.length == n
 * 0 <= manager[i] < n
 * manager[headID] == -1
 * informTime.length == n
 * 0 <= informTime[i] <= 1000
 * 如果员工 i 没有下属，informTime[i] == 0
 * 题目保证所有员工都可以收到通知
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/5/1
 */
public class Z1TimeSum {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] timeCost = new int[n];
        int maxTime = 0;
        for (int i = 0 ; i < n ; i++) {
            maxTime = Math.max(maxTime, getTime(i, timeCost, manager, informTime));
        }
        return maxTime;
    }

    public int getTime(int currentId, int[] timeCost, int[] manager, int[] informTime) {
        if (timeCost[currentId] != 0) {
            return timeCost[currentId];
        }
        int managerId = manager[currentId];
        return managerId == -1 ? 0 : (timeCost[currentId] = informTime[managerId] + getTime(managerId, timeCost, manager, informTime));
    }
}
