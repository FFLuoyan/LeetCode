package org.zongjieli.leetcode.question.daily.year2021.month3.week3;
/**
 * 给停车场设计一个停车系统,停车场总共有三个不同大小的停车位
 * 每种尺寸有固定数目的车位
 *
 * 请你实现
 *
 *  ParkingSystem(int big,int medium,int small)初始化类
 *  三个参数分别对应每种停车位的数目
 *
 *  bool addCar(int certType) 检查是否有 carType 对应的停车位
 *  carType 有三种类型,大、中、小,分别用数字 1,2,3 表示
 *  一辆车只能停在 carType 对应尺寸的车位中,如果没有空车位
 *  请返回 false,否则该车将停入车位并返回 true
 *
 * @author   Zongjie.Li
 * @date     2021/3/19
 * @version  1.0
 */
public class ParkingSystem {

    private final int[] park;

    public ParkingSystem(int big, int medium, int small) {
        this.park = new int[]{0,big,medium,small};
    }

    public boolean addCar(int carType) {
        return park[carType] -- > 0;
    }
}
