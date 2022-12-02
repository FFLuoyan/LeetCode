package org.zongjieli.leetcode.question.daily.year2022.month12.Week1;

/**
 * 有 n 个盒子,给定一个长度为 n 的二进制字符串 boxes
 * 其中 boxes[i] 的值为 '0' 表示第 i 个盒子是空的
 * 而 boxes[i] 的值为 '1' 表示盒子里有一个小球
 * 在一步操作中,可以将一个小球从某个盒子移动到一个与之相邻的盒子中
 * 第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1
 * 注意,操作执行后,某些盒子中可能会存在不止一个小球
 * 返回一个长度为 n 的数组 answer
 * 其中 answer[i] 是将所有小球移动到第 i 个盒子所需的最小操作数
 * 每个 answer[i] 都需要根据盒子的初始状态进行计算
 *
 * n == boxes.length
 * 1 <= n <= 2000
 * boxes[i] 为 '0' 或 '1'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/2
 */
public class Z5MoveBall {

    public int[] minOperations(String boxes) {
        byte[] boxBytes = boxes.getBytes();
        int leftCount = 0, li = boxBytes.length - 1;
        int[] result = new int[boxBytes.length];
        for (byte boxByte : boxBytes) {
            result[li] += leftCount;
            leftCount += (boxByte - '0');
        }
        int rightCount = 0;
        for (int i = li - 1 ; i >= 0 ; i--) {
            leftCount -= (boxBytes[i + 1] - '0');
            rightCount += (boxBytes[i + 1] - '0');
            result[i] = result[i + 1] - leftCount + rightCount;
        }
        return result;
    }

}
