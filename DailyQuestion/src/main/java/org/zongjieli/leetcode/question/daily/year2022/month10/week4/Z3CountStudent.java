package org.zongjieli.leetcode.question.daily.year2022.month10.week4;
/**
 * 学校的自助午餐提供圆形和方形的三明治,分别用数字 0 和 1 表示
 * 所有学生站在一个队列里,每个学生要么喜欢圆形的要么喜欢方形的
 * 餐厅里三明治的数量与学生的数量相同,所有三明治都放在一个栈里,每一轮:
 * 如果队列最前面的学生喜欢栈顶的三明治,那么会拿走它并离开队列
 * 否则,这名学生会放弃这个三明治并回到队列的尾部
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止
 *
 * 给定两个整数数组 students 和 sandwiches
 * 其中 sandwiches[i] 是栈里面第 i​​​​​​ 个三明治的类型(i = 0 是栈的顶部)
 * students[j] 是初始队列里第 j​​​​​​ 名学生对三明治的喜好(j = 0 是队列的最开始位置)
 * 请返回无法吃午餐的学生数量
 *
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i] 要么是 0,要么是 1
 * students[i] 要么是 0,要么是 1
 *
 * @author   Li.zongjie
 * @date     2022/10/19
 * @version  1.0
 */
public class Z3CountStudent {

    public int countStudents(int[] students, int[] sandwiches) {
        int startIndex = 0;
        for (int i = 0; i < sandwiches.length; i++) {
            if ((startIndex = findNext(students, sandwiches[i], startIndex)) == -1) {
                return sandwiches.length - i;
            }
            startIndex++;
        }
        return 0;
    }

    public int findNext(int[] students, int type, int startIndex) {
        for (int i = startIndex ; i < students.length ; i++) {
            if (type == students[i]) {
                students[i] = -1;
                return i;
            }
        }
        for (int i = 0 ; i < startIndex ; i++) {
            if (type == students[i]) {
                students[i] = -1;
                return i;
            }
        }
        return -1;
    }
}
