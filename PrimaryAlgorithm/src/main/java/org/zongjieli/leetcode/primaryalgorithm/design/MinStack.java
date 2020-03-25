package org.zongjieli.leetcode.primaryalgorithm.design;

import java.util.LinkedList;

/**
 * @ClassName: MinStack
 * @Description: 设计一个栈类, 支持 push pop top 等操作
 * 而且可以在常数时间内检索到最小元素
 * @Author: Zongjie.Li
 * @Date: 2020/3/25
 * @Version: 1.0
 **/
public class MinStack {
    private int min = Integer.MAX_VALUE;
    private LinkedList<Integer> stack;

    public MinStack() {
        this.stack = new LinkedList();
    }

    public void push(int x) {
        // 将元素推入栈中
        stack.addFirst(x);
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        // 删除栈顶元素
        int deleteObj = stack.poll();
        if (deleteObj == min) {
            min = Integer.MAX_VALUE;
            for (int i : stack) {
                min = min < i ? min : i;
            }
        }
    }

    public int top() {
        // 获取栈顶元素
        return stack.get(0);
    }

    public int getMin() {
        return this.min;
    }

}
