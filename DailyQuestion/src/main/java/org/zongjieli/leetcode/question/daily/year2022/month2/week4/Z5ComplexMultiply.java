package org.zongjieli.leetcode.question.daily.year2022.month2.week4;
/**
 * 复数可以用字符串表示,遵循 "实部+虚部i" 的形式,并满足下述条件:
 *  实部是一个整数,取值范围是 [-100, 100]
 *  虚部也是一个整数,取值范围是 [-100, 100]
 *  i^2 == -1
 *
 * 给定两个字符串表示的复数 num1 和 num2
 * 请遵循复数表示形式,返回表示它们乘积的字符串
 *
 * num1 和 num2 都是有效的复数表示
 *
 * @author   Li.zongjie
 * @date     2022/2/28
 * @version  1.0
 */
public class Z5ComplexMultiply {
    public String complexNumberMultiply(String num1, String num2) {
        int split1 = num1.indexOf('+');
        int split2 = num2.indexOf('+');
        int r1 = Integer.parseInt(num1.substring(0, split1));
        int r2 = Integer.parseInt(num2.substring(0, split2));

        int i1 = Integer.parseInt(num1.substring(split1 + 1, num1.length() - 1));
        int i2 = Integer.parseInt(num2.substring(split2 + 1, num2.length() - 1));

        // StringBuilder can be replaced with String
        // 百度发现,String 连加的底层会被编译器优化为 StringBuilder 类型,待验证
        return String.valueOf(r1 * r2 - i1 * i2) + '+' + (r1 * i2 + r2 * i1) + 'i';
    }

    public static void main(String[] args) {
        Z5ComplexMultiply test = new Z5ComplexMultiply();
        System.out.println(test.complexNumberMultiply("1+1i", "1+1i"));
    }
}
