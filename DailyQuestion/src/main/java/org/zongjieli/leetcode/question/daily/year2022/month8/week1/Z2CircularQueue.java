package org.zongjieli.leetcode.question.daily.year2022.month8.week1;
/**
 * 设计一个循环队列实现
 * 循环队列是一种线性数据结构,其操作表现基于 FIFO(先进先出)原则
 * 并且队尾被连接在队首之后以形成一个循环,它也被称为 "环形缓冲器"
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间
 * 在一个普通队列里,一旦一个队列满了,我们就不能插入下一个元素,即使在队列前面仍有空间
 * 但是使用循环队列,我们能使用这些空间去存储新的值
 *
 * 这个实现应该支持如下操作:
 *
 *  Z2CircularQueue(k): 构造器,设置队列长度为 k
 *  Front:              从队首获取元素,如果队列为空,返回 -1
 *  Rear:               获取队尾元素,如果队列为空,返回 -1
 *  enQueue(value):     向循环队列插入一个元素,如果成功插入则返回真
 *  deQueue():          从循环队列中删除一个元素,如果成功删除则返回真
 *  isEmpty():          检查循环队列是否为空
 *  isFull():           检查循环队列是否已满
 *
 * 所有的值都在 0 至 1000 的范围内
 * 操作数将在 1 至 1000 的范围内
 * 请不要使用内置的队列库
 *
 * @author   Li.zongjie
 * @date     2022/8/2
 * @version  1.0
 */
public class Z2CircularQueue {

    private int size;
    private int[] values;
    private int ai = 0;
    private int di = 0;

    public Z2CircularQueue(int k) {
        size = k;
        values = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        values[ai++ % size] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        di++;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return values[di % size];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return values[(ai - 1) % size];
    }

    public boolean isEmpty() {
        return di == ai;
    }

    public boolean isFull() {
        return ai - di == size;
    }
}
