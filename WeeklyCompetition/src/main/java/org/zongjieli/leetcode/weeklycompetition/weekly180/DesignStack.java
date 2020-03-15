package org.zongjieli.leetcode.weeklycompetition.weekly180;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DesignStack
 * @Description: 自己设计一个栈类, 要求符合以下条件
 * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
 * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
 * int pop()：返回栈顶的值，或栈为空时返回 -1 。
 * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 * @Author: Zongjie.Li
 * @Date: 2020/3/15
 * @Version: 1.0
 **/
public class DesignStack {

    private int size = 0;
    private int[] stackValues;

    public DesignStack(int maxSize) {
        this.stackValues = new int[maxSize];
    }

    public void push(int x) {
        if (this.size < this.stackValues.length) {
            this.stackValues[size++] = x;
        }
    }

    public int pop() {
        if (this.size > 0) {
            return this.stackValues[this.size-- - 1];
        }
        return -1;
    }

    public void inc(int k, int val) {
        for (int i = 0; i < k && i < this.size; i++) {
            this.stackValues[i] += val;
        }
    }

    public static void main(String[] args) {
        DesignStack designStack = new DesignStack(3);
        designStack.push(1);
        designStack.push(2);
        designStack.pop();
        designStack.push(2);
        designStack.push(3);
        designStack.push(4);
        designStack.inc(5,100);
        designStack.inc(2,100);
        designStack.pop();
        designStack.pop();
        designStack.pop();
        designStack.pop();
    }
}
