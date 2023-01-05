package org.zongjieli.leetcode.question.daily.year2022.month12.week5;

import java.util.*;

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

    private final int n;
    private final PriorityQueue<int[]> distances;
    private final TreeSet<Integer> seats;

    public Z5ExamSeat(int n) {
        this.n = n;
        distances = new PriorityQueue<>((a, b) -> {
            int ad = (a[1] - a[0]) / 2, bd = (b[1] - b[0]) / 2;
            return ad > bd ? -1 : ad < bd ? 1 : Integer.compare(a[0], b[0]);
        });
        seats = new TreeSet<>();
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int left = seats.first();
        int right = n - 1 - seats.last();
        int[] distance = new int[]{0, 0};
        Integer higher;
        while (!distances.isEmpty() && !(seats.contains((distance = distances.peek())[0]) && (higher = seats.higher(distance[0])) != null && higher == distance[1])) {
            distances.poll();
        }
        int cd = (distance[1] - distance[0]) / 2;
        if (cd >= right && cd > left) {
            distances.poll();
            int seat = cd + distance[0];
            seats.add(seat);
            distances.add(new int[]{distance[0], seat});
            distances.add(new int[]{seat, distance[1]});
            return seat;
        }
        if (left >= right) {
            seats.add(0);
            distances.add(new int[]{0, left});
            return 0;
        }
        seats.add(n - 1);
        distances.add(new int[]{left, n - 1});
        return n - 1;
    }

    public void leave(int p) {
        seats.remove(p);
        Integer lower, higher;
        if ((lower = seats.lower(p)) != null && (higher = seats.higher(p)) != null) {
            distances.add(new int[]{lower, higher});
        }
    }

    public static void main(String[] args) {
        Z5ExamSeat test;

        test = new Z5ExamSeat(10);
        // 0, 9, 4, 2, 5
        System.out.print(test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat());
        test.leave(4);
        System.out.println(" " + test.seat());

        test = new Z5ExamSeat(4);
        // 0, 3, 1, 2, 1
        System.out.print(test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat());
        test.leave(1);
        test.leave(3);
        System.out.println(" " + test.seat());

        test = new Z5ExamSeat(10);
        // 0, 9, 4, 0, 4, 2, 6, 1, 3, 5, 7, 8
        System.out.print(test.seat() + " " + test.seat() + " " + test.seat());
        test.leave(0);
        test.leave(4);
        System.out.println(" " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat());
        test.leave(0);

        test = new Z5ExamSeat(8);
        // 0, 7, 3, 7, 0, 5, 1, 2, 4, 6, 0
        System.out.print(test.seat() + " " + test.seat() + " " + test.seat());
        test.leave(0);
        test.leave(7);
        System.out.print(" " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat());
        test.leave(0);
        test.leave(7);
        System.out.println(" " + test.seat());

        test = new Z5ExamSeat(10);
        // 0, 9, 4, 0, 4, 2, 6, 1, 3, 5, 7, 8, 0, 4, 7, 3, 3, 9, 0, 8, 0, 8
        System.out.print(test.seat() + " " + test.seat() + " " + test.seat());
        test.leave(0);
        test.leave(4);
        System.out.print(" " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat());
        test.leave(0);
        test.leave(4);
        System.out.print(" " + test.seat() + " " + test.seat());
        test.leave(7);
        System.out.print(" " + test.seat());
        test.leave(3);
        System.out.print(" " + test.seat());
        test.leave(3);
        System.out.print(" " + test.seat());
        test.leave(9);
        System.out.print(" " + test.seat());
        test.leave(0);
        test.leave(8);
        System.out.print(" " + test.seat() + " " + test.seat());
        test.leave(0);
        test.leave(8);
        System.out.println(" " + test.seat() + " " + test.seat());
        test.leave(2);

        test = new Z5ExamSeat(9);
        // 0, 8, 4, 2, 5, 1, 3, 4, 6, 7, 3]
        System.out.print(test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat());
        test.leave(4);
        System.out.print(" " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat() + " " + test.seat());
        test.leave(3);
        System.out.println(" " + test.seat());
    }
}
