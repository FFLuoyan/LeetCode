package org.zongjieli.leetcode.primaryalgorithm.math;

/**
 * @ClassName: CountPrimes
 * @Description: 计算小于某个非负整数的质数的数量
 * @Author: Zongjie.Li
 * @Date: 2020/3/25
 * @Version: 1.0
 **/
public class CountPrimes {
    public int countPrimes(int n){
        int[] primeArray = new int[n];
        int primeSize = 0;
        for (int checkNumber = 2; checkNumber < n ;checkNumber++){
            boolean isPrime = true;
            for (int primeNumberIndex = 0 ; primeNumberIndex < primeSize ; primeNumberIndex ++){
                if (checkNumber % primeArray[primeNumberIndex] == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                primeArray[primeSize++] = checkNumber;
            }
        }
        return primeSize;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(500000));
    }
}
