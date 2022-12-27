package org.zongjieli.leetcode.question.daily.year2022.month12.week4;

/**
 * 存在一种仅支持 4 种操作和 1 个变量 X 的编程语言:
 * ++X 和 X++ 使变量 X 的值 加 1
 * --X 和 X-- 使变量 X 的值 减 1
 * 最初,X 的值是 0
 * 给定一个字符串数组 operations,这是由操作组成的一个列表,返回执行所有操作后 X 的最终值
 *
 * 1 <= operations.length <= 100
 * operations[i] 将会是 "++X"、"X++"、"--X" 或 "X--"
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/27
 */
public class Z5OperateValue {

    public int finalValueAfterOperations(String[] operations) {
        int value = 0;
        for (String operation : operations) {
            value -= (operation.charAt(1) - 44);
        }
        return value;
    }

}
