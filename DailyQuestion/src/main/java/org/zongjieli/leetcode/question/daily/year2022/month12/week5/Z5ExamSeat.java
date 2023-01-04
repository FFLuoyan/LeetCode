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

    private final TreeMap<Integer, PriorityQueue<Integer>> leftDistanceSeatsMap;
    private final TreeMap<Integer, Integer> seatLeftDistanceMap;
    private final int n;

    public Z5ExamSeat(int n) {
        leftDistanceSeatsMap = new TreeMap<>();
        seatLeftDistanceMap = new TreeMap<>();
        this.n = n;
    }

    public int seat() {
        if (leftDistanceSeatsMap.isEmpty()) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.add(0);
            leftDistanceSeatsMap.put(0, queue);
            seatLeftDistanceMap.put(0, 0);
            return 0;
        }
        int rightMax = n - 1 - seatLeftDistanceMap.lastKey();
        int leftMax = seatLeftDistanceMap.firstKey();
        int seatMaxLeftDistance = leftDistanceSeatsMap.lastKey();
        int seatMax = seatMaxLeftDistance / 2;
        if (rightMax > seatMax && rightMax > leftMax) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.add(n - 1);
            leftDistanceSeatsMap.put(rightMax, queue);
            seatLeftDistanceMap.put(n - 1, rightMax);
            return n - 1;
        } else if (leftMax >= seatMax) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.add(0);
            leftDistanceSeatsMap.put(0, queue);
            seatLeftDistanceMap.put(0, 0);
            return 0;
        } else {
            // 如果 seatMaxLeftDistance 为单数
            // seatMaxLeftDistance - 1 对应的位置也是最小值
            // 需要判断最小的数据的位置
            if ((seatMaxLeftDistance & 1) == 1 && leftDistanceSeatsMap.containsKey(seatMaxLeftDistance - 1)) {
                int rightSeat = leftDistanceSeatsMap.lastEntry().getValue().peek();
                int leftSeat = leftDistanceSeatsMap.get(seatMaxLeftDistance - 1).peek();
                if (leftSeat < rightSeat) {
                    seatMaxLeftDistance--;
                }
            }
            PriorityQueue<Integer> queue = leftDistanceSeatsMap.get(seatMaxLeftDistance);
            int seat = queue.poll();
            if (queue.isEmpty()) {
                leftDistanceSeatsMap.remove(seatMaxLeftDistance);
            }
            int seatLeftDistance = seatMaxLeftDistance - seatMax;
            leftDistanceSeatsMap.computeIfAbsent(seatLeftDistance, k -> new PriorityQueue<>()).add(seat);
            seatLeftDistanceMap.put(seat, seatLeftDistance);

            int value =  seat - seatLeftDistance;
            leftDistanceSeatsMap.computeIfAbsent(seatMax, k -> new PriorityQueue<>()).add(value);
            seatLeftDistanceMap.put(value, seatMax);
            return value;
        }
    }

    public void leave(int p) {
        int distance = seatLeftDistanceMap.remove(p);
        PriorityQueue<Integer> queue = leftDistanceSeatsMap.get(distance);
        queue.remove(p);
        if (queue.isEmpty()) {
            leftDistanceSeatsMap.remove(distance);
        }
        if (p == 0) {
            return;
        }
        Map.Entry<Integer, Integer> rightSeatEntry = seatLeftDistanceMap.higherEntry(p);
        if (rightSeatEntry == null) {
            return;
        }
        int rightSeat = rightSeatEntry.getKey();
        int rightSeatDistance = rightSeatEntry.getValue();
        int rightSeatDistanceAfter = rightSeatDistance + distance;
        seatLeftDistanceMap.put(rightSeat, rightSeatDistanceAfter);
        queue = leftDistanceSeatsMap.get(rightSeatDistance);
        queue.remove(rightSeat);
        if (queue.isEmpty()) {
            leftDistanceSeatsMap.remove(rightSeatDistance);
        }
        leftDistanceSeatsMap.computeIfAbsent(rightSeatDistanceAfter, k -> new PriorityQueue<>()).add(rightSeat);
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
    }
}
