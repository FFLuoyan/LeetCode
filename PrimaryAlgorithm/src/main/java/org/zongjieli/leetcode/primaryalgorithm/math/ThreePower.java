package org.zongjieli.leetcode.primaryalgorithm.math;

/**
 * @ClassName: ThreePower
 * @Description: 判断一个数是不是 3 的整数次幂
 * @Author: Zongjie.Li
 * @Date: 2020/3/26
 * @Version: 1.0
 **/
public class ThreePower {
    public boolean isPowerOfThree (int n){
        if (n < 1){
            return false;
        }
        while (n != 1){
            if (n % 3 == 0){
                n /= 3;
            }else {
                break;
            }
        }
        if (n == 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ThreePower threePower = new ThreePower();
        System.out.println(threePower.isPowerOfThree(0));
        System.out.println(threePower.isPowerOfThree(1));
//        System.out.println(threePower.isPowerOfThree(3));
//        System.out.println(threePower.isPowerOfThree(100));
//        System.out.println(threePower.isPowerOfThree(81));
    }
}
