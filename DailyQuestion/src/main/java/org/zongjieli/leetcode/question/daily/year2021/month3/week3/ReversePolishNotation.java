package org.zongjieli.leetcode.question.daily.year2021.month3.week3;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 *
 * 根据逆波兰表示法求表达式的值
 *
 * 有效的运算符包括 '+','-','*','/'
 * 每个运算对象可以是整数,也可以是另一个逆波兰表达式
 * 整数除法只保留整数部分,给定的逆波兰表达式总是有效的
 *
 * @author   Zongjie.Li
 * @date     2021/3/20
 * @version  1.0
 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> store = new Stack<>();
        for (String value : tokens){
            if (value.length() > 1){
                store.push(Integer.valueOf(value));
                continue;
            }
            switch (value.charAt(0)){
                case '/':
                    int secondValue = store.pop();
                    int firstValue = store.pop();
                    store.push(firstValue / secondValue);
                    break;
                case '*':
                    secondValue = store.pop();
                    firstValue = store.pop();
                    store.push(firstValue * secondValue);
                    break;
                case '+':
                    secondValue = store.pop();
                    firstValue = store.pop();
                    store.push(firstValue + secondValue);
                    break;
                case '-':
                    secondValue = store.pop();
                    firstValue = store.pop();
                    store.push(firstValue - secondValue);
                    break;
                default:
                    store.push(Integer.valueOf(value));
            }
        }
        return store.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotation notation = new ReversePolishNotation();
        System.out.println(notation.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
