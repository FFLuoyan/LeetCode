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

    public boolean isPowerOfThreeByLog (int n){
        // 猜测,自然对数为底的对数函数,由于底较小,容易出现精度的问题,导致计算错误
        return ((Math.log10(n) % Math.log10(3)) % 1) == 0;
    }

    public static void main(String[] args) {

    }
}
