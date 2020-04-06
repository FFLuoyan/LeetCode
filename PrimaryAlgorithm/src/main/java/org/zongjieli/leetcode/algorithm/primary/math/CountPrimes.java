package org.zongjieli.leetcode.algorithm.primary.math;

/**
 * @ClassName: CountPrimes
 * @Description: 计算小于某个非负整数的质数的数量
 * @Author: Zongjie.Li
 * @Date: 2020/3/25
 * @Version: 1.0
 **/
public class CountPrimes {
    public int countPrimes(int n){
//        int[] primeArray = new int[n];
//        int primeSize = 0;
//        for (int checkNumber = 2; checkNumber < n ;checkNumber++){
//            boolean isPrime = true;
//            for (int primeNumberIndex = 0 ; primeNumberIndex < primeSize ; primeNumberIndex ++){
//                if (checkNumber % primeArray[primeNumberIndex] == 0){
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime){
//                primeArray[primeSize++] = checkNumber;
//            }
//        }
//        return primeSize;
        boolean[] compositeArray = new boolean[n];
        int primeSize = 0;
        for (int checkNumber = 2 ; checkNumber < n ; checkNumber++){
            // checkNumber 表示需要校验的数字
            if (!compositeArray[checkNumber]){
                // 每一个校验过得数字都设置为 true,说明不是质数,未被校验的数字则为默认值 false
                primeSize ++;
                // 没找到一个未被校验过的数字,则说明该数字为质数
                // 针对每个被校验的数字,均会被前面的数字校验一遍,如果前面的数字的校验均通过,说明为质数
                for (int compositeNumber = checkNumber + checkNumber; compositeNumber < n ;compositeNumber += checkNumber){
                    compositeArray[compositeNumber] = true;
                }
            }
        }
        return primeSize;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(500000));
        // 超时方法 45138
    }
}
