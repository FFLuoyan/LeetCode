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
        String[] nums1 = num1.split("\\+");
        String[] nums2 = num2.split("\\+");

        int real1 = Integer.parseInt(nums1[0]);
        int real2 = Integer.parseInt(nums2[0]);

        int image1 = Integer.parseInt(nums1[1].substring(0, nums1[1].length() - 1));
        int image2 = Integer.parseInt(nums2[1].substring(0, nums2[1].length() - 1));

        int real = real1 * real2 - image1 * image2;
        int image = real1 * image2 + real2 * image1;

        return real + "+" + image + "i";
    }

    public static void main(String[] args) {
        Z5ComplexMultiply test = new Z5ComplexMultiply();
        System.out.println(test.complexNumberMultiply("1+1i", "1+1i"));
    }
}
