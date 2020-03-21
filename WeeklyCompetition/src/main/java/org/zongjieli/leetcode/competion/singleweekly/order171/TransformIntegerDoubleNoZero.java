package org.zongjieli.leetcode.competion.singleweekly.order171;

import java.util.Arrays;

/**
 * @ClassName: TransformIntegerDoubleNoZero
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/12
 * @Version: 1.0
 **/
public class TransformIntegerDoubleNoZero {
    public static int[] getNoZeroInteger(int n){
        for(int i = 0; i < n ; i++){
            if(String.valueOf(i).indexOf('0') == -1 && String.valueOf(n-i).indexOf('0') == -1){
                return new int[]{i,n-i};
            }
        }
        return null;
    }
    public static void main(String[] args) {
System.out.println(Arrays.toString(getNoZeroInteger(108)));
    }
}
