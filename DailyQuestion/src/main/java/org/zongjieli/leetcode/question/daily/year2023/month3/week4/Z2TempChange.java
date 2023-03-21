package org.zongjieli.leetcode.question.daily.year2023.month3.week4;

/**
 * 给定一个四舍五入到两位小数的非负浮点数 celsius 来表示温度,以摄氏度(Celsius)为单位
 * 需要将摄氏度转换为开氏度(Kelvin)和华氏度(Fahrenheit)
 * 并以数组 ans = [kelvin, fahrenheit] 的形式返回结果
 * 返回数组 ans,与实际答案误差不超过 10^-5 的会视为正确答案
 * 注意:
 * 开氏度 = 摄氏度 + 273.15
 * 华氏度 = 摄氏度 * 1.80 + 32.00
 *
 * 0 <= celsius <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/21
 */
public class Z2TempChange {

    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.8 + 32};
    }

}
