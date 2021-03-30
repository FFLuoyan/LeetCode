package org.zongjieli.leetcode.question.daily.year2021.month3.week3;

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
        int[] store = new int[tokens.length / 2 + 1];
        int storeIndex = 0;
        for (String value : tokens){
            char firstChar = value.charAt(0);
            if (value.length() > 1){
                // 大于 1 的肯定为数字
                boolean isPositive = true;
                int valueIndex = 0;
                if (firstChar == '-') {
                    isPositive = false;
                    valueIndex ++;
                }
                int number = Character.digit(value.charAt(valueIndex++),10);
                while (valueIndex < value.length()){
                    number = 10 * number + Character.digit(value.charAt(valueIndex++),10);
                }
                if (!isPositive){
                    number = number * (-1);
                }
                store[storeIndex++] = number;
                continue;
            }
            switch (firstChar){
                case '+':
                    storeIndex--;
                    store[storeIndex - 1] = store[storeIndex - 1] + store[storeIndex];
                    break;
                case '-':
                    storeIndex--;
                    store[storeIndex - 1] = store[storeIndex - 1] - store[storeIndex];
                    break;
                case '*':
                    storeIndex--;
                    store[storeIndex - 1] = store[storeIndex - 1] * store[storeIndex];
                    break;
                case '/':
                    storeIndex--;
                    store[storeIndex - 1] = store[storeIndex - 1] / store[storeIndex];
                    break;
                default:
                    store[storeIndex++] = Character.digit(firstChar,10);
            }
        }
        return store[0];
    }

    public static void main(String[] args) {
        ReversePolishNotation notation = new ReversePolishNotation();
        System.out.println(notation.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
