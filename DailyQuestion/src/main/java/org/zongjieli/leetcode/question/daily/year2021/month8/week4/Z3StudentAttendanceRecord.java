package org.zongjieli.leetcode.question.daily.year2021.month8.week4;
/**
 *
 * 可以用字符串表示一个学生的出勤记录
 * 其中的每个字符用来标记当天的出勤情况(缺勤、迟到、到场)
 * 记录中只含下面三种字符：
 * 'A'：Absent 缺勤
 * 'L'：Late 迟到
 * 'P'：Present 到场
 *
 * 如果学生能够同时满足下面两个条件,则可以获得出勤奖励
 *
 * 一: 按总出勤计,学生缺勤('A')严格少于两天
 * 二: 学生不会存在连续 3 天或连续 3 天以上的迟到('L')记录
 *
 * 给你一个整数 n,表示出勤记录的长度(次数)
 * 请你返回记录长度为 n 时,可能获得出勤奖励的记录情况数量
 * 答案可能很大,所以返回对 10^9 + 7 取余 的结果
 *
 * 1 <= n <= 10^5
 *
 * @author   Li.zongjie
 * @date     2021/8/18
 * @version  1.0
 */
public class Z3StudentAttendanceRecord {

    /**
     * 首先符合条件 1 的情况只有两种
     * 一种是未缺勤
     * 一种是缺勤一次
     * 设未缺勤时有结果 result = F(n)
     * 则总结果为 F(n) + n * F(n - 1)
     * 问题的关键便转化为求 F(n)
     * 当 n = 1 时
     * 显然 F(1) = 2
     * 用一个数组 record 存储第 n 天时有多少种情况
     * 其中 record[0] 表示第 n 天该生正常出席
     * record[1] 表示第 n 天该生迟到,且只连续迟到 1 天
     * record[2] 表示第 n 天该生迟到,且连续迟到两天
     *
     * 那么有第 n + 1 天时
     *
     * record[0] = record[0] + record[1] + record[2]
     * record[1] = record[0]
     * record[2] = record[1]
     *
     * 2021.08.19 修正
     * 上述分析存在错误
     * 原因是
     * 总结果的数量与 F(n) 的对应关系存在错误
     * 当存在缺勤时,可能结果不是简单的将缺勤的天数插入 F(n - 1) 中
     * 因为存在 LLALL 也是符合条件的结果
     * 而在这种插入 A 之前的序列,没有考虑在其中
     *
     * F(n) 表示可能结果总数
     * F(n) = record[0] + record[1] + record[2] + record[3] + record[4] + record[5]
     *
     * record[0]    无缺勤,前置 0 L
     * record[1]    无缺勤,前置 1 L
     * record[2]    无缺勤,前置 2 L
     * record[3]    有缺勤,前置 0 L
     * record[4]    有缺勤,前置 1 L
     * record[5]    有缺勤,前置 2 L
     *
     * record[0] = record[0] + record[1] + record[2]
     * record[1] = record[0]
     * record[2] = record[1]
     * record[3] = record[0] + record[1] + record[2] + record[3] + record[4] + record[5]
     * record[4] = record[3]
     * record[5] = record[4]
     */
    public int checkRecord(int n) {
        long[] record = new long[]{1,1,0,1,0,0};
        for (int i = 1 ; i < n ; i++){
            long temp = record[2];
            record[2] = record[1] % 1000000007;
            record[1] = record[0] % 1000000007;
            record[0] = (temp + record[1] + record[2]) % 1000000007;
            temp = record[5];
            record[5] = record[4] % 1000000007;
            record[4] = record[3] % 1000000007;
            record[3] = (record[0] + record[4] + record[5] + temp) % 1000000007;
        }
        return (int) ((record[0] + record[1] + record[2] + record[3] + record[4] + record[5]) % 1000000007);
    }

    public static void main(String[] args) {
        Z3StudentAttendanceRecord record = new Z3StudentAttendanceRecord();
        System.out.println(record.checkRecord(10101));
    }
}
