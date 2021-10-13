package org.zongjieli.leetcode.question.daily.year2021.month10.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序,输出从 1 到 n 数字的字符串表示
 *  1. 如果 n 是 3 的倍数,输出 "Fizz"
 *  2. 如果 n 是 5 的倍数,输出 "Buzz"
 *  3. 如果 n 同时是 3 和 5 的倍数,输出 "FizzBuzz"
 *
 * @author   Li.zongjie
 * @date     2021/10/13
 * @version  1.0
 */
public class Z3FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(2 * n);
        String a = "Fizz";
        String b = "Buzz";
        String c = "FizzBuzz";
        for (int i = 1 ; i <= n ; i++){
            if (i % 3 == 0){
                if (i % 5 == 0){
                    result.add(c);
                } else {
                    result.add(a);
                }
            } else if (i % 5 == 0){
                result.add(b);
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
