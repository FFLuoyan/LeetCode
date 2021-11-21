package org.zongjieli.leetcode.competion.singleweekly.order268;
/**
 * 用一个水罐给花园里的 n 株植物浇水
 * 植物排成一行,从左到右进行标记
 * 编号从 0 到 n - 1,其中,第 i 株植物的位置是 x = i
 * x = -1 处有一条河,可以在那里重新灌满水罐
 *
 * 每一株植物都需要浇特定量的水
 * 将会按下面描述的方式完成浇水:
 *  按从左到右的顺序给植物浇水
 *  在给当前植物浇完水之后,如果你没有足够的水完全浇灌下一株植物,那么就需要返回河边重新装满水罐
 *  你不能提前重新灌满水罐
 *  最初,在河边(也就是，x = -1),在 x 轴上每移动一个单位都需要一步
 *
 * 给定一个下标从 0 开始的整数数组 plants
 * 数组由 n 个整数组成,其中 plants[i] 为第 i 株植物需要的水量
 * 另有一个整数 capacity 表示水罐的容量,返回浇灌所有植物需要的步数
 *
 * n == plants.length
 * 1 <= n <= 1000
 * 1 <= plants[i] <= 10^6
 * max(plants[i]) <= capacity <= 10^9
 *
 * @author   Li.zongjie
 * @date     2021/11/21
 * @version  1.0
 */
public class WaterPlant {
    public int wateringPlants(int[] plants, int capacity) {
        int currentCapacity = capacity;
        int currentIndex = 0;
        int result = 0;
        while (currentIndex < plants.length){
            if (currentCapacity >= plants[currentIndex]){
                currentCapacity -= plants[currentIndex];
                currentIndex++;
                result++;
            } else {
                result += (2 * currentIndex);
                currentCapacity = capacity;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WaterPlant test = new WaterPlant();
        System.out.println(test.wateringPlants(new int[]{2,2,3,3,3}, 5));
    }
}
