package org.zongjieli.leetcode.primaryalgorithm.design;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName: ShuffleArray
 * @Description: 设计一个类, 可以打乱一个数组并返回结果, 也可以重设数组至它的初始状态
 * @Author: Zongjie.Li
 * @Date: 2020/3/25
 * @Version: 1.0
 **/
public class ShuffleArray {
    private int[] startValue;

    Random random = new Random();

    public ShuffleArray(int[] nums) {
        this.startValue = nums;
    }

    public int[] reset() {
//        int [] resetArray = new int[this.startValue.length];
//        for (int i = 0 ; i < resetArray.length ; i++){
//            resetArray[i] = this.startValue[i];
//        }
        return this.startValue;
    }

    public int[] shuffling(){
        int[] shufflingArray = new int[this.startValue.length];
        for (int i = 0 ; i < shufflingArray.length ; i++){
            shufflingArray[i] = this.startValue[i];
        }
        for (int i = 0 ; i < shufflingArray.length ; i++){
            int randomIndex = random.nextInt(shufflingArray.length - i) + i;
            int temp = shufflingArray[i];
            shufflingArray[i] = shufflingArray[randomIndex];
            shufflingArray[randomIndex] = temp;
        }
        return shufflingArray;
    }

    public static void main(String[] args) {
        ShuffleArray shuffleArray = new ShuffleArray(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println(Arrays.toString(shuffleArray.shuffling()));
    }
}
