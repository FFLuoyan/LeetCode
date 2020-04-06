package org.zongjieli.leetcode.algorithm.primary.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: NumberToString
 * @Description: 根据输入的 n 输出一个长度为 n 的字符串 List
 *              对应的位置如果为 3 的倍数,则为 Fizz
 *              如果为 5 的倍数,则为 Buzz
 *              如果即为 3 的倍数,又为 5 的倍数,则为 FizzBuzz
 *              如果没有,则为当前数字的字符串
 *
 *              该方法可以使用 Map 进行映射,然后对 String 进行想加,可以实现针对多个映射的通用解法
 *
 * @Author: Zongjie.Li
 * @Date: 2020/3/25
 * @Version: 1.0
 **/
public class NumberToString {

    private final String nullString = "";
    private final String fizz = "Fizz";
    private final String buzz = "Buzz";
    private final String fizzBuzz = "FizzBuzz";

    public List<String> fizzBuzz (int n){
        List<String> stringList = new ArrayList<>(n);
        for (int i = 1 ; i<= n ; i++){
            String add = nullString;
            if (i % 3 == 0){
                add = fizz;
            }
            if (i % 5 == 0){
                add = add == nullString ? buzz : fizzBuzz;
            }
            add = add == nullString ? String.valueOf(i) : add;
            stringList.add(add);
        }
        return stringList;
    }

    public static void main(String[] args) {
        System.out.println(new NumberToString().fizzBuzz(15));
    }
}
