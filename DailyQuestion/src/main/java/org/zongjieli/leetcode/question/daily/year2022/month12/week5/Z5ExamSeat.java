package org.zongjieli.leetcode.question.daily.year2022.month12.week5;

import java.util.TreeSet;

/**
 * 在考场里,一排有 n 个座位,分别编号为 0, 1, 2, ..., n-1
 * 当学生进入考场后,他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上
 * 如果有多个这样的座位,他会坐在编号最小的座位上
 * 如果考场里没有人,那么学生就坐在 0 号座位上
 *
 * 返回 Z5ExamSeat(int n) 类,它有两个公开的函数:
 *  Z5ExamSeat.seat()
 *      返回一个 int,代表学生坐的位置
 *  Z5ExamSeat.leave(int p)
 *      代表坐在座位 p 上的学生现在离开了考场
 *  每次调用 Z5ExamSeat.leave(p) 时都保证有学生坐在座位 p 上
 *
 * 1 <= n <= 10^9
 * 在所有的测试样例中, Z5ExamSeat.seat() 和 Z5ExamSeat.leave() 最多被调用 10^4 次
 * 保证在调用 Z5ExamSeat.leave(p) 时有学生正坐在座位 p 上
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/1
 */
public class Z5ExamSeat {

    private final TreeSet<Integer> seats;
    private final int n;

    public Z5ExamSeat(int n) {
        seats = new TreeSet<>();
        this.n = n;
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int value = 0, before = seats.first(), distance = before;
        for (Integer seat : seats) {
            int cd = (seat - before) / 2;
            if (cd > distance) {
                distance = cd;
                value = before + distance;
            }
            before = seat;
        }
        if (n - 1 - before > distance) {
            value = n - 1;
        }
        seats.add(value);
        return value;
    }

    public void leave(int p) {
        seats.remove(p);
    }

    public static void main(String[] args) {
        Z5ExamSeat test = new Z5ExamSeat(10);
        // 0
        System.out.println(test.seat());
        // 9
        System.out.println(test.seat());
        // 4
        System.out.println(test.seat());
        // 2
        System.out.println(test.seat());
        test.leave(4);
        // 5
        System.out.println(test.seat());
    }
}
