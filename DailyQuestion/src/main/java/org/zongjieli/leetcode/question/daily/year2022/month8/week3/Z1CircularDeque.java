package org.zongjieli.leetcode.question.daily.year2022.month8.week3;
/**
 * 设计实现双端队列
 * 实现 Z1CircularDeque 类:
 *
 * Z1CircularDeque(int k):
 *  构造函数,双端队列最大为 k
 * boolean insertFront():
 *  将一个元素添加到双端队列头部,如果操作成功返回 true,否则返回 false
 * boolean insertLast():
 *  将一个元素添加到双端队列尾部,如果操作成功返回 true,否则返回 false
 * boolean deleteFront():
 *  从双端队列头部删除一个元素,如果操作成功返回 true,否则返回 false
 * boolean deleteLast():
 *  从双端队列尾部删除一个元素,如果操作成功返回 true,否则返回 false
 * int getFront():
 *  从双端队列头部获得一个元素,如果双端队列为空,返回 -1
 * int getRear():
 *  获得双端队列的最后一个元素,如果双端队列为空,返回 -1
 * boolean isEmpty():
 *  若双端队列为空,则返回 true,否则返回 false
 * boolean isFull():
 *  若双端队列满了,则返回 true,否则返回 false
 *
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull 调用次数不大于 2000 次
 *
 * @author   Li.zongjie
 * @date     2022/8/15
 * @version  1.0
 */
public class Z1CircularDeque {

    int[] values;
    int start = 0;
    int end = 0;
    int l;

    public Z1CircularDeque(int k) {
        values = new int[k + 1];
        l = k + 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        values[start--] = value;
        if (start < 0) {
            start = l - 1;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (++end == l) {
            end = 0;
        }
        values[end] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (++start == l) {
            start = 0;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (--end == -1) {
            end = l - 1;
        }
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : values[start == l - 1 ? 0 : start + 1];
    }

    public int getRear() {
        return isEmpty() ? -1 : values[end];
    }

    public boolean isEmpty() {
        return start == end;
    }

    public boolean isFull() {
        return (end + l - start) % l == l - 1;
    }

    public static void main(String[] args) {
        Z1CircularDeque test = new Z1CircularDeque(3);
        // true
        System.out.println(test.insertLast(1));
        // true
        System.out.println(test.insertLast(2));
        // true
        System.out.println(test.insertFront(3));
        // false
        System.out.println(test.insertFront(4));
        // 2
        System.out.println(test.getRear());
        // true
        System.out.println(test.isFull());
        // true
        System.out.println(test.deleteLast());
        // true
        System.out.println(test.insertFront(4));
        // 4
        System.out.println(test.getFront());
    }
}
