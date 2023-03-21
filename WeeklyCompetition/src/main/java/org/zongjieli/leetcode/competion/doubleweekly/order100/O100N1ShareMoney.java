package org.zongjieli.leetcode.competion.doubleweekly.order100;

/**
 * 给定一个整数 money,表示总共有的钱数(单位为美元)
 * 和另一个整数 children,表示要将钱分配给多少个儿童
 * 需要按照如下规则分配:
 *  所有的钱都必须被分配
 *  每个儿童至少获得 1 美元
 *  没有人获得 4 美元
 * 请按照上述规则分配金钱
 * 并返回最多有多少个儿童获得恰好 8 美元
 * 如果没有任何分配方案,返回 -1
 *
 * 1 <= money <= 200
 * 2 <= children <= 30
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/18
 */
public class O100N1ShareMoney {

    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        int result = (money - children) / 7;
        if (result > children) {
            return children - 1;
        }
        if (result == children) {
            if ((money - children) % 7 == 0) {
                return children;
            }
            return children - 1;
        }
        if ((money - children) % 7 == 3 && result == children - 1) {
            return result - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        O100N1ShareMoney test = new O100N1ShareMoney();
        // 0
        System.out.println(test.distMoney(5, 2));
        // 1
        System.out.println(test.distMoney(19, 2));
    }

}
