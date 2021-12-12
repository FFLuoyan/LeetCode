package org.zongjieli.leetcode.competion.singleweekly.order271;
/**
 * Alice 和 Bob 打算给花园里的 n 株植物浇水
 * 植物排成一行,从左到右进行标记,编号从 0 到 n - 1
 * 其中,第 i 株植物的位置是 x = i
 * 每一株植物都需要浇特定量的水,Alice 和 Bob 每人有一个水罐,最初是满的
 * 他们按下面描述的方式完成浇水:
 *  Alice 按从左到右的顺序给植物浇水,从植物 0 开始
 *  Bob 按从右到左的顺序给植物浇水,从植物 n - 1 开始,他们同时给植物浇水
 *  如果没有足够的水完全浇灌下一株植物,他 / 她会立即重新灌满浇水罐
 *  不管植物需要多少水,浇水所耗费的时间都是一样的
 *  不能提前重新灌满水罐
 *  每株植物都可以由 Alice 或者 Bob 来浇水
 *  如果 Alice 和 Bob 到达同一株植物,那么当前水罐中水更多的人会给这株植物浇水
 *  如果他俩水量相同,那么 Alice 会给这株植物浇水
 * 给定一个下标从 0 开始的整数数组 plants,数组由 n 个整数组成
 * 其中,plants[i] 为第 i 株植物需要的水量
 * 另有两个整数 capacityA 和 capacityB 分别表示 Alice 和 Bob 水罐的容量
 * 返回两人浇灌所有植物过程中重新灌满水罐的次数
 *
 * n == plants.length
 * 1 <= n <= 10^5
 * 1 <= plants[i] <= 10^6
 * max(plants[i]) <= capacityA, capacityB <= 10^9
 *
 * @author   Li.zongjie
 * @date     2021/12/12
 * @version  1.0
 */
public class WaterPlant {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int aIndex = 0;
        int bIndex = plants.length - 1;
        int aCapacity = capacityA;
        int bCapacity = capacityB;
        int result = 0;
        while (aIndex <= bIndex){
            if (aIndex == bIndex){
                if (Math.max(aCapacity,bCapacity) < plants[aIndex]){
                    result++;
                }
                break;
            }
            if ((aCapacity -= plants[aIndex]) < 0){
                result++;
                aCapacity = capacityA - plants[aIndex];
            }

            if ((bCapacity -= plants[bIndex]) < 0){
                result++;
                bCapacity = capacityB - plants[bIndex];
            }

            aIndex++;
            bIndex--;
        }
        return result;
    }
}
