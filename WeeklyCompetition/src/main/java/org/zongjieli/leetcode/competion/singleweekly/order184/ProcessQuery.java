package org.zongjieli.leetcode.competion.singleweekly.order184;

/**
 * @ClassName: ProcessQuery
 * @Description: 给定一个待查数组 queries,数组中的元素为 1 到 m 之间的正整数
 *               请按照下列规则处理所有待查项 queries[i](从 0 到 queries[queries.length - 1])
 *                  一开始,排列 P = [1,2,3,4,...,m]
 *                  对于当前的 i,请找出待查项 queries[i] 在排列 P 中的位置(下标从 0 开始)
 *                  然后将其从原位置移动到排列 P 的起始位置
 *                  queries[i] 的值即为 P 中查找到的 queries[i] 值的位置
 *               返回 queries 的查询结果
 * @Author: Zongjie.Li
 * @Date: 2020/4/12
 * @Version: 1.0
 **/
public class ProcessQuery {
    public int[] processQueries(int[] queries, int m) {
        int[] number = new int[m];
        for (int i = 0 ; i < m;i++){
            number[i] = i+1;
        }
        for (int i = 0;i< queries.length;i++){
            for (int j = 0;j< number.length;j++){
                if (number[0] == queries[i]){
                    queries[i] = j;
                    break;
                } else {
                    int temp = number[j + 1];
                    number[j + 1] = number[0];
                    number[0] = temp;
                }
            }
        }
        return queries;
    }
}
