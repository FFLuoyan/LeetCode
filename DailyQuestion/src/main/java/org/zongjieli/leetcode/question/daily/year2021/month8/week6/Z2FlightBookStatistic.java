package org.zongjieli.leetcode.question.daily.year2021.month8.week6;
/**
 * 有 n 个航班,分别从 1 到 n 进行编号
 * 有一份航班预订表 bookings,表中第 i 条预订记录 bookings[i] = [firstI, lastI, seatsI] 
 * 意味着在从 firstI 到 lastI (包含 firstI 和 lastI) 的每个航班上预订了 seatsI 个座位
 *
 * 请返回一个长度为 n 的数组 answer,其中 answer[i] 是航班 i 上预订的座位总数
 *
 * 1 <= n <= 2 * 10^4
 * 1 <= bookings.length <= 2 * 10^4
 * bookings[i].length == 3
 * 1 <= firstI <= lastI <= n
 * 1 <= seatsI <= 10^4
 *
 * @author   Li.zongjie
 * @date     2021/9/1
 * @version  1.0
 */
public class Z2FlightBookStatistic {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            answer[booking[0] - 1] += booking[2];
            if (booking[1] < n){
                answer[booking[1]] -= booking[2];
            }
        }
        for (int i = 1 ; i < n ; i++){
            answer[i] += answer[i - 1];
        }
        return answer;
    }
}
