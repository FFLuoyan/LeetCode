package org.zongjieli.leetcode.question.daily.year2023.month2.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个函数 f(x, y) 和一个目标结果 z
 * 函数公式未知,请计算方程 f(x,y) == z 所有可能的正整数数对 x 和 y
 * 满足条件的结果数对可以按任意顺序返回
 * 尽管函数的具体式子未知,但它是单调递增函数,也就是说:
 *  f(x, y) < f(x + 1, y)
 *  f(x, y) < f(x, y + 1)
 * 函数接口定义如下:
 * interface CustomFunction {
 *  public:
 *      // Returns some positive integer f(x, y) for two positive integers x and y based on a formula.
 *      int f(int x, int y);
 *  };
 * 解决方案将按如下规则进行评判:
 * 判题程序有一个由 CustomFunction 的 9 种实现组成的列表,以及一种为特定的 z 生成所有有效数对的答案的方法
 * 判题程序接受两个输入: function_id(决定使用哪种实现测试你的代码)以及目标结果 z
 * 判题程序将会调用实现的 findSolution 并将结果与答案进行比较
 * 如果结果与答案相符,那么解决方案将被视作正确答案,即 Accepted
 *
 * 1 <= function_id <= 9
 * 1 <= z <= 100
 * 题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内
 * 在 1 <= x, y <= 1000 的前提下,题目保证 f(x, y) 是一个 32 位有符号整数
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/18
 */
public class Z6FindResult {

    interface CustomFunction {
        public int f(int x, int y);
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int x = 1, y = 1, current;
        List<List<Integer>> result = new ArrayList<>();
        while (x <= 1000 && customfunction.f(x++, y) < z) {}
        // current >= z 或者 x > 1000
        while (x > 0 && y <= 1000) {
            if ((current = customfunction.f(x, y)) == z) {
                result.add(Arrays.asList(x--, y++));
            } else if (current < z) {
                y++;
            } else {
                x--;
            }
        }
        return result;
    }

}
