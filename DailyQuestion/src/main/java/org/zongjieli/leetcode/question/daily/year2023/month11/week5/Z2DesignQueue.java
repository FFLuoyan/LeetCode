package org.zongjieli.leetcode.question.daily.year2023.month11.week5;

/**
 * 请设计一个队列,支持在前,中,后三个位置的 push 和 pop 操作
 * 请完成 Z2DesignQueue 类:
 *  Z2DesignQueue() 初始化队列
 *  void pushFront(int val) 将 val 添加到队列的最前面
 *  void pushMiddle(int val) 将 val 添加到队列的正中间
 *  void pushBack(int val) 将 val 添加到队里的最后面
 *  int popFront() 将最前面的元素从队列中删除并返回值,如果删除之前队列为空,那么返回 -1
 *  int popMiddle() 将正中间的元素从队列中删除并返回值,如果删除之前队列为空,那么返回 -1
 *  int popBack() 将最后面的元素从队列中删除并返回值,如果删除之前队列为空,那么返回 -1
 * 请注意当有两个中间位置的时候,选择靠前面的位置进行操作,比方说:
 *  将 6 添加到 [1, 2, 3, 4, 5] 的中间位置,结果数组为 [1, 2, 6, 3, 4, 5]
 *  从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素,返回 3,数组变为 [1, 2, 4, 5, 6]
 *
 * 1 <= val <= 10^9
 * 最多调用 1000 次 pushFront, pushMiddle, pushBack, popFront, popMiddle 和 popBack
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/28
 */
public class Z2DesignQueue {

    private final Node start;

    private final Node end;

    private Node middle;

    private int size = 0;

    class Node {

        int value;

        Node before;

        Node after;

        Node(int val) {
            value = val;
        }

        Node(int val, Node a, Node b) {
            value = val;
            after = a;
            before = b;
        }

    }
    public Z2DesignQueue() {
        start = new Node(-1);
        end = new Node(-1, null, start);
        start.after = end;
        middle = start;
    }

    public void pushFront(int val) {
        Node first = start.after;
        Node add = new Node(val, first, start);
        first.before = add;
        start.after = add;
        if (++size % 2 == 0) {
            middle = middle.before;
        } else if (middle == start) {
            middle = add;
        }
    }

    public void pushMiddle(int val) {
        if (++size % 2 == 1) {
            // 加在后面
            Node after = middle.after;
            Node add = new Node(val, after, middle);
            after.before = add;
            middle.after = add;
            middle = add;
        } else {
            Node before = middle.before;
            Node add = new Node(val, middle, before);
            before.after = add;
            middle.before = add;
            middle = middle.before;
        }
    }

    public void pushBack(int val) {
        Node last = end.before;
        Node add = new Node(val, end, last);
        last.after = add;
        end.before = add;
        if (++size % 2 == 1) {
            middle = middle.after;
        }
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        Node first = start.after;
        start.after = first.after;
        first.after.before = start;
        if (--size % 2 == 1) {
            middle = middle.after;
        } else if (middle == first) {
            middle = start;
        }
        return first.value;
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        Node remove = middle;
        middle.before.after = middle.after;
        middle.after.before = middle.before;
        middle = --size % 2 == 0 ? middle.before : middle.after;
        return remove.value;
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        Node last = end.before;
        last.before.after = end;
        end.before = last.before;
        if (--size % 2 == 0) {
            middle = middle.before;
        }
        return last.value;
    }

    public static void main(String[] args) {
        Z2DesignQueue test = new Z2DesignQueue();
        test.pushFront(1);
        test.pushBack(2);
        test.pushMiddle(3);
        // 3
        System.out.println(test.popMiddle());
        // 1
        System.out.println(test.popMiddle());
        // 2
        System.out.println(test.popBack());
        // -1
        System.out.println(test.popFront());
        test.pushBack(10);
        // 10
        System.out.println(test.popMiddle());
        // -1
        System.out.println(test.popMiddle());
        // -1
        System.out.println(test.popMiddle());
        test.pushMiddle(773222);
        test.pushMiddle(279355);
        // 279355
        System.out.println(test.popMiddle());
        // 773222
        System.out.println(test.popMiddle());
        // -1
        System.out.println(test.popMiddle());
        // -1
        System.out.println(test.popBack());
        // -1
        System.out.println(test.popMiddle());
        // -1
        System.out.println(test.popFront());
        test.pushBack(448905);
        // 448905
        System.out.println(test.popFront());
        test.pushMiddle(168284);
        test.pushMiddle(874541);
        // 874541
        System.out.println(test.popMiddle());
        // 168284
        System.out.println(test.popBack());
        test.pushFront(15656);
        // 15656
        System.out.println(test.popMiddle());
        test.pushMiddle(803226);
        test.pushMiddle(720129);
        test.pushMiddle(626048);
        // 626048
        System.out.println(test.popMiddle());
        test.pushMiddle(860306);
        // 803226
        System.out.println(test.popBack());
        test.pushMiddle(630886);
        // 630886
        System.out.println(test.popMiddle());
        // 720129
        System.out.println(test.popMiddle());
        // 860306
        System.out.println(test.popMiddle());
        // -1
        System.out.println(test.popMiddle());
    }
}
