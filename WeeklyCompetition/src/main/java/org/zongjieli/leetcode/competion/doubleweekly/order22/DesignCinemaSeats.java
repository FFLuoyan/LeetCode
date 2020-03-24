package org.zongjieli.leetcode.competion.doubleweekly.order22;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DesignCinemaSeats
 * @Description: 设计电影院中可以安排多少个四人家庭的数目
 * 每行有 10 个座位,3 和 4,7 和 8 中间有过道,四人家庭必须坐在一起
 * 但是四人家庭可以分为 2 个 2 人组合
 * 入参表示已经被占用的位置的坐标int[][] List
 * 第二个数字表示的是坐标
 * n 表示该电影院总共有多少行座位
 * @Author: Zongjie.Li
 * @Date: 2020/3/21
 * @Version: 1.0
 **/
public class DesignCinemaSeats {

    public static void main(String[] args) {
        DesignCinemaSeats seats = new DesignCinemaSeats();
        int a = 2 * 1000000000;
        System.out.println(a);
        System.out.println(seats.maxNumberOfFamilies(3, new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 8}, new int[]{2, 6}, new int[]{3, 1}, new int[]{3, 10}}));
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Integer> seatRecords = new HashMap<>();
        int count = 0;
        for (int seatIndex = 0; seatIndex < reservedSeats.length; seatIndex++) {
            int seatValue = 0;
            int seatPosition = reservedSeats[seatIndex][1];
            if (seatPosition == 2 || seatPosition == 3) {
                //0001
                seatValue = 1;
            } else if (seatPosition == 4 || seatPosition == 5) {
                //0010
                seatValue = 2;
            } else if (seatPosition == 6 || seatPosition == 7) {
                //0100
                seatValue = 4;
            } else if (seatPosition == 8 || seatPosition == 9) {
                //1000
                seatValue = 8;
            }
            Integer recordObject = seatRecords.get(reservedSeats[seatIndex][0]);
            int recordValue = recordObject == null ? 0 : recordObject;
            if ((recordValue | seatValue) != recordValue) {
                // 如果值不相同,说明有新的位置被占用
                int seatBeforeCount;
                if ((recordValue & 3) == 0) {
                    // 此时应当检测 12 位是否被占用
                    if ((recordValue & 12) == 0) {
                        // 1234 位均无占用,则可以容纳两个家庭
                        seatBeforeCount = 2;
                    } else {
                        seatBeforeCount = 1;
                    }
                } else if ((recordValue & 6) == 0 || (recordValue & 12) == 0) {
                    seatBeforeCount = 1;
                } else {
                    seatBeforeCount = 0;
                }
                recordValue |= seatValue;
                seatRecords.put(reservedSeats[seatIndex][0],recordValue);
                int seatAfterCount;
                if ((recordValue & 3) == 0) {
                    if ((recordValue & 12) == 0) {
                        seatAfterCount = 2;
                    } else {
                        seatAfterCount = 1;
                    }
                } else if ((recordValue & 6) == 0 || (recordValue & 12) == 0) {
                    seatAfterCount = 1;
                } else {
                    seatAfterCount = 0;
                }
                count -= (seatBeforeCount - seatAfterCount);
            }
        }
        return count + n + n;
    }
}
