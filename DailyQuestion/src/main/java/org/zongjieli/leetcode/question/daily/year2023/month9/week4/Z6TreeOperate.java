package org.zongjieli.leetcode.question.daily.year2023.month9.week4;

/**
 * 给定一棵 n 个节点的树,编号从 0 到 n - 1,以父节点数组 parent 的形式给出
 * 其中 parent[i] 是第 i 个节点的父节点
 * 树的根节点为 0 号节点,所以 parent[0] = -1,因为它没有父节点
 * 想要设计一个数据结构实现树里面对节点的加锁,解锁和升级操作
 * 数据结构需要支持如下函数:
 *  Lock:
 *      指定用户给指定节点上锁,上锁后其他用户将无法给同一节点上锁
 *      只有当节点处于未上锁的状态下,才能进行上锁操作
 *  Unlock:
 *      指定用户给指定节点解锁,只有当指定节点当前正被指定用户锁住时,才能执行该解锁操作
 *  Upgrade:
 *      指定用户给指定节点上锁,并且将该节点的所有子孙节点解锁
 *      只有如下 3 个条件全部满足时才能执行升级操作:
 *          指定节点当前状态为未上锁
 *          指定节点至少有一个上锁状态的子孙节点(可以是任意用户上锁的)
 *          指定节点没有任何上锁的祖先节点
 * 请实现 LockingTree 类:
 *  Z6TreeOperate(int[] parent):
 *      用父节点数组初始化数据结构
 *  lock(int num, int user):
 *      如果 id 为 user 的用户可以给节点 num 上锁,那么返回 true,否则返回 false
 *      如果可以执行此操作,节点 num 会被 id 为 user 的用户上锁
 *  unlock(int num, int user):
 *      如果 id 为 user 的用户可以给节点 num 解锁,那么返回 true,否则返回 false
 *      如果可以执行此操作,节点 num 变为未上锁状态
 *  upgrade(int num, int user):
 *      如果 id 为 user 的用户可以给节点 num 升级,那么返回 true,否则返回 false
 *      如果可以执行此操作,节点 num 会被升级
 *
 * n == parent.length
 * 2 <= n <= 2000
 * 对于 i != 0,满足 0 <= parent[i] <= n - 1
 * parent[0] == -1
 * 0 <= num <= n - 1
 * 1 <= user <= 10^4
 * parent 表示一棵合法的树
 * lock,unlock 和 upgrade 的调用总共不超过 2000 次
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/23
 */
public class Z6TreeOperate {

    int[] parents;

    int[] lock;

    int[] beforeSon;

    int[] lastSon;

    public Z6TreeOperate(int[] parent) {
        int n = parent.length;
        parents = parent;
        lock = new int[n];
        beforeSon = new int[n];
        lastSon = new int[n];
        for (int i = 1; i < parent.length; i++) {
            beforeSon[i] = lastSon[parent[i]];
            lastSon[parent[i]] = i;
        }
    }

    public boolean lock(int num, int user) {
        if (lock[num] == 0) {
            lock[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (lock[num] == user) {
            lock[num] = 0;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (lock[num] != 0) {
            return false;
        }
        int parent = parents[num];
        while (parent != -1) {
            if (lock[parent] != 0) {
                return false;
            }
            parent = parents[parent];
        }
        if (unlockSons(num)) {
            lock[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlockSons(int num) {
        boolean isUnlock = false;
        int son = lastSon[num];
        while (son != 0) {
            if (lock[son] != 0) {
                lock[son] = 0;
                isUnlock = true;
            }
            isUnlock |= unlockSons(son);
            son = beforeSon[son];
        }
        return isUnlock;
    }

}
