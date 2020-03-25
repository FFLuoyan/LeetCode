package org.zongjieli.leetcode.primaryalgorithm.design;

/**
 * @ClassName: MinStackBaseArray
 * @Description: 自设计栈类,与 MinStack 类似,但是基于数组
 * @Author: Zongjie.Li
 * @Date: 2020/3/25
 * @Version: 1.0
 **/
public class MinStackBaseArray {
    private int min = Integer.MAX_VALUE;
    private int[] stack;
    private int size = 0;

    public MinStackBaseArray (){
        this.stack = new int[16];
    }

    public void push(int x){
        // 将元素推入栈中
        this.stack[this.size++] = x;
        this.min = min < x ? min : x;
        if (this.size == this.stack.length){
            int[] newStack = new int[this.stack.length *2];
            for (int index = 0 ;index < this.stack.length ;index ++){
                newStack[index] = this.stack[index];
            }
            this.stack = newStack;
        }
    }

    public void pop(){
        // 删除栈顶元素
        if (this.stack[this.size - 1] == min){
            min = Integer.MAX_VALUE;
            for (int index = 0 ; index < this.size - 1; index ++){
                min = this.stack[index] < min ? this.stack[index] : min;
            }
        }
        this.size --;
    }

    public int top(){
        // 获取栈顶元素
        return stack[this.size - 1];
    }

    public int getMin(){
        return this.min;
    }

    public static void main(String[] args) {
        MinStackBaseArray stackBaseArray = new MinStackBaseArray();
        stackBaseArray.push(-2);
        stackBaseArray.push(0);
        stackBaseArray.push(-3);
        System.out.println(stackBaseArray.getMin());
        stackBaseArray.pop();
        System.out.println(stackBaseArray.top());
        System.out.println(stackBaseArray.getMin());
    }
}
