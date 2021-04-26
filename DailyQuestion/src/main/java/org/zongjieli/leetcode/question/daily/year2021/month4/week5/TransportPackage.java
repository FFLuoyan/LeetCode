package org.zongjieli.leetcode.question.daily.year2021.month4.week5;
/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]
 * 每一天都会按给出重量的顺序往传送带上装载包裹
 * 装载的重量不会超过船的最大运载重量
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力
 *
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 *
 * @author   Zongjie.Li
 * @date     2021/4/26
 * @version  1.0
 */
public class TransportPackage {

    public int shipWithinDays(int[] weights, int D) {
        int minTrans = 1;
        for (int weight : weights) {
            minTrans = Math.max(minTrans,weight);
        }
        int[] save = new int[weights.length];
        int[] nextIndex = new int[weights.length];
        int number = 0;
        for (int i = 0 ; i < weights.length ; i++) {
            if (save[number] + weights[i] <= minTrans){
                save[number] += weights[i];
            } else {
                save[++number] = weights[i];
            }
            nextIndex[number] = i + 1;
        }

        while (number + 1 > D){
            int min = save[0] + weights[nextIndex[0]] - minTrans;
            int minIndex = 0;
            for (int i = 1 ; i < number ; i++){
                int temp = save[i] + weights[nextIndex[i]] - minTrans;
                if (temp < min){
                    min = temp;
                    minIndex = i;
                }
            }
            minTrans += min;
            while (nextIndex[minIndex] < weights.length){
                int next = weights[nextIndex[minIndex]];
                if (save[minIndex] + next <= minTrans){
                    save[minIndex] += next;
                    save[minIndex + 1] -= next;
                    nextIndex[minIndex] ++;
                } else {
                    minIndex++;
                }
            }
            number = minIndex;
        }

        return minTrans;
    }

    public static void main(String[] args) {
        TransportPackage transportPackage = new TransportPackage();
        System.out.println( transportPackage.shipWithinDays(new int[]{3,3,9,8,8,8,1},2));
    }
}
