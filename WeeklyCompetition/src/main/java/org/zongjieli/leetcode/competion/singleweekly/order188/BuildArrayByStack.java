package org.zongjieli.leetcode.competion.singleweekly.order188;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BuildArrayByStack
 * @Description: 给定一个目标数据 target 和一个整数 n
 *               每次迭代需要从 list 中依序读取一个数字
 *               使用下述操作来构建目标数组 target
 *               Push: 从 List 中读取一个新元素,并将其推入数组中
 *               Pop:  删除数组中的最后一个元素
 *               如果目标数组构建完成,就停止读取更多元素
 * @Author: Zongjie.Li
 * @Date: 2020/5/10
 * @Version: 1.0
 **/
public class BuildArrayByStack {
    public List<String> buildArray(int[] target, int n) {
        int number = 1;
        int index = 0;
        String push = "Push";
        String pop = "Pop";
        List<String> operate = new ArrayList<>();
        while (number <= n){
            operate.add(push);
            if (target[index] == number){
                if (++index == target.length){
                    break;
                }
            } else {
                operate.add(pop);
            }
            number++;
        }
        return operate;
    }
}
