package org.zongjieli.leetcode.question.daily.year2022.month5.week2;

import java.util.*;

/**
 * 基因序列可以表示为一条由 8 个字符组成的字符串
 * 其中每个字符都是 'A'、'C'、'G' 和 'T' 之一
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化
 * 一次基因变化就意味着这个基因序列中的一个字符发生了变化
 * 例如,"AACCGGTT" --> "AACCGGTA" 就是一次基因变化
 * 另有一个基因库 bank 记录了所有有效的基因变化
 * 只有基因库中的基因才是有效的基因序列
 * 给定两个基因序列 start 和 end,以及一个基因库 bank
 * 请找出并返回能够使 start 变化为 end 所需的最少变化次数
 * 如果无法完成此基因变化,返回 -1
 * 注意:起始基因序列 start 默认是有效的,但是它并不一定会出现在基因库中
 *
 * start.length == 8
 * end.length == 8
 * 0 <= bank.length <= 10
 * bank[i].length == 8
 * start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
 *
 * @author   Li.zongjie
 * @date     2022/5/7
 * @version  1.0
 */
public class Z6MinGene {

    public int minMutation(String start, String end, String[] bank) {
        LinkedList<String> banks = new LinkedList<>();
        for (String b : bank) {
            banks.addLast(b);
        }
        if (!banks.contains(end)) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        int result = 0;
        LinkedList<String> next = new LinkedList<>();
        next.addFirst(start);
        int length;
        while ((length = next.size()) > 0) {
            for (int i = 0 ; i < length ; i++) {
                String cs = next.pollFirst();
                if (cs.equals(end)) {
                    return result;
                }
                int bl = banks.size();
                for (int j = 0 ; j < bl ; j++) {
                    String cbs = banks.pollFirst();
                    if (same(cs, cbs) == 7) {
                        next.addLast(cbs);
                    } else {
                        banks.addLast(cbs);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    private int same (String a, String b) {
        int result = 0;
        for (int i = 0 ; i < 8 ; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result++;
            }
        }
        return result;
    }

}
